import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pantalla_Crear_Cuenta extends Pantalla_secundaria {
	private JTextField textField;
	private JLabel lblNewLabel_1_1_1;
	private JPasswordField passwordField;


	//private static final long serialVersionUID = 1L;
	private JPasswordField passwordField_1;
	private JTextField textField_1;

	public Pantalla_Crear_Cuenta(int num_fondo, int num_musica) {
		super(num_fondo, num_musica);
		
		JLabel lblNewLabel_80 = new JLabel("Dressing up!");
		lblNewLabel_80.setForeground(Color.PINK);
		lblNewLabel_80.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_80.setFont(new Font(fuente, Font.PLAIN, 100));
		lblNewLabel_80.setBounds(488, -3, 679, 144);
		add(lblNewLabel_80);
		
		JLabel lblNewLabel_81 = new JLabel("Dressing up!");
		lblNewLabel_81.setForeground(new Color(199, 21, 133));
		lblNewLabel_81.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_81.setFont(new Font(fuente, Font.PLAIN, 100));
		lblNewLabel_81.setBounds(491, -3, 679, 144);
		add(lblNewLabel_81);
		
		JLabel lblNewLabel_2 =new JLabel("");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(648, 503, 343, 33);
		lblNewLabel_2.setVisible(false);
		
		textField = new JTextField();
		textField.setForeground(new Color(199, 21, 133));
		textField.setBackground(Color.PINK);
		textField.setBounds(705, 203, 286, 33);
		textField.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		textField.setColumns(10);
		add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(199, 21, 133));
		passwordField.setBackground(Color.PINK);
		passwordField.setBounds(705, 384, 286, 33);
		passwordField.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Ingresa usuario");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(705, 172, 208, 33);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingresa contraseña");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(705, 353, 208, 33);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		add(lblNewLabel_1);
		
		JButton boton_iniciarsesion = new JButton("CREAR CUENTA");
		boton_iniciarsesion.setForeground(Color.PINK);
		boton_iniciarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int re=0;
				
					Controlador_Usuario basesita= new Controlador_Usuario ();
					re=basesita.verificarUsuario(textField.getText());
					//basesita.cerrarConexion();
				
				if (textField.getText().isEmpty() || passwordField.getText().isEmpty() ||  passwordField_1.getText().isEmpty() || textField_1.getText().isEmpty()) {
					lblNewLabel_2.setText("Llene todos los campos");
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setOpaque(true);
					
				} else if (!passwordField.getText().equals(passwordField_1.getText())) {
					lblNewLabel_2.setText("Las contraseñas no coinciden");
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setOpaque (true);
				
				}else if (re==1){
					lblNewLabel_2.setText("Ese usuario ya existe");
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setOpaque (true);
				}
				else {
					lblNewLabel_2.setText("***Creando usuario***");
					basesita= new Controlador_Usuario ();                                              
					basesita.insertarUsuario(new Usuario (textField.getText(), passwordField.getText(),textField_1.getText(),1,1,1));
					
					lblNewLabel_2.setVisible(false);
					lblNewLabel_2.setOpaque(true);
					botonframe (new Pantalla_Iniciar_Sesion (num_fondo,num_musica,1));
					}
				}
				
			
		});
		boton_iniciarsesion.setBounds(774, 546, 217, 40);
		boton_iniciarsesion.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_iniciarsesion.setBackground(new Color(199, 21, 133));
		add(boton_iniciarsesion);
		
		JButton boton_volver = new JButton("VOLVER");
		boton_volver.setForeground(new Color(199, 21, 133));
		boton_volver.setBounds(10, 53, 122, 27);
		boton_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Menu_principal (num_fondo,num_musica));
				
				
			}
		});
		boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_volver.setBackground(Color.PINK);
		add(boton_volver);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setForeground(new Color(199, 21, 133));
		passwordField_1.setBackground(Color.PINK);
		passwordField_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		passwordField_1.setBounds(705, 460, 286, 33);
		add(passwordField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirmar contraseña");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.PINK);
		lblNewLabel_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(705, 427, 208, 33);
		add(lblNewLabel_1_1);
		
		JLabel ima = new JLabel();
		ima.setVerticalAlignment(SwingConstants.CENTER);
		ima.setIcon(imagenes.getUnotam(3,400, 430, 600));
		ima.setBorder(null);
		ima.setBounds(53, 168, 444, 449);
		add(ima);
		
		
		add(lblNewLabel_2);
		
		
		//correo
		 lblNewLabel_1_1_1 = new JLabel("Ingresa correo");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setForeground(Color.PINK);
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(705, 246, 208, 33);
		add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(199, 21, 133));
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.PINK);
		textField_1.setBounds(705, 277, 286, 33);
		add(textField_1);
		
		this.boton_ajustes(0,new Usuario (),num_fondo,num_musica);
		this.add_fondo(num_fondo);
		// TODO Auto-generated constructor stub
	}
}
