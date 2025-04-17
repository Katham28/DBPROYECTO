import java.sql.Connection;
import java.util.LinkedList;

public class Controlador_Prenda {
private Modelo_Prenda modelo_prenda= Modelo_Prenda.getInstancia();
	
	public Controlador_Prenda() {
		// TODO Auto-generated constructor stub
	}
	
	//En lista
	public void añadir_Prenda_lista (Prenda prenda) {
		modelo_prenda.añadir_Prenda_lista(prenda);
	}
	
	public LinkedList<Prenda>  obtener_lista () {
		return modelo_prenda.obtener_lista();
	}
	
	
	//En bd
	public void insertar_Prenda (Prenda prenda) {
		modelo_prenda.insertar_Prenda(prenda);
	}
	
	public void eliminar_Prenda (Prenda prenda) {
		modelo_prenda.eliminar_Prenda(prenda);
	}
	
	public void modificar_Prenda (Prenda prenda) {
		modelo_prenda.modificar_Prenda(prenda);
	}
	
	public Prenda buscar_Prenda (Prenda prenda) {
		modelo_prenda.buscar_Prenda(prenda);
		return prenda;
	}
	
	public void cargar_todo() {
		modelo_prenda.cargar_todo();
	}

}
