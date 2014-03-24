import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;


public class Documento {

	String rutaArchivo ="";					//	Ruta absoluta
	String nhc ="X";												// ok
	String servicio ="X";
	String nombreNormalizado = "X";
	
	String cadenaOCR = "";										// ok
	
	ArrayList<String> metadatos = new ArrayList<String>();
	Fisica fisica = new Fisica();								// ok
	
	Boolean revisado = false;
	Boolean semaforoAmarilloServicio = false;
	Boolean semaforoAmarilloNombre = false;
	Boolean semaforoAmarilloNhc = false;
	
	Mapa mapa;
	
	Documento(String rutaArchivo){
		this.rutaArchivo = rutaArchivo;
		mapa = new Mapa(rutaArchivo);
		cadenaOCR = mapa.textoPag1;
		nhc = mapa.nhc;
		fisica = mapa.fisica;
		/* Si no localizamos el nhc, luego lo mapeamos, primero con la ayuda de saber
		   que documento es, luego, fuerza bruta.
		 */
	}

	
	boolean reDetectorNHCUrgencias(){
		if(nhc.contains("ERROR") || nhc.contains("NO")){
			if(nombreNormalizado.equals("Informe urgencias") || nombreNormalizado.equals("Enfermer�a urgencias") ){
				int limiteCadena = cadenaOCR.length();
				if(limiteCadena > 200)
					limiteCadena =  200;
				String subCadena = cadenaOCR.substring(0, limiteCadena);
				String nhcS = "";
				boolean buscandoFinal = false;
				for(int i=0;i<limiteCadena;i++){
					char c = subCadena.charAt(i);
					if(c >= '0' && c <= '9'){
						buscandoFinal = true;
						nhcS += c;
					}
					else if(buscandoFinal){
						if(c != ' ' && c != 10){
							return false;
						}
						else{
							if(nhcS.charAt(0) == '0'){
								return false;
							}
							nhc = nhcS;
							semaforoAmarilloNhc = true;
							return true;
						}
						
					}
				}
				
			}
		}
		return false;
	}
	
	
	boolean reDetectorNHC(Modelo modelo){
		
		//System.out.println("Imprimimos nhc: " + nhc);
		if(nhc.contains("ERROR") || nhc.contains("NO")){
			//System.out.println("Instrucciones: " + modelo.instruccionesNHC);
			if(!modelo.instruccionesNHC.equals("@")){
											
				int limiteCadena = cadenaOCR.length();
				if(limiteCadena > 200)
					limiteCadena =  200;
				String subCadena = cadenaOCR.substring(0, limiteCadena);
				
				//System.out.println(subCadena);
				int contador = subCadena.indexOf(modelo.instruccionesNHC);
								
				//System.out.println("El numero del contador: " + contador);
				
				if( contador != -1){
					
					System.out.println("El dato clave es... " + modelo.instruccionesNHC);
					
					contador = contador + modelo.instruccionesNHC.length() + 1;
					if(contador >= subCadena.length()){
						contador = subCadena.length() - 1;
					}
					
					System.out.println(this.rutaArchivo);
					//System.out.println("Cacho cadena: " + subCadena.substring(contador - modelo.instruccionesNHC.length() - 2 , contador + 10));
					
					String nhcS = "";
					boolean fin = false;
					boolean error = false;
					
					while(!fin && contador < subCadena.length()){
						
						char c = subCadena.charAt(contador);
						System.out.println("Caracter:  " + c);
						if(c != ' ' && c != 10 ){
							if(c >= '0' && c <= '9'){
								nhcS += c;
							}
							else if(c !='.'){
								error = true;
								fin = true;
							}
						}
						else if(nhcS.length() > 0){
							fin = true;
						}
						
						contador++;
					}
					
					if(!error){
						if(nhcS.length()>0){
							nhc = nhcS;
							System.out.println("Detectado ianus, ahora vale..." + nhc);
							return true;
						}
					}
					else{
						nhc = nhcS + "ERROR";
						return false;
					}
				}
			}
		}
		
		return false;
	}
	
	
	boolean detector(Modelo modelo){
		
		if(!nhc.equals("Separador")){
			// detectaEcos();
			
				if(!modelo.metadatos.metaServicioNombre.equals("@")){
					//System.out.println(cadenaOCR);
					if(cadenaOCR.contains(modelo.metadatos.metaServicioNombre)){
						nombreNormalizado = modelo.nombreNormalizado;
						servicio = modelo.servicios.get(0);
						// System.out.println("Caso 0: " +modelo.fisica.tama�oPagina + " = " + fisica.tama�oPagina);
						System.out.println("Se encontr� por esta palabra: " + modelo.metadatos.metaServicioNombre);
						return true;
					}
					else{
						//		Bloque copiado ****************************************************************
						boolean marca = false; 
						if(!modelo.metadatos.metaNombre.equals("@")){
							if(cadenaOCR.contains(modelo.metadatos.metaNombre)){
								nombreNormalizado = modelo.nombreNormalizado;
								//System.out.println("Caso 1: " +modelo.fisica.tama�oPagina + " = " + fisica.tama�oPagina);
								System.out.println("Se encontr� por esta palabra: " + modelo.metadatos.metaNombre);
								
								marca = true;
							}
							else if(!modelo.metadatos.metaModelo.equals("@")){
								if(cadenaOCR.contains(modelo.metadatos.metaModelo)){
									nombreNormalizado = modelo.nombreNormalizado;
									marca = true;
									// System.out.println("Caso 2: " +modelo.fisica.tama�oPagina + " = " + fisica.tama�oPagina);
									System.out.println("Se encontr� por esta palabra: " + modelo.metadatos.metaModelo);
								}
							}
						}
						if(!modelo.metadatos.metaServicio.equals("@") && marca){
							if(cadenaOCR.contains(modelo.metadatos.metaServicio)){
								this.servicio = modelo.servicios.get(0);
								// System.out.println("Caso 3: " +modelo.fisica.tama�oPagina + " = " + fisica.tama�oPagina);
								System.out.println("El servicio se encontr� por esta palabra: " + modelo.metadatos.metaServicio);
							}
						}
						if(marca == true)
							return true;
						// *************************************************************************************
						
					}
				}
				else
					{
					boolean marca = false; 
					if(!modelo.metadatos.metaNombre.equals("@")){
						if(cadenaOCR.contains(modelo.metadatos.metaNombre)){
							nombreNormalizado = modelo.nombreNormalizado;
							// System.out.println("Caso 1: " +modelo.fisica.tama�oPagina + " = " + fisica.tama�oPagina);
							System.out.println("Se encontr� por esta palabra: " + modelo.metadatos.metaNombre);

							marca = true;
						}
						else if(!modelo.metadatos.metaModelo.equals("@")){
							if(cadenaOCR.contains(modelo.metadatos.metaModelo)){
								nombreNormalizado = modelo.nombreNormalizado;
								marca = true;
								//System.out.println("Caso 2: " +modelo.fisica.tama�oPagina + " = " + fisica.tama�oPagina);
								System.out.println("Se encontr� por esta palabra: " + modelo.metadatos.metaModelo);

							}
						}
					}
					if(!modelo.metadatos.metaServicio.equals("@") && marca){
						if(cadenaOCR.contains(modelo.metadatos.metaServicio)){
							this.servicio = modelo.servicios.get(0);
							// System.out.println("Caso 3: " +modelo.fisica.tama�oPagina + " = " + fisica.tama�oPagina);
							System.out.println("El servicio se encontr� por esta palabra: " + modelo.metadatos.metaServicio);

						}
					}
					if(marca == true)
						return true;
				}
			}
		
		return false;
	}
	
	boolean detectorRevisado(){
		return false;
	}
	
	public void getServicio(){}
	public void getNombreNormalizado(){}
	public void getMetadatos(){};
	
	
	String registraFichero(){
		
		int aux = this.rutaArchivo.indexOf("@");
		String auxS = this.rutaArchivo.substring(0,aux + 1);
		String nuevaS = this.nhc + " @" + this.servicio + " @" + this.nombreNormalizado + " r.pdf";
		nuevaS = auxS + nuevaS;
		System.out.println(nuevaS);
		
		this.rutaArchivo = nuevaS;
		
		return nuevaS;
	}
	
	String apartaFichero(){
		
		String rutaApartar = "";
		
		int aux = this.rutaArchivo.lastIndexOf("\\");
		rutaApartar = rutaArchivo.substring(0,aux);
		aux = rutaApartar.lastIndexOf("\\") + 1;
		rutaApartar = rutaArchivo.substring(0,aux);
		
		return rutaApartar;
	}
	
	
	boolean renombraFichero(){
		
		String rutaOriginal = "";
					
		
		System.out.println("Esta es la ruta de urgencias" + Inicio.rutaDirectorio);
		int indexCarpeta = Inicio.rutaDirectorio.lastIndexOf("\\");
		
		String carpeta = Inicio.rutaDirectorio.substring(indexCarpeta);
		//System.out.println(carpeta);
		String raiz = Inicio.rutaDirectorio.substring(0,indexCarpeta);
		//System.out.println(raiz);
		int indexRaiz = raiz.lastIndexOf("\\");
		//System.out.println(indexRaiz);
		raiz = raiz.substring(0,indexRaiz);
		//System.out.println(raiz);
		raiz += "\\02 Revisado" + carpeta;
		//System.out.println(raiz);
		
		
		File fichero = new File(raiz);
		if(fichero.mkdirs()){
			System.out.println("Directorio creado");
			Inicio.carpetaActualRevisando = raiz;
		}
			
		
		int indexNombrePdf = rutaArchivo.lastIndexOf("\\");
		String nuevoNombrePdf = rutaArchivo.substring(indexNombrePdf);
		raiz += nuevoNombrePdf;
		System.out.println(raiz);
		
		int indice= raiz.lastIndexOf(".pdf");
		String nuevaRuta = raiz.substring(0, indice);
		nuevaRuta = nuevaRuta + " @" + nhc + " @" + servicio + " @" + this.nombreNormalizado +" r.pdf";
		
		
		
		System.out.println(nuevaRuta);
		
		
		try {
			
			PdfReader pdf = new PdfReader(rutaArchivo);
			
			PdfStamper stp = new PdfStamper(pdf, new FileOutputStream(nuevaRuta));
			PdfWriter writer = stp.getWriter();
			PdfAction pdfAcc;
			
			if(this.fisica.tama�oPagina == 1){
				pdfAcc = PdfAction.gotoLocalPage(1, new PdfDestination(PdfDestination.XYZ,fisica.dimensiones.ancho*2/3,-1, 1), writer);
				writer.setOpenAction(pdfAcc);
			}
			
		
					/*
					else{
						//pdfAcc = PdfAction.gotoLocalPage(1, new PdfDestination(PdfDestination.FIT,10000), writer);
						pdfAcc = PdfAction.gotoLocalPage(1,new PdfDestination(PdfDestination.FITV), writer);
		
					}
					*/
			
			
			stp.close();
			
			pdf.close();
			
			rutaOriginal = rutaArchivo;
			rutaArchivo = nuevaRuta;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
/*
		File ficheroBorrar = new File(rutaOriginal);
		if(ficheroBorrar.delete()){
			System.out.println("Fichero Borrado");
		}
		else{
			JOptionPane.showMessageDialog(null, "Fichero no borrado. Debe de estar en uso.");
			return false;
		}
*/
		return true;
		
		/*
		File fichero = new File(ruta);
//		System.out.println(ruta);
		int aux = ruta.lastIndexOf(".");
		ruta = ruta.substring(0,aux);
		File ficheroN = new File(ruta + " @" + orientacion + 
				numPaginas + dimensiones + " " + alto + "-" + ancho + ".pdf");
//		System.out.println(ficheroN.getAbsolutePath());
		boolean renombrado = fichero.renameTo(ficheroN);
		if(renombrado){
			System.out.println("Renombrado");
		}else{
			System.out.println("Error");
		}
		*/
	}
	
	void detectaEKGs(){
		if(this.nombreNormalizado.equals("X") && !this.servicio.equals("Separador")){
			if(this.fisica.tama�oPagina == 0 && this.fisica.vertical == 2){
				this.nombreNormalizado = "EKG";
				}
		}
	}

	void detectaEcos(){
		
		if(this.nombreNormalizado.equals("X") && !this.servicio.equals("Separador")){
			if((this.fisica.dimensiones.alto <= 330 && this.fisica.dimensiones.alto >= 290) || 
					this.fisica.dimensiones.ancho <= 330 && this.fisica.dimensiones.ancho >= 290){
				this.nombreNormalizado = "Eco";
				}
		}
	}
	
	
	
}




class Servicio{
	
	String nombreServicio = "";
	ArrayList<String> nombresNormalizados = new ArrayList<String>();
	Estadistica estadisticaServicio = new Estadistica();
	
}

class NombreNormalizado{
	String nombreNormalizado = "";
	ArrayList<String> servicios = new ArrayList<String>();
	ArrayList<String> modelos = new ArrayList<String>();
}

class Fisica{
	
	Dimensiones dimensiones = new Dimensiones();
	int vertical = 1;			//	1 vertical; 2 horizontal; 0 variable
	int tama�oPagina = 1;		//	0 A4; 1 A3; -1 A5; 3 A4 o A5
	int numPaginas = 1;
	int peso = 0;
}

class Dimensiones{
	int alto = 0;
	int ancho = 0;
}

class Estadistica{
	
}
