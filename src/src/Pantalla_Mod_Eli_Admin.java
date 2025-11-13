import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

public class Pantalla_Mod_Eli_Admin extends JPanel {
	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);
	protected String fuente= "Niagara Engraved";
	JLabel fondo;
	JButton boton_conf = new JButton("AJUSTES");
	private JTextField textField_1=new JTextField ();
	private JTextField textField_2=new JTextField ();
	private JTextField textField_3=new JTextField ();
	private JTextField textField_4=new JTextField ();
	JLabel lblmensaje = new JLabel("");
	JLabel lblmensaje2 = new JLabel("");
	
	JComboBox comboBox = new JComboBox();
	JTextField textField_4B = new JTextField("");
	JLabel lblNewLabel_11=new JLabel ();
	JLabel lblNewLabel_1=new JLabel ();
	JTextField textField=new JTextField ();
	
	JButton boton_MOD= new JButton ();
	JButton boton_ELI= new JButton ();
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("ELIMINAR");

	/**
	 * Create the panel.
	 */
	
	public void add_fondo (int num_fondo) {
		System.out.println(""+num_fondo);
		JLabel fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.CENTER);
		fondo.setIcon(imagenes.getfondo(""+num_fondo));
		fondo.setBorder(null);
		fondo.setBounds(0, 0, 1134, 650);
		add(fondo);	
		
		
		


	}
	
	public void botonframe (JPanel b) {
		removeAll();
		setLayout(new BorderLayout(0, 0));
		add(b);
		repaint();
		revalidate();
	}
	
	public void disable () {
		boton_MOD.setEnabled(false);
		boton_ELI.setEnabled(true);
		
		//lblNewLabel.setEnabled(true);
		 textField.setEnabled(false);
		 
		 //lblNewLabel_1.setEnabled(true);
		 textField_2.setEnabled(false);
		 
		 //lblNewLabel4.setEnabled(true);
		 textField_1.setEnabled(false);
		 
		// lblNewLabel_11.setEnabled(true);
		 textField_3.setEnabled(false); 
		 

		 
		 lblmensaje.setText("");
		 lblmensaje.setVisible(false);
		 
		 lblmensaje2.setText("");
		 lblmensaje2.setVisible(false);
		
	}
	
	
	public void enable () {
		boton_MOD.setEnabled(true);
		boton_ELI.setEnabled(false);
		
		//lblNewLabel.setEnabled(true);
		 textField.setEnabled(true);
		 
		// lblNewLabel_1.setEnabled(true);
		 textField_2.setEnabled(true);
		 
		 //lblNewLabel4.setEnabled(true);
		 textField_1.setEnabled(true);
		 
		 //lblNewLabel_11.setEnabled(true);
		 textField_3.setEnabled(true); 
	}
	
	public void first_enable () {
		chckbxNewCheckBox.setEnabled(true);
		boton_MOD.setEnabled(true);
		boton_ELI.setEnabled(false);
		

		//lblNewLabel.setEnabled(true);
		 textField.setEnabled(true);
		 
		// lblNewLabel_1.setEnabled(true);
		 textField_2.setEnabled(true);
		 
		 //lblNewLabel4.setEnabled(true);
		 textField_1.setEnabled(true);
		 
		 //lblNewLabel_11.setEnabled(true);
		 textField_3.setEnabled(true); 
	}
	
	public void first_disable () {
		chckbxNewCheckBox.setEnabled(false);
		boton_MOD.setEnabled(false);
		boton_ELI.setEnabled(false);
		
		
		//lblNewLabel.setEnabled(true);
		 textField.setEnabled(false);
		 
		 //lblNewLabel_1.setEnabled(true);
		 textField_2.setEnabled(false);
		 
		 //lblNewLabel4.setEnabled(true);
		 textField_1.setEnabled(false);
		 
		// lblNewLabel_11.setEnabled(true);
		 textField_3.setEnabled(false); 
	}

	public Pantalla_Mod_Eli_Admin(int num_fondo, int num_musica) {
		setBackground(new Color(199, 21, 133));
		setBounds(100, 100, 1122, 650);
		setLayout(null);
		

		
		JButton boton_volver = new JButton("VOLVER");
		boton_volver.setForeground(new Color(199, 21, 133));
		boton_volver.setBounds(10, 55, 122, 27);
		boton_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Menu_Admin (num_fondo,num_musica));
				
			}
		});
		boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_volver.setBackground(Color.PINK);
		add(boton_volver);

		lblmensaje.setOpaque(true);
		lblmensaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblmensaje.setForeground(Color.PINK);
		lblmensaje.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblmensaje.setBackground(Color.BLACK);
		lblmensaje.setBounds(642, 169, 317, 31);
		lblmensaje.setVisible(false);
		add(lblmensaje);
		
		lblmensaje2.setOpaque(true);
		lblmensaje2.setHorizontalAlignment(SwingConstants.LEFT);
		lblmensaje2.setForeground(Color.PINK);
		lblmensaje2.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblmensaje2.setBackground(Color.BLACK);
		lblmensaje2.setBounds(642, 505, 317, 31);
		lblmensaje2.setVisible(false);
		add(lblmensaje2);
		
		JButton boton_buscar = new JButton("BUSCAR");
		boton_buscar.setForeground(new Color(199, 21, 133));
		boton_buscar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_buscar.setBackground(Color.PINK);
		boton_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int re=0;
			
			//1 para errpr
			

			Controlador_Prenda b = new Controlador_Prenda();
			Prenda g= new Prenda ();
			
			if(textField_4B.getText().isEmpty()  ) {
				 lblmensaje.setVisible(true);
				 lblmensaje.setText("Ingresa lo que hay que buscar");
				 System.out.println("Vacio");
				re=1;
			}else {
				b = new Controlador_Prenda();
				g= new Prenda ();
				g.setName("" + textField_4B.getText());
				g=b.buscar_1_Prenda(g, comboBox.getSelectedItem().toString());
				lblmensaje.setVisible(false);
			}
		
			 if (g==null && !textField_4B.getText().isEmpty()) {
				re=1;
				 textField.setText("");
				 textField_2.setText("");
				 textField_1.setText ("");
				 textField_3.setText("");
				 lblmensaje.setVisible(true);
				 lblmensaje.setText("No encontrado");
			}else if (!textField_4B.getText().isEmpty()) {
				 textField.setText(g.getName());
				 textField_2.setText(""+g.getPuntaje());
				 textField_1.setText (g.getName_archivo());
				 textField_3.setText(g.getDescripcion());
				 lblmensaje.setText("");
				 lblmensaje.setVisible(false);
			}
			
			
			if(re==1) {
				first_disable();
			}else {
				first_enable();
			}
				
			}
		});
		boton_buscar.setBounds(775, 210, 122, 27);
		add(boton_buscar);
		

		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cuerpo", "Ojos", "Cejas", "Boca", "Vello", "Tatuaje", "Piercing", "Capa", "Peinado", "Pantalon", "Sombrero", "Lentes", "Calcetas", "Top", "Calzado"}));
		comboBox.setBounds(516, 113, 286, 31);
		comboBox.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		comboBox.setForeground(Color.PINK);
		comboBox.setBackground(Color.BLACK);
		add(comboBox);
		
		
		
		//buscar
		JLabel lblNewLabelB = new JLabel("Ingresa nombre");
		lblNewLabelB.setOpaque(true);
		lblNewLabelB.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabelB.setForeground(Color.PINK);
		lblNewLabelB.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabelB.setBackground(Color.BLACK);
		lblNewLabelB.setBounds(187, 80, 208, 33);
		add(lblNewLabelB);
		
		
		textField_4B.setForeground(new Color(199, 21, 133));
		textField_4B.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_4B.setColumns(10);
		textField_4B.setBackground(Color.PINK);
		textField_4B.setBounds(187, 113, 286, 33);
		add(textField_4B);
		
		
		JLabel lblNewLabelB2 = new JLabel("Selecciona categoria");
		lblNewLabelB2.setOpaque(true);
		lblNewLabelB2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabelB2.setForeground(Color.PINK);
		lblNewLabelB2.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabelB2.setBackground(Color.BLACK);
		lblNewLabelB2.setBounds(516, 80, 208, 33);
		add(lblNewLabelB2);
		
		
		//modifica
		JLabel lblNewLabel = new JLabel("Ingresa nombre");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(187, 233, 208, 33);
		add(lblNewLabel);
		
		 textField = new JTextField(" ");
		textField.setForeground(new Color(199, 21, 133));
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBackground(Color.PINK);
		textField.setBounds(187, 265, 286, 33);
		textField.setEditable(false);
		add(textField);
		
		textField_1 = new JTextField(" ");
		textField_1.setForeground(new Color(199, 21, 133));
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.PINK);
		textField_1.setBounds(187, 349, 286, 33);
		add(textField_1);
		

		JLabel lblNewLabel4 = new JLabel("Ingresa nombre del archivo");
		lblNewLabel4.setOpaque(true);
		lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel4.setForeground(Color.PINK);
		lblNewLabel4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel4.setBackground(Color.BLACK);
		lblNewLabel4.setBounds(187, 319, 208, 33);
		add(lblNewLabel4);
		
		textField_2 = new JTextField(" ");
		textField_2.setForeground(new Color(199, 21, 133));
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.PINK);
		textField_2.setBounds(516, 265, 286, 33);
		add(textField_2);
		
		lblNewLabel_1 = new JLabel("Ingresa puntaje");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(516, 233, 208, 33);
		add(lblNewLabel_1);
		
		
		textField_3 = new JTextField(" ");
		textField_3.setForeground(new Color(199, 21, 133));
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.PINK);
		textField_3.setBounds(516, 349, 286, 33);
		add(textField_3);
		
		 lblNewLabel_11 = new JLabel("Ingresa descripcion");
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setForeground(Color.PINK);
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_11.setBackground(Color.BLACK);
		lblNewLabel_11.setBounds(516, 319, 208, 33);
		add(lblNewLabel_11);
		
		
		
		 boton_MOD = new JButton("MODIFICAR");
		boton_MOD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            // Validación de campos vacíos
		            if (textField.getText().isBlank() ||
		                textField_3.getText().isBlank() ||
		                textField_1.getText().isBlank() ||
		                textField_2.getText().isBlank()) {
		                lblmensaje2.setText("Se deben llenar todos los campos");
		                lblmensaje2.setVisible(true);
		                return;
		            }

		            System.out.println("presiono");

		            // Validación del puntaje (debe ser número entero positivo)
		            int puntaje;
		            try {
		                puntaje = Integer.parseInt(textField_2.getText());
		                if (puntaje < 0) {
		                    lblmensaje2.setText("El puntaje debe ser un número positivo");
		                    lblmensaje2.setVisible(true);
		                    return;
		                }
		            } catch (NumberFormatException ex) {
		                lblmensaje2.setText("El puntaje debe ser un número entero positivo");
		                lblmensaje2.setVisible(true);
		                return;
		            }

		            // Creación de objetos
		            Prenda g = new Prenda();
		           
		            Controlador_Prenda b = new Controlador_Prenda();

		            // Seteo de datos en la prenda
		            g.setName(textField.getText().trim());
		            g.setDescripcion(textField_3.getText().trim());
		            g.setName_archivo(textField_1.getText().trim());
		            g.setPuntaje(puntaje);

		            int re=0;
		             b = new Controlador_Prenda();
		             re=b.modificar_Prenda(g, comboBox.getSelectedItem().toString());
		             g.anadir_llenar_todos();//añado observadoressssssssss
		            if (re !=-1) {
		             
		                first_disable();
						lblmensaje2.setText("Prenda modificada correctamente");
						lblmensaje2.setVisible(true);
						
						
						
						g.actualizar_todos(g, comboBox.getSelectedItem().toString());
						
		               // botonframe(new Pantalla_Menu_Admin(num_fondo, num_musica));
		            } else {
		            	lblmensaje2.setText("ERROR modificando la prenda");
		                lblmensaje2.setVisible(true);
		            }
		        } catch (Exception ex) {
		            lblmensaje2.setText("Error inesperado: " + ex.getMessage());
		            lblmensaje2.setVisible(true);
		            ex.printStackTrace();
		        }
				
					
				
			}
		});
		boton_MOD.setForeground(new Color(199, 21, 133));
		boton_MOD.setFont(new Font("Dialog", Font.PLAIN, 14));
		boton_MOD.setBackground(Color.PINK);
		boton_MOD.setBounds(775, 450, 122, 27);
		add(boton_MOD);
		
		
		//ELIMINAR
		
		 boton_ELI = new JButton("ELIMINAR");
		boton_ELI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int re=0;
				
				
				Controlador_Prenda b = new Controlador_Prenda();
				Prenda g= new Prenda ();
				g.setName("" + textField_4B.getText());
				re=b.eliminar_Prenda(g, comboBox.getSelectedItem().toString());
				if(re==-1) {
					lblmensaje2.setText("ERROR eliminando la prenda");
				}
				else {
					//botonframe (new Pantalla_Menu_Admin (num_fondo,num_musica));
					first_disable();
					lblmensaje2.setText("Prenda eliminada correctamente");
					lblmensaje2.setVisible(true);
					
				}
			}
		});
		boton_ELI.setForeground(new Color(199, 21, 133));
		boton_ELI.setFont(new Font("Dialog", Font.PLAIN, 14));
		boton_ELI.setBackground(Color.PINK);
		boton_ELI.setBounds(775, 546, 122, 27);
		add(boton_ELI);
		
		
		
		
		
		chckbxNewCheckBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxNewCheckBox.setForeground(Color.PINK);
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if(chckbxNewCheckBox.isSelected()) {
					disable();
				}
				else {
					enable();
					
				}
				
			}
		});
	
		chckbxNewCheckBox.setBounds(635, 545, 134, 31);
		add(chckbxNewCheckBox);
		first_disable ();
		
		
		JLabel ima = new JLabel();
		ima.setVerticalAlignment(SwingConstants.CENTER);
		ima.setIcon(imagenes.getUnota2("miadmin", 300));
		ima.setBorder(null);
		ima.setBounds(825, 148, 348, 360);
		add(ima);
		
		
		this.add_fondo(num_fondo);
		
		
	}
}
