import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Pantalla_Ajustes extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);
	protected String fuente= "Goudy Old Style";
	private JTextField textField;
	private JTextField passwordField;
	private JTextField passwordField_1;
	private JTextField textField_1;
	private Usuario usuario;

	
	public void botonframe (JPanel b) {
		removeAll();
		setLayout(new BorderLayout(0, 0));
		add(b);
		repaint();
		revalidate();
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

	
	public Pantalla_Ajustes(int num_fondo, int num_musica) {
		System.out.println("num_fondo"+num_fondo);
		
		setBackground(new Color(199, 21, 133));
		setBounds(100, 100, 1122, 650);
		setLayout(null);
		JButton boton_volver = new JButton("VOLVER");
		boton_volver.setForeground(new Color(199, 21, 133));
		boton_volver.setBounds(10, 10, 217, 40);
		boton_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Menu_principal (num_fondo,num_musica));
			}
		});
		boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_volver.setBackground(Color.PINK);
		add(boton_volver);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Ajustes(1,num_musica));
			}
		});
		btnNewButton.setIcon(imagenes.getfondo("1"));
		btnNewButton.setBackground(new Color(255, 255, 153));
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 99, 205, 202);
		add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Ajustes(2,num_musica));
			}
		});
		btnNewButton2.setIcon(imagenes.getfondo("2"));
		btnNewButton2.setBackground(new Color(255, 255, 153));
		btnNewButton2.setOpaque(false);
		btnNewButton2.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton2.setBounds(225, 99, 205, 202);
		add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Ajustes(3,num_musica));
			}
		});
		btnNewButton3.setIcon(imagenes.getfondo("3"));
		btnNewButton3.setBackground(new Color(255, 255, 153));
		btnNewButton3.setOpaque(false);
		btnNewButton3.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton3.setBounds(440, 99, 205, 202);
		add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Ajustes(4,num_musica));
			}
		});
		
		btnNewButton4.setIcon(imagenes.getfondo("4"));
		btnNewButton4.setBackground(new Color(255, 255, 153));
		btnNewButton4.setOpaque(false);
		btnNewButton4.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton4.setBounds(669, 99, 205, 202);
		add(btnNewButton4);
		
		
	
		JButton btnNewButton5 = new JButton("");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Ajustes(5,num_musica));
			}
		});
		
		btnNewButton5.setIcon(imagenes.getfondo("5"));
		btnNewButton5.setBackground(new Color(255, 255, 153));
		btnNewButton5.setOpaque(false);
		btnNewButton5.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton5.setBounds(884, 99, 205, 202);
		add(btnNewButton5);
		
		
		this.add_fondo(num_fondo);
	}
	
	/**
	 * Create the panel.
	 * @wbp.parser.constructor
	 */
	public Pantalla_Ajustes(Usuario usa) {
		//super(num_fondo, num_musica);
		// TODO Auto-generated constructor stub
		setBackground(new Color(199, 21, 133));
		setBounds(100, 100, 1122, 650);
		setLayout(null);
		
		JLabel lblmensaje = new JLabel("");
		lblmensaje.setOpaque(true);
		lblmensaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblmensaje.setForeground(Color.PINK);
		lblmensaje.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblmensaje.setBackground(Color.BLACK);
		lblmensaje.setBounds(876, 517, 258, 33);
		lblmensaje.setVisible(false);
		add(lblmensaje);
		
	
		
		JButton boton_volver = new JButton("VOLVER");
		boton_volver.setForeground(new Color(199, 21, 133));
		boton_volver.setBounds(10, 10, 122, 27);
		boton_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Menu_Usuario (usa));
			}
		});
		boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_volver.setBackground(Color.PINK);
		add(boton_volver);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_fondo(usa.getCve_usuario(),1);
				usa.setFondo(re);
				botonframe (new Pantalla_Ajustes(usa));
			}
		});
		btnNewButton.setIcon(imagenes.getfondo("1"));
		btnNewButton.setBackground(new Color(255, 255, 153));
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton.setBounds(12, 79, 168, 153);
		add(btnNewButton);
		
		JButton btnNewButton2 = new JButton("");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_fondo(usa.getCve_usuario(),2);
				usa.setFondo(re);
				botonframe (new Pantalla_Ajustes(usa));
			}
		});
		btnNewButton2.setIcon(imagenes.getfondo("2"));
		btnNewButton2.setBackground(new Color(255, 255, 153));
		btnNewButton2.setOpaque(false);
		btnNewButton2.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton2.setBounds(179, 79, 168, 153);
		add(btnNewButton2);
		
		JButton btnNewButton3 = new JButton("");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_fondo(usa.getCve_usuario(),3);
				usa.setFondo(re);
				botonframe (new Pantalla_Ajustes(usa));
			}
		});
		btnNewButton3.setIcon(imagenes.getfondo("3"));
		btnNewButton3.setBackground(new Color(255, 255, 153));
		btnNewButton3.setOpaque(false);
		btnNewButton3.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton3.setBounds(346, 79, 170, 153);
		add(btnNewButton3);
		
		JButton btnNewButton4 = new JButton("");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_fondo(usa.getCve_usuario(),4);
				usa.setFondo(re);
				botonframe (new Pantalla_Ajustes(usa));
			}
		});
		
		btnNewButton4.setIcon(imagenes.getfondo("4"));
		btnNewButton4.setBackground(new Color(255, 255, 153));
		btnNewButton4.setOpaque(false);
		btnNewButton4.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton4.setBounds(513, 79, 168, 153);
		add(btnNewButton4);
		
		
	
		JButton btnNewButton5 = new JButton("");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_fondo(usa.getCve_usuario(),5);
				usa.setFondo(re);
				botonframe (new Pantalla_Ajustes(usa));
			}
		});
		
		btnNewButton5.setIcon(imagenes.getfondo("5"));
		btnNewButton5.setBackground(new Color(255, 255, 153));
		btnNewButton5.setOpaque(false);
		btnNewButton5.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton5.setBounds(675, 79, 162, 153);
		add(btnNewButton5);
		
		
		
		
		//
		JLabel lblNewLabel_2 = new JLabel("Seleccionar fondo");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(10, 47, 217, 33);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Actualizar datos");
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setForeground(Color.PINK);
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_2_1.setBackground(Color.BLACK);
		lblNewLabel_2_1.setBounds(10, 443, 217, 33);
		add(lblNewLabel_2_1);
		
		
		textField = new JTextField(""+usa.getUser());
		textField.setForeground(new Color(199, 21, 133));
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBackground(Color.PINK);
		textField.setBounds(237, 474, 286, 33);
		add(textField);
		
		passwordField = new JTextField(usa.getPassword());
		passwordField.setForeground(new Color(199, 21, 133));
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField.setBackground(Color.PINK);
		passwordField.setBounds(556, 474, 286, 33);
		add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Ingresa nuevo usuario");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(237, 443, 208, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa nueva contraseña");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(556, 443, 247, 33);
		add(lblNewLabel_1);
		
		JButton boton_iniciarsesion = new JButton("CREAR CUENTA");
		boton_iniciarsesion.setForeground(new Color(199, 21, 133));
		boton_iniciarsesion.setFont(new Font("Dialog", Font.PLAIN, 14));
		boton_iniciarsesion.setBackground(Color.PINK);
		boton_iniciarsesion.setBounds(835, 682, 217, 40);
		add(boton_iniciarsesion);
		
		passwordField_1 = new JTextField(usa.getPassword());
		passwordField_1.setForeground(new Color(199, 21, 133));
		passwordField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField_1.setBackground(Color.PINK);
		passwordField_1.setBounds(556, 550, 286, 33);
		add(passwordField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirmar nueva contraseña");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.PINK);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(556, 517, 247, 33);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ingresa nuevo correo");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.PINK);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(239, 517, 208, 33);
		add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField(""+usa.getCorreo());
		textField_1.setForeground(new Color(199, 21, 133));
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.PINK);
		textField_1.setBounds(237, 550, 286, 33);
		add(textField_1);
		
		
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Usuario");
		chckbxNewCheckBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxNewCheckBox.setForeground(Color.PINK);
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(chckbxNewCheckBox.isSelected()) {
					textField.setEnabled(true);
					
				}
				else {
					textField.setEnabled(false);
					textField.setText(usa.getUser());
				}
				
				
			}
		});
		textField.setEnabled(false);
		chckbxNewCheckBox.setBounds(10, 505, 131, 21);
		add(chckbxNewCheckBox);
		
		
		JCheckBox chckbxNewCheckBox2 = new JCheckBox("Correo");
		chckbxNewCheckBox2.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxNewCheckBox2.setForeground(Color.PINK);
		chckbxNewCheckBox2.setBackground(Color.BLACK);
		chckbxNewCheckBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(chckbxNewCheckBox2.isSelected()) {
					textField_1.setEnabled(true);
				}
				else {
					textField_1.setEnabled(false);
					textField_1.setText(usa.getCorreo());
					//textField_1.setText("");
				}
				
				
			}
		});
		textField_1.setEnabled(false);
		chckbxNewCheckBox2.setBounds(10, 486, 131, 21);
		add(chckbxNewCheckBox2);
		
		

		JCheckBox chckbxNewCheckBox3 = new JCheckBox("Contraseña");
		chckbxNewCheckBox3.setFont(new Font("Dialog", Font.PLAIN, 12));
		chckbxNewCheckBox3.setForeground(Color.PINK);
		chckbxNewCheckBox3.setBackground(Color.BLACK);
		chckbxNewCheckBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(chckbxNewCheckBox3.isSelected()) {
					passwordField.setEnabled(true);
					passwordField_1.setEnabled(true);
				}
				else {
					passwordField.setEnabled(false);
					passwordField_1.setEnabled(false);
					passwordField.setText(""+usa.getPassword());
					passwordField_1.setText(""+usa.getPassword());
					
				}
				
				
			}
		});
		passwordField.setEnabled(false);
		passwordField_1.setEnabled(false);
		chckbxNewCheckBox3.setBounds(10, 525, 131, 21);
		add(chckbxNewCheckBox3);
		
		
		
		usuario=usa;
		JButton boton_guardar = new JButton("GUARDAR");
		boton_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!chckbxNewCheckBox2.isSelected() && !chckbxNewCheckBox.isSelected() && !chckbxNewCheckBox3.isSelected()) {
					//si no seleccione nada
					lblmensaje.setText("Realiza cambios en al menos un campo");
					lblmensaje.setVisible(true);
					
				}
				else if (!passwordField.getText().equals(passwordField_1.getText())) {
					//si no coinciden las nuevas contraseñas
					lblmensaje.setText("La contraseña no coincide");
					lblmensaje.setVisible(true);
				}
				else {
					//si seleccione checkbox y coinciden las contraseñas
					usuario.setCorreo(textField_1.getText());
					usuario.setPassword(passwordField.getText());
					usuario.setUser(textField.getText() );
					
					Controlador_Usuario basesita= new Controlador_Usuario ();
					int re=basesita.actualizarUsuario(usuario);
					
					if (re==0) {
						botonframe (new Pantalla_Menu_Usuario(usuario));
						lblmensaje.setText("");
						lblmensaje.setVisible(false);
						
					}else {
						lblmensaje.setText("Usuario existente");
						lblmensaje.setVisible(false);
					}
					
					
					
				
				}
					
				
			}
		});
		boton_guardar.setForeground(Color.PINK);
		boton_guardar.setFont(new Font("Dialog", Font.PLAIN, 14));
		boton_guardar.setBackground(new Color(199, 21, 133));
		boton_guardar.setBounds(930, 554, 122, 27);
		add(boton_guardar);
		
		
		JLabel selecF = new JLabel("Seleccionar foto de perfil");
		selecF.setOpaque(true);
		selecF.setHorizontalAlignment(SwingConstants.LEFT);
		selecF.setForeground(Color.PINK);
		selecF.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecF.setBackground(Color.BLACK);
		selecF.setBounds(10, 242, 217, 33);
		add(selecF);
		
		JButton btnNewButton7 = new JButton("");
		btnNewButton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_foto(usa.getCve_usuario(),1);
				usa.setFoto_perfil(re);
				botonframe (new Pantalla_Menu_Usuario(usa));
			}
		});
		btnNewButton7.setIcon(imagenes.getperfil("1p",40,40));
		btnNewButton7.setOpaque(false);
		btnNewButton7.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton7.setBackground(new Color(255, 255, 153));
		btnNewButton7.setBounds(10, 274, 168, 153);
		add(btnNewButton7);
		
		
		JButton btnNewButton8 = new JButton("");
		btnNewButton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_foto(usa.getCve_usuario(),2);
				usa.setFoto_perfil(re);
				botonframe (new Pantalla_Menu_Usuario(usa));
				
				
			}
		});
		btnNewButton8.setIcon(imagenes.getperfil("2p",40,40));
		btnNewButton8.setOpaque(false);
		btnNewButton8.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton8.setBackground(new Color(255, 255, 153));
		btnNewButton8.setBounds(179, 274, 168, 153);
		add(btnNewButton8);
		
		
		JButton btnNewButton8_ = new JButton("");
		btnNewButton8_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_foto(usa.getCve_usuario(),3);
				usa.setFoto_perfil(re);
				botonframe (new Pantalla_Menu_Usuario(usa));
			}
		});
		btnNewButton8_.setOpaque(false);
		btnNewButton8_.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton8_.setBackground(new Color(255, 255, 153));
		btnNewButton8_.setBounds(348, 274, 168, 153);
		btnNewButton8_.setIcon(imagenes.getperfil("3p",40,40));
		add(btnNewButton8_);
		
		JButton btnNewButton8_1 = new JButton("");
		btnNewButton8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_foto(usa.getCve_usuario(),4);
				usa.setFoto_perfil(re);
				botonframe (new Pantalla_Menu_Usuario(usa));
			}
		});
		btnNewButton8_1.setOpaque(false);
		btnNewButton8_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton8_1.setBackground(new Color(255, 255, 153));
		btnNewButton8_1.setBounds(513, 274, 168, 153);
		btnNewButton8_1.setIcon(imagenes.getperfil("4p",40,40));
		add(btnNewButton8_1);
		
		JButton btnNewButton8_1_1 = new JButton("");
		btnNewButton8_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_foto(usa.getCve_usuario(),5);
				usa.setFoto_perfil(re);
				botonframe (new Pantalla_Menu_Usuario(usa));
			}
		});
		btnNewButton8_1_1.setOpaque(false);
		btnNewButton8_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton8_1_1.setBackground(new Color(255, 255, 153));
		btnNewButton8_1_1.setBounds(675, 274, 168, 153);
		btnNewButton8_1_1.setIcon(imagenes.getperfil("5p",40,40));
		add(btnNewButton8_1_1);
		
		JButton btnNewButton8_1_1_1 = new JButton("");
		btnNewButton8_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Usuario basesita= new Controlador_Usuario ();
				int re=basesita.cambiar_foto(usa.getCve_usuario(),6);
				usa.setFoto_perfil(re);
				botonframe (new Pantalla_Menu_Usuario(usa));
			}
		});
		btnNewButton8_1_1_1.setOpaque(false);
		btnNewButton8_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNewButton8_1_1_1.setBackground(new Color(255, 255, 153));
		btnNewButton8_1_1_1.setBounds(835, 274, 168, 153);
		btnNewButton8_1_1_1.setIcon(imagenes.getperfil("6p",40,40));
		add(btnNewButton8_1_1_1);
		
		
		
		
		this.add_fondo(usa.getFondo());
	}
}

	