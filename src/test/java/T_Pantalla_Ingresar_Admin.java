import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.Pantalla_Ingresar_Admin;
import main.java.Prenda;
import main.java.Usuario;

public class T_Pantalla_Ingresar_Admin {

	private static Pantalla_Ingresar_Admin pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Ingresar_Admin(1,1);
        frame = new JFrame("Demo Pantalla Agregar_Admin");
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
            pantalla = new Pantalla_Ingresar_Admin(1,1);
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }

    

    @Test
    public void test_Vacios() throws InterruptedException {
        JButton boton = pantalla.getBoton_ingresar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion

    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        

    	
        boton.doClick();
    

        
        assertTrue(lblResult.getText().equals("Se deben llenar todos los campos"));
        
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void test_Mayor_20_Caracteres_todos() throws InterruptedException {
        JButton boton = pantalla.getBoton_ingresar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        

               
               textField.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
               textField_2.setText("11111111111111111111111111111111111111111");
               textField_1.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
               textField_3.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
               
               boton.doClick();
               Thread.sleep(500); // Espera a que se procese el evento
               
               assertTrue(lblResult.getText().equals("Sólo 20 carácteres máximos permitidos"));
        
     
        
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void test_puntaje_positivo() throws InterruptedException {
        JButton boton = pantalla.getBoton_ingresar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        textField.setText("Rojo");
        textField_1.setText("Arojo");
        textField_3.setText("Rojito");
        
        
        
        textField_2.setText("-1");
        boton.doClick();
        Thread.sleep(500); // Espera a que se procese el evento
        assertTrue(lblResult.getText().equals("El puntaje debe ser un número positivo"));
     
        textField_2.setText("uno");
        boton.doClick();
        Thread.sleep(500); // Espera a que se procese el evento
        assertTrue(lblResult.getText().equals("El puntaje debe ser un número positivo"));      

    }
    
    @Test
    public void test_Correcto() throws InterruptedException {
        JButton boton = pantalla.getBoton_ingresar();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        textField.setText("Rojo");
        textField_2.setText("1");
        textField_1.setText("Arojo");
        textField_3.setText("Rojito");
        
        
        

        boton.doClick();
        Thread.sleep(500); // Espera a que se procese el evento
        if(lblResult.getText().equals("Prenda ingresada exitosamente"))
        assertTrue(lblResult.getText().equals("Prenda ingresada exitosamente"));
        else
        assertTrue(lblResult.getText().equals("Esa prenda ya existe"));


    }


}
