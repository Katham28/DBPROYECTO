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
	public int insertar_Prenda (Prenda prenda,String categ) {
		int re=modelo_prenda.insertar_Prenda(prenda, categ);
		return re;
	}
	
	public int eliminar_Prenda (Prenda prenda, String categ) {
		int re=modelo_prenda.eliminar_Prenda(prenda,categ);
		return re;
	}
	
	public int modificar_Prenda (Prenda prenda,String categ) {
		int re=modelo_prenda.modificar_Prenda(prenda,categ);
		return re;
	}
	
	public Prenda buscar_1_Prenda (Prenda prenda,String categ) {
		Prenda prendab=this.modelo_prenda.buscar_1_Prenda (prenda,categ);
		
		return prendab;
	}
	
	public Categoria buscar_categ (String categ) {
		Categoria categor= this.modelo_prenda.buscar_categ(categ);
		categor.setName(categ);
		System.out.println(categor);
		return categor;
	}
	
	public int sacar_canti(String Categ) {
		int re=0;
		
		re=this.modelo_prenda.sacar_canti(Categ);
		return re;
	}
	
	public void cargar_todo() {
		modelo_prenda.cargar_todo();
	}
	
	public Prenda obtenerPrendaPorCategoriaYFila(String categoria, int fila) {
		Prenda b=modelo_prenda.obtenerPrendaPorCategoriaYFila(categoria, fila);
		
		return b;
	}

}
