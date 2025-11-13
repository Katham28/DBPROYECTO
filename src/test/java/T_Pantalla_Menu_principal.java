import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;

import main.java.Pantalla_Menu_principal;

public class T_Pantalla_Menu_principal {
	  private static Pantalla_Menu_principal pantalla;
	    private static JFrame frame;

	    @BeforeClass
	    public static void setUpOnce() {
	        // Crear la pantalla y mostrarla UNA vez para todos los tests
	        pantalla = new Pantalla_Menu_principal(3, 1);
	        frame = new JFrame("Demo  Pantalla Menu Principal");
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
	            pantalla = new Pantalla_Menu_principal(3, 1); // nueva instancia si es necesario
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
	    public void testBotonCrearCuenta() throws InterruptedException {
	    	JButton boton = pantalla.getBoton_crear_cuenta();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());

	        System.out.println("Clickeando CREAR CUENTA...");
	        boton.doClick();
	        Thread.sleep(1000); // tiempo para

	    }


	    @Test
	    public void testBotonIniciarSesion() throws InterruptedException {
	    	JButton boton = pantalla.getBoton_iniciarsesion();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando INICIAR SESIÓN...");
	        boton.doClick();
	        Thread.sleep(1000); // tiempo para
	    }

	    @Test
	    public void testBotonAdministrador() throws InterruptedException {
	    	JButton boton = pantalla.getBotton_items();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando ADMINISTRADOR...");
	        boton.doClick();
	        Thread.sleep(1000); 
	    }

	    @Test
	    public void testBotonReporteAll() throws InterruptedException {
	    	JButton boton = pantalla.getBoton_reporte_all();
	        assertNotNull(boton);
	        assertTrue(boton.isVisible() && boton.isEnabled());
	        System.out.println("Clickeando REPORTE GENERAL...");
	        boton.doClick();
	        Thread.sleep(1000); 

	    }
	}
