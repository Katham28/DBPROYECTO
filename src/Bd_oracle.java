import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Bd_oracle {
	private String lastTable;
    Connection conn;

    public void leer() throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM usuario");
            while (rset.next()) {
                //System.out.println(rset.getString(1));
                
                String name=rset.getString("user_name");
                System.out.println(name);
            }
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }
        
    }
    
    public int usuario(String usuario, String contra) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        int re=0;
        
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM usuario where user_name='"+usuario+"' and password='"+contra+"'");
            if (rset.next()) {
            	
            	System.out.println("ENCONTRADO");
            	String name=rset.getString("user_name");
                System.out.println(name);
                String pass=rset.getString("password");
                System.out.println(pass);
            	re=1;
            }
            else {
            	System.out.println("NO encontrado");
            	re=0;
            }
            
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }
        return re;   
    }
    
    public int verificar(String usuario, String contra) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        int re=0;
        
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM usuario where user_name='"+usuario+"'");
            if (rset.next()) {
            	
            	System.out.println("ENCONTRADO");
            	String name=rset.getString("user_name");
                System.out.println(name);
            	re=1;
            }
            else {
            	System.out.println("NO encontrado");
            	re=0;
            }
            
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }
        return re;   
    }
    
    public int conseguir_cve_cuenta(String usuario) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        int re=0;
        
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM usuario where user_name='"+usuario+"'");
            if (rset.next()) {
            	
            	System.out.println("ENCONTRADO");
            	String name=rset.getString("user_name");
            	int cve=rset.getInt("cve_usuario");
                System.out.println(name);
            	re=cve;
            }
            else {
            	System.out.println("NO encontrado");
            	re=0;
            }
            
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }
        return re;   
    }
    
    public void cuenta(String usuario, String contra) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        int re=0;
        
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("insert into usuario (user_name,password,cve_juego) values ('"+usuario+"','"+contra+"',1)");

        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }  
        
        int cve= conseguir_cve_cuenta(usuario);
        
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("insert into coleccion (cve_coleccion,cve_usuario) values (1,"+cve+")");

        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }  
        
        String uno=""+cve+"uno";
        String dos=""+cve+"dos";
        String tres=""+cve+"tres";
        
        try {
            stmt = conn.createStatement();
            stmt.executeQuery("insert into personaje (cve_personaje,nombre,cve_usuario) values (1,'"+uno+"',"+cve+")");
            stmt.executeQuery("insert into personaje (cve_personaje,nombre,cve_usuario) values (1,'"+dos+"',"+cve+")");
            stmt.executeQuery("insert into personaje (cve_personaje,nombre,cve_usuario) values (1,'"+tres+"',"+cve+")");

        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        } 
        
    }
    
    public void update_puntaje(String usuario,int pun,int nu) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        int cve= conseguir_cve_cuenta(usuario);
        
        String b="";
        if (nu==1) {
        String uno=""+cve+"uno";
        b=uno;
        }
        else if (nu==2) {
        String dos=""+cve+"dos";
        b=dos;
        }
        else if (nu==3) {
        String tres=""+cve+"tres";
        b=tres;
        }
        
        if (pun==0)
        	pun=1;
        
        
        String query = "UPDATE personaje SET PUNTAJE_TOTAL ="+pun+" WHERE cve_usuario ="+cve +"AND nombre ='"+b+"'";
        PreparedStatement pstmt = conn.prepareStatement(query);
        try  {
            System.out.println("Preparing to execute query...");
            System.out.println(""+pstmt);
            pstmt.executeUpdate();
            

        } catch (SQLException e) {
            e.printStackTrace();
           
        } finally {
          //  if (conn != null) conn.close();
        	System.out.println("Cambios guardados");
        }
        
       
         
    }
    
    public int saco_puntaje(String usuario,int pun,int nu) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        int cve= conseguir_cve_cuenta(usuario);
        
        String b="";
        if (nu==1) {
        String uno=""+cve+"uno";
        b=uno;
        }
        else if (nu==2) {
        String dos=""+cve+"dos";
        b=dos;
        }
        else if (nu==3) {
        String tres=""+cve+"tres";
        b=tres;
        }
        

        
       
        int punt=0;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("select PUNTAJE_TOTAL from personaje where nombre='"+b+"'");
            if (rset.next()) {
            	
            	punt=rset.getInt("PUNTAJE_TOTAL");
            	
            }
            else {
            	System.out.println("NO encontrado");
            }
            
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }
        
        if (pun==1)
        	pun=0;
       return punt;
         
    }
    
    public LinkedList <Categoria> items(String tabla, LinkedList <Categoria> categ, int pos) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM " + tabla);
            while (rset.next()) {
                String nombre=rset.getString("nombre");
                String descripcion=rset.getString("descripcion");
                
                String archivo=rset.getString("archivo");
                int clave = rset.getInt("CVE_" + tabla);
                
                
                System.out.println(""+nombre+" "+ descripcion +" "+ archivo);
            	
        		categ.get(pos).getAtuendos().add(new Prenda(clave, nombre,descripcion,archivo));
              
            }
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }
        return categ;
        
    }
    
    
    
    
    public LinkedList <Categoria> items_puntillo (String tabla, LinkedList <Categoria> categ, int pos) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;
        
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM " + tabla);
            while (rset.next()) {
                String nombre=rset.getString("nombre");
                String descripcion=rset.getString("descripcion");
                int puntaje=rset.getInt("puntaje");              
                String archivo=rset.getString("archivo");
                
                if (nombre.equals("Ninguno")) {
                puntaje=0;	
                }
                
                
                System.out.println(""+nombre+" "+ descripcion +" "+ archivo +" "+ puntaje);
            	
        		categ.get(pos).getAtuendos().add(new Prenda(nombre,descripcion,archivo,puntaje));
              
            }
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }
        return categ;
        
    }
    
    public LinkedList<Categoria> itemPorClave(String tabla, LinkedList<Categoria> categ, List<Integer> claves, int pos) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM " + tabla);
            while (rset.next()) {
                String nombre = rset.getString("nombre");
                String descripcion = rset.getString("descripcion");
                int puntaje = rset.getInt("puntaje");
                String archivo = rset.getString("archivo");
                int clave = rset.getInt("CVE_" + tabla);

                if (claves.contains(clave)) {
                    if (nombre.equals("Ninguno")) {
                        puntaje = 0;
                    }
                    System.out.println("unico encontrado\n");
                    System.out.println(nombre + " " + descripcion + " " + archivo + " " + puntaje);

                    categ.get(pos).getAtuendos().add(new Prenda(nombre, descripcion, archivo, puntaje, clave));
                }
            }
        } finally {
            if (rset != null) rset.close();
            if (stmt != null) stmt.close();
        }
        return categ;
    }
    
    public LinkedList <Categoria> items_gesto (String tabla, LinkedList <Categoria> categ, int pos,String colu) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;  
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT * FROM " + tabla);
            while (rset.next()) {
                String nombre=rset.getString(colu);
                String descripcion=rset.getString(colu);
                
                String archivo=rset.getString("archivo");
                int clave;
                if(tabla.equals("Bello_facila")) {
                	clave = rset.getInt("CVE_BELLO_FACIAL");
                }else {
                	clave = rset.getInt("CVE_" + tabla);
                }
                System.out.println(""+nombre+" "+ descripcion +" "+ archivo);
            	
        		categ.get(pos).getAtuendos().add(new Prenda(clave,nombre,descripcion,archivo));
            }
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }

       // categ.get(pos).getAtuendos().add(new ropa("Cuerpo1","C1"));
        return categ;
        
    }
    
    public void insertar_personaje (String usuario, LinkedList <Categoria> categ) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;  
        try {
            stmt = conn.createStatement();
            //rset = stmt.executeQuery("SELECT * FROM " + tabla);
            
            
            
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }


    }
    
    public void insertar_prenda (String usuario, Prenda ropaje) throws SQLException {
        Statement stmt = null;
        ResultSet rset = null;  
        try {
            stmt = conn.createStatement();
            //rset = stmt.executeQuery("SELECT * FROM " + tabla);
            
            
            
        } finally {
            if (rset != null) rset.close(); 
            if (stmt != null) stmt.close(); 
        }


    }
    
    //ruleta
    
    public Prenda ruleta() throws SQLException {
        String[] tables = {"CALCETAS", "CAPA", "LENTES", "CALZADO", "PANTALON", "PEINADO", "PIERCING", "SOMBRERO", "TATUAJE", "TOP", "VESTIDO"};
        Random random = new Random();
        Prenda selectedRopa = null;

        while (selectedRopa == null) {
            String table = tables[random.nextInt(tables.length)];
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM " + table + " WHERE nombre != 'Ninguno' ORDER BY DBMS_RANDOM.VALUE");

            if (rset.next()) {
                String nombre = rset.getString("nombre");
                String descripcion = rset.getString("descripcion");
                String archivo = rset.getString("archivo");
                int clave = rset.getInt("CVE_" + table);
                selectedRopa = new Prenda(clave, nombre, descripcion, archivo);
                lastTable = table;
            }

            rset.close();
            stmt.close();
        }

        return selectedRopa;
    }

    public String getLastTable() {
        return lastTable;
    }
    
    public Bd_oracle()  {
    	//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "CE", "12345678");
    	try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@200.13.89.10:1521/pdbcib.lci.ulsa.mx", "cib500_22", "jHu%500/22.");
			System.out.println("Conexion al LCI exitosa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orclpdb", "CE", "12345678");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
				e1.printStackTrace();
			}
			System.out.println("ERROR LCI. Conexion de respaldo establecida");
		}
    	
        if (conn == null) {
            System.out.println("No hay conexión");
        } else {
            System.out.println("Conectado");
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Conexión cerrada");
        }else
        	System.out.println("Conexión no se pudo cerrar");
    }
    

}