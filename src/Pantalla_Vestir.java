import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Pantalla_Vestir extends Pantalla_secundaria {
	private Usuario usa;
	private static final long serialVersionUID = 1L;
	JPanel panel2;
	private int num_per;

	private Imagen imagenes=new Imagen() ;
	private int puntaje;

	JLabel lblNewLabel_1 = new JLabel("**"+this.num_per+"**");
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
	private Prenda curPrenda [] = new Prenda [15];
	
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


	public void inicializarCurPrenda () {
		for (int i=0;i<15;i++) {
			curPrenda [i]= categ.get(i).getAtuendos().get(0);
		}
	
	}
	
	public void iniciarlizar_personaje () {
		
	}
	
	public void imprimirCurPrenda () {
		System.out.println("curPrendas*******************");
		for (int i=0;i<15;i++) {
			System.out.println(this.curPrenda[i]);
			//System.out.println("\n");
		}
	}
	/**
	 * Create the panel.
	 */

	public Pantalla_Vestir (Usuario usa,int num_per) {
		super(usa.getFondo(),usa.getMusica());
		this.usa=usa;
		this.num_per=num_per;
		
		lblNewLabel_1 = new JLabel("**"+this.num_per+"**");
				
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
		

		
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(982, 184, 112, 33);
		add(lblNewLabel_1);
		

		panel2 =new Panel_Informacion_Usuario(usa.getUser(),usa.getCorreo(),usa.getFoto_perfil());
		panel2.setBounds(0, -23, 147, 663);
		add(panel2);
		
		lblNewLabel_3 = new JLabel("Puntaje");
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(977, 246, 117, 33);
		add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel(""+puntaje);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(199, 21, 133));
		lblNewLabel_2.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		lblNewLabel_2.setBackground(Color.PINK);
		lblNewLabel_2.setBounds(979, 275, 115, 33);
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
		         imprimirCurPrenda();
		        

		        // Call guardarPersonaje
		       Modelo_Mongo mongo = new Modelo_Mongo(usa.getUser());
		        mongo.guardarPersonaje(num_per, curPrenda,puntaje);
		        mongo.cerrarConexion();
		        
		        
		        //try {
					//Bd_oracle basesita = new Bd_oracle ();
					//basesita.update_puntaje(usuario, puntaje,ver);
					//basesita.cerrarConexion();
				//} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				//}
		        
		        botonframe (new Pantalla_Menu_Usuario (usa));
				
		    }
		});




		Guardar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		Guardar.setBackground(Color.PINK);
		Guardar.setBounds(972, 346, 122, 33);
		add(Guardar);
		////dfncondujnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
		
		this.ver = ver;
		puntaje=0;
		
		boton_der_1 = new JButton(">");
		boton_izq_1 = new JButton("<");
		llenar (usa.getUser());
		
		int x []=new int [20];
		for (int i=0;i<16;i++) 
			x[i]=0;
	
		max=categ.size()-1;
		max2=categ.get(0).getAtuendos().size()-1;

		
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
		name_Ropa.setText(""+categ.get(act).obtener_uno(act2));
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
				name_Ropa.setText(""+categ.get(act).obtener_uno(act2).getName());
			}
			else  {
				boton_izq_1.setEnabled(false);
				boton_der_1.setEnabled(true);
				act_ropa.setText(""+(act2+1)+"/"+(max2+1));
				name_Ropa.setText(""+categ.get(act).obtener_uno(act2).getName());
			}
		
		JButton boton_der = new JButton(">");
		JButton boton_izq = new JButton("<");
		boton_izq.setEnabled(false);
		
		//<
		boton_izq.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Save the clave of the current clothing item
		        //curClaves[act] = categ.get(act).getAtuendos().get(act2).getClave();

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
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2).getName());
		            cam_Actual();
		        } else {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(true);
		            act_ropa.setText("" + (act2 + 1) + "/" + (max2 + 1));
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2).getName());
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
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2).getName());
		            cam_Actual();
		        } else {
		            boton_izq_1.setEnabled(false);
		            boton_der_1.setEnabled(true);
		            act_ropa.setText("" + (act2 + 1) + "/" + (max2 + 1));
		            name_Ropa.setText("" + categ.get(act).obtener_uno(act2).getName());
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
		        name_Ropa.setText("" + categ.get(act).obtener_uno(act2).getName());
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
		        name_Ropa.setText("" + categ.get(act).obtener_uno(act2).getName());
		        cam_Actual();
		    }
		});

		boton_der_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
		boton_der_1.setBackground(new Color(153, 255, 255));
		boton_der_1.setBounds(783, 496, 49, 21);
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
		this.first_Adding() ;
		//add_fondo(usa.getFondo());
	//inicializar (x);
		  /*try {
				Bd_oracle basesita = new Bd_oracle ();
				puntaje= basesita.saco_puntaje(usuario, puntaje,ver);
				basesita.cerrarConexion();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  */
		 lblNewLabel_2.setText("" + puntaje);
	
		
		
		 //add_fondo(usa.getFondo());

	}
	
	
	
	
	
	public void cam_Actual() {
		
		
		nu = new JLabel();
		curPrenda [act]= categ.get(act).getAtuendos().get(act2);
		String arc = "" + categ.get(act).getAtuendos().get(act2).getName_archivo();
		System.out.println("CurPrenda"+curPrenda [act]);
		    labels.get(act).setIcon(imagenes.getUnota(arc, 500, 500));
		    pun[act]=categ.get(act).getAtuendos().get(act2).getPuntaje();
		   // System.out.println(""+pun[act]);
		    contar ();
		    
		lblNewLabel_2.setText(""+puntaje);
		
		
		//showing();
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


	
	public void first_Adding () {		
		for (int i=16;i>=0;i--) {	
			JLabel label = labels.get(i);
			label.setVerticalAlignment(SwingConstants.CENTER);
			label.setBorder(null);
			label.setBounds(450, 150, 444,400);
			add(label);
		}	
		
		add_fondo(usa.getFondo());
	}
	public void botonframe (JPanel b) {
		removeAll();
		setLayout(new BorderLayout(0, 0));
		add(b);
		repaint();
		revalidate();
	}
	
	
	public void llenar (String usuario) {
		 
		
		Controlador_Prenda b=new Controlador_Prenda ();
		Modelo_Mongo mongo = new Modelo_Mongo(usuario);
		 categ.add(b.buscar_categ("Cuerpo"));
		 categ.add(b.buscar_categ("Ojos"));
		 categ.add(b.buscar_categ("Cejas"));
		 categ.add(b.buscar_categ("Boca"));

		 categ=mongo.leerCateg("Vello", categ);
		 categ=mongo.leerCateg("Lentes", categ);
		 
		 categ.add(b.buscar_categ("Peinado"));
		 
		 categ=mongo.leerCateg("Tatuaje", categ);
		 categ=mongo.leerCateg("Calcetas", categ);
		 categ=mongo.leerCateg("Top", categ);
		 categ=mongo.leerCateg("Pantalon", categ);
		 categ=mongo.leerCateg("Sombrero", categ);
		 categ=mongo.leerCateg("Calzado", categ);
		 categ=mongo.leerCateg("Piercing", categ);
		 categ=mongo.leerCateg("Capa", categ);
		
	
			
			//inicio vacio plox poner 5 en el int x=0
			for (int x = 4; x < 15; x++) {
			    categ.get(x).getAtuendos().add(0, new Prenda(0,"Ninguno", "Ninguno", "vacio"));
			}

		
		for (int i=0;i<16;i++) {
			JLabel nu=new JLabel ();
			labels.add(nu);
			
			pun[i]=0;
		}
		
		
		
		inicializarCurPrenda ();

	}
}