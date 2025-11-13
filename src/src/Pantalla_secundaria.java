import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Pantalla_secundaria extends JPanel {

	private static final long serialVersionUID = 1L;
	protected Imagen imagenes= new Imagen (5);
	protected String fuente= "Niagara Engraved";
	JLabel fondo;
	JButton boton_conf = new JButton("AJUSTES");
	
	
	
	/**
	 * Create the panel.
	 */
	public Pantalla_secundaria(int num_fondo,int num_musica) {
		
		setBackground(new Color(199, 21, 133));
		setBounds(100, 100, 1122, 650);
		setLayout(null);
		
		
		boton_conf.setForeground(new Color(199, 21, 133));
		
		boton_conf.setFont(new Font("Artifakt Element", Font.PLAIN, 14));
		boton_conf.setBackground(Color.PINK);
		boton_conf.setBounds(10, 94, 122, 27);
		add(boton_conf);
		
		//add_fondo (num_fondo);
		//botonframe ();
	}
	
	public void botonframe (JPanel b) {
		removeAll();
		setLayout(new BorderLayout(0, 0));
		add(b);
		repaint();
		revalidate();
	}
	
	public void add_fondo (int num_fondo) {
		System.out.println(""+num_fondo);
		JLabel fondo = new JLabel();
		fondo.setVerticalAlignment(SwingConstants.CENTER);
		fondo.setIcon(imagenes.getfondo(""+num_fondo));
		fondo.setBorder(null);
		fondo.setBounds(0, 0, 1134, 650);
		add(fondo);

	}
	
	public void boton_ajustes(int b,Usuario usuario,int num_fondo,int num_musica) {
		if (b==0) {
			boton_conf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botonframe (new Pantalla_Ajustes (num_fondo,num_musica));
				}
			});
		}else {
			boton_conf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					botonframe (new Pantalla_Ajustes (usuario));
				}
			});
			
		}
		
	}
	
	
	 public static void mostrarConfeti(JButton boton) {
	        Container contenedor = boton.getParent();
	        if (contenedor == null) return;

	        JPanel confeti = new JPanel() {
	            final int PARTICULAS = 50;
	            final int[] x = new int[PARTICULAS];
	            final int[] y = new int[PARTICULAS];
	            final double[] dx = new double[PARTICULAS]; 
	            final double[] dy = new double[PARTICULAS];
	            final Color[] colors = new Color[PARTICULAS];
	            int vida = 40;
	            final Random r = new Random();

	            {
	                setOpaque(false);
	                int centerX = boton.getX() + boton.getWidth() / 2;
	                int centerY = boton.getY() + boton.getHeight() / 2;

	                for (int i = 0; i < PARTICULAS; i++) {
	                    x[i] = centerX;
	                    y[i] = centerY;
	                    double angle = r.nextDouble() * 2 * Math.PI;
	                    double speed = 2 + r.nextDouble() ;
	                    dx[i] = Math.cos(angle) * speed;
	                    dy[i] = Math.sin(angle) * speed;
	                    colors[i] = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
	                }

	                new javax.swing.Timer(16, e -> {
	                    for (int i = 0; i < PARTICULAS; i++) {
	                        x[i] += dx[i];
	                        y[i] += dy[i];
	                    }
	                    vida--;
	                    repaint();
	                    if (vida <= 20) {
	                        ((javax.swing.Timer) e.getSource()).stop();
	                        contenedor.remove(this);
	                        contenedor.repaint();
	                    }
	                }).start();
	            }

	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                for (int i = 0; i < PARTICULAS; i++) {
	                    g.setColor(colors[i]);
	                    g.fillRect(x[i] - 1, y[i] - 4, 2, 8);
	                    g.fillRect(x[i] - 4, y[i] - 1, 8, 2);
	                }
	            }
	        };

	        confeti.setBounds(0, 0, contenedor.getWidth(), contenedor.getHeight());
	        contenedor.add(confeti);
	        contenedor.setComponentZOrder(confeti, 0);
	        contenedor.repaint();
	    }
	
	// 🌟 Explosión desde el centro del contenedor
    public static void mostrarConfetiDesdeCentro(Container contenedor) {
        if (contenedor == null) return;

        JPanel confeti = new JPanel() {
            final int PARTICULAS = 100;
            final int[] x = new int[PARTICULAS];
            final int[] y = new int[PARTICULAS];
            final double[] dx = new double[PARTICULAS];
            final double[] dy = new double[PARTICULAS];
            final Color[] colors = new Color[PARTICULAS];
            int vida = 100;
            final Random r = new Random();

            {
                setOpaque(false);
                int centerX = contenedor.getWidth() / 2;
                int centerY = contenedor.getHeight() / 2;

                for (int i = 0; i < PARTICULAS; i++) {
                    x[i] = centerX;
                    y[i] = centerY;
                    double angle = r.nextDouble() * 2 * Math.PI;
                    double speed = 3 + r.nextDouble() * 8;
                    dx[i] = Math.cos(angle) * speed;
                    dy[i] = Math.sin(angle) * speed;
                    colors[i] = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
                }

                new javax.swing.Timer(16, e -> {
                    for (int i = 0; i < PARTICULAS; i++) {
                        x[i] += dx[i];
                        y[i] += dy[i];
                    }
                    vida--;
                    repaint();
                    if (vida <= 0) {
                        ((javax.swing.Timer) e.getSource()).stop();
                        contenedor.remove(this);
                        contenedor.repaint();
                    }
                }).start();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < PARTICULAS; i++) {
                    g.setColor(colors[i]);
                    g.fillRect(x[i] - 1, y[i] - 4, 2, 8);
                    g.fillRect(x[i] - 4, y[i] - 1, 8, 2);
                }
            }
        };

        confeti.setBounds(0, 0, contenedor.getWidth(), contenedor.getHeight());
        contenedor.add(confeti);
        contenedor.setComponentZOrder(confeti, 0);
        contenedor.repaint();
    }





}
