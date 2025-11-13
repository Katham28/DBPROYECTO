import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Pantalla_Iniciar_Sesion;

public class T_Pantalla_Iniciar_Sesion {


    private static Pantalla_Iniciar_Sesion pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Iniciar_Sesion(3, 1,0);
        frame = new JFrame("Demo Pantalla Iniciar sesion");
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
            pantalla = new Pantalla_Iniciar_Sesion(3, 1,0);
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }

    @Test
    public void testBoton() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }

    
    @Test
    public void testContraseña_incorrecta() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JPasswordField passwordField = pantalla.getPasswordField();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        // 3️⃣ Contraseñas no coinciden
        usuarioField.setText("usa");
        passwordField.setText("contraseña123");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Usuario y/o contraseña incorrectos"));
    
        }
    
    @Test
    public void test_mayor_20_caracteres() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JPasswordField passwordField = pantalla.getPasswordField();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        // 4️⃣ Más de 20 caracteres
        String textoLargo = "aaaaaaaaaaaaaaaaaaaaa"; // 21 caracteres
        usuarioField.setText(textoLargo);
        passwordField.setText("contraseña123");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));

        
        
        // 4️⃣ Más de 20 caracteres
        usuarioField.setText("usa");
        passwordField.setText(textoLargo);
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));
       
        }
    
    
    @Test
    public void test_contra_menor_8_caracteres() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JPasswordField passwordField = pantalla.getPasswordField();


        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        usuarioField.setText("usuario1");
        passwordField.setText("1234567");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Contraseña mínimo 8 caracteres"));
        
        
        }
    

    

    
    @Test
    public void test_usuario_CORRECTO() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JPasswordField passwordField = pantalla.getPasswordField();


        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        
        usuarioField.setText("usa1");
        passwordField.setText("12345678");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(boton.getText().equals("cargando"));
    }
    
    
    @Test
    public void testBotonVolver() throws InterruptedException {
        JButton boton = pantalla.getBoton_volver();
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        System.out.println("Clickeando VOLVER...");
        //boton.doClick();
        Thread.sleep(500);
    }

}
