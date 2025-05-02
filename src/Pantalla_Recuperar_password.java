import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pantalla_Recuperar_password extends Pantalla_secundaria{
	private JTextField textField_codigo;
	private JTextField passwordField;
	private JTextField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_usuario = new JTextField("");
	private JLabel lblNewLabel_mensaje;
	private JLabel lblNewLabel_mensaje1;
	private JLabel lblNewLabel_mensaje2;
	JLabel lblNewLabel3_codigo_obtenido= new JLabel("Ingresa codigo obtenido");
	JLabel lblNewLabel = new JLabel("Ingresa usuario");
	JLabel lblNewLabel_1_contrase = new JLabel("Ingresa nueva contraseña");
	JLabel lblNewLabel_1_newcontrase = new JLabel("Confirmar nueva contraseña");
	JButton boton_confirmar_codigo = new JButton("Confirmar codigo");
	JButton boton_cambiar = new JButton("Finalizar");
	JButton boton_obtener_codigo = new JButton("Obtener codigo");
	
	public Pantalla_Recuperar_password(int num_fondo, int num_musica) {
		super(num_fondo, num_musica);
		JButton boton_volver = new JButton("VOLVER");
		boton_volver.setForeground(new Color(199, 21, 133));
		boton_volver.setBounds(10, 55, 122, 27);
		boton_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Iniciar_Sesion (num_fondo,num_musica,0));
			}
		});
		boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_volver.setBackground(Color.PINK);
		add(boton_volver);
		
		//obtener codigo
		
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(440, 137, 208, 23);
		add(lblNewLabel);

		
		textField_usuario.setForeground(new Color(199, 21, 133));
		textField_usuario.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_usuario.setColumns(10);
		textField_usuario.setBackground(Color.PINK);
		textField_usuario.setBounds(440, 160, 286, 33);
		add(textField_usuario);
		
		
		boton_obtener_codigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Controlador_Correo controlador_correo= new Controlador_Correo ();
				
				if (textField_usuario.getText().isEmpty()) {   // si esta vacio
					lblNewLabel_mensaje1.setText("Llena el campo requerido");
					lblNewLabel_mensaje1.setVisible(true);
				} else {  //si esta lleno
					Controlador_Usuario basesita= new Controlador_Usuario ();
					Usuario usa=basesita.buscarUsuario_Correo(textField_usuario.getText());
					
					if(usa==null) { //no lo encontre
						lblNewLabel_mensaje1.setText("Ese usuario NO existe");
						lblNewLabel_mensaje1.setVisible(true);
					} else {  // lo encontre
						int re=controlador_correo.enviarCorreo(usa.getCorreo());
						
						if(re==0) {
							lblNewLabel_mensaje1.setText("El correo no se pudo enviar");
							lblNewLabel_mensaje1.setVisible(true);
						}else {
							lblNewLabel_mensaje1.setText("Correo enviado");
							lblNewLabel_mensaje1.setVisible(true);
							set_enabled(1);
						}
						
						
					}
					
				}
				
				
			}
		});
		boton_obtener_codigo.setForeground(Color.PINK);
		boton_obtener_codigo.setBounds(876, 198, 182, 40);
		boton_obtener_codigo.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_obtener_codigo.setBackground(new Color(199, 21, 133));
		add(boton_obtener_codigo);
		
		//confirmar codigo
		
		lblNewLabel3_codigo_obtenido.setOpaque(true);
		lblNewLabel3_codigo_obtenido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel3_codigo_obtenido.setForeground(Color.PINK);
		lblNewLabel3_codigo_obtenido.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel3_codigo_obtenido.setBackground(Color.BLACK);
		lblNewLabel3_codigo_obtenido.setBounds(440, 269, 208, 23);
		add(lblNewLabel3_codigo_obtenido);
		
		textField_codigo = new JTextField("");
		textField_codigo.setForeground(new Color(199, 21, 133));
		textField_codigo.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_codigo.setColumns(10);
		textField_codigo.setBackground(Color.PINK);
		textField_codigo.setBounds(440, 294, 286, 33);
		add(textField_codigo);
		
		
		
		boton_confirmar_codigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador_Correo controlador_correo= new Controlador_Correo ();
				int re= controlador_correo.verificar_Codigo(textField_codigo.getText());
				if(re==0) {
					lblNewLabel_mensaje2.setText("Codigo inválido");
					lblNewLabel_mensaje2.setVisible(true);
				}else {
					set_enabled(2);
					set_disabled(3);
					set_disabled(1);
					lblNewLabel_mensaje2.setText("Codigo verificado exitosamente");
					lblNewLabel_mensaje2.setVisible(true);
					
					lblNewLabel_mensaje.setVisible(false);
					lblNewLabel_mensaje1.setVisible(false);
				}
				
			}
		});
		boton_confirmar_codigo.setForeground(Color.PINK);
		boton_confirmar_codigo.setBounds(876, 333, 182, 40);
		boton_confirmar_codigo.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_confirmar_codigo.setBackground(new Color(199, 21, 133));
		add(boton_confirmar_codigo);
		
		//cambiar contraseñas
		
		lblNewLabel_1_contrase.setOpaque(true);
		lblNewLabel_1_contrase.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_contrase.setForeground(Color.PINK);
		lblNewLabel_1_contrase.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1_contrase.setBackground(Color.BLACK);
		lblNewLabel_1_contrase.setBounds(440, 390, 247, 23);
		add(lblNewLabel_1_contrase);
		
		passwordField_1 = new JTextField("");
		passwordField_1.setForeground(new Color(199, 21, 133));
		passwordField_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField_1.setBackground(Color.PINK);
		passwordField_1.setBounds(440, 491, 286, 33);
		add(passwordField_1);
		
		
		lblNewLabel_1_newcontrase.setOpaque(true);
		lblNewLabel_1_newcontrase.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_newcontrase.setForeground(Color.PINK);
		lblNewLabel_1_newcontrase.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1_newcontrase.setBackground(Color.BLACK);
		lblNewLabel_1_newcontrase.setBounds(440, 467, 247, 23);
		add(lblNewLabel_1_newcontrase);
		
		passwordField = new JTextField("");
		passwordField.setForeground(new Color(199, 21, 133));
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
		passwordField.setBackground(Color.PINK);
		passwordField.setBounds(440, 415, 286, 33);
		add(passwordField);
		
		
		boton_cambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int band=0;
				if (passwordField.getText().isEmpty() || passwordField_1.getText().isEmpty()) {
					lblNewLabel_mensaje.setText("Llene todos los campos");
					lblNewLabel_mensaje.setVisible(true);
				} else if (!passwordField.getText().equals(passwordField_1.getText())) {
					lblNewLabel_mensaje.setText("Las contraseñas no coinciden");
					lblNewLabel_mensaje.setVisible(true);
				} else {
					Controlador_Usuario basesita= new Controlador_Usuario ();
					band=basesita.cambiar_password(textField_usuario.getText(), passwordField.getText());
					
					if (band==1) {
						
						
						set_disabled (1);
						set_disabled (2);
						set_enabled(3);
						
						lblNewLabel_mensaje.setVisible(true);
						lblNewLabel_mensaje.setText("Contraseña actualizada exitosamente");
						
						lblNewLabel_mensaje2.setVisible(false);
						lblNewLabel_mensaje1.setVisible(false);
						
						textField_codigo.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						
						
					}else {
						lblNewLabel_mensaje.setText("");
						lblNewLabel_mensaje1.setVisible(false);
					}
					
					
				}
				
				
				
			}
		});
		boton_cambiar.setForeground(Color.PINK);
		boton_cambiar.setBounds(876, 525, 182, 40);
		boton_cambiar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_cambiar.setBackground(new Color(199, 21, 133));
		add(boton_cambiar);
		

		//logic
		lblNewLabel_mensaje =new JLabel("");
		lblNewLabel_mensaje.setBackground(new Color(0, 0, 0));
		lblNewLabel_mensaje.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_mensaje.setForeground(Color.PINK);
		lblNewLabel_mensaje.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		lblNewLabel_mensaje.setBounds(772, 491, 286, 33);
		lblNewLabel_mensaje.setVisible(true);
		lblNewLabel_mensaje.setOpaque(true);
		add(lblNewLabel_mensaje);
		
		lblNewLabel_mensaje1 =new JLabel("");
		lblNewLabel_mensaje1.setBackground(new Color(0, 0, 0));
		lblNewLabel_mensaje1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_mensaje1.setForeground(Color.PINK);
		lblNewLabel_mensaje1.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		lblNewLabel_mensaje1.setBounds(772, 164, 286, 33);
		lblNewLabel_mensaje1.setVisible(false);
		lblNewLabel_mensaje1.setOpaque(true);
		add(lblNewLabel_mensaje1);
		
		lblNewLabel_mensaje2 =new JLabel("");
		lblNewLabel_mensaje2.setBackground(new Color(0, 0, 0));
		lblNewLabel_mensaje2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_mensaje2.setForeground(Color.PINK);
		lblNewLabel_mensaje2.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		lblNewLabel_mensaje2.setBounds(772, 295, 286, 33);
		lblNewLabel_mensaje2.setVisible(true);
		lblNewLabel_mensaje2.setOpaque(true);
		add(lblNewLabel_mensaje2);
		
		JLabel lblNewLabel_80 = new JLabel("Dressing up!");
		lblNewLabel_80.setForeground(Color.PINK);
		lblNewLabel_80.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_80.setFont(new Font(fuente, Font.PLAIN, 100));
		lblNewLabel_80.setBounds(488, -3, 679, 151);
		add(lblNewLabel_80);
		
		JLabel lblNewLabel_81 = new JLabel("Dressing up!");
		lblNewLabel_81.setForeground(new Color(199, 21, 133));
		lblNewLabel_81.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_81.setFont(new Font(fuente, Font.PLAIN, 100));
		lblNewLabel_81.setBounds(491, -3, 679, 151);
		add(lblNewLabel_81);

		
		set_disabled (1);
		set_disabled (2);
		this.add_fondo(num_fondo);
		this.boton_ajustes(0,new Usuario (),num_fondo,num_musica);
		// TODO Auto-generated constructor stub
	}
	
	
	public void set_enabled (int num) {
		if (num==1) {
			lblNewLabel3_codigo_obtenido.setEnabled(true);
			textField_codigo.setEnabled(true);
			boton_confirmar_codigo.setEnabled(true);
			lblNewLabel_mensaje1.setVisible(true);
		}else if (num==2) {
			lblNewLabel_1_contrase.setEnabled(true);
			lblNewLabel_1_newcontrase.setEnabled(true);
			passwordField.setEnabled(true);
			passwordField_1.setEnabled(true);
			 boton_cambiar.setEnabled(true);
				lblNewLabel_mensaje.setVisible(true);
		} else if (num==3) {
			lblNewLabel.setEnabled(true);
			textField_usuario.setEnabled(true);
			boton_obtener_codigo.setEnabled(true);
			lblNewLabel_mensaje1.setVisible(true);
		}
		
	}
	
	public void set_disabled (int num) {
		if (num==1) {
			lblNewLabel3_codigo_obtenido.setEnabled(false);
			textField_codigo.setEnabled(false);
			boton_confirmar_codigo.setEnabled(false);
			lblNewLabel_mensaje2.setText("");
			lblNewLabel_mensaje2.setVisible(false);
		}else if (num==2) {
			lblNewLabel_1_contrase.setEnabled(false);
			lblNewLabel_1_newcontrase.setEnabled(false);
			passwordField.setEnabled(false);
			passwordField_1.setEnabled(false);
			 boton_cambiar.setEnabled(false);
			 lblNewLabel_mensaje.setText("");
			 lblNewLabel_mensaje.setVisible(false);
			 
		
			lblNewLabel_mensaje.setVisible(false);
		} else if (num==3) {
			lblNewLabel.setEnabled(false);
			textField_usuario.setEnabled(false);
			boton_obtener_codigo.setEnabled(false);
			lblNewLabel_mensaje1.setText("");
			 lblNewLabel_mensaje1.setVisible(false);
		}
		
		
		
		
	}
}
