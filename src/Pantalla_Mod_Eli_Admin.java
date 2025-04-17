import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Pantalla_Mod_Eli_Admin extends JPanel {
	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);
	protected String fuente= "Niagara Engraved";
	JLabel fondo;
	JButton boton_conf = new JButton("AJUSTES");


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
				
			}
		});
		boton_buscar.setBounds(937, 177, 122, 27);
		add(boton_buscar);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cuerpo", "Ojos", "Cejas", "Boca", "Vello", "Tatuaje", "Piercing", "Capa", "Peinado", "Pantalon", "Sombrero", "Lentes", "Calcetas", "Top", "Calzado"}));
		comboBox.setBounds(417, 88, 280, 21);
		add(comboBox);
		
		
		
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
