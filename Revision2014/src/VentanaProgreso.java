
import javax.swing.JFrame;
import javax.swing.JLabel;



public class VentanaProgreso extends JFrame{
	
	JLabel etiqueta = new JLabel("Hola");
	
	VentanaProgreso(){
		setSize(300,100);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		add(etiqueta);
		
		pack();
		setVisible(true);
	}
	
	static public void main(String args[]){
		new VentanaProgreso();
	}
}
