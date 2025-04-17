import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Pantalla_Gatcha extends Pantalla_secundaria {
	private Usuario usa;
	private static final long serialVersionUID = 1L;
	JPanel panel2;


	/**
	 * Create the panel.
	 */

	public Pantalla_Gatcha (Usuario usa) {
		super(usa.getFondo(),usa.getMusica());
		this.usa=usa;
				
				
		this.boton_ajustes(1,usa,usa.getFondo(),usa.getMusica());
		

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
		
		
		
		panel2 =new Panel_Informacion_Usuario(usa.getUser(),usa.getCorreo(),usa.getFoto_perfil());
		panel2.setBounds(0, -23, 147, 663);
		add(panel2);
		
		
		
		this.add_fondo(usa.getFondo());
	}

}
