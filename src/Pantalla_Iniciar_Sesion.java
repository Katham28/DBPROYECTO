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

public class Pantalla_Iniciar_Sesion extends Pantalla_secundaria{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	JLabel lblNewLabel_2;
	
	/**
	 * Create the panel.
	 */
	public Pantalla_Iniciar_Sesion(int num_fondo, int num_musica,int band) {
		super(num_fondo, num_musica);
		
			
			JLabel lblNewLabel_80 = new JLabel("Dressing up!");
			lblNewLabel_80.setForeground(Color.PINK);
			lblNewLabel_80.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_80.setFont(new Font(fuente, Font.PLAIN, 100));
			lblNewLabel_80.setBounds(488, -3, 679, 290);
			add(lblNewLabel_80);
			
			JLabel lblNewLabel_81 = new JLabel("Dressing up!");
			lblNewLabel_81.setForeground(new Color(199, 21, 133));
			lblNewLabel_81.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_81.setFont(new Font(fuente, Font.PLAIN, 100));
			lblNewLabel_81.setBounds(491, -3, 679, 290);
			add(lblNewLabel_81);
			

			lblNewLabel_2 =new JLabel("");
			lblNewLabel_2.setBackground(new Color(0, 0, 0));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setForeground(Color.PINK);
			lblNewLabel_2.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(676, 465, 286, 33);
			lblNewLabel_2.setVisible(false);
			
			JLabel lblband =new JLabel("Cuenta creada exitosamente,ahora inicia sesión :)");
			lblband.setBackground(new Color(0, 0, 0));
			lblband.setHorizontalAlignment(SwingConstants.RIGHT);
			lblband.setForeground(Color.PINK);
			lblband.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			lblband.setBounds(63, 136, 437, 33);
			if (band==0)
			lblband.setVisible(false);
			else {
				lblband.setOpaque(true);
				lblband.setVisible(true);
			}
			textField = new JTextField();
			textField.setBackground(Color.PINK);
			textField.setForeground(new Color(199, 21, 133));
			textField.setBounds(676, 271, 286, 33);
			textField.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
			textField.setColumns(10);
			add(textField);
			
			passwordField = new JPasswordField();
			passwordField.setBackground(Color.PINK);
			passwordField.setForeground(new Color(199, 21, 133));
			passwordField.setBounds(676, 368, 286, 33);
			passwordField.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
			add(passwordField);
			
			JLabel lblNewLabel4 = new JLabel("Ingresa usuario");
			lblNewLabel4.setBackground(new Color(0, 0, 0));
			lblNewLabel4.setBounds(676, 240, 176, 33);
			lblNewLabel4.setOpaque(true);
			lblNewLabel4.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel4.setForeground(Color.PINK);
			lblNewLabel4.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			add(lblNewLabel4);
			
			JLabel lblNewLabel_5 = new JLabel("Ingresa contraseña");
			lblNewLabel_5.setBackground(new Color(0, 0, 0));
			lblNewLabel_5.setBounds(676, 333, 176, 33);
			lblNewLabel_5.setOpaque(true);
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_5.setForeground(Color.PINK);
			lblNewLabel_5.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			add(lblNewLabel_5);
			
			JButton boton_iniciarsesion = new JButton("INICIAR SESION");
			boton_iniciarsesion.setForeground(Color.PINK);
			boton_iniciarsesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Usuario b;
					Controlador_Usuario basesita= new Controlador_Usuario ();
					b=basesita.buscarUsuario(new Usuario (textField.getText(), passwordField.getText()));
					
					
					if (textField.getText().isEmpty() || passwordField.getText().isEmpty()) {
						lblNewLabel_2.setText("Llene todos los campos");
						lblNewLabel_2.setOpaque(true);
						lblNewLabel_2.setVisible(true);
						
					}else  if (b==null){
						lblNewLabel_2.setText("Usuario y/o contraseña incorrectos");
						lblNewLabel_2.setOpaque(true);
						lblNewLabel_2.setVisible(true);
					}
					else {
						lblNewLabel_2.setVisible(false);
						lblNewLabel_2.setOpaque(false);
						botonframe (new Pantalla_Menu_Usuario (b));
					}
					
					
				}
			});
			boton_iniciarsesion.setBounds(676, 508, 286, 40);
			boton_iniciarsesion.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			boton_iniciarsesion.setBackground(new Color(199, 21, 133));
			add(boton_iniciarsesion);
			
			JButton boton_volver = new JButton("VOLVER");
			boton_volver.setForeground(new Color(199, 21, 133));
			boton_volver.setBounds(10, 55, 122, 27);
			boton_volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botonframe (new Pantalla_Menu_principal (num_fondo,num_musica));
					
				}
			});
			boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			boton_volver.setBackground(Color.PINK);
			add(boton_volver);
			

			JButton boton_olvido = new JButton("Recuperar contraseña");
			boton_olvido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botonframe (new Pantalla_Recuperar_password (num_fondo,num_musica));
				}
			});
			boton_olvido.setForeground(Color.PINK);
			boton_olvido.setFont(new Font("Dialog", Font.PLAIN, 14));
			boton_olvido.setBounds(676, 434, 286, 21);
			//boton_olvido.setContentAreaFilled(false);
			boton_olvido.setBackground(new Color(199, 21, 133));
			boton_olvido.setBorderPainted(false);
			add(boton_olvido);
			
			JLabel ima = new JLabel();
			ima.setVerticalAlignment(SwingConstants.CENTER);
			ima.setIcon(imagenes.getUnotam(2,400, 430, 600));
			ima.setBorder(null);
			ima.setBounds(161, 161, 444, 449);
			add(ima);
			

			

			
			
			add(lblNewLabel_2);
			add(lblband);
			
			
		
			this.add_fondo(num_fondo);
			this.boton_ajustes(0,new Usuario (),num_fondo,num_musica);
	}
}
