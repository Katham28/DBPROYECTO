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

import main.java.Pantalla_Gatcha;
import main.java.Usuario;

public class T_Pantalla_Gatcha {

    private static Pantalla_Gatcha pantalla;
    private static JFrame frame;

    @BeforeClass
    public static void setUpOnce() {
        // Crear la pantalla y mostrarla una vez
        pantalla = new Pantalla_Gatcha( new Usuario("usa","12345678","usa@gmail.com",1,1,1));
        frame = new JFrame("Demo Pantalla Gatcha");
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
            pantalla = new Pantalla_Gatcha( new Usuario("usa","12345678","usa@gmail.com",1,1,1));
            frame.add(pantalla);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
            
            
        });
        Thread.sleep(500); // espera breve para que la UI se refresque
    }
    
    @Test
    public void testCheckSaveLimits_tiros_Restantes() throws Exception {
        // mock devuelve 0 (por defecto)
        // llamamos al método privado checkSaveLimits() usando reflexión
        JButton boton = pantalla.getBoton_girar();
        Usuario usuario = pantalla.getUsa();
        
        JLabel lblMsg = pantalla.getLblSavesRemaining();
        JLabel lblMsg2= pantalla.getLblTipoNombre();
        JLabel lblMsg3= pantalla.getLblRepeatInfo();
        JLabel lblMsg4= pantalla.getLblNewLabel_2();
        
      //  pantalla.setTest(2);

        // el label debe mostrar 10 - 0
        assertTrue(lblMsg.getText().contains("TIROS RESTANTES"));
        assertTrue(lblMsg.getText().contains(""+pantalla.getIntentos()));
        // boton girar habilitado
       if(pantalla.getIntentos()!=0)
        assertTrue(boton.isEnabled());
       else
    	   assertTrue(!boton.isEnabled());
    	   
    }
    
    
    @Test
    public void testCheckSaveLimits_tirando() throws Exception {
        // mock devuelve 0 (por defecto)
        // llamamos al método privado checkSaveLimits() usando reflexión
        JButton boton = pantalla.getBoton_girar();
        Usuario usuario = pantalla.getUsa();
        
        JLabel lblMsg = pantalla.getLblSavesRemaining();
        JLabel lblMsg2= pantalla.getLblTipoNombre();
        JLabel lblMsg3= pantalla.getLblRepeatInfo();
        JLabel lblMsg4= pantalla.getLblNewLabel_2();
        
      
        pantalla.setTest(2);

        boton.doClick();

      
        assertTrue(lblMsg.getText().contains("TIROS RESTANTES"));
        assertTrue(lblMsg.getText().contains(""+10));
        
        
        assertTrue(lblMsg2.getText().contains("Tipo:"));
        assertTrue(lblMsg2.getText().contains("Nombre:"));
        
    }
    
    @Test
    public void testCheckSaveLimits_tiros_Restantes_igual_0() throws Exception {
        // mock devuelve 0 (por defecto)
        // llamamos al método privado checkSaveLimits() usando reflexión
        JButton boton = pantalla.getBoton_girar();
        Usuario usuario = pantalla.getUsa();
        
        JLabel lblMsg = pantalla.getLblSavesRemaining();
        JLabel lblMsg2= pantalla.getLblTipoNombre();
        JLabel lblMsg3= pantalla.getLblRepeatInfo();
        JLabel lblMsg4= pantalla.getLblNewLabel_2();
        JLabel lblMsg5= pantalla.getLblNextSave();
        
        pantalla.setTest(1);
        
        assertTrue(lblMsg.getText().contains("TIROS RESTANTES"));
       assertTrue(lblMsg.getText().contains("0"));
       assertTrue(lblMsg5.getText().contains("REGRESA")); 
       assertTrue(!boton.isEnabled());
    }
    
}
