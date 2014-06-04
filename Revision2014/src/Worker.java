import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;


class Worker extends SwingWorker<Double, Integer>{

	
	private final JProgressBar progreso;
	private final CargaListaPdfs pdfs;
	public Worker(JProgressBar unaBarraProgreso, CargaListaPdfs pdfs){
		progreso = unaBarraProgreso;
		this.pdfs = pdfs;
	}
	
	
	@Override
	protected Double doInBackground() throws Exception {
		// TODO Auto-generated method stub
		
		int aux = Inicio.listaDocumentos.length;
		int tamModelos = Inicio.modelos.size();
		
		for(int i=0;i<aux;i++){
			Inicio.listaDocumentos[i] = new Documento(pdfs.ficheros[i].getAbsolutePath());
			// System.out.println(listaDocumentos[i].cadenaOCR);
			for(int j=0;j<tamModelos;j++){
				if(Inicio.listaDocumentos[i].detector(Inicio.modelos.get(j))){
					break;
				}
			}
			publish( i/aux*100);
		}
		
		int errores = 0;
		for(int i=0;i<Inicio.listaDocumentos.length;i++){
			if(!Inicio.listaDocumentos[i].renombraFichero(Inicio.listaDocumentos[0]))
				errores++;
		}
		System.out.println(errores + " errores");
		
		
		return 100.0;
	}
	
	protected void done(){
		System.out.println("hecho");
		Inicio.progreso = true;
	}
	
	@Override
    protected void process(List<Integer> chunks) {
        System.out.println("process() esta en el hilo "
                + Thread.currentThread().getName());
        progreso.setValue(chunks.get(0));
    }
	
}