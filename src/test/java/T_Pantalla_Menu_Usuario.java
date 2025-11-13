import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Pantalla_Menu_Usuario;
import main.java.Usuario;

public class T_Pantalla_Menu_Usuario {
	 private static Pantalla_Menu_Usuario pantalla;
	    private static JFrame frame;

	    @BeforeClass
	    public static void setUpOnce() {
	        // Crear la pantalla y mostrarla UNA vez para todos los tests
	        pantalla = new Pantalla_Menu_Usuario( new Usuario("usa","12345678","usa@gmail.com",1,1,1) );
	        frame = new JFrame("Demo  Pantalla Menu Usuario");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1150, 705); // ancho x alto
	        frame.setLocationRelativeTo(null); // centra en pantalla
	        frame.setVisible(true);
	        frame.add(pantalla);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
	    
	    @Before
	    public void resetPantallaPrincipal() throws InvocationTargetException, InterruptedException {
	        // Ejecutar en el EDT para seguridad en Swing
	        SwingUtilities.invokeAndWait(() -> {
	            frame.getContentPane().removeAll();        // eliminar panel actual
	            pantalla = new Pantalla_Menu_Usuario( new Usuario("usa","12345678","usa@gmail.com",1,1,1) );
		        frame = new JFrame("Demo  Pantalla Menu Usuario");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(1150, 705); // ancho x alto
		        frame.setLocationRelativeTo(null); // centra en pantalla
		        frame.setVisible(true);
	            frame.add(pantalla);
	            frame.getContentPane().revalidate();
	            frame.getContentPane().repaint();
	        });
	        
	        Thread.sleep(1000); // tiempo para
	    }
	    
	    @Test
	    public void testBotonropa() throws InterruptedException {
	    	JButton boton = pantalla.getBtnNewButton();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando 1...");
	        boton.doClick();
	        Thread.sleep(1000); 
	    }
	    
	    
	    @Test
	    public void testBotonropa1() throws InterruptedException {
	    	JButton boton = pantalla.getBtnNewButton_1();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando 2...");
	        boton.doClick();
	        Thread.sleep(1000); 
	    }
	    
	    
	    @Test
	    public void testBotonropa1_1() throws InterruptedException {
	    	JButton boton = pantalla.getBtnNewButton_1_1();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando 3...");
	        boton.doClick();
	        Thread.sleep(1000); 
	    }
	    
	    @Test
	    public void testBoton_AJUSTE() throws InterruptedException {
	    	JButton boton = pantalla.getBoton_conf();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando AJUSTES...");
	        boton.doClick();
	        Thread.sleep(1000); 
	    }
	    
	    @Test
	    public void testBotonReporteAll() throws InterruptedException {
	    	JButton boton = pantalla.getBoton_reporte_all();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando REPORTE USUARIO...");
	        boton.doClick();
	        Thread.sleep(1000); 

	    }
	    
	    
	    @Test
	    public void testBotonVolver() throws InterruptedException {
	        JButton boton = pantalla.getBoton_cierro_1();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());

	        System.out.println("Clickeando VOLVER...");
	        //boton.doClick();
	        Thread.sleep(1000);
	    }


}
