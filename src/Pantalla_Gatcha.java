import static com.mongodb.client.model.Filters.eq;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.bson.Document;

public class Pantalla_Gatcha extends Pantalla_secundaria {
	private Usuario usa;
	private static final long serialVersionUID = 1L;
	JPanel panel2;
    private Bd_oracle bd;
    private Modelo_Mongo bdMongo;
    private JLabel lblTipoNombre;

    private JLabel lblNextSave= new JLabel("");;
    private JLabel lblRepeatInfo;
    private JButton boton_girar;
    private Timer timer;
    private String usuario;
    private int intentos=10;
    JLabel lblSavesRemaining = new JLabel("*Tiros restantes:"+intentos+"*");
    JLabel lblNewLabel_2 = new JLabel("*Prenda obtenida*");
    String [] categor = new String[15];
    Imagen imagenes= new Imagen ();
    JLabel ima = new JLabel();
    
    Prenda prenda_gatcha;
	/**
	 * Create the panel.
	 */
    

    
    public Prenda sacar_prenda (int numero) {
    	categor[0] = "Cuerpo";
        categor[1] = "Ojos";
        categor[2] = "Cejas";
        categor[3] = "Boca";
        categor[4] = "Peinado";
        categor[5] = "Vello";
        categor[6] = "Tatuaje";
        categor[7] = "Piercing";
        categor[8] = "Capa";
        categor[9] = "Pantalon";
        categor[10] = "Sombrero";
        categor[11] = "Lentes";
        categor[12] = "Calcetas";
        categor[13] = "Top";
        categor[14] = "Calzado";       
   
      
	     // nextInt(11) genera de 0 a 10, sumamos 4 para que sea de 4 a 14
	     Controlador_Prenda b=new  Controlador_Prenda ();
	     int canti=  b.sacar_canti(categor[numero]);
	  // System.out.println("Categoria:" +categor[numero] + "Num_prendas:"+canti);
	     
	     Random rand2 = new Random();
         
         b= new Controlador_Prenda();
         
         Prenda prenda_gatcha= null;
         
         while(prenda_gatcha==null) {
        	 int numRandom = rand2.nextInt(canti) ;  //quiza haya que quitar el 1 pero quien sabe :0
         prenda_gatcha=b.obtenerPrendaPorCategoriaYFila(categor[numero], numRandom);

         }
        // System.out.println(prenda_gatcha);
         
       return prenda_gatcha;
         
    }
   

	public Pantalla_Gatcha (Usuario usa) {
		super(usa.getFondo(),usa.getMusica());
		bdMongo = new Modelo_Mongo(usa.getUser());
		this.usa=usa;
	
		//label
	       
        lblTipoNombre = new JLabel("");
        lblTipoNombre.setOpaque(true);
        lblTipoNombre.setBackground(Color.PINK);
        lblTipoNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTipoNombre.setForeground(new Color(199, 21, 133));
        lblTipoNombre.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
        lblTipoNombre.setBounds(369, 122, 567, 33);
        add(lblTipoNombre);
        
        lblRepeatInfo = new JLabel("");
        lblRepeatInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblRepeatInfo.setForeground(Color.RED);
        lblRepeatInfo.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        lblRepeatInfo.setBounds(393, 157, 527, 33);
        add(lblRepeatInfo);
        
        //nextSave
     
        lblNextSave.setOpaque(false);
        lblNextSave.setBackground(new Color(0, 0, 0));
        lblNextSave.setHorizontalAlignment(SwingConstants.CENTER);
        lblNextSave.setForeground(new Color(255, 255, 255));
        lblNextSave.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        lblNextSave.setBounds(438, 188, 428, 33);
        add(lblNextSave);
        
        //tiros restantes
        lblSavesRemaining.setOpaque(true);
        lblSavesRemaining.setBackground(new Color(0, 0, 0));
        lblSavesRemaining.setBackground(Color.BLACK);
        lblSavesRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        lblSavesRemaining.setForeground(Color.PINK);
        lblSavesRemaining.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
        lblSavesRemaining.setBounds(369, 75, 567, 33);
		add(lblSavesRemaining);
		
		//botones
		this.boton_ajustes(1,usa,usa.getFondo(),usa.getMusica());	
		
		JButton boton_volver = new JButton("VOLVER");
		boton_volver.setForeground(new Color(199, 21, 133));
		boton_volver.setBounds(10, 10, 122, 27);
		boton_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonframe (new Pantalla_Menu_Usuario (usa));
				if (timer != null) {
                    timer.cancel();
                }
			}
		});
		boton_volver.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_volver.setBackground(Color.PINK);
		add(boton_volver);
		
		  boton_girar = new JButton("GIRAR RULETA");
	        boton_girar.setForeground(new Color(199, 21, 133));
	        boton_girar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
	        boton_girar.setBackground(Color.PINK);
	        boton_girar.setBounds(526, 231, 248, 50);
	        add(boton_girar);

	        boton_girar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	//Saco una categ random
	            	  Random rand = new Random();
	                  int num_Categ = 5 + rand.nextInt(10); 
	            	//Saco prenda, pongo imagen y muestro la prenda obtenida
            		prenda_gatcha= sacar_prenda (num_Categ);
            		// Display the tipo and name
                    lblTipoNombre.setText("Tipo: " + categor[num_Categ] + ", Nombre: " + prenda_gatcha.getName());
            	    System.out.println(prenda_gatcha);
            		ima.setIcon(imagenes.getprenda(prenda_gatcha.getName_archivo()));
            		
            		
            		// Check save limits and display remaining saves
                    Instant now = Instant.now();
                    Instant twentyFourHoursAgo = now.minusSeconds(60*60*24);
                    long saveCount = bdMongo.getSaveCount(Date.from(twentyFourHoursAgo), Date.from(now));

                    if (saveCount >= 10) {
                    	lblSavesRemaining.setText("TIROS RESTANTES: 0");
                        Instant nextSaveTime = now.plus(24*60*60, ChronoUnit.SECONDS);
                        lblNextSave.setText("REGRESA EN : " + ChronoUnit.HOURS.between(now, nextSaveTime) + " HORAS");
                        lblNextSave.setOpaque(true);
                        boton_girar.setEnabled(false);
                        return;
                    } else {
                        lblSavesRemaining.setText("TIROS RESTANTES: " + (10 - saveCount));
                        lblNextSave.setText("");
                    }
            		//
            		
	    	        
                 // Save the ropa and check for duplicates
                    Document existingDoc = bdMongo.getCollection(categor[num_Categ]).find(eq("name", prenda_gatcha.getName())).first();
                    if (existingDoc != null) {
                        lblRepeatInfo.setText("PRENDA REPETIDA!");
                    } else {
                        bdMongo.guardarRopa(prenda_gatcha, categor[num_Categ]);
                        lblRepeatInfo.setText("");
                    }

                    bdMongo.logGiro();

           
                    checkSaveLimits();
	            	
	            	
	            }
	        });
	        
	        checkSaveLimits();

	        // Schedule periodic updates
	        timer = new Timer();
	        timer.schedule(new TimerTask() {
	            @Override
	            public void run() {
	                checkSaveLimits();
	            }
	        }, 0, 60000); // Update every 60 seconds		
			
			ima.setBounds(526, 333, 248, 234);
			ima.setHorizontalAlignment(SwingConstants.CENTER);
			ima.setVerticalAlignment(SwingConstants.CENTER);
			add(ima);
			
			//subpanel
		panel2 =new Panel_Informacion_Usuario(usa.getUser(),usa.getCorreo(),usa.getFoto_perfil());
		panel2.setBounds(0, -23, 147, 663);
		add(panel2);	
		
		JPanel panel = new JPanel();
		panel.setBounds(526, 317, 248, 299);
		add(panel);
		

		this.add_fondo(usa.getFondo());
	}
	
	
	private void checkSaveLimits() {
		// Check save limits and display remaining saves
        Instant now = Instant.now();
        Instant twentyFourHoursAgo = now.minusSeconds(60*60*24);
        long saveCount = bdMongo.getSaveCount(Date.from(twentyFourHoursAgo), Date.from(now));

        if (saveCount >= 10) {
        	lblSavesRemaining.setText("TIROS RESTANTES: 0");
            Instant nextSaveTime = now.plus(24*60*60, ChronoUnit.SECONDS);
            lblNextSave.setText("REGRESA EN : " + ChronoUnit.HOURS.between(now, nextSaveTime) + " HORAS");
            lblNextSave.setOpaque(true);
            boton_girar.setEnabled(false);
            return;
        } else {
            lblSavesRemaining.setText("TIROS RESTANTES: " + (10 - saveCount));
            lblNextSave.setText("");
        }
		//
    }
}
