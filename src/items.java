import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

public class items extends JPanel {
	private static final long serialVersionUID = 1L;
	private Imagen imagenes;
	JLabel lblNewLabel_1;
	JLabel act_categ;
	JLabel name_Ropa;
	JLabel act_ropa;
	JLabel nu;
	JLabel fondo;
	private LinkedList <Categoria> categ= new LinkedList ();
	private LinkedList <JLabel> labels= new LinkedList();
	int max;
	int act=0;
	int act2=0;
	int max2;
	JButton boton_der_1;
	JButton boton_izq_1;
	private JButton boton_cierro_1;


	/**
	 * Create the panel.
	 */
	public items(int num) {
		imagenes= new Imagen (num);
		boton_der_1 = new JButton(">");
		boton_izq_1 = new JButton("<");
		llenar ();
		max=categ.size()-1;
		max2=categ.get(0).getAtuendos().size()-1;
		setBackground(new Color(199, 21, 133));
		setLayout(null);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.CENTER);
		fondo.setIcon(imagenes.getfondo("fondo1"));
		fondo.setBorder(null);
		fondo.setBounds(0, 0, 1134, 650);
		

		JButton boton_cierro = new JButton("VOLVER");
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
		
		JLabel lblNewLabel = new JLabel("Todos los items");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel.setBounds(891, 10, 176, 33);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(""+categ.get(0).getName());
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(524, 71, 176, 27);
		add(lblNewLabel_1);
		
		act_ropa = new JLabel("");
		act_ropa.setOpaque(true);
		act_ropa.setBackground(new Color(0, 0, 0));
			act_ropa.setHorizontalAlignment(SwingConstants.CENTER);
			act_ropa.setForeground(Color.PINK);
			act_ropa.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			act_ropa.setBounds(524, 508, 176, 28);
			add(act_ropa);
			

		name_Ropa= new JLabel("");
		name_Ropa.setOpaque(true);
		name_Ropa.setBackground(new Color(0, 0, 0));
			name_Ropa.setHorizontalAlignment(SwingConstants.CENTER);
			name_Ropa.setForeground(Color.PINK);
			name_Ropa.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
			name_Ropa.setBounds(524, 546, 176, 27);
			add(name_Ropa);
			
			if (categ.get(act).getAtuendos().size()==0 ) {
				boton_izq_1.setEnabled(false);
				boton_der_1.setEnabled(false);
				act_ropa.setText("0/0");
				name_Ropa.setText("-");
			}
			else if (categ.get(act).getAtuendos().size()==1) {
				boton_izq_1.setEnabled(false);
				boton_der_1.setEnabled(false);
				act_ropa.setText("1/1");
				name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
			}
			else  {
				boton_izq_1.setEnabled(false);
				boton_der_1.setEnabled(true);
				act_ropa.setText(""+(act2+1)+"/"+(max2+1));
				name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
			}
		
		JButton boton_der = new JButton(">");
		JButton boton_izq = new JButton("<");
		boton_izq.setEnabled(false);
		
		//<
		boton_izq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				act=act-1;
				lblNewLabel_1.setText(""+categ.get(act).getName());
				max2=categ.get(act).getAtuendos().size()-1;
				act2=0;
				if (act==0) {
					boton_izq.setEnabled(false);
					boton_der.setEnabled(true);
				}
				else  {
					boton_izq.setEnabled(true);
					boton_der.setEnabled(true);
				}
				act_categ.setText(""+(act+1)+"/"+categ.size());
				
				if (categ.get(act).getAtuendos().size()==0 ) {
					boton_izq_1.setEnabled(false);
					boton_der_1.setEnabled(false);
					act_ropa.setText("0/0");
					name_Ropa.setText("-");
				}
				else if (categ.get(act).getAtuendos().size()==1) {
					boton_izq_1.setEnabled(false);
					boton_der_1.setEnabled(false);
					act_ropa.setText("1/1");
					name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
					cam_Actual();
					showing ();
				}
				else  {
					boton_izq_1.setEnabled(false);
					boton_der_1.setEnabled(true);
					act_ropa.setText(""+(act2+1)+"/"+(max2+1));
					name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
					cam_Actual();
					showing ();
				}
				
			}
		});
		boton_izq.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_izq.setBackground(new Color(255, 255, 153));
		boton_izq.setBounds(451, 73, 49, 21);
		add(boton_izq);
		//>
		boton_der.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				act=act+1;
				max2=categ.get(act).getAtuendos().size()-1;
				act2=0;
				lblNewLabel_1.setText(""+categ.get(act).getName());
				if (act==max) {
					boton_der.setEnabled(false);
					boton_izq.setEnabled(true);
				
				}
				else {
					boton_der.setEnabled(true);
					boton_izq.setEnabled(true);
				}
				
				 act_categ.setText(""+(act+1)+"/"+categ.size());
				 
					if (categ.get(act).getAtuendos().size()==0 ) {
						boton_izq_1.setEnabled(false);
						boton_der_1.setEnabled(false);
						act_ropa.setText("0/0");
						name_Ropa.setText("-");
					}
					else if (categ.get(act).getAtuendos().size()==1) {
						boton_izq_1.setEnabled(false);
						boton_der_1.setEnabled(false);
						act_ropa.setText("1/1");
						name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
						cam_Actual();
						showing ();
					}
					else  {
						boton_izq_1.setEnabled(false);
						boton_der_1.setEnabled(true);
						act_ropa.setText(""+(act2+1)+"/"+(max2+1));
						name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
						cam_Actual();
						showing ();
					}
					
					
			}
		});
		boton_der.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_der.setBackground(new Color(255, 255, 153));
		boton_der.setBounds(710, 73, 49, 21);
		add(boton_der);
		

		boton_izq_1.setEnabled(false);
		if (categ.get(0).getAtuendos().size()==0 ||categ.get(0).getAtuendos().size()==1) {
			boton_izq_1.setEnabled(false);
			boton_der_1.setEnabled(false);
		}
		else  {
			boton_izq_1.setEnabled(false);
			boton_der_1.setEnabled(true);
		}
			
		//<
		boton_izq_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				act2=act2-1;
				if (act2==0) {
					boton_izq_1.setEnabled(false);
					boton_der_1.setEnabled(true);
				}
				else  {
					boton_izq_1.setEnabled(true);
					boton_der_1.setEnabled(true);
				}
				
				
				act_ropa.setText(""+(act2+1)+"/"+(max2+1));
				name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
				cam_Actual();
				showing ();
				
			}
		});
		boton_izq_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_izq_1.setBackground(new Color(153, 255, 255));
		boton_izq_1.
		setBounds(451, 508, 49, 21);
		add(boton_izq_1);
		
		//>
		boton_der_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				act2=act2+1;
				if (act2==max2) {
					boton_der_1.setEnabled(false);
					boton_izq_1.setEnabled(true);
				
				}
				else {
					boton_der_1.setEnabled(true);
					boton_izq_1.setEnabled(true);
				}
				
				act_ropa.setText(""+(act2+1)+"/"+(max2+1));
				name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
				cam_Actual();
				showing ();
			}
		});
		boton_der_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_der_1.setBackground(new Color(153, 255, 255));
		boton_der_1.setBounds(710, 508, 49, 21);
		add(boton_der_1);
		
		act_categ = new JLabel(""+(act+1)+"/"+categ.size());
		act_categ.setOpaque(true);
		act_categ.setBackground(new Color(0, 0, 0));
		act_categ.setHorizontalAlignment(SwingConstants.CENTER);
		act_categ.setForeground(Color.PINK);
		act_categ.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		act_categ.setBounds(524, 30, 176, 28);
		add(act_categ);
		
		nu=new JLabel ();
		String arc= ""+categ.get(act).getAtuendos().get(act2).getName_archivo();
		nu.setIcon(imagenes.getUnota(arc,500,500));
		labels.add(act, nu);
		cam_Actual();
		showing ();
	
		add (fondo);
	}
	
	
	public void cam_Actual() {
		nu = new JLabel();
		String arc = "" + categ.get(act).getAtuendos().get(act2).getName_archivo();
		System.out.println(arc);
		    labels.get(act).setIcon(imagenes.getUnota(arc, 500, 500));
		    
		showing();
		repaint();
		revalidate();
		
	}
	
	public void inicializar () {
		
		
		
	}
	
	public void showing () {
		int x=0;
		
		
		for (int i=16;i>=0;i--) {
			
			JLabel label = labels.get(i);
			label.setVerticalAlignment(SwingConstants.CENTER);
			label.setBorder(null);
			label.setBounds(450, 150, 444,400);
			add(label);
		}	
		add (fondo);
	}
	public void botonframe (JPanel b) {
		removeAll();
		setLayout(new BorderLayout(0, 0));
		add(b);
		repaint();
		revalidate();
	}
	public void llenar () {
		this.categ.add(new Categoria("Cuerpo",0));
		this.categ.add(new Categoria("Ojos",0));
		this.categ.add(new Categoria("Cejas",0));
		this.categ.add(new Categoria("Boca",0));
		this.categ.add(new Categoria("Vello_facial",0));
		this.categ.add(new Categoria("Lentes",0));
		this.categ.add(new Categoria("Peinado",0));
		this.categ.add(new Categoria("Tatuaje",0));	
		this.categ.add(new Categoria("Calcetas",0));
		this.categ.add(new Categoria("Superior",0));
		this.categ.add(new Categoria("Pantalon",0));
		this.categ.add(new Categoria("Sombrero",0));

		this.categ.add(new Categoria("Calzado",0));
	
		this.categ.add(new Categoria("Piercing",0));
		this.categ.add(new Categoria("Capa",0));
		try {
			Bd_oracle basesita= new Bd_oracle ();
			categ=basesita.items("cuerpo",categ,0);
			categ=basesita.items_gesto("Ojos",categ,1,"descripcion");
			categ=basesita.items_gesto("Cejas",categ,2,"descripccion");
			categ=basesita.items_gesto("Boca",categ,3,"descripccion");
			categ=basesita.items_gesto("Bello_facila",categ,4,"descripccion");
			categ=basesita.items("Lentes",categ,5);
			categ=basesita.items("Peinado",categ,6);
			categ=basesita.items("Tatuaje",categ,7);
			categ=basesita.items("Calcetas",categ,8);
			categ=basesita.items("Vestido",categ,9);
			categ=basesita.items("Top",categ,9);
			categ=basesita.items("Pantalon",categ,10);
			categ=basesita.items("Sombrero",categ,11);
			
			categ=basesita.items("Calzado",categ,12);

			categ=basesita.items("Piercing",categ,13);
			categ=basesita.items("Capa",categ,14);
			basesita.cerrarConexion();
			
		} catch (SQLException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
		
		
		for (int i=0;i<16;i++) {
			JLabel nu=new JLabel ();
			labels.add(nu);
		}

	}
	

}
