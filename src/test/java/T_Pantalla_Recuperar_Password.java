import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Pantalla_Crear_Cuenta;
import main.java.Pantalla_Recuperar_password;

public class T_Pantalla_Recuperar_Password {

    private static Pantalla_Recuperar_password pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Recuperar_password(3, 1);
        frame = new JFrame("Demo Pantalla Recuperar Contraseña");
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
            pantalla = new Pantalla_Recuperar_password(3, 1);
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }
 // 1️⃣ Campo usuario vacío al pedir código
    @Test
    public void testUsuarioVacio_obtenerCodigo() throws InterruptedException {
        JButton boton = pantalla.getBoton_obtener_codigo();
        JTextField usuario = pantalla.getTextField_usuario();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje1();

        usuario.setText("");
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Llena el campo requerido"));
    }

    // 2️⃣ Usuario con más de 20 caracteres
    @Test
    public void testUsuarioLargo_obtenerCodigo() throws InterruptedException {
    	
    	
    	
        JButton boton = pantalla.getBoton_obtener_codigo();
        JTextField usuario = pantalla.getTextField_usuario();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje1();

        usuario.setText("abcdefghijklmnopqrstu"); // 21 chars
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Sólo 20 carácteres máximos permitidos"));
    }

    // 3️⃣ Usuario no existente
    @Test
    public void testUsuarioNoExiste_obtenerCodigo() throws InterruptedException {

        JButton boton = pantalla.getBoton_obtener_codigo();
        JTextField usuario = pantalla.getTextField_usuario();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje1();

        usuario.setText("frfesw");
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Ese usuario NO existe"));
    }



    // 5️⃣ Usuario existente y correo enviado
    @Test
    public void testCorreoEnviadoCorrectamente() throws InterruptedException {
        JButton boton = pantalla.getBoton_obtener_codigo();
        JTextField usuario = pantalla.getTextField_usuario();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje1();

        usuario.setText("katham_28");
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Correo enviado"));
    }

    @Test
    public void testCodigoVacio_confirmarCodigo() throws InterruptedException {
        JButton boton = pantalla.getBoton_confirmar_codigo();
        JTextField codigo = pantalla.getTextField_codigo();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje2();
        JTextField usuario = pantalla.getTextField_usuario();
        JButton boton_obtener = pantalla.getBoton_obtener_codigo();
        
        usuario.setText("katham_28");
        boton_obtener.doClick();
        codigo.setText("");
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Llena el campo requerido"));
    }

    // 7️⃣ Código largo
    @Test
    public void testCodigoLargo_confirmarCodigo() throws InterruptedException {
        JButton boton = pantalla.getBoton_confirmar_codigo();
        JTextField codigo = pantalla.getTextField_codigo();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje2();
        JTextField usuario = pantalla.getTextField_usuario();
        JButton boton_obtener = pantalla.getBoton_obtener_codigo();
        
        usuario.setText("katham_28");
        boton_obtener.doClick();
        codigo.setText("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        boton.doClick();
        Thread.sleep(300);


        assertTrue(lblMsg.getText().equals("Sólo 20 carácteres máximos permitidos"));
    }

    // 8️⃣ Código inválido
    @Test
    public void testCodigoInvalido_confirmarCodigo() throws InterruptedException {
        JButton boton = pantalla.getBoton_confirmar_codigo();
        JTextField codigo = pantalla.getTextField_codigo();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje2();
        JTextField usuario = pantalla.getTextField_usuario();
        JButton botoncorreo=pantalla.getBoton_obtener_codigo();
        
        usuario.setText("katham_28");
        botoncorreo.doClick();
        codigo.setText("123456");
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Codigo inválido"));
    }

    // 9️⃣ Código correcto
    @Test
    public void testCodigoCorrecto_confirmarCodigo() throws InterruptedException {
        JButton boton = pantalla.getBoton_confirmar_codigo();
        JTextField codigo = pantalla.getTextField_codigo();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje2();
        JTextField usuario = pantalla.getTextField_usuario();
        JButton boton_obtener = pantalla.getBoton_obtener_codigo();
        
        usuario.setText("katham_28");
        boton_obtener.doClick();
        codigo.setText("YUI40");
        boton.doClick();
        Thread.sleep(300);
       

        assertTrue(lblMsg.getText().equals("Codigo verificado exitosamente"));
    }

    // 🔟 Contraseña vacía o no coincide
    @Test
    public void testContraseñaNoCoincide_cambiar() throws InterruptedException {
    	JButton boton_correo = pantalla.getBoton_obtener_codigo();
    	JButton boton_cod = pantalla.getBoton_confirmar_codigo();
    	JButton boton = pantalla.getBoton_cambiar();
        JTextField pass1 = pantalla.getPasswordField();
        JTextField pass2 = pantalla.getPasswordField_1();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje();
        JTextField codigo = pantalla.getTextField_codigo();
        JTextField usuario = pantalla.getTextField_usuario();
        
        usuario.setText("katham_28");
        boton_correo.doClick();
        codigo.setText("YUI40");
        boton_cod.doClick();
        pass1.setText("12345678");
        pass2.setText("diferente");
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Las contraseñas no coinciden"));
    }

    // 11️⃣ Contraseña corta
    @Test
    public void testContraseñaCorta_cambiar() throws InterruptedException {
    	JButton boton_correo = pantalla.getBoton_obtener_codigo();
    	JButton boton_cod = pantalla.getBoton_confirmar_codigo();
    	JButton boton = pantalla.getBoton_cambiar();
        JTextField pass1 = pantalla.getPasswordField();
        JTextField pass2 = pantalla.getPasswordField_1();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje();
        JTextField codigo = pantalla.getTextField_codigo();
        JTextField usuario = pantalla.getTextField_usuario();
        
        usuario.setText("katham_28");
        boton_correo.doClick();
        codigo.setText("YUI40");
        boton_cod.doClick();
        pass1.setText("12345");
        pass2.setText("12345");
        boton.doClick();
        Thread.sleep(300);


        assertTrue(lblMsg.getText().equals("Contraseña mínimo 8 caracteres"));
    }

    // 12️⃣ Contraseña correcta y cambio exitoso
    @Test
    public void testContraseñaCorrecta_cambiar() throws InterruptedException {
    	JButton boton_correo = pantalla.getBoton_obtener_codigo();
    	JButton boton_cod = pantalla.getBoton_confirmar_codigo();
    	JButton boton = pantalla.getBoton_cambiar();
        JTextField pass1 = pantalla.getPasswordField();
        JTextField pass2 = pantalla.getPasswordField_1();
        JLabel lblMsg = pantalla.getLblNewLabel_mensaje();
        JTextField codigo = pantalla.getTextField_codigo();
        JTextField usuario = pantalla.getTextField_usuario();
        
        usuario.setText("katham_28");
        boton_correo.doClick();
        codigo.setText("YUI40");
        boton_cod.doClick();
        pass1.setText("nuevaContra123");
        pass2.setText("nuevaContra123");
        boton.doClick();
        Thread.sleep(300);

        assertTrue(lblMsg.getText().equals("Contraseña actualizada exitosamente"));
    }

    // 13️⃣ Botón volver
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
