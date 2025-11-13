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
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import main.java.Pantalla_Mod_Eli_Admin;
import main.java.Prenda;
import main.java.Usuario;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class T_Pantalla_Mod_Eli_Admin {

	private static Pantalla_Mod_Eli_Admin pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Mod_Eli_Admin(1,1);
        frame = new JFrame("Demo Pantalla Mod_Eli_Admin");
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
            pantalla = new Pantalla_Mod_Eli_Admin(1,1);
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }

    @Test
    public void testningunoseleccionado_BUSCAR() throws InterruptedException {
        JButton boton = pantalla.getBoton_buscar();
    	JLabel lblResult =pantalla.getLblmensaje();
//    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();

    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Ingresa lo que hay que buscar"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void testno_Existe_BUSCAR() throws InterruptedException {
        JButton boton = pantalla.getBoton_buscar();
    	JLabel lblResult =pantalla.getLblmensaje();
//    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JTextField textField_4B = pantalla.getTextField_4B();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        textField_4B.setText("no_Existe");
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("No encontrado"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    
    @Test
    public void test_Existe_BUSCAR() throws InterruptedException {
        JButton boton = pantalla.getBoton_buscar();
    	JLabel lblResult =pantalla.getLblmensaje();
//    	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JTextField textField_4B = pantalla.getTextField_4B();
    	
        assertNotNull(boton);
        assertTrue(boton.isVisible() && boton.isEnabled());
        
        textField_4B.setText("Rojo");
    	
        boton.doClick();
    
        assertTrue(lblResult.getText().equals("Encontrado"));
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    
    @Test
    public void test_Vacios() throws InterruptedException {
        JButton boton_BUSCAR = pantalla.getBoton_buscar();
        JButton boton_Eliminar = pantalla.getBoton_ELI();
        JButton boton_mod= pantalla.getBoton_MOD();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JLabel lblmensaje2 =pantalla.getLblmensaje2();
    	
     	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JTextField textField_4B = pantalla.getTextField_4B();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	Prenda b= pantalla.getG();
    	
        assertNotNull(boton_BUSCAR);
        assertTrue(boton_BUSCAR.isVisible() && boton_BUSCAR.isEnabled());
        
        textField_4B.setText("Rojo");
    	
        boton_BUSCAR.doClick();
    
        assertTrue(lblResult.getText().equals("Encontrado"));
        
        textField.setText("");
        //textField_2.setText("");
        textField_1.setText("");
        textField_3.setText("");
        
        boton_mod.doClick();
        
        assertTrue(lblmensaje2.getText().equals("Se deben llenar todos los campos"));
        
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void test_Mayor_20_Caracteres_todos() throws InterruptedException {
        JButton boton_BUSCAR = pantalla.getBoton_buscar();
        JButton boton_Eliminar = pantalla.getBoton_ELI();
        JButton boton_mod= pantalla.getBoton_MOD();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JLabel lblmensaje2 =pantalla.getLblmensaje2();
    	
     	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JTextField textField_4B = pantalla.getTextField_4B();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	Prenda b= pantalla.getG();
    	
        assertNotNull(boton_BUSCAR);
        assertTrue(boton_BUSCAR.isVisible() && boton_BUSCAR.isEnabled());
        
        textField_4B.setText("Rojo");
    	
        boton_BUSCAR.doClick();
    
        if(lblResult.getText().equals("Encontrado")) {
        	   assertTrue(lblResult.getText().equals("Encontrado"));
               
               textField.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
               textField_2.setText("11111111111111111111111111111111111111111");
               textField_1.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
               textField_3.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
               
               boton_mod.doClick();
               Thread.sleep(500); // Espera a que se procese el evento
               
               assertTrue(lblmensaje2.getText().equals("Sólo 20 carácteres máximos permitidos"));
        }
     
        
        Thread.sleep(500); // tiempo para que se ejecute la acción
    }
    
    @Test
    public void test_puntaje_positivo() throws InterruptedException {
        JButton boton_BUSCAR = pantalla.getBoton_buscar();
        JButton boton_Eliminar = pantalla.getBoton_ELI();
        JButton boton_mod= pantalla.getBoton_MOD();
    	JLabel lblResult =pantalla.getLblmensaje();
    	JLabel lblmensaje2 =pantalla.getLblmensaje2();
    	
     	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JTextField textField_4B = pantalla.getTextField_4B();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	Prenda b= pantalla.getG();
    	
        assertNotNull(boton_BUSCAR);
        assertTrue(boton_BUSCAR.isVisible() && boton_BUSCAR.isEnabled());
        
        textField_4B.setText("Rojo");
    	
        boton_BUSCAR.doClick();
    
        assertTrue(lblResult.getText().equals("Encontrado"));
        textField_2.setText("-1");
        
        boton_mod.doClick();
        Thread.sleep(500); // Espera a que se procese el evento
        
        assertTrue(lblmensaje2.getText().equals("El puntaje debe ser un número positivo"));
        textField_2.setText("uno");
        
        boton_mod.doClick();
        Thread.sleep(500); // Espera a que se procese el evento
        
        assertTrue(lblmensaje2.getText().equals("El puntaje debe ser un número positivo"));      

    }
    
    @Test
    public void test_Modificar() throws InterruptedException {
        JButton boton_BUSCAR = pantalla.getBoton_buscar();
        JButton boton_mod= pantalla.getBoton_MOD();

    	JLabel lblResult =pantalla.getLblmensaje();
    	JLabel lblmensaje2 =pantalla.getLblmensaje2();
    	
     	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JTextField textField_4B = pantalla.getTextField_4B();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	Prenda b= pantalla.getG();
    	
        assertNotNull(boton_BUSCAR);
        assertTrue(boton_BUSCAR.isVisible() && boton_BUSCAR.isEnabled());
        
        textField_4B.setText("Rojo");
    	
        boton_BUSCAR.doClick();
    
        assertTrue(lblResult.getText().equals("Encontrado"));
        
        textField.setText("Rojo_mod");
        textField_2.setText("1");
        textField_1.setText("A_Rojo_mod");
        textField_3.setText("Rojito_mod");
        
        boton_mod.doClick();
        Thread.sleep(500); // Espera a que se procese el evento
        
        assertTrue(lblmensaje2.getText().equals("Prenda modificada correctamente"));

    }
    
    @Test
    public void Ztest_Eliminar() throws InterruptedException {
        JButton boton_BUSCAR = pantalla.getBoton_buscar();
        JButton boton_Eliminar = pantalla.getBoton_ELI();

    	JLabel lblResult =pantalla.getLblmensaje();
    	JLabel lblmensaje2 =pantalla.getLblmensaje2();
    	
     	JCheckBox chckbxNewCheckBox = pantalla.getChckbxNewCheckBox();
    	JTextField textField_4B = pantalla.getTextField_4B();
    	JTextField textField=pantalla.getTextField();//name
    	JTextField textField_2=pantalla.getTextField_2();//puntaje
    	JTextField textField_1=pantalla.getTextField_1();//name_Archivo
    	JTextField textField_3=pantalla.getTextField_3();//descripcion
    	Prenda b= pantalla.getG();
    	
        assertNotNull(boton_BUSCAR);
        assertTrue(boton_BUSCAR.isVisible() && boton_BUSCAR.isEnabled());
        
        textField_4B.setText("Rojo");
    	
        boton_BUSCAR.doClick();
    
        assertTrue(lblResult.getText().equals("Encontrado"));
        
        chckbxNewCheckBox.doClick();
        boton_Eliminar.doClick();
        Thread.sleep(500); // Espera a que se procese el evento
        
        assertTrue(lblmensaje2.getText().equals("Prenda eliminada correctamente"));

    }

}
