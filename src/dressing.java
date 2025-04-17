import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.SwingConstants;

public class dressing extends JPanel {

	private static final long serialVersionUID = 1L;
	private Imagen imagenes;
	private int puntaje;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2=new JLabel(""+puntaje);
	JLabel act_categ;
	JLabel name_Ropa;
	JLabel act_ropa;
	JLabel fondo;
	JLabel nu;
	private LinkedList <Categoria> categ= new LinkedList ();
	private LinkedList <JLabel> labels= new LinkedList();
	private int curClaves [] = new int [20];
	private int pun []= new int [20];

	int max;
	int act=0;
	int act2=0;
	int max2;
	JButton boton_der_1;
	JButton boton_izq_1;
	private JLabel lblNewLabel_4;
	private JButton Guardar;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private int ver;
	private String usuario;

	/**
	 * Create the panel.
	 */
	public dressing(int num,String usuario, int ver) {
		this.ver = ver;
		puntaje=0;
		imagenes= new Imagen (num);
		boton_der_1 = new JButton(">");
		boton_izq_1 = new JButton("<");
		llenar (usuario);
		this.usuario = usuario;
		int x []=new int [20];
		for (int i=0;i<16;i++) 
			x[i]=0;
	
		max=categ.size()-1;
		max2=categ.get(0).getAtuendos().size()-1;
		setBackground(new Color(199, 21, 133));
		setLayout(null);
		
		fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.CENTER);
		fondo.setIcon(imagenes.getfondo("fondo1"));
		fondo.setBorder(null);
		fondo.setBounds(0, 0, 1134, 704);

		
		JButton boton_cierro = new JButton("VOLVER");
		boton_cierro.setForeground(new Color(199, 21, 133));
		boton_cierro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new moda (num,usuario));
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
		lblNewLabel.setBounds(10, 217, 217, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.PINK);
		lblNewLabel_5.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(10, 186, 117, 33);
		add(lblNewLabel_5);
		
		lblNewLabel_1 = new JLabel(""+categ.get(0).getName());
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(480, 71, 260, 33);
		add(lblNewLabel_1);
		
		act_ropa = new JLabel("");
		act_ropa.setOpaque(true);
		act_ropa.setBackground(new Color(0, 0, 0));
			act_ropa.setHorizontalAlignment(SwingConstants.CENTER);
			act_ropa.setForeground(Color.PINK);
			act_ropa.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
			act_ropa.setBounds(480, 496, 260, 33);
			add(act_ropa);
			

		name_Ropa= new JLabel("");
		name_Ropa.setOpaque(true);
		name_Ropa.setBackground(new Color(0, 0, 0));
			name_Ropa.setHorizontalAlignment(SwingConstants.CENTER);
			name_Ropa.setForeground(Color.PINK);
			name_Ropa.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
			name_Ropa.setBounds(480, 539, 260, 33);
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
		        // Save the clave of the current clothing item
		        curClaves[act] = categ.get(act).getAtuendos().get(act2).getClave();

		        act = act - 1;
		        lblNewLabel_1.setText("" + categ.get(act).getName());
		        max2 = categ.get(act).getAtuendos().size() - 1;
		        act2 = 0;
		        if (act == 0) {
		            boton_izq.setEnabled(false);
		            boton_der.setEnabled(true);
		        } else {
		            boton_izq.setEnabled(true);
		            boton_der.setEnabled(true);
		        }
		        act_categ.setText("" + (act + 1) + "/" + categ.size());

		        if (categ.get(act).getAtuendos().size() == 0) {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(false);
		            act_ropa.setText("0/0");
		            name_Ropa.setText("-");
		        } else if (categ.get(act).getAtuendos().size() == 1) {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(false);
		            act_ropa.setText("1/1");
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2));
		            cam_Actual();
		        } else {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(true);
		            act_ropa.setText("" + (act2 + 1) + "/" + (max2 + 1));
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2));
		            cam_Actual();
		        }
		    }
		});

		boton_izq.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_izq.setBackground(new Color(255, 255, 153));
		boton_izq.setBounds(357, 77, 80, 21);
		add(boton_izq);
		//>
		boton_der.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Save the clave of the current clothing item
		        curClaves[act] = categ.get(act).getAtuendos().get(act2).getClave();

		        act = act + 1;
		        max2 = categ.get(act).getAtuendos().size() - 1;
		        act2 = 0;
		        lblNewLabel_1.setText("" + categ.get(act).getName());
		        if (act == max) {
		            boton_der.setEnabled(false);
		            boton_izq.setEnabled(true);
		        } else {
		            boton_der.setEnabled(true);
		            boton_izq.setEnabled(true);
		        }
		        act_categ.setText("" + (act + 1) + "/" + categ.size());

		        if (categ.get(act).getAtuendos().size() == 0) {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(false);
		            act_ropa.setText("0/0");
		            name_Ropa.setText("-");
		        } else if (categ.get(act).getAtuendos().size() == 1) {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(false);
		            act_ropa.setText("1/1");
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2));
		            cam_Actual();
		        } else {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(true);
		            act_ropa.setText("" + (act2 + 1) + "/" + (max2 + 1));
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2));
		            cam_Actual();
		        }
		    }
		});

		boton_der.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_der.setBackground(new Color(255, 255, 153));
		boton_der.setBounds(783, 77, 80, 21);
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
		        // Save the clave of the current clothing item
		        curClaves[act] = categ.get(act).getAtuendos().get(act2).getClave();

		        act2 = act2 - 1;
		        if (act2 == 0) {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(true);
		        } else {
		            boton_izq_1.setEnabled(true);
		            boton_der_1.setEnabled(true);
		        }
		        act_ropa.setText("" + (act2 + 1) + "/" + (max2 + 1));
		        name_Ropa.setText("" + categ.get(act).obtener_uno(act2));
		        cam_Actual();
		    }
		});

		boton_izq_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_izq_1.setBackground(new Color(153, 255, 255));
		boton_izq_1.setBounds(357, 508, 49, 21);
		add(boton_izq_1);
		
		//>
		boton_der_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Save the clave of the current clothing item
		        curClaves[act] = categ.get(act).getAtuendos().get(act2).getClave();

		        act2 = act2 + 1;
		        if (act2 == max2) {
		            boton_der_1.setEnabled(false);
		            boton_izq_1.setEnabled(true);
		        } else {
		            boton_der_1.setEnabled(true);
		            boton_izq_1.setEnabled(true);
		        }
		        act_ropa.setText("" + (act2 + 1) + "/" + (max2 + 1));
		        name_Ropa.setText("" + categ.get(act).obtener_uno(act2));
		        cam_Actual();
		    }
		});

		boton_der_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_der_1.setBackground(new Color(153, 255, 255));
		boton_der_1.setBounds(791, 508, 49, 21);
		add(boton_der_1);
		
		act_categ = new JLabel(""+(act+1)+"/"+categ.size());
		act_categ.setOpaque(true);
		act_categ.setBackground(new Color(0, 0, 0));
		act_categ.setHorizontalAlignment(SwingConstants.CENTER);
		act_categ.setForeground(Color.PINK);
		act_categ.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		act_categ.setBounds(480, 27, 260, 33);
		add(act_categ);
		

		nu=new JLabel ();
		String arc= ""+categ.get(act).getAtuendos().get(act2).getName_archivo();
		nu.setIcon(imagenes.getUnota(arc,500,500));
		labels.add(act, nu);
		cam_Actual();
		showing ();
		
		lblNewLabel_2 = new JLabel(""+puntaje);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(199, 21, 133));
		lblNewLabel_2.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setBounds(10, 312, 217, 33);
		add(lblNewLabel_2);
		
		

		Guardar = new JButton("GUARDAR");
		Guardar.setForeground(new Color(199, 21, 133));
		Guardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if (puntaje==1)
		    		puntaje=0;
		    	
	            if (!categ.get(act).getAtuendos().isEmpty() && act2 < categ.get(act).getAtuendos().size()) {
	                curClaves[act] = categ.get(act).getAtuendos().get(act2).getClave();
	            }

		        // Print ver and curClaves array
		        System.out.println("ver: " + ver);
		        System.out.print("curClaves: ");
		        for (int clave : curClaves) {
		            System.out.print(clave + " ");
		        }
		        System.out.println();

		        // Call guardarPersonaje
		        Bd_mongo mongo = new Bd_mongo(usuario);
		        mongo.guardarPersonaje(ver, curClaves, puntaje);
		        mongo.cerrarConexion();
		        
		        
		        try {
					Bd_oracle basesita = new Bd_oracle ();
					basesita.update_puntaje(usuario, puntaje,ver);
					basesita.cerrarConexion();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        
		        botonframe (new moda (num,usuario));
				
		    }
		});




		Guardar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		Guardar.setBackground(Color.PINK);
		Guardar.setBounds(10, 67, 217, 33);
		add(Guardar);
		
		
		lblNewLabel_3 = new JLabel("Puntaje");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(10, 280, 117, 33);
		add(lblNewLabel_3);
		
		inicializar (x);
		  try {
				Bd_oracle basesita = new Bd_oracle ();
				puntaje= basesita.saco_puntaje(usuario, puntaje,ver);
				basesita.cerrarConexion();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		 lblNewLabel_2.setText("" + puntaje);
		add(fondo);
}
	
	
	public void cam_Actual() {
		nu = new JLabel();
		String arc = "" + categ.get(act).getAtuendos().get(act2).getName_archivo();
		System.out.println(arc);
		    labels.get(act).setIcon(imagenes.getUnota(arc, 500, 500));
		    pun[act]=categ.get(act).getAtuendos().get(act2).getPuntaje();
		    System.out.println(""+pun[act]);
		contar ();
		    
		lblNewLabel_2.setText(""+puntaje);
		    
		showing();
		repaint();
		revalidate();
		
	}
	
	public int contar () {
		int puntitos=0;
		for (int i=0;i<16;i++) {
			puntitos=pun[i]+puntitos;
			
		}
		this.puntaje=puntitos;
		return puntitos;
	}
	
	public void inicializar(int x[]) {
	    for (int i = 0; i < 15; i++) {
	        System.out.println(" " + i);
	        nu = new JLabel();
	        if (!categ.get(i).getAtuendos().isEmpty() && x[i] < categ.get(i).getAtuendos().size()) {
	            String arc = "" + categ.get(i).getAtuendos().get(x[i]).getName_archivo();
	            labels.get(i).setIcon(imagenes.getUnota(arc, 500, 500));
	        } else {
	            labels.get(i).setIcon(imagenes.getUnota("vacio", 500, 500));
	        }
	    }

	    // Call leerPersonaje and initialize curClaves and puntaje
	    Bd_mongo mongo = new Bd_mongo(usuario);
	    int[] resultClaves = mongo.leerPersonaje(ver);
	    if (resultClaves != null) {
	        curClaves = resultClaves;
	    } else {
	        for (int i = 0; i < curClaves.length; i++) {
	            curClaves[i] = 0;
	        }
	    }
	    puntaje = mongo.leerPuntaje(ver);
	    lblNewLabel_2.setText("" + puntaje);

	    // Update labels based on curClaves
	    for (int i = 0; i < categ.size(); i++) {
	        boolean found = false;
	        for (Prenda r : categ.get(i).getAtuendos()) {
	            if (r.getClave() == curClaves[i]) {
	                labels.get(i).setIcon(imagenes.getUnota(r.getName_archivo(), 500, 500));
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            if (i < 5) {
	                // Display the image of the first ropa of that index categ
	                if (!categ.get(i).getAtuendos().isEmpty()) {
	                    String firstArc = categ.get(i).getAtuendos().get(0).getName_archivo();
	                    labels.get(i).setIcon(imagenes.getUnota(firstArc, 500, 500));
	                } else {
	                    labels.get(i).setIcon(imagenes.getUnota("vacio", 500, 500));
	                }
	            } else {
	                labels.get(i).setIcon(imagenes.getUnota("vacio", 500, 500));
	            }
	        }
	    }
	    

	    puntaje = mongo.leerPuntaje(ver);
	    if (puntaje==1)
	    	puntaje=0;
	    lblNewLabel_2.setText("" + puntaje);
	    

	    
	    showing();
	    repaint();
	    revalidate();
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
	public void llenar (String usuario) {
		
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
		
		if (usuario.equals("admin")){
		try {
			Bd_oracle basesita= new Bd_oracle ();
			categ=basesita.items("cuerpo",categ,0);
			categ=basesita.items_gesto("Ojos",categ,1,"descripcion");
			categ=basesita.items_gesto("Cejas",categ,2,"descripccion");
			categ=basesita.items_gesto("Boca",categ,3,"descripccion");
			categ=basesita.items_gesto("Bello_facila",categ,4,"descripccion");
			categ=basesita.items_puntillo("Lentes",categ,5);
			categ=basesita.items_puntillo("Peinado",categ,6);
			categ=basesita.items_puntillo("Tatuaje",categ,7);
			categ=basesita.items_puntillo("Calcetas",categ,8);
			categ=basesita.items_puntillo("Vestido",categ,9);
			categ=basesita.items_puntillo("Top",categ,9);
			categ=basesita.items_puntillo("Pantalon",categ,10);
			categ=basesita.items_puntillo("Sombrero",categ,11);
			
			categ=basesita.items_puntillo("Calzado",categ,12);

			categ=basesita.items_puntillo("Piercing",categ,13);
			categ=basesita.items_puntillo("Capa",categ,14);
			basesita.cerrarConexion();
			
		} catch (SQLException E) {
			// TODO Auto-generated catch block
			E.printStackTrace();
		}
		
		}
		
		else {
			System.out.println("usuario promedio");
			try {
				Bd_oracle basesita= new Bd_oracle ();
				Bd_mongo mango = new Bd_mongo(usuario);
				categ=basesita.items("cuerpo",categ,0);
				categ=basesita.items_gesto("Ojos",categ,1,"descripcion");
				categ=basesita.items_gesto("Cejas",categ,2,"descripccion");
				categ=basesita.items_gesto("Boca",categ,3,"descripccion");
				categ=basesita.items_gesto("Bello_facila",categ,4,"descripccion");
				categ=basesita.itemPorClave("Lentes",categ,mango.leerClaves("LENTES"),5);
				categ=basesita.itemPorClave("Peinado",categ,mango.leerClaves("PEINADO"),6);
				categ=basesita.itemPorClave("Tatuaje",categ,mango.leerClaves("TATUAJE"),7);
				categ=basesita.itemPorClave("Calcetas",categ,mango.leerClaves("CALCETAS"),8);
				categ=basesita.itemPorClave("Vestido",categ,mango.leerClaves("VESTIDO"),9);
				categ=basesita.itemPorClave("Top",categ,mango.leerClaves("TOP"),9);
				categ=basesita.itemPorClave("Pantalon",categ,mango.leerClaves("PANTALON"),10);
				categ=basesita.itemPorClave("Sombrero",categ,mango.leerClaves("SOMBRERO"),11);
				
				categ=basesita.itemPorClave("Calzado",categ,mango.leerClaves("CALZADO"),12);

				categ=basesita.itemPorClave("Piercing",categ,mango.leerClaves("PIERCING"),13);
				categ=basesita.itemPorClave("Capa",categ,mango.leerClaves("CAPA"),14);
				
				basesita.cerrarConexion();
				
			} catch (SQLException E) {
				// TODO Auto-generated catch block
				E.printStackTrace();
			}
			
			for (int x = 5; x < 15; x++) {
			    categ.get(x).getAtuendos().add(0, new Prenda("Ninguno", "Ninguno", "vacio", 0));
			}

			
		}
		
		
		
		for (int i=0;i<16;i++) {
			JLabel nu=new JLabel ();
			labels.add(nu);
			
			pun[i]=0;
		}
		
		
		
		

	}
}
