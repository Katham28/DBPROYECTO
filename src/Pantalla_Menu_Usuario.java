import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class Pantalla_Menu_Usuario extends Pantalla_secundaria {
	private Usuario usa;
	private static final long serialVersionUID = 1L;
	JPanel panel2;
	public Pantalla_Menu_Usuario (Usuario usa) {
		super(usa.getFondo(),usa.getMusica());
		this.usa=usa;
				
		
		this.boton_ajustes(1,usa,usa.getFondo(),usa.getMusica());
		panel2 =new Panel_Informacion_Usuario(usa.getUser(),usa.getCorreo(),usa.getFoto_perfil());
		panel2.setBounds(0, -23, 147, 663);
		add(panel2);
		
		JButton boton_cierro_1_1 = new JButton("GATCHA");
		boton_cierro_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Gatcha (usa));
				
			}
		});
		boton_cierro_1_1.setForeground(new Color(199, 21, 133));
		boton_cierro_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		boton_cierro_1_1.setBackground(Color.PINK);
		boton_cierro_1_1.setBounds(10, 217, 120, 27);
		panel2.add(boton_cierro_1_1);
		
		

						JButton boton_cierro_1 = new JButton("SALIR");
						boton_cierro_1.setBounds(10, 32, 120, 27);
						panel2.add(boton_cierro_1);
						boton_cierro_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								botonframe (new Pantalla_Menu_principal (usa.getFondo(),usa.getMusica()));
							}
						});
						boton_cierro_1.setForeground(Color.PINK);
						boton_cierro_1.setFont(new Font("Dialog", Font.PLAIN, 14));
						boton_cierro_1.setBackground(new Color(199, 21, 133));
		
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Vestir (usa,1));
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
				botonframe (new Pantalla_Vestir (usa,2));
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
				botonframe (new Pantalla_Vestir (usa,3));
			}
		});
		//btnNewButton_1_1.setIcon(imagenes.getUno(1));
		btnNewButton_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		btnNewButton_1_1.setBackground(new Color(204, 255, 153));
		btnNewButton_1_1.setBounds(494, 451, 207, 81);
		add(btnNewButton_1_1);
		
		fondo_labels_botones ();
		this.add_fondo(usa.getFondo());
		
	}
	
	
	public void fondo_labels_botones () {
		
		JLabel lblNewLabel_1 = new JLabel("*1*");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(494, 248, 207, 33);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("*2*");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.PINK);
		lblNewLabel_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(494, 386, 207, 33);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("*3*");
		lblNewLabel_1_1_1.setOpaque(true);
		lblNewLabel_1_1_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(Color.PINK);
		lblNewLabel_1_1_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(494, 529, 207, 33);
		add(lblNewLabel_1_1_1);
		
		
		JLabel lblNewLabel_81 = new JLabel("Dressing up!");
		lblNewLabel_81.setBackground(new Color(255, 255, 153));
		lblNewLabel_81.setOpaque(true);
		lblNewLabel_81.setForeground(new Color(197, 21, 133));
		lblNewLabel_81.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_81.setFont(new Font(fuente, Font.PLAIN, 47));
		lblNewLabel_81.setBounds(494, 170, 207, 81);
		add(lblNewLabel_81);
		
		//labels 2
		
		JLabel lblNewLabel_83 = new JLabel("Dressing up!");
		lblNewLabel_83.setOpaque(true);
		lblNewLabel_83.setBackground(new Color(255, 153, 255));
		lblNewLabel_83.setForeground(new Color(199, 21, 133));
		lblNewLabel_83.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_83.setFont(new Font(fuente, Font.PLAIN, 47));
		lblNewLabel_83.setBounds(494, 308, 207, 81);
		add(lblNewLabel_83);
	
		//labels 3	
		JLabel lblNewLabel_85 = new JLabel("Dressing up!");
		lblNewLabel_85.setOpaque(true);
		lblNewLabel_85.setBackground(new Color(102, 255, 153));
		lblNewLabel_85.setForeground(new Color(199, 21, 133));
		lblNewLabel_85.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_85.setFont(new Font(fuente, Font.PLAIN, 47));
		lblNewLabel_85.setBounds(494, 451, 207, 81);
		add(lblNewLabel_85);
	}
}
