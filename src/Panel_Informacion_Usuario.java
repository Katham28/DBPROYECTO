import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Panel_Informacion_Usuario extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);

	/**
	 * Create the panel.
	 */
	public Panel_Informacion_Usuario(String user,String correo,int foto_perfil) {
		setBackground(Color.BLACK);
		setLayout(null);
		setBounds(0, 0, 147, 663);
		
		JLabel lblNewLabel = new JLabel(""+user);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(199, 21, 133));
		lblNewLabel.setFont(new Font("Artifakt Element", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 527, 127, 27);
		add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Artifakt Element", Font.PLAIN, 12));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(10, 501, 200, 24);
		add(lblNewLabel_5);
		
		
		JLabel lblNewLabel2 = new JLabel(""+correo);
		lblNewLabel2.setOpaque(true);
		lblNewLabel2.setBackground(Color.PINK);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel2.setForeground(new Color(199, 21, 133));
		lblNewLabel2.setFont(new Font("Artifakt Element", Font.PLAIN, 12));
		lblNewLabel2.setBounds(10, 585, 127, 27);
		add(lblNewLabel2);
		
		JLabel lblNewLabel_52 = new JLabel("Correo");
		lblNewLabel_52.setOpaque(true);
		lblNewLabel_52.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_52.setForeground(Color.PINK);
		lblNewLabel_52.setFont(new Font("Artifakt Element", Font.PLAIN, 12));
		lblNewLabel_52.setBackground(new Color(0, 0, 0));
		lblNewLabel_52.setBounds(10, 564, 200, 24);
		add(lblNewLabel_52);
		
		
		String ima_cadena= ""+foto_perfil+"p";
		
		JLabel ima = new JLabel();
		ima.setVerticalAlignment(SwingConstants.CENTER);
		ima.setHorizontalAlignment(SwingConstants.CENTER);
		ima.setIcon(imagenes.getperfil(ima_cadena,40,40));
		ima.setBorder(null);
		ima.setBounds(0, 325, 147, 166);
		add(ima);
		
	}

}
