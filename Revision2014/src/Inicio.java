import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Inicio extends JFrame {

	/**
	 * @param args
	 */
	
	static final String RUTA = "j:/digitalizaci�n/00 documentacion/01 Escaneado"; 
	static final String RUTAB = "h:/digitalizaci�n/00 documentacion/01 Escaneado";
	static final String RUTAURG ="j:/DIGITALIZACI�N/01 INFORMES URG (Colectiva)"; 
	static final String RUTAURGB ="H:/DIGITALIZACI�N/01 INFORMES URG (Colectiva)";	
	
	static final String RUTAPC = "c:/ianus/ianus.txt"; 
	static String nombrePc;
	static boolean acrobatAntiguo = false;
	
	static String rutaFocoAcrobat = "cal\\FocoAcrobat.exe";
	static String rutaFocoNHC = "cal\\FocoNHC.exe";
	static String rutaFocoAcrobatV = "cal\\FocoAcrobatV.exe";

	static boolean menuVertical = false;
	
	static final String CONSENTIMIENTO = "Consentimento informado";
	static final String EKG = "ECG";
	static final String ECO = "Eco";
	static final String MONITORIZACION = "Cardiotocograf�a basal";
	static final String DOC = "Doc";
	static final String CURSOCLINICO = "Curso cl�nico";
	static final String CRIBADO = "Cribado prenatal";
	static final String HOSPITALIZACION = "Hospitalizaci�n";
	static final String CIA = "CIA";
	
	
	static boolean documentacionDeUrgencias = false;
	
	static JButton jBNHC = new javax.swing.JButton();
    static JButton jBServicio = new javax.swing.JButton();
    static JButton jBNombreDoc = new javax.swing.JButton();
    static JButton jBServiciop = new javax.swing.JButton();
    static JButton jBNombreDocp = new javax.swing.JButton();
    static JButton jBNHCp = new javax.swing.JButton();
    static JButton jBDeshabilitar;
    
    static JCheckBox jCheckBox1 = new JCheckBox();
    
    static JList jLServicios = new javax.swing.JList();
    static JList jLNombresDoc = new javax.swing.JList();
    
    static LeerExcel excel;
    static ArrayList<Object> documentosServicio;
    
    static String rutaCarpetaEscaneadaUsuario = "";    //	almacena la ruta de la carpeta actual
    static ArrayList<String> listaCarpetasRegistradas = new ArrayList<String>();  // almacena las rutas de las carpetas registradas
    static String carpetaActualRevisando = "";   // almacena la carpeta que se est� revisando
    
    static String rutaCompletaPdfs[];
    static ArrayList<String> carpetasAbiertas = new ArrayList<String>();
    static boolean ficherosCargados = true;
    static boolean ventanaRevisionAbierta = false;

    static VentanaPrincipal ventanaPrincipal;
    static VentanaCompacta ventanaCompacta;
    static VentanaExplorador ventanaExplorador;
    static VentanaComprobar ventanaComprobacion;
    static InterfazIntroducirNHC ventanaIntroducirNHC;
    static VentanaExtraer ventanaExtraer;
    static VentanaA3 ventanaA3;
    static VentanaNombresYServicios ventanaNombresYServicios;
    static VentanaNombres ventanaNombres;
    static VentanaIntegral ventanaIntegral;
    static VentanaMicro ventanaMicro;
     
    static int numeroPdf;
    static int tama�oCarpetaPdf;
    static String rutaDirectorio;
    
    static Documento[] listaDocumentos;
    static ArrayList<Modelo> modelos = new ArrayList<Modelo>();
    static ArrayList<Integer> separadores;

    static DefaultListModel modelo;
    
    static boolean progreso = false;
    static boolean erroresAntesRegistrar = false;
    
    static Progress frame; 
    static VentanaProgreso vProgreso;
    
    static int numeroPantallas;
    static int documentacion = 1;
    static String usuario = "";
    static PreferenciasUsuario coordenadas;
    
    static String auxRutaImagen = "";				//	Para ayudar a la hora de asignar una imagen a una norma, aviso, comentario...
	
    static Utiles utiles = new Utiles();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaExplorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaExplorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaExplorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaExplorador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		*/
		
		boolean rebotado = false;
		
		if(args.length>0){
			usuario = args[0];
			if(args[1].contains("true")){
				documentacionDeUrgencias = true;
			}
			else{
				documentacionDeUrgencias = false;
			}
			
			rebotado = true;
		}
		
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
				
		numeroPantallas = gs.length;
		
		nombrePc = new IdentificarPc().getIdentificacion(RUTAPC);
		
		if(nombrePc.equals("mahc13p")){
			acrobatAntiguo = true;
			rutaFocoAcrobat = "cal\\FocoAcrobat2.exe";
		}
		
		excel = new LeerExcel();
		
		excel.getTablaDocumentos("Documentos.xls");
		
		
		
		if(!rebotado){
			 	VentanaUrgODoc vud =  new VentanaUrgODoc();
			    int tipoDoc = vud.getTipoDocumentacion();
			    if(tipoDoc != -1){
			    	if(tipoDoc == 0){
			    		documentacionDeUrgencias = true;
			    	}
			    	else{
			    		documentacionDeUrgencias = false;
			    	}
			    }
			    else{
			    	System.exit(0);
			    }
			    
			    System.out.println("documentacion de urgencias: " + documentacionDeUrgencias);
			    
			    VentanaInicio dialog = new VentanaInicio(new javax.swing.JFrame(), true);
			    dialog.addWindowListener(new java.awt.event.WindowAdapter() {

			                @Override
			                public void windowClosing(java.awt.event.WindowEvent e) {
			                  System.exit(0);
			                }
			         });
			    dialog.setVisible(true);
			    	
		}
	
	    modelos = excel.leerModelos("DocumentosOCR.xls", documentacionDeUrgencias);
		
		// System.out.println(modelos.get(83).instruccionesNHC);
	    
/*
		frame = new Progress();
		frame.pack();
		frame.setVisible(true);
		frame.iterate();
*/
	    
	    if (usuario != ""){
        	
        	//Inicio.coordenadasVentanas.leerCoordenadasVentana("Coordenadas.xls");
        	
           	coordenadas = new PreferenciasUsuario();
           	// numeroPantallas = coordenadas.numPantallas;
        	
           // Inicio.navegador1.frame.setBounds(Inicio.coordenadasVentanas.vPdf1);
           // Inicio.navegador1.frame.setVisible(true);
 
           	
            //ventanaE = new VentanaExplorador();
            //ventanaE.setBounds(Inicio.coordenadasVentanas.vExplorador);

           	
           	System.out.println("El numero de coordenadas es: " + coordenadas.coordenadas.length);
           	for(int i=0;i<coordenadas.coordenadas.length;i++){
           		System.out.println(i + " coordenadas: " + coordenadas.coordenadas[i].x + ", " +
           					coordenadas.coordenadas[i].y);
           	}
           	System.out.println();
           	
           	ventanaExplorador = new VentanaExplorador();
           	ventanaExplorador.setBounds(Inicio.coordenadas.coordenadas[0].x,Inicio.coordenadas.coordenadas[0].y,
           			                    Inicio.coordenadas.coordenadas[1].x,Inicio.coordenadas.coordenadas[1].y);
           	
        }
	    
	    
		
		
		//new VentanaPrincipal();
		//new VentanaCompacta();
		
	}

}

class VentanaUrgODoc{
	
	int getTipoDocumentacion(){
		
		int opcion = JOptionPane.showOptionDialog(null, "�Qu� documentaci�n vas a revisar?", "Selector de documentaci�n", 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, new Object[] {"Urgencias","Documentaci�n"}, "Documentaci�n");
		/*
		if(opcion == 0){
			InicioIanus.documentacion = false;
		}
		*/
		
		Inicio.documentacion = opcion;
		
		return opcion;
	}
	
}

class IdentificarPc {

	
	String getIdentificacion(String ruta){
		File f = new File(ruta);
		Scanner s;
		String pc = "NoN";
		try{
			s = new Scanner(f);
			if (s.hasNextLine()){
				 pc = s.nextLine();
				System.out.println(pc);
			}
			s.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		return pc;
	}
}	