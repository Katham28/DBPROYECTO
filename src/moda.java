import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class moda extends JPanel {
	private Imagen imagenes;
	private LinkedList <JLabel> labels= new LinkedList();
	private LinkedList <Categoria> categ= new LinkedList ();

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public moda(int num,String usuario) {
		imagenes= new Imagen (num);
		setBackground(new Color(199, 21, 133));
		setLayout(null);
		

		JButton boton_cierro = new JButton("CERRAR SESIÓN");
		boton_cierro.setForeground(new Color(199, 21, 133));
		boton_cierro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//botonframe (new principal_ (num));
			}
		});
		boton_cierro.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_cierro.setBackground(Color.PINK);
		boton_cierro.setBounds(10, 10, 217, 40);
		add(boton_cierro);
		
		JLabel lblNewLabel = new JLabel(""+usuario);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(199, 21, 133));
		lblNewLabel.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel.setBounds(783, 40, 285, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(783, 13, 117, 33);
		add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new dressing(num,usuario,1));
			}
		});
		//btnNewButton.setIcon(imagenes.getUnota("C10",100,100));
		btnNewButton.setBackground(new Color(255, 255, 153));
		btnNewButton.setOpaque(false);
		btnNewButton.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton.setBounds(494, 170, 207, 81);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new dressing(num,usuario,2));
			}
		});
	//	btnNewButton_1.setIcon(imagenes.getUno(2));
		btnNewButton_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton_1.setBackground(new Color(255, 153, 255));
		btnNewButton_1.setBounds(494, 308, 207, 81);
		add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new dressing(num,usuario,3));
			}
		});
		//btnNewButton_1_1.setIcon(imagenes.getUno(1));
		btnNewButton_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton_1_1.setBackground(new Color(204, 255, 153));
		btnNewButton_1_1.setBounds(494, 451, 207, 81);
		add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("*1*");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(494, 248, 207, 33);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("*2*");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(494, 386, 207, 33);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("*3*");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(494, 529, 207, 33);
		add(lblNewLabel_1_1_1);
		
		JButton boton_cierro_1 = new JButton("OBTENER PRENDAS");
		boton_cierro_1.setForeground(new Color(199, 21, 133));
		boton_cierro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Obtener_prenda(num,usuario));
				
			}
		});
		boton_cierro_1.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_cierro_1.setBackground(Color.PINK);
		boton_cierro_1.setBounds(10, 60, 217, 40);
		if (usuario.equals("admin")) {
			boton_cierro_1.setEnabled(false);
		}
		else
		{
			boton_cierro_1.setEnabled(true);
		}
		add(boton_cierro_1);
		
		
		//labels 1
		
		JLabel lblNewLabel_81 = new JLabel("Dressing up!");
		lblNewLabel_81.setBackground(new Color(255, 255, 153));
		lblNewLabel_81.setOpaque(true);
		lblNewLabel_81.setForeground(new Color(197, 21, 133));
		lblNewLabel_81.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_81.setFont(new Font("hello honey - Personal Use", Font.PLAIN, 47));
		lblNewLabel_81.setBounds(494, 170, 207, 81);
		add(lblNewLabel_81);
		
		//labels 2
		
		JLabel lblNewLabel_83 = new JLabel("Dressing up!");
		lblNewLabel_83.setOpaque(true);
		lblNewLabel_83.setBackground(new Color(255, 153, 255));
		lblNewLabel_83.setForeground(new Color(199, 21, 133));
		lblNewLabel_83.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_83.setFont(new Font("hello honey - Personal Use", Font.PLAIN, 47));
		lblNewLabel_83.setBounds(494, 308, 207, 81);
		add(lblNewLabel_83);
	
		//labels 3	
		JLabel lblNewLabel_85 = new JLabel("Dressing up!");
		lblNewLabel_85.setOpaque(true);
		lblNewLabel_85.setBackground(new Color(102, 255, 153));
		lblNewLabel_85.setForeground(new Color(199, 21, 133));
		lblNewLabel_85.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_85.setFont(new Font("hello honey - Personal Use", Font.PLAIN, 47));
		lblNewLabel_85.setBounds(494, 451, 207, 81);
		add(lblNewLabel_85);
		
		//imagenes
		
		JLabel ima = new JLabel();
		ima.setVerticalAlignment(SwingConstants.CENTER);
		ima.setIcon(imagenes.getUnotam(1,300,300,300));
		ima.setBorder(null);
		ima.setBounds(228, 307, 240, 288);
		add(ima);
		
		JLabel ima2 = new JLabel();
		ima2.setVerticalAlignment(SwingConstants.CENTER);
		ima2.setIcon(imagenes.getUnotam(2,300,300,300));
		ima2.setBorder(null);
		ima2.setBounds(721, 307, 240, 288);
		add(ima2);
		
		
		JLabel fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.CENTER);
		fondo.setIcon(imagenes.getfondo("fondo1"));
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

