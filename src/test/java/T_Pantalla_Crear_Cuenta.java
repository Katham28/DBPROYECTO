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
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Color;
import java.lang.reflect.InvocationTargetException;

import main.java.Imagen;
import main.java.Pantalla_Crear_Cuenta;


public class T_Pantalla_Crear_Cuenta {

    private static Pantalla_Crear_Cuenta pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Crear_Cuenta(3, 1);
        frame = new JFrame("Demo Pantalla Crear Cuenta");
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
            pantalla = new Pantalla_Crear_Cuenta(3, 1);
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }

    @Test
    public void testVaciosVariosCuenta() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
    	JLabel lblResult =pantalla.getLblNewLabel_2();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
    	
    	JTextField usuarioField = pantalla.getTextField();
    	JTextField correoField = pantalla.getTextField_1();
    	JPasswordField passwordField = pantalla.getPasswordField();
    	JPasswordField passwordField_1= pantalla.getPasswordField_1();
        
        usuarioField.setText("");
        correoField.setText("correo@valido.com");
        passwordField.setText("contraseña123");
        passwordField_1.setText("contraseña123");
    	
        System.out.println("Clickeando CREAR CUENTA con campos vacios...");
        boton.doClick();
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
        
        usuarioField.setText("usuario");
        correoField.setText("");
        passwordField.setText("contraseña123");
        passwordField_1.setText("contraseña123");
    	
        System.out.println("Clickeando CREAR CUENTA con campos vacios...");
        boton.doClick();
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
        
        usuarioField.setText("usuario");
        correoField.setText("correo@valido.com");
        passwordField.setText("");
        passwordField_1.setText("contraseña123");
        
        System.out.println("Clickeando CREAR CUENTA con campos vacios...");
        boton.doClick();
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
        
        usuarioField.setText("usuario");
        correoField.setText("correo@valido.com");
        passwordField.setText("contraseña123");
        passwordField_1.setText("");
        
        System.out.println("Clickeando CREAR CUENTA con campos vacios...");
        boton.doClick();
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
        
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    @Test
    public void testCorreo_invalido_CuentaCasos() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JPasswordField passwordField = pantalla.getPasswordField();
        JPasswordField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        // 2️⃣ Correo inválido
        usuarioField.setText("usuario1");
        correoField.setText("correo_invalido");
        passwordField.setText("contraseña123");
        passwordField_1.setText("contraseña123");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Correo invalido"));
    }
    
    @Test
    public void testContraseña_no_coincide() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JPasswordField passwordField = pantalla.getPasswordField();
        JPasswordField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        // 3️⃣ Contraseñas no coinciden
        usuarioField.setText("usuario1");
        correoField.setText("correo@valido.com");
        passwordField.setText("contraseña123");
        passwordField_1.setText("otra_contraseña");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Las contraseñas no coinciden"));


        }
    
    @Test
    public void test_mayor_20_caracteres() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JPasswordField passwordField = pantalla.getPasswordField();
        JPasswordField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        // 4️⃣ Más de 20 caracteres
        String textoLargo = "aaaaaaaaaaaaaaaaaaaaa"; // 21 caracteres
        usuarioField.setText(textoLargo);
        correoField.setText("correo@valido.com");
        passwordField.setText("contraseña123");
        passwordField_1.setText("contraseña123");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));


        }
    
    
    @Test
    public void test_contra_menor_8_caracteres() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JPasswordField passwordField = pantalla.getPasswordField();
        JPasswordField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        usuarioField.setText("usuario1");
        correoField.setText("correo@valido.com");
        passwordField.setText("1234567");
        passwordField_1.setText("1234567");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Contraseña mínimo 8 caracteres"));
        
        
        }
    
    @Test
    public void test_usuario_Existente() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JPasswordField passwordField = pantalla.getPasswordField();
        JPasswordField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        // 6️⃣ Usuario ya existe (simular re=1)
        usuarioField.setText("usa");//<-usuario que ya existe
        correoField.setText("correo@valido.com");
        passwordField.setText("contraseña123");
        passwordField_1.setText("contraseña123");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Ese usuario ya existe"));

    }
    
    @Test
    public void testCampos_vacios_CuentaCasos() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JPasswordField passwordField = pantalla.getPasswordField();
        JPasswordField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        // 1️⃣ Campos vacíos
        usuarioField.setText("");
        correoField.setText("");
        passwordField.setText("");
        passwordField_1.setText("");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Llene todos los campos"));
    }
    
    @Test
    public void test_usuario_CORRECTO() throws InterruptedException {
        JButton boton = pantalla.getBoton_iniciarsesion();
        JLabel lblResult = pantalla.getLblNewLabel_2();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JPasswordField passwordField = pantalla.getPasswordField();
        JPasswordField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        pantalla.setTest(1);
        
        // 7.Usuario_correcto
        usuarioField.setText("usa");
        correoField.setText("correo@valido.com");
        passwordField.setText("contraseña123");
        passwordField_1.setText("contraseña123");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("***Creando usuario***"));
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
