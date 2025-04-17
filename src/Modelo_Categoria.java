import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class Modelo_Categoria {
	private static Modelo_Categoria instancia;
	private Connection connect=null;
	
	//todas las prendas de todas las categorias
	private LinkedList <Categoria> categorias=new LinkedList ();
	
	private Modelo_Categoria () {
		try {
			connect=DriverManager.getConnection("jdbc:sqlite:BD_relacional.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static Modelo_Categoria getInstancia () {
		if (instancia==null) {
			instancia=new Modelo_Categoria();
		}
			return instancia;
			}
	
	
	//En lista

		
		public LinkedList<Categoria>  obtener_categorias () {
			return categorias;
		}

		public void añadir_Categoria_lista(Categoria categoria) {
			// TODO Auto-generated method stub
			categorias.add(categoria);
		}
		
		

}
