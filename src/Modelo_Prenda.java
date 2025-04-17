import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class Modelo_Prenda {
	private static Modelo_Prenda instancia;
	private Connection connect=null;
	
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
	public void insertar_Prenda (Prenda prenda) {
		
	}
	
	public void eliminar_Prenda (Prenda prenda) {
		
	}
	
	public void modificar_Prenda (Prenda prenda) {
		
	}
	
	public Prenda buscar_Prenda (Prenda prenda) {
		
		
		return prenda;
	}
	
	public void cargar_todo() {
		
		
		
	}

}
