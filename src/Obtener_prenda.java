import java.awt.BorderLayout;
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
import static com.mongodb.client.model.Filters.eq;

public class Obtener_prenda extends JPanel {

    private static final long serialVersionUID = 1L;
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

    /**
     * Create the panel.
     */
    public Obtener_prenda(int num, String usuario) {
        imagenes = new Imagen(num);
        bd = new Bd_oracle();
        bdMongo = new Bd_mongo(usuario);
        this.usuario = usuario;
        setBackground(new Color(199, 21, 133));
        setBounds(100, 100, 1122, 566);
        setLayout(null);

        JButton boton_cierro = new JButton("CERRAR SESIÓN");
        boton_cierro.setForeground(new Color(199, 21, 133));
        boton_cierro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //botonframe(new principal_(num));
                if (timer != null) {
                    timer.cancel();
                }
            }
        });
        boton_cierro.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        boton_cierro.setBackground(Color.PINK);
        boton_cierro.setBounds(10, 10, 217, 40);
        add(boton_cierro);

        JButton boton_principal = new JButton("VOLVER A PRINCIPAL");
        boton_principal.setForeground(new Color(199, 21, 133));
        boton_principal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonframe(new moda(num, usuario));
                if (timer != null) {
                    timer.cancel();
                }
            }
        });
        boton_principal.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        boton_principal.setBackground(Color.PINK);
        boton_principal.setBounds(10, 60, 217, 40);
        add(boton_principal);
        
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
		
        lblTipoNombre = new JLabel("");
        lblTipoNombre.setOpaque(true);
        lblTipoNombre.setBackground(Color.PINK);
        lblTipoNombre.setHorizontalAlignment(SwingConstants.CENTER);
        lblTipoNombre.setForeground(new Color(199, 21, 133));
        lblTipoNombre.setFont(new Font("Artifakt Element", Font.PLAIN, 18));
        lblTipoNombre.setBounds(285, 116, 527, 33);
        add(lblTipoNombre);

        lblSavesRemaining = new JLabel("");
        lblSavesRemaining.setOpaque(true);
        lblSavesRemaining.setBackground(Color.BLACK);
        lblSavesRemaining.setHorizontalAlignment(SwingConstants.CENTER);
        lblSavesRemaining.setForeground(new Color(199, 21, 133));
        lblSavesRemaining.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        lblSavesRemaining.setBounds(285, 150, 527, 33);
        add(lblSavesRemaining);

        lblNextSave = new JLabel("");
        lblNextSave.setOpaque(false);
        lblNextSave.setBackground(new Color(0, 0, 0));
        lblNextSave.setHorizontalAlignment(SwingConstants.CENTER);
        lblNextSave.setForeground(new Color(255, 255, 255));
        lblNextSave.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        lblNextSave.setBounds(332, 183, 428, 33);
        add(lblNextSave);

        lblRepeatInfo = new JLabel("");
        lblRepeatInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblRepeatInfo.setForeground(Color.RED);
        lblRepeatInfo.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        lblRepeatInfo.setBounds(394, 143, 527, 33);
        add(lblRepeatInfo);

        boton_girar = new JButton("GIRAR RULETA");
        boton_girar.setForeground(new Color(199, 21, 133));
        boton_girar.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
        boton_girar.setBackground(Color.PINK);
        boton_girar.setBounds(423, 260, 248, 50);
        add(boton_girar);

        panel_imagen = new JPanel();
        panel_imagen.setBackground(Color.PINK);
        panel_imagen.setBorder(new LineBorder(Color.BLACK));
        panel_imagen.setBounds(421, 320, 248, 234);
        add(panel_imagen);

        boton_girar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Prenda prenda = bd.ruleta();
                    String tipo = bd.getLastTable();
                    System.out.println("Prenda seleccionada: " + prenda.getName() + " from table: " + tipo);

                    // Display the tipo and name
                    lblTipoNombre.setText("Tipo: " + tipo + ", Nombre: " + prenda.getName());

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

                    // Display the final image
                    ImageIcon icon = new ImageIcon(getClass().getResource(prenda.getName_archivo() + ".png"));
                    if (icon.getIconWidth() > 0) {
                        Image img = icon.getImage().getScaledInstance(panel_imagen.getWidth(), panel_imagen.getHeight(), Image.SCALE_SMOOTH);
                        JLabel label = new JLabel(new ImageIcon(img));
                        panel_imagen.removeAll();
                        panel_imagen.add(label);
                        panel_imagen.revalidate();
                        panel_imagen.repaint();
                    }

                    // Save the ropa and check for duplicates
                    Document existingDoc = bdMongo.getCollection(tipo).find(eq("clave", prenda.getClave())).first();
                    if (existingDoc != null) {
                        lblRepeatInfo.setText("PRENDA REPETIDA!");
                    } else {
                        //bdMongo.guardarRopa(prenda, tipo);
                        lblRepeatInfo.setText("");
                    }

                    bdMongo.logGiro();

           
                    checkSaveLimits();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Initial check for save limits
        checkSaveLimits();

        // Schedule periodic updates
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkSaveLimits();
            }
        }, 0, 60000); // Update every 60 seconds
        
        JLabel fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.CENTER);
		fondo.setIcon(imagenes.getfondo("fondo1"));
		fondo.setBorder(null);
		fondo.setBounds(0, 0, 1134, 650);
		add(fondo);
    }

    private void checkSaveLimits() {
        Instant now = Instant.now();
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
    }

    public void botonframe(JPanel b) {
        removeAll();
        setLayout(new BorderLayout(0, 0));
        add(b);
        repaint();
        revalidate();
    }
}

