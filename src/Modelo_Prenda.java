import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	
    public void cargar_categ(String categ) {
		
		StrategyCuerpo st= new StrategyCuerpo ();
		
	}

}
