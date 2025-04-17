import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Pantalla_Vestir extends Pantalla_secundaria {
	private Usuario usa;
	private static final long serialVersionUID = 1L;
	JPanel panel2;
	private int num_per;


	/**
	 * Create the panel.
	 */

	public Pantalla_Vestir (Usuario usa,int num_per) {
		super(usa.getFondo(),usa.getMusica());
		this.usa=usa;
		this.num_per=num_per;
				
				
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
		

		JLabel lblNewLabel_1 = new JLabel("**"+this.num_per+"**");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(979, 280, 112, 33);
		add(lblNewLabel_1);
		
		panel2 =new Panel_Informacion_Usuario(usa.getUser(),usa.getCorreo(),usa.getFoto_perfil());
		panel2.setBounds(0, -23, 147, 663);
		add(panel2);
		
		
		
		
		this.add_fondo(usa.getFondo());
	}
}