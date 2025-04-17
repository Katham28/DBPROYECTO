import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Pantalla_Menu_principal extends Pantalla_secundaria {

	public Pantalla_Menu_principal(int num_fondo, int num_musica) {
		super(num_fondo, num_musica);
		
		JLabel lblNewLabel_1 = new JLabel("Dressing up!");
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font(fuente, Font.PLAIN, 200));
		lblNewLabel_1.setBounds(120, 71, 926, 237);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dressing up!");
		lblNewLabel_2.setForeground(new Color(199, 21, 133));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font(fuente, Font.PLAIN, 200));
		lblNewLabel_2.setBounds(117, 71, 926, 237);
		add(lblNewLabel_2);
		
		
		JButton boton_iniciarsesion = new JButton("INICIAR SESION");
		boton_iniciarsesion.setForeground(new Color(199, 21, 133));
		boton_iniciarsesion.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_iniciarsesion.setBackground(Color.PINK);
		boton_iniciarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Iniciar_Sesion (num_fondo,num_musica,0));
			}
		});
		boton_iniciarsesion.setBounds(468, 376, 217, 40);
		add(boton_iniciarsesion);
		
		JButton botton_items = new JButton("ADMINISTRADOR");
		botton_items.setForeground(new Color(199, 21, 133));
		botton_items.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		botton_items.setBackground(Color.PINK);
		botton_items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Iniciar_Sesion_Admin (num_fondo,num_musica));
				
			}
		});
		botton_items.setBounds(468, 439, 217, 40);
		add(botton_items);
		
		JButton boton_crear_cuenta = new JButton("CREAR CUENTA");
		boton_crear_cuenta.setForeground(new Color(199, 21, 133));
		boton_crear_cuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Crear_Cuenta(num_fondo,num_musica));
			}
		});
		boton_crear_cuenta.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_crear_cuenta.setBackground(Color.PINK);
		boton_crear_cuenta.setBounds(468, 500, 217, 40);
		add(boton_crear_cuenta);
		
		
		JLabel ima = new JLabel();
		ima.setVerticalAlignment(SwingConstants.CENTER);
		ima.setIcon(imagenes.getUno(1));
		ima.setBorder(null);
		ima.setBounds(670, 334, 240, 316);
		add(ima);
		
		JLabel ima2 = new JLabel();
		ima2.setVerticalAlignment(SwingConstants.CENTER);
		ima2.setIcon(this.imagenes.getUno(2));
		ima2.setBorder(null);
		ima2.setBounds(882, 334, 240, 316);
		add(ima2);
		
		
		JLabel ima3 = new JLabel();
		ima3.setFont(new Font("Segoe Print", Font.PLAIN, 10));
		ima3.setVerticalAlignment(SwingConstants.CENTER);
		ima3.setIcon(this.imagenes.getUno(3));
		ima3.setBorder(null);
		ima3.setBounds(71, 334, 240, 316);
		add(ima3);
		
		JLabel ima4 = new JLabel();
		ima4.setFont(new Font("Segoe Print", Font.PLAIN, 10));
		ima4.setVerticalAlignment(SwingConstants.CENTER);
		ima4.setIcon(this.imagenes.getUno(4));
		ima4.setBorder(null);
		ima4.setBounds(263, 334, 240, 316);
		add(ima4);
		
		 this.boton_ajustes(0,new Usuario (),num_fondo,num_musica);
		
		this.add_fondo(num_fondo);
		
	}

}
