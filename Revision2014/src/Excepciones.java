
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
		return false;
	}
}
