import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pantalla_Menu_Admin extends JPanel{

	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);
	protected String fuente= "Niagara Engraved";
	JLabel fondo;
	JButton boton_conf = new JButton("AJUSTES");

	public Pantalla_Menu_Admin(int num_fondo, int num_musica) {
		// TODO Auto-generated constructor stub
		setBackground(new Color(199, 21, 133));
		setBounds(100, 100, 1122, 650);
		setLayout(null);
		
		JButton boton_volver = new JButton("SALIR");
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
		

		JButton boton_iniciarsesion = new JButton("INGRESAR");
		boton_iniciarsesion.setForeground(new Color(199, 21, 133));
		boton_iniciarsesion.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_iniciarsesion.setBackground(Color.PINK);
		boton_iniciarsesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Ingresar_Admin(num_fondo, num_musica));
			}
		});
		boton_iniciarsesion.setBounds(468, 376, 217, 40);
		add(boton_iniciarsesion);
		
		JButton botton_items = new JButton("MODIFICAR || ELIMINAR");
		botton_items.setForeground(new Color(199, 21, 133));
		botton_items.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		botton_items.setBackground(Color.PINK);
		botton_items.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Mod_Eli_Admin(num_fondo, num_musica));
				
			}
		});
		botton_items.setBounds(468, 439, 217, 40);
		add(botton_items);
		
		
		
		this.add_fondo(num_fondo);
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
	
}
