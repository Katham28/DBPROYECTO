import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Pantalla_Iniciar_Sesion_Admin;
import main.java.Usuario;

public class T_Pantalla_Iniciar_Sesion_Admin {

	private static Pantalla_Iniciar_Sesion_Admin pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Iniciar_Sesion_Admin(1,3);
        frame = new JFrame("Demo Pantalla Iniciar_Sesion_Admin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1150, 705);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(pantalla);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    @Before
    public void resetPantalla() throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            frame.getContentPane().removeAll();
            pantalla =  new Pantalla_Iniciar_Sesion_Admin(1,3);
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }
    
    @Test
    public void testningunollenado() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	 JTextField textField = pantalla.getTextField();
    	 JPasswordField passwordField = pantalla.getPasswordField();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void testalgunoincorrecto() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	 JTextField textField = pantalla.getTextField();
    	 JPasswordField passwordField = pantalla.getPasswordField();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        textField.setText("adminfake");
        passwordField.setText("admin");
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Usuario y/o contraseña incorrectos"));
        
        textField.setText("admin");
        passwordField.setText("adminfake");
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Usuario y/o contraseña incorrectos"));
        

    }
    
    @Test
    public void testambosincorrecto() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	 JTextField textField = pantalla.getTextField();
    	 JPasswordField passwordField = pantalla.getPasswordField();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        textField.setText("adminfake");
        passwordField.setText("adminfake");
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Usuario y/o contraseña incorrectos"));
        

    }
    
    @Test
    public void testcorrecto() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	 JTextField textField = pantalla.getTextField();
    	 JPasswordField passwordField = pantalla.getPasswordField();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        textField.setText("admin");
        passwordField.setText("admin");
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Iniciando sesion"));
        

    }
    
    @Test
    public void testningunollenado_alguno() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	 JTextField textField = pantalla.getTextField();
    	 JPasswordField passwordField = pantalla.getPasswordField();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        textField.setText("admin");
        passwordField.setText("");
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
        
        textField.setText("");
        passwordField.setText("admin");
        
        boton.doClick();
        
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void testmenor_20_Caracteres() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	 JTextField textField = pantalla.getTextField();
    	 JPasswordField passwordField = pantalla.getPasswordField();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
    	
        textField.setText("123456789012345678901");
        passwordField.setText("123456789012345678901");
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void testmenor_20_Caracteres_uno() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	 JTextField textField = pantalla.getTextField();
    	 JPasswordField passwordField = pantalla.getPasswordField();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
    	
        textField.setText("123456789012345678901");
        passwordField.setText("12345678");
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
        
        textField.setText("12345678");
        passwordField.setText("123456789012345678901");
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    

}
