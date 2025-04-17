import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pantalla_secundaria extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);
	protected String fuente= "Niagara Engraved";
	JLabel fondo;
	JButton boton_conf = new JButton("AJUSTES");
	
	
	
	/**
	 * Create the panel.
	 */
	public Pantalla_secundaria(int num_fondo,int num_musica) {
		
		setBackground(new Color(199, 21, 133));
		setBounds(100, 100, 1122, 650);
		setLayout(null);
		
		
		boton_conf.setForeground(new Color(199, 21, 133));
		
		boton_conf.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_conf.setBackground(Color.PINK);
		boton_conf.setBounds(10, 94, 122, 27);
		add(boton_conf);
		
		//add_fondo (num_fondo);
		//botonframe ();
	}
	
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
	
	public void boton_ajustes(int b,Usuario usuario,int num_fondo,int num_musica) {
		if (b==0) {
			boton_conf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botonframe (new Pantalla_Ajustes (num_fondo,num_musica));
				}
			});
		}else {
			boton_conf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botonframe (new Pantalla_Ajustes (usuario));
				}
			});
			
		}
		
		
		
	}

}
