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

import main.java.Pantalla_Ajustes;
import main.java.Usuario;

public class T_Pantalla_Ajustes_Usuario {

	private static Pantalla_Ajustes pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Ajustes( new Usuario("usa","12345678","usa@gmail.com",1,1,1));
        frame = new JFrame("Demo Pantalla Ajustes");
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
            pantalla = new Pantalla_Ajustes( new Usuario("usa","12345678","usa@gmail.com",1,1,1));
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }

    @Test
    public void testningunoseleccionado() throws InterruptedException {
        JButton boton = pantalla.getBoton_guardar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JCheckBox chckbxNewCheckBox2 = pantalla.getChckbxNewCheckBox2();
    	JCheckBox chckbxNewCheckBox3 = pantalla.getChckbxNewCheckBox3();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Realiza cambios en al menos un campo"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    
    @Test
    public void testCorreo_invalido_CuentaCasos() throws InterruptedException {
        JButton boton = pantalla.getBoton_guardar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JCheckBox chckbxNewCheckBox2 = pantalla.getChckbxNewCheckBox2();
    	JCheckBox chckbxNewCheckBox3 = pantalla.getChckbxNewCheckBox3();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JTextField passwordField = pantalla.getPasswordField();
        JTextField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        chckbxNewCheckBox2.doClick();
        correoField.setText("correo_invalido");
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Correo invalido"));
    }
    
    
    @Test
    public void testContraseña_no_coincide() throws InterruptedException {
        JButton boton = pantalla.getBoton_guardar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JCheckBox chckbxNewCheckBox2 = pantalla.getChckbxNewCheckBox2();
    	JCheckBox chckbxNewCheckBox3 = pantalla.getChckbxNewCheckBox3();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JTextField passwordField = pantalla.getPasswordField();
        JTextField passwordField_1 = pantalla.getPasswordField_1();

        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        chckbxNewCheckBox3.doClick();
        
        passwordField.setText("contraseña123");
        passwordField_1.setText("otra_contraseña");
        boton.doClick();
        
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("La contraseña no coincide"));


        }
    
    @Test
    public void test_mayor_20_caracteres() throws InterruptedException {
        JButton boton = pantalla.getBoton_guardar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JCheckBox chckbxNewCheckBox2 = pantalla.getChckbxNewCheckBox2();
    	JCheckBox chckbxNewCheckBox3 = pantalla.getChckbxNewCheckBox3();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JTextField passwordField = pantalla.getPasswordField();
        JTextField passwordField_1 = pantalla.getPasswordField_1();
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        chckbxNewCheckBox.doClick();
        // 4️⃣ Más de 20 caracteres
        String textoLargo = "aaaaaaaaaaaaaaaaaaaaa"; // 21 caracteres
        usuarioField.setText(textoLargo);
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));


        }
    
    
    @Test
    public void test_contra_menor_8_caracteres() throws InterruptedException {
        JButton boton = pantalla.getBoton_guardar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JCheckBox chckbxNewCheckBox2 = pantalla.getChckbxNewCheckBox2();
    	JCheckBox chckbxNewCheckBox3 = pantalla.getChckbxNewCheckBox3();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JTextField passwordField = pantalla.getPasswordField();
        JTextField passwordField_1 = pantalla.getPasswordField_1();
        
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());

        chckbxNewCheckBox3.doClick();

        passwordField.setText("1234567");
        passwordField_1.setText("1234567");
        
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Contraseña mínimo 8 caracteres"));
        
        
        }
    
    @Test
    public void test_usuario_Existente() throws InterruptedException {
        JButton boton = pantalla.getBoton_guardar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JCheckBox chckbxNewCheckBox2 = pantalla.getChckbxNewCheckBox2();
    	JCheckBox chckbxNewCheckBox3 = pantalla.getChckbxNewCheckBox3();
        
        JTextField usuarioField = pantalla.getTextField();
        JTextField correoField = pantalla.getTextField_1();
        JTextField passwordField = pantalla.getPasswordField();
        JTextField passwordField_1 = pantalla.getPasswordField_1();
        
        
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        chckbxNewCheckBox.doClick();

        usuarioField.setText("katham_28");//<-usuario que ya existe
 
        boton.doClick();
        Thread.sleep(300);
        assertTrue(lblResult.getText().equals("Ese usuario ya existe"));

    }
   



}
