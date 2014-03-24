import java.awt.AWTException;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Coco
 */
public class VentanaCompacta extends javax.swing.JFrame {

	/**
	 * Creates new form VentanaCompacta
	 */

	Documento documentoTemp;

	public VentanaCompacta() {
		initComponents();
		setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		Inicio.jBNHCp = new javax.swing.JButton();
		Inicio.jBServiciop = new javax.swing.JButton();
		Inicio.jBNombreDocp = new javax.swing.JButton();
		jLNHC = new javax.swing.JLabel();
		jLServicio = new javax.swing.JLabel();
		jLNombreDoc = new javax.swing.JLabel();
		jBExtraer = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jBGiroDcha = new javax.swing.JButton();
		jB180 = new javax.swing.JButton();
		jBGiroIz = new javax.swing.JButton();
		jBEliminar = new javax.swing.JButton();
		jBApartar = new javax.swing.JButton();
		jBDeshabilitar = new javax.swing.JButton();

		setTitle("Revisi�n");
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(750, 180));
		setResizable(false);

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jPanel1.addKeyListener(listener);
		
		jPanel1.setFocusable(true);

		Inicio.jBNHCp.setEnabled(false);
		Inicio.jBNHCp.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
		// Inicio.jBNHCp.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/iconos/CirculoRojo64x64.png")));
		// // NOI18N
		// Inicio.jBNHCp.setText("2.999.999");
		Inicio.jBNHCp.setMaximumSize(new java.awt.Dimension(150, 75));
		Inicio.jBNHCp.setMinimumSize(new java.awt.Dimension(150, 75));
		Inicio.jBNHCp.setPreferredSize(new java.awt.Dimension(150, 75));

		Inicio.jBNHCp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.ventanaIntroducirNHC= new InterfazIntroducirNHC(null,false, Inicio.jBNHCp);
				Inicio.ventanaIntroducirNHC.setVisible(true);
				jPanel1.requestFocus();
				new Acrobat().getFocus();
			}
		});

		Inicio.jBServiciop.setEnabled(false);
		Inicio.jBServiciop.setBackground(new java.awt.Color(233, 0, 0));
		Inicio.jBServiciop.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
		// Inicio.jBServiciop.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/iconos/NuclearAzul72x72.png")));
		// // NOI18N
		// Inicio.jBServiciop.setText("DIG");
		Inicio.jBServiciop.setPreferredSize(new java.awt.Dimension(145, 75));

		Inicio.jBServiciop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/*
				 * Icon icono = new
				 * ImageIcon(getClass().getResource("/iconos/maletin48x48.png"
				 * )); Object seleccion =
				 * JOptionPane.showInputDialog(Inicio.jBServiciop
				 * ,"Seleccione el Servicio"
				 * ,"Selector de servicios",JOptionPane.QUESTION_MESSAGE, icono,
				 * // unIcono, // null para icono defecto new Object[] {
				 * "opcion 1", "opcion 2", "opcion 3" }, "opcion 1");
				 */
				jPanel1.requestFocus();
			}

		});

		Inicio.jBNombreDocp.setEnabled(false);
		Inicio.jBNombreDocp.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
		// Inicio.jBNombreDocp.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/iconos/NuclearAmarillo128x128.png")));
		// // NOI18N
		// Inicio.jBNombreDocp.setText("Enfermer�a");
		Inicio.jBNombreDocp.setPreferredSize(new java.awt.Dimension(250, 75));

		Inicio.jBNombreDocp.setMaximumSize(new java.awt.Dimension(370, 75));
		Inicio.jBNombreDocp.setMinimumSize(new java.awt.Dimension(370, 75));
		Inicio.jBNombreDocp.setPreferredSize(new java.awt.Dimension(370, 75));

		Inicio.jBNombreDocp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/*
				 * Icon icono = new
				 * ImageIcon(getClass().getResource("/iconos/portfolio48x48.png"
				 * )); Object seleccion =
				 * JOptionPane.showInputDialog(Inicio.jBNombreDocp
				 * ,"Seleccione el Nombre del Documento"
				 * ,"Selector de servicios",JOptionPane.QUESTION_MESSAGE, icono,
				 * // unIcono, // null para icono defecto new Object[] {
				 * "opcion 1", "opcion 2", "opcion 3" }, "opcion 1");
				 */
				jPanel1.requestFocus();
			}

		});

		jLNHC.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
		jLNHC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLNHC.setText("N�mero de Historia");

		jLServicio.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
		jLServicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLServicio.setText("Servicio");

		jLNombreDoc.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
		jLNombreDoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLNombreDoc.setText("Nombre del Documento");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLNHC,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																150,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																Inicio.jBNHCp,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																179,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jLServicio,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				200,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jLNombreDoc,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				250,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				Inicio.jBServiciop,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(10,
																				10,
																				10)
																		.addComponent(
																				Inicio.jBNombreDocp,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jLServicio,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLNombreDoc,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																jLNHC,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																Inicio.jBNHCp,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																Inicio.jBServiciop,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																Inicio.jBNombreDocp,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jBExtraer.setEnabled(true);
		jBExtraer.setIcon(new javax.swing.ImageIcon("iconos/accept-32.png")); // NOI18N
		jBExtraer.setText("Extraer");
		jBExtraer
				.setToolTipText("Obtiene la ruta y nombre del nuevo archivo, y lo coloca en el portapapeles");
		jBExtraer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// jBExtraerActionPerformed(evt);
				
				habilitarTeclas(jBDeshabilitar.getText());
				
				if(Inicio.ventanaExtraer != null){
					Inicio.ventanaExtraer.dispose();
				}
				
				Inicio.ventanaExtraer = new VentanaExtraer();
				jPanel1.requestFocus();
			}
		});

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		jBGiroDcha.setIcon(new javax.swing.ImageIcon(
				"iconos/Giro Derecha 24x24.png")); // NOI18N
		jBGiroDcha.setToolTipText("Documento siguiente");
		jBGiroDcha.setLabel("");
		jBGiroDcha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBGrabarActionPerformed(evt);
				jPanel1.requestFocus();
			}
		});

		jB180.setIcon(new javax.swing.ImageIcon("iconos/Giro.png")); // NOI18N
		jB180.setToolTipText("Rota la p�gina");
		// jB180.setText("180 �");
		jB180.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jB180ActionPerformed(evt);
				jPanel1.requestFocus();
			}
		});

		jBGiroIz.setIcon(new javax.swing.ImageIcon("iconos/borrar.png")); // NOI18N
		jBGiroIz.setToolTipText("Eliminar p�gina");
		jBGiroIz.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBEliminarActionPerformed(evt);
				jPanel1.requestFocus();
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jBGiroIz,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												62,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jB180,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												93,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jBGiroDcha,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												62,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jBGiroIz, javax.swing.GroupLayout.PREFERRED_SIZE,
						22, Short.MAX_VALUE)
				.addComponent(jB180, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
						Short.MAX_VALUE)
				.addComponent(jBGiroDcha,
						javax.swing.GroupLayout.PREFERRED_SIZE, 0,
						Short.MAX_VALUE));

		jBDeshabilitar.setText("Teclas On");
		jBDeshabilitar.setBackground(Color.pink);
		jBDeshabilitar.setToolTipText("Habilita/Deshabilita las teclas");
		jBDeshabilitar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// jBEliminarActionPerformed(evt);
				habilitarTeclas(jBDeshabilitar.getText());
				jPanel1.requestFocus();
			}
		});

		// jBEliminar.setIcon(new ImageIcon("/iconos/Cubo Basura32x32.png")); //
		// NOI18N
		jBEliminar.setText("Eliminar");
		jBEliminar.setToolTipText("Elimina el documento");
		jBEliminar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// jBEliminarActionPerformed(evt);

				Inicio.jBNHC.setText("Eliminar");
				Inicio.jBNHCp.setText("Eliminar");
				Inicio.jBServicio.setText("Eliminar");
				Inicio.jBServiciop.setText("Eliminar");
				Inicio.jBNombreDoc.setText("Eliminar");
				Inicio.jBNombreDocp.setText("Eliminar");

				Inicio.jBNHC.setBackground(Color.gray);
				Inicio.jBNHCp.setBackground(Color.gray);
				Inicio.jBServicio.setBackground(Color.gray);
				Inicio.jBServiciop.setBackground(Color.gray);
				Inicio.jBNombreDoc.setBackground(Color.gray);
				Inicio.jBNombreDocp.setBackground(Color.gray);

				jPanel1.requestFocus();
			}
		});

		// jBApartar.setIcon(new
		// javax.swing.ImageIcon("/iconos/Clip32x32.png")); // NOI18N
		jBApartar.setText("Apartar");
		jBApartar.setToolTipText("Aparta el documento");
		jBApartar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jBApartarActionPerformed(evt);
				jPanel1.requestFocus();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(0, 0, Short.MAX_VALUE)
								.addComponent(jBDeshabilitar)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jBEliminar)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jBApartar)
								.addGap(28, 28, 28)
								.addComponent(jPanel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(31, 31, 31).addComponent(jBExtraer)
								.addGap(36, 36, 36)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jBExtraer,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														29,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(
																		jBDeshabilitar,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		29,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		jBEliminar,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		29,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		jBApartar,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		29,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jPanel2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap(751, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	KeyListener listener = new KeyListener() {
		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped="
					+ KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed="
					+ KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyReleased(KeyEvent e) {

			System.out.println(e.getKeyText(e.getKeyCode()));
			System.out.println(e.getKeyCode());
			
			
			switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
				
				if(Inicio.ventanaIntroducirNHC != null){
        			Inicio.ventanaIntroducirNHC.dispose();
        		}
				/*
	   			 if(Inicio.listaDocumentos[Inicio.numeroPdf].nhc.equals("NO") || Inicio.listaDocumentos[Inicio.numeroPdf].nhc.contains("ERROR")){
	   				   
	    	           try {
						Robot robot = new Robot();
						robot.delay(100);
						
		    	           Inicio.ventanaIntroducirNHC = new InterfazIntroducirNHC(null, true, Inicio.jBNHCp);
		    	           Inicio.ventanaIntroducirNHC.setVisible(true);
		    	           		    	           
		    	   		if (!Inicio.listaDocumentos[Inicio.numeroPdf].nhc.equals(Inicio.jBNHCp
		    					.getText())) {
		    				// System.out.println("Cambiamos el nhc");
		    				Inicio.listaDocumentos[Inicio.numeroPdf].nhc = Inicio.jBNHCp
		    						.getText();
		    				Inicio.listaDocumentos[Inicio.numeroPdf].revisado = true;
		    			}
		    	           
	    	           } catch (AWTException ev) {
						// TODO Auto-generated catch block
						ev.printStackTrace();
	    	           }

	    	           
	    	           //dialog.requestFocus();
	    	           // jPanel1.requestFocus();
    			   }
	   			 else{
	   			 */
	 	   			jBGrabarPagina(); 
	   			 /* } */

				break;
			case KeyEvent.VK_R:
				
				System.out.println("Hola estoy pulsando la r en la ventana compacta");
				
				new Acrobat().rotarPagina();
				if ((Inicio.jBServicio.getText().equals("CAR") || Inicio.jBServicio
						.getText().equals("ANR"))
						&& Inicio.jBNombreDoc.getText().equals("X")) {
					// if(Inicio.listaDocumentos[Inicio.numeroPdf].fisica.numPaginas
					// <= 2){
					Inicio.jBNombreDocp.setText("EKG");
					Inicio.jBNombreDoc.setText("EKG");
					Inicio.jBServiciop.setText("CAR");
					Inicio.jBServicio.setText("CAR");
					Inicio.jBNombreDocp.setBackground(Color.green);
					Inicio.jBNombreDoc.setBackground(Color.green);
					// }
				}
				break;
			case KeyEvent.VK_E:
				new Acrobat().eliminarPagina();
				break;
			case KeyEvent.VK_Q:
				
				System.out.println("Hola estoy pulsando la q en la ventana compacta");
				
				if(Inicio.ventanaIntroducirNHC != null){
					Inicio.ventanaIntroducirNHC.dispose();
				}
				
				
				Inicio.ventanaIntroducirNHC = new InterfazIntroducirNHC(null,true, Inicio.jBNHCp);
				Inicio.ventanaIntroducirNHC.setVisible(true);
				break;
				
  			case KeyEvent.VK_SPACE:  
  				System.out.println("Hola estoy pulsando la barra espaciadora en la ventana compacta");
  				
  				if(Inicio.ventanaIntroducirNHC != null){
  	  				Inicio.ventanaIntroducirNHC.validarNHC(Inicio.ventanaIntroducirNHC.jBNHCAnterior.getText());
  	  				//new FocalAdobe();
  	  				Inicio.ventanaIntroducirNHC.dispose();
  	  				break;	
  				}
  			/*	
  			case KeyEvent.VK_0:
  			case KeyEvent.VK_1:
  			case KeyEvent.VK_2:
  			case KeyEvent.VK_3:
  			case KeyEvent.VK_4:
  			case KeyEvent.VK_5:
  			case KeyEvent.VK_6:
  			case KeyEvent.VK_7:
  			case KeyEvent.VK_8:
  			case KeyEvent.VK_9:
 				String cadena = Inicio.ventanaIntroducirNHC.jTFnhc.getText();
  				cadena += e.getKeyText(e.getKeyCode());
  				Inicio.ventanaIntroducirNHC.jTFnhc.setText(cadena);
  				break;
  				
  			case KeyEvent.VK_NUMPAD0:
  			case KeyEvent.VK_NUMPAD1:
  			case KeyEvent.VK_NUMPAD2:
  			case KeyEvent.VK_NUMPAD3:
  			case KeyEvent.VK_NUMPAD4:
  			case KeyEvent.VK_NUMPAD5:
  			case KeyEvent.VK_NUMPAD6:
  			case KeyEvent.VK_NUMPAD7:
  			case KeyEvent.VK_NUMPAD8:
  			case KeyEvent.VK_NUMPAD9:
  				String cadenaBloqNum = Inicio.ventanaIntroducirNHC.jTFnhc.getText();
  				String cadenaExtraida = e.getKeyText(e.getKeyCode());
  				cadenaBloqNum += cadenaExtraida.substring(7);
  				Inicio.ventanaIntroducirNHC.jTFnhc.setText(cadenaBloqNum);
  				break;
  				
  			*/	
			case KeyEvent.VK_ESCAPE: /* cerrarAutoHotKey() */
				;
				break;
			}

			// if(e.getKeyCode() == KeyEvent.VK_A )

			// System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
	};

	public void habilitarTeclas(String texto) {
		if (texto.equals("Teclas On")) {
			String cmd = "taskkill.exe /F /IM FocoAcrobat.exe /T";
			String cmd2 = "taskkill.exe /F /IM FocoNHC.exe /T";

			Process hijo, hijo2;
			try {
				hijo = Runtime.getRuntime().exec(cmd);

				hijo.waitFor();
				hijo2 = Runtime.getRuntime().exec(cmd2);

				hijo2.waitFor();

				Thread.sleep(300);

			} catch (IOException e) {
				// System.out.println("Incapaz de matar.");
			} catch (InterruptedException e) {
				// System.out.println("Incapaz de matar.");
			}

			jBDeshabilitar.setText("Teclas Off");
			jBDeshabilitar.setBackground(Color.cyan);

		} else if (texto.equals("Teclas Off")) {

			File archivo2 = new File("cal\\FocoAcrobat.exe");
			File archivo3 = new File("cal\\FocoNHC.exe");
			try {
				Process p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler " + archivo2);
				Process pNHC = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + archivo3);

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			jBDeshabilitar.setText("Teclas On");
			jBDeshabilitar.setBackground(Color.pink);

		}
	}

	private void jB180ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new Acrobat().rotarPagina();
	}

	void revisarPropiedadesDocumento() {
		if (!Inicio.listaDocumentos[Inicio.numeroPdf].nhc.equals(Inicio.jBNHCp
				.getText())) {
			// System.out.println("Cambiamos el nhc");
			Inicio.listaDocumentos[Inicio.numeroPdf].nhc = Inicio.jBNHCp
					.getText();
			Inicio.listaDocumentos[Inicio.numeroPdf].revisado = true;
		}
		if (!Inicio.listaDocumentos[Inicio.numeroPdf].servicio
				.equals(Inicio.jBServiciop.getText())) {
			// System.out.println("Cambiamos el servicio");
			Inicio.listaDocumentos[Inicio.numeroPdf].servicio = Inicio.jBServiciop
					.getText();
			Inicio.listaDocumentos[Inicio.numeroPdf].revisado = true;
		}
		if (!Inicio.listaDocumentos[Inicio.numeroPdf].nombreNormalizado
				.equals(Inicio.jBNombreDocp.getText())) {
			// System.out.println("Cambiamos el nombre del documento");
			Inicio.listaDocumentos[Inicio.numeroPdf].nombreNormalizado = Inicio.jBNombreDocp
					.getText();
			Inicio.listaDocumentos[Inicio.numeroPdf].revisado = true;
		}
		Inicio.listaDocumentos[Inicio.numeroPdf].semaforoAmarilloServicio = false;
	}

	private void jBGrabarPagina() {
		new Acrobat().guardarPagina();

		revisarPropiedadesDocumento();

		System.out.println("Numero de pdf " + Inicio.numeroPdf
				+ ". Tama�o Carpeta: " + Inicio.tama�oCarpetaPdf);
		if (Inicio.numeroPdf < Inicio.tama�oCarpetaPdf - 1) {

			// File archivo = new
			// File(Inicio.rutaCompletaPdfs[++Inicio.numeroPdf]);
			Inicio.ventanaExplorador.listaPdfs
					.setSelectedIndex(Inicio.numeroPdf);

			File archivo = new File(
					Inicio.listaDocumentos[++Inicio.numeroPdf].rutaArchivo);
			Inicio.ventanaExplorador.listaPdfs
					.setSelectedIndex(Inicio.numeroPdf);

			try {
				Process p = Runtime.getRuntime().exec(
						"rundll32 url.dll,FileProtocolHandler " + archivo);

				Inicio.jBNHC
						.setText(Inicio.listaDocumentos[Inicio.numeroPdf].nhc);
				if (Inicio.listaDocumentos[Inicio.numeroPdf].nhc.equals("Separador")
						|| Inicio.listaDocumentos[Inicio.numeroPdf].nhc.contains("ERROR")
						|| Inicio.listaDocumentos[Inicio.numeroPdf].nhc
								.equals("NO")) {
					Inicio.jBNHC.setBackground(Color.red);
					Inicio.jBNHCp.setBackground(Color.red);
				} else if (Inicio.listaDocumentos[Inicio.numeroPdf].nhc
						.equals("Eliminar")
						|| Inicio.listaDocumentos[Inicio.numeroPdf].nhc
								.equals("Apartar")) {
					Inicio.jBNHC.setBackground(Color.GRAY);
					Inicio.jBNHCp.setBackground(Color.GRAY);
				} else if(Inicio.listaDocumentos[Inicio.numeroPdf].semaforoAmarilloNhc){
					Inicio.jBNHC.setBackground(Color.yellow);
					Inicio.jBNHCp.setBackground(Color.yellow);
				}
				else{
					Inicio.jBNHC.setBackground(Color.green);
					Inicio.jBNHCp.setBackground(Color.green);
				}
				
				if (Inicio.listaDocumentos[Inicio.numeroPdf].nhc
						.equals("Separador")
						&& !Inicio.listaDocumentos[Inicio.numeroPdf].servicio
								.equals("X")) {
					Inicio.jBNHC.setBackground(Color.green);
					Inicio.jBNHCp.setBackground(Color.green);
				}

				Inicio.jBServicio
						.setText(Inicio.listaDocumentos[Inicio.numeroPdf].servicio);
				if (Inicio.listaDocumentos[Inicio.numeroPdf].servicio
						.equals("X")) {
					Inicio.jBServicio.setBackground(Color.red);
					Inicio.jBServiciop.setBackground(Color.red);
				} else if (Inicio.listaDocumentos[Inicio.numeroPdf].servicio
						.equals("Eliminar")
						|| Inicio.listaDocumentos[Inicio.numeroPdf].servicio
								.equals("Apartar")) {
					Inicio.jBServicio.setBackground(Color.GRAY);
					Inicio.jBServiciop.setBackground(Color.GRAY);
				} else {
					Inicio.jBServicio.setBackground(Color.green);
					Inicio.jBServiciop.setBackground(Color.green);
				}

				Inicio.jBNombreDoc
						.setText(Inicio.listaDocumentos[Inicio.numeroPdf].nombreNormalizado);
				if (Inicio.listaDocumentos[Inicio.numeroPdf].nombreNormalizado
						.equals("X")) {
					Inicio.jBNombreDoc.setBackground(Color.red);
					Inicio.jBNombreDocp.setBackground(Color.red);
				} else if (Inicio.listaDocumentos[Inicio.numeroPdf].nombreNormalizado
						.equals("Eliminar")
						|| Inicio.listaDocumentos[Inicio.numeroPdf].nombreNormalizado
								.equals("Apartar")) {
					Inicio.jBNombreDoc.setBackground(Color.GRAY);
					Inicio.jBNombreDocp.setBackground(Color.GRAY);
				} else {
					Inicio.jBNombreDoc.setBackground(Color.green);
					Inicio.jBNombreDocp.setBackground(Color.green);
				}

				Inicio.jBNHCp
						.setText(Inicio.listaDocumentos[Inicio.numeroPdf].nhc);
				Inicio.jBServiciop
						.setText(Inicio.listaDocumentos[Inicio.numeroPdf].servicio);
				Inicio.jBNombreDocp
						.setText(Inicio.listaDocumentos[Inicio.numeroPdf].nombreNormalizado);

				if (Inicio.listaDocumentos[Inicio.numeroPdf].semaforoAmarilloServicio == true) {
					Inicio.jBServicio.setBackground(Color.yellow);
					Inicio.jBServiciop.setBackground(Color.yellow);
				}

				if (Inicio.listaDocumentos[Inicio.numeroPdf].nhc.equals("NO")
						|| Inicio.listaDocumentos[Inicio.numeroPdf].nhc
								.contains("ERROR")) {
					/*
					try {
						Robot robot = new Robot();
						robot.delay(1300);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					*/
					Inicio.ventanaIntroducirNHC = new InterfazIntroducirNHC(null,false, Inicio.jBNHCp);
					Inicio.ventanaIntroducirNHC.setVisible(true);

					// dialog.requestFocus();
					// jPanel1.requestFocus();
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else {
			int registrar = JOptionPane.showConfirmDialog(null, "Carpeta revisada. �Quieres registrar?");
			if(JOptionPane.OK_OPTION == registrar){
				Inicio.ventanaPrincipal.registraCambiosFinales();
			}
		}
		jPanel1.requestFocus();
	}

	private void jBGrabarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		jBGrabarPagina();
		jPanel1.requestFocus();
	}

	private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		new Acrobat().eliminarPagina();
		jPanel1.requestFocus();

	}

	private void jBApartarActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

		Inicio.jBNHC.setText("Apartar");
		Inicio.jBNHCp.setText("Apartar");
		Inicio.jBServicio.setText("Apartar");
		Inicio.jBServiciop.setText("Apartar");
		Inicio.jBNombreDoc.setText("Apartar");
		Inicio.jBNombreDocp.setText("Apartar");

		Inicio.jBNHC.setBackground(Color.gray);
		Inicio.jBNHCp.setBackground(Color.gray);
		Inicio.jBServicio.setBackground(Color.gray);
		Inicio.jBServiciop.setBackground(Color.gray);
		Inicio.jBNombreDoc.setBackground(Color.gray);
		Inicio.jBNombreDocp.setBackground(Color.gray);

		jPanel1.requestFocus();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */

	private void registraCambiosFinales() {
		new Acrobat().guardarPagina();
		revisarPropiedadesDocumento();
		new CerrarTodo().closePdf();
		System.out.println("Cerrados los pdfs ahora");

		System.out.println("numero de documentos: "
				+ Inicio.listaDocumentos.length);

		for (int i = 0; i < Inicio.listaDocumentos.length; i++) {
			System.out.println(Inicio.listaDocumentos[i].rutaArchivo);
		}

		for (int i = 0; i < Inicio.listaDocumentos.length; i++) {
			if (Inicio.listaDocumentos[i].revisado) {
				File nombreAntiguo = new File(
						Inicio.listaDocumentos[i].rutaArchivo);

				String rutaNueva = Inicio.listaDocumentos[i].registraFichero();
				File nombreNuevo = new File(rutaNueva);
				boolean correcto = nombreAntiguo.renameTo(nombreNuevo);
				if (correcto) {
					System.out.println("Renombrado con exito");
				} else {
					System.out.println("Error al renombrar");
				}
			}
		}

		Inicio.modelo.removeAllElements();
		Inicio.jBNHC.setText("");
		Inicio.jBNHCp.setText("");
		Inicio.jBServicio.setText("");
		Inicio.jBServiciop.setText("");
		Inicio.jBNombreDoc.setText("");
		Inicio.jBNombreDocp.setText("");
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jB180;
	private javax.swing.JButton jBApartar;
	private javax.swing.JButton jBEliminar;
	private javax.swing.JButton jBGiroDcha;
	private javax.swing.JButton jBGiroIz;
	private javax.swing.JButton jBExtraer;

	public javax.swing.JButton jBDeshabilitar;

	// private javax.swing.JButton jBNHC;
	// private javax.swing.JButton jBNombreDoc;
	// private javax.swing.JButton jBServicio;
	private javax.swing.JLabel jLNHC;
	private javax.swing.JLabel jLNombreDoc;
	private javax.swing.JLabel jLServicio;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	// End of variables declaration
}

class Acrobat {

	public void guardarPagina() {
		try {

			Robot robot = new Robot();

			robot.delay(100);
			robot.keyPress(KeyEvent.VK_F9);
			robot.keyRelease(KeyEvent.VK_F9);
			robot.delay(100);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(100);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void rotarPagina() {
		try {
			Robot robot = new Robot();
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_F9);
			robot.keyRelease(KeyEvent.VK_F9);
			robot.delay(100);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_R);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(100);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarPagina() {
		try {
			Robot robot = new Robot();

			robot.delay(100);
			robot.keyPress(KeyEvent.VK_F9);
			robot.keyRelease(KeyEvent.VK_F9);
			robot.delay(100);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_D);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(100);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getFocus() {
		try {
			Robot robot = new Robot();

			robot.delay(100);
			robot.keyPress(KeyEvent.VK_F9);
			robot.keyRelease(KeyEvent.VK_F9);
			robot.delay(100);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}