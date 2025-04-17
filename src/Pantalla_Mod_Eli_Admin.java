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
	JLabel lblNewLabel_11=new JLabel ();
	JLabel lblNewLabel_1=new JLabel ();
	JTextField textField=new JTextField ();
	
	JButton boton_MOD= new JButton ();
	JButton boton_ELI= new JButton ();

	/**
	 * Create the panel.
	 */
	

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
		
		JButton boton_buscar = new JButton("BUSCAR");
		boton_buscar.setForeground(new Color(199, 21, 133));
		boton_buscar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_buscar.setBackground(Color.PINK);
		boton_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int re=0;
			if(re==1) {
				disable();
			}else {
				enable();
			}
				
			}
		});
		boton_buscar.setBounds(775, 147, 122, 27);
		add(boton_buscar);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cuerpo", "Ojos", "Cejas", "Boca", "Vello", "Tatuaje", "Piercing", "Capa", "Peinado", "Pantalon", "Sombrero", "Lentes", "Calcetas", "Top", "Calzado"}));
		comboBox.setBounds(516, 145, 208, 31);
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
		lblNewLabelB.setBounds(187, 114, 208, 33);
		add(lblNewLabelB);
		
		JTextField textField_4B = new JTextField(" ");
		textField_4B.setForeground(new Color(199, 21, 133));
		textField_4B.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_4B.setColumns(10);
		textField_4B.setBackground(Color.PINK);
		textField_4B.setBounds(187, 145, 286, 33);
		add(textField_4B);
		
		
		//modifica
		JLabel lblNewLabel = new JLabel("Ingresa nombre");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(187, 267, 208, 33);
		add(lblNewLabel);
		
		 textField = new JTextField(" ");
		textField.setForeground(new Color(199, 21, 133));
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBackground(Color.PINK);
		textField.setBounds(187, 299, 286, 33);
		add(textField);
		
		textField_1 = new JTextField(" ");
		textField_1.setForeground(new Color(199, 21, 133));
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.PINK);
		textField_1.setBounds(187, 383, 286, 33);
		add(textField_1);
		

		JLabel lblNewLabel4 = new JLabel("Ingresa nombre del archivo");
		lblNewLabel4.setOpaque(true);
		lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel4.setForeground(Color.PINK);
		lblNewLabel4.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel4.setBackground(Color.BLACK);
		lblNewLabel4.setBounds(187, 353, 208, 33);
		add(lblNewLabel4);
		
		textField_2 = new JTextField(" ");
		textField_2.setForeground(new Color(199, 21, 133));
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.PINK);
		textField_2.setBounds(516, 299, 286, 33);
		add(textField_2);
		
		lblNewLabel_1 = new JLabel("Ingresa puntaje");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(516, 267, 208, 33);
		add(lblNewLabel_1);
		
		
		textField_3 = new JTextField(" ");
		textField_3.setForeground(new Color(199, 21, 133));
		textField_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.PINK);
		textField_3.setBounds(516, 383, 286, 33);
		add(textField_3);
		
		 lblNewLabel_11 = new JLabel("Ingresa descripcion");
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setForeground(Color.PINK);
		lblNewLabel_11.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_11.setBackground(Color.BLACK);
		lblNewLabel_11.setBounds(516, 353, 208, 33);
		add(lblNewLabel_11);
		
		disable();
		
		 boton_MOD = new JButton("MODIFICAR");
		boton_MOD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int re=0;
				
				if(re==1) {
					
				}
				else {
					botonframe (new Pantalla_Menu_Admin (num_fondo,num_musica));
				}
			}
		});
		boton_MOD.setForeground(new Color(199, 21, 133));
		boton_MOD.setFont(new Font("Dialog", Font.PLAIN, 14));
		boton_MOD.setBackground(Color.PINK);
		boton_MOD.setBounds(775, 461, 122, 27);
		add(boton_MOD);
		
		
		//ELIMINAR
		
		 boton_ELI = new JButton("ELIMINAR");
		boton_ELI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int re=0;
				
				if(re==1) {
					
				}
				else {
					botonframe (new Pantalla_Menu_Admin (num_fondo,num_musica));
				}
			}
		});
		boton_ELI.setForeground(new Color(199, 21, 133));
		boton_ELI.setFont(new Font("Dialog", Font.PLAIN, 14));
		boton_ELI.setBackground(Color.PINK);
		boton_ELI.setBounds(775, 528, 122, 27);
		add(boton_ELI);
		
		this.add_fondo(num_fondo);
		
		this.disable();
		//this.boton_ajustes(0,new Usuario (),num_fondo,num_musica);
	}

	
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
		 textField_1.setEnabled(false);
		 textField_2.setEnabled(false);
		 textField_3.setEnabled(false);
		 textField.setEnabled(false);
		 boton_MOD.setEnabled (false);
		 boton_ELI.setEnabled (false);
		 
		
	}
	
	
	public void enable () {
		 textField_1.setEnabled(true);
		 textField_2.setEnabled(true);
		 textField_3.setEnabled(true);
		 textField.setEnabled(true);
		 boton_MOD.setEnabled (true);
		 boton_ELI.setEnabled (true);
	}
}
