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
    private Imagen imagenes;
    private Bd_oracle bd;
    private Bd_mongo bdMongo;
    private JPanel panel_imagen;
    private JLabel lblTipoNombre;
    private JLabel lblSavesRemaining;
    private JLabel lblNextSave;
    private JLabel lblRepeatInfo;
    private JButton boton_girar;
    private Timer timer;
    private String usuario;
    private int intentos=10;
    JLabel lblNewLabel_1 = new JLabel("*Tiros restantes:"+intentos+"*");
    JLabel lblNewLabel_2 = new JLabel("*Prenda obtenida: n*");

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
		
		  boton_girar = new JButton("GIRAR RULETA");
	        boton_girar.setForeground(new Color(199, 21, 133));
	        boton_girar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
	        boton_girar.setBackground(Color.PINK);
	        boton_girar.setBounds(526, 270, 248, 50);
	        add(boton_girar);

	        panel_imagen = new JPanel();
	        panel_imagen.setBackground(Color.PINK);
	        panel_imagen.setBorder(new LineBorder(Color.BLACK));
	        panel_imagen.setBounds(524, 330, 248, 234);
	        add(panel_imagen);

	        boton_girar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	lblNewLabel_2.setVisible(true);
	            	intentos=intentos-1;
	            	
	    	        if (intentos==0) {
	            		boton_girar.setEnabled(false);
	            	    lblNewLabel_1.setText("*Tiros restantes:"+intentos+"*");
	            	}
	            	else {
	            		boton_girar.setEnabled(true);
	            		lblNewLabel_1.setText("*Tiros restantes:"+intentos+"*");
	            		}	     
	    	        
	            	
	            	
	            }
	        });

	        if (intentos==0) {
        		boton_girar.setEnabled(false);
        	    lblNewLabel_1.setText("*Tiros restantes:"+intentos+"*");
        	}
        	else {
        		boton_girar.setEnabled(true);
        		lblNewLabel_1.setText("*Tiros restantes:"+intentos+"*");
        		}	     
	        
	        
	        
	        //tiros restantes
			lblNewLabel_1.setOpaque(true);
			lblNewLabel_1.setBackground(new Color(0, 0, 0));
			lblNewLabel_1.setBackground(Color.BLACK);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(Color.PINK);
			lblNewLabel_1.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(526, 102, 248, 33);
			add(lblNewLabel_1);
			
			
			//prenda obtenida
			lblNewLabel_2.setOpaque(true);
			lblNewLabel_2.setBackground(new Color(0, 0, 0));
			lblNewLabel_2.setBackground(Color.BLACK);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setForeground(Color.PINK);
			lblNewLabel_2.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(526, 145, 248, 33);
			lblNewLabel_2.setVisible(false);
			add(lblNewLabel_2);
		
			
			//subpanel
		panel2 =new Panel_Informacion_Usuario(usa.getUser(),usa.getCorreo(),usa.getFoto_perfil());
		panel2.setBounds(0, -23, 147, 663);
		add(panel2);	
		this.add_fondo(usa.getFondo());
	}
	
	
	 private void checkSaveLimits() {
	        /*Instant now = Instant.now();
	        Instant twentyFourHoursAgo = now.minusSeconds(120);
	        long saveCount = bdMongo.getSaveCount(Date.from(twentyFourHoursAgo), Date.from(now));

	        if (saveCount >= 10) {
	            lblSavesRemaining.setText("TIROS RESTANTES: 0");
	            Instant nextSaveTime = now.plus(120, ChronoUnit.SECONDS);
	            lblNextSave.setText("REGRESA EN : " + ChronoUnit.MINUTES.between(now, nextSaveTime) + " HORAS");
	            boton_girar.setEnabled(false);
	        } else {
	            lblSavesRemaining.setText("TIROS RESTANTES: " + (10 - saveCount));
	            lblNextSave.setText("");
	            boton_girar.setEnabled(true);
	        }
	        
	        
	        */
	    }

}
