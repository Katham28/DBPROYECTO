import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Categoria {

	private String name;
	private int num_ropa;
	private JLabel jla;
	private LinkedList <Prenda> atuendos=new LinkedList();
	
	public Categoria(String name,int num_Ropa) {
		super();
		this.name = name;
		
	}
	
	
	public Prenda obtener_uno(int i) {
		return atuendos.get(i);
	}
	public int obtener_Cant() {
		return atuendos.size();
	}
	
	public void agregar (Prenda v) {
		atuendos.add(v);		
	}
	
	//

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<Prenda> getAtuendos() {
		return atuendos;
	}
	public void setAtuendos(LinkedList<Prenda> atuendos) {
		this.atuendos = atuendos;
	}	
	
	public void imprimir () {
		
		for (Prenda elemento : atuendos) {
	        System.out.println(elemento);
	    }
		
	}
	

}
