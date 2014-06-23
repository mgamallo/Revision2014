
public class Excepciones {
	
	static public boolean excepcionesIngresos(int numPdf) {
		// TODO Auto-generated method stub
		if(Inicio.listaDocumentos[numPdf].nombreNormalizado.equals(Inicio.CONSENTIMIENTO) ){
			Inicio.listaDocumentos[numPdf].servicio = "X";
			
			/*Inicio.jBServicio.setText("");
			Inicio.jBServiciop.setText("");
			Inicio.jBServicio.setBackground(Color.red);
			Inicio.jBServiciop.setBackground(Color.red);
			*/
			
			System.out.println("Esta es una excepción al ingreso");
			
			return true;
		}
		if(Inicio.listaDocumentos[numPdf].nombreNormalizado.equals(Inicio.CRIBADO)
				&& !(Inicio.listaDocumentos[numPdf].fisica.numPaginas > 2)){
			Inicio.listaDocumentos[numPdf].servicio = "ORL";
			
			/*Inicio.jBServicio.setText("");
			Inicio.jBServiciop.setText("");
			Inicio.jBServicio.setBackground(Color.red);
			Inicio.jBServiciop.setBackground(Color.red);
			*/
			
			System.out.println("Esta es una excepción al ingreso");
			
			return true;
		}

		return false;
	}

	static public boolean excepcionesNeuro(int numPdf){
		
		return false;
	}
	
	static public boolean detectaMonitoriz(int numPdf){
		return false;
	}
	
	static public boolean detectaDocRosaNeuro(int numPdf){
		return false;
	}
}
