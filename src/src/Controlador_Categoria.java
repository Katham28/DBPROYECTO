import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class Controlador_Categoria {
	private Modelo_Categoria modelo_categoria= Modelo_Categoria.getInstancia();
	
	public Controlador_Categoria() {
		// TODO Auto-generated constructor stub
	}	
	
	public void añadir_Categoria_lista (Categoria categoria) {
		modelo_categoria.añadir_Categoria_lista(categoria);
	}
	
	public LinkedList<Categoria>  obtener_categorias () {
		return modelo_categoria.obtener_categorias();
	}
	

}
