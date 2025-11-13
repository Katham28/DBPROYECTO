package main.java;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Insets;

public class Pantalla_Menu_Usuario extends Pantalla_secundaria {
	private Usuario usa;
	JButton boton_reporte_all = new JButton("");
	JButton boton_cierro_1_1 = new JButton("GATCHA");
	JButton boton_cierro_1 = new JButton("SALIR");
	JButton btnNewButton = new JButton("");
	JButton btnNewButton_1 = new JButton("");
	JButton btnNewButton_1_1 = new JButton("");
	
	private static final long serialVersionUID = 1L;
	JPanel panel2;
	
	
	
	public Usuario getUsa() {
		return usa;
	}


	public void setUsa(Usuario usa) {
		this.usa = usa;
	}


	public JButton getBoton_reporte_all() {
		return boton_reporte_all;
	}


	public void setBoton_reporte_all(JButton boton_reporte_all) {
		this.boton_reporte_all = boton_reporte_all;
	}


	public JButton getBoton_cierro_1_1() {
		return boton_cierro_1_1;
	}


	public void setBoton_cierro_1_1(JButton boton_cierro_1_1) {
		this.boton_cierro_1_1 = boton_cierro_1_1;
	}


	public JButton getBoton_cierro_1() {
		return boton_cierro_1;
	}


	public void setBoton_cierro_1(JButton boton_cierro_1) {
		this.boton_cierro_1 = boton_cierro_1;
	}


	public JButton getBtnNewButton() {
		return btnNewButton;
	}


	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}


	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}


	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}


	public JButton getBtnNewButton_1_1() {
		return btnNewButton_1_1;
	}


	public void setBtnNewButton_1_1(JButton btnNewButton_1_1) {
		this.btnNewButton_1_1 = btnNewButton_1_1;
	}


	public JPanel getPanel2() {
		return panel2;
	}


	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}


	public Pantalla_Menu_Usuario (Usuario usa) {
		super(usa.getFondo(),usa.getMusica());
		this.usa=usa;
				
		
		this.boton_ajustes(1,usa,usa.getFondo(),usa.getMusica());
		panel2 =new Panel_Informacion_Usuario(usa.getUser(),usa.getCorreo(),usa.getFoto_perfil());
		panel2.setBounds(0, -23, 147, 663);
		add(panel2);
		
		
		boton_reporte_all.setIcon(imagenes.getUnota("topmonta", 200, 200));
		boton_reporte_all.setForeground(new Color(199, 21, 133));
		boton_reporte_all.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_reporte_all.setBackground(Color.PINK);
		//
		boton_reporte_all.setBorderPainted(false);
		boton_reporte_all.setMargin(new Insets(0, 0, 100, 0));
		boton_reporte_all.setFocusPainted(false);
		boton_reporte_all.setOpaque(false);
		boton_reporte_all.setHorizontalAlignment(SwingConstants.CENTER);
		boton_reporte_all.setVerticalAlignment(SwingConstants.CENTER);
		//
		boton_reporte_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Generando reporte");
				mostrarConfeti(boton_reporte_all);
				Controlador_Reporte report = new Controlador_Reporte ();
				//report.reporte_all_prendas();
				report.reporte_prendas_usuario(usa.getUser());
			}
		});
		boton_reporte_all.setBounds(970, 54, 124, 93);
		add(boton_reporte_all);
		
	
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
		this.mostrarConfetiDesdeCentro(this);
		
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
