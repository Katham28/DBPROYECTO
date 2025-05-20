import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Modelo_Prenda {
	private static Modelo_Prenda instancia;
	private Connection connect=null;
	private Facade fac= new Facade ();
	//todas las prendas de una categoria
	private LinkedList <Prenda> prendas=new LinkedList ();
	
	private Modelo_Prenda () {
		try {
			connect=DriverManager.getConnection("jdbc:sqlite:BD_relacional.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static Modelo_Prenda getInstancia () {
		if (instancia==null) {
			instancia=new Modelo_Prenda();
		}
			return instancia;
			}
	
	//En lista
	public void añadir_Prenda_lista (Prenda prenda) {
		prendas.add(prenda);
	}
	
	public LinkedList<Prenda>  obtener_lista () {
		return prendas;
	}
	
	
	//En bd
	public int insertar_Prenda (Prenda prenda, String categ) {
		int re=fac.facade_agregar.agregar(prenda, categ, connect);
		return re;
	}
	
	public int  eliminar_Prenda (Prenda prenda,String categ) {
		int re=fac.facade_eliminar.eliminar(prenda, categ, connect);
		return re;
	}
	
	public int modificar_Prenda (Prenda prenda, String categ) {
		int re=fac.facade_modificar.modficar(prenda, categ, connect);
		return re;
	
	}
	
	public Prenda buscar_1_Prenda (Prenda prenda,String categ) {
		Prenda prendab=fac.facade_buscar.buscar_Una_Prenda(prenda, categ, connect);
		return prendab;
	}
	
	public Categoria buscar_categ (String categ) {
		Categoria categor=fac.facade_buscar.buscar_1_categ(categ,connect);
		return categor;
	}
	
	public void cargar_todo() {
		
		
		
	}
	
	public int sacar_canti(String categ) {
		int cantidad=0;
		String sql = "SELECT COUNT(*) FROM " + categ;
	    try {
	        Statement consulta = connect.createStatement();
	        ResultSet resultado = consulta.executeQuery(sql);

	        if (resultado.next()) {
	            cantidad = resultado.getInt(1);
	            resultado.close();
	            consulta.close();

	            System.out.println("La tabla " + categ  + " tiene " + cantidad + " filas.");
	            return cantidad;
	        } else {
	            resultado.close();
	            consulta.close();
	            return 0;
	        }

	    } catch (SQLException e) {
	        System.out.println("ERROR contando filas en la tabla: " + categ);
	        e.printStackTrace();
	        return -1; // Indica error
	    }
		
	}
	
	public Prenda obtenerPrendaPorCategoriaYFila(String categoria, int fila) {
	    String sql = "SELECT * FROM " + categoria + " LIMIT 1 OFFSET ?";

	    try {
	        PreparedStatement consulta = connect.prepareStatement(sql);
	        consulta.setInt(1, fila); // Ej: fila = 0 para la primera fila


	        ResultSet rs = consulta.executeQuery();

	        if (rs.next()) {
	            Prenda prenda = new Prenda();
	            prenda.setName(rs.getString("name"));
	            prenda.setDescripcion(rs.getString("descripcion"));
	            prenda.setName_archivo(rs.getString("name_archivo"));
	            prenda.setPuntaje(rs.getInt("puntaje"));
	            
	            
	            rs.close();
	            consulta.close();

	            return prenda;
	        } else {
	            rs.close();
	            consulta.close();
	            return null; // no hay prenda en esa fila y categoría
	        }

	    } catch (SQLException e) {
	        System.out.println("ERROR obteniendo prenda por categoría y fila");
	        e.printStackTrace();
	        return null;
	    }
	}

	
    public void cargar_categ(String categ) {
		
		StrategyCuerpo st= new StrategyCuerpo ();
		
	}

}
