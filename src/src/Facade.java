
public class Facade {
	Facade_agregar facade_agregar;
	Facade_modificar facade_modificar;
	Facade_eliminar facade_eliminar;
	Facade_Buscar facade_buscar;
	
	
	public Facade() {
		this.facade_agregar=new Facade_agregar();
		this.facade_modificar=new Facade_modificar();
		this.facade_eliminar= new Facade_eliminar();
		this.facade_buscar=new Facade_Buscar();
		// TODO Auto-generated constructor stub
	}
	
	public int agregar_prenda(Prenda prenda, String categ) {
		int re=0;
		
		
		return re;
				
	}
	
	public int eliminar_prenda(Prenda prenda, String categ) {
		int re=0;
		
		
		return re;
	}
	
	public int modificar_prenda(Prenda prenda, String categ) {
		int re=0;
		
		
		return re;
	}
	
	public Prenda buscar_uno(Prenda prenda, String categ) {
		Prenda prend= null;
		int re=0;
		
		
		return prend;
	}

}
