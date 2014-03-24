import java.util.ArrayList;


public class AveriguaServicio {

	private ArrayList<Integer> separadores = new ArrayList<Integer>();
	
	AveriguaServicio(){
		for(int i=0; i< Inicio.listaDocumentos.length;i++){
			if(Inicio.listaDocumentos[i].nhc.equals("Separador")){
				System.out.println("Detectado separador");
				separadores.add(i);
			}
		}
		if (separadores.size() == 0 || separadores.get(0) != 0){
			separadores.add(-1);
		}
		separadores.add(Inicio.listaDocumentos.length);
		
		for(int i=0;i<separadores.size();i++){
			System.out.println(separadores.get(i));
		}
	}
	
	ArrayList<Integer> getNumOrdenSeparadores(){
		return separadores;
	}
}
