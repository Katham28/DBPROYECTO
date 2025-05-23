import java.util.LinkedList;

public class Sujeto {
	private LinkedList<Observador> observadores;
	
	//Constructor
	public Sujeto() {
		super();
		this.observadores = new LinkedList <Observador>();
	}
	
	//Metodos del patron
	
	public void anadir_llenar_todos () { //dispositivo que quiere imprimir
		
		Controlador_Usuario b= new Controlador_Usuario();
		this.observadores=b.buscarTodosUsuarios();
	}
	
	
	
	 public void actualizar_todos(Prenda prenda, String clase) { //notificar a los dispositivos que quieren imprimir el estado de la impresora
		if (this.observadores.isEmpty()) {
			System.out.println("\t**No hay ningun observador");
		}
		else  if(clase.equals("Cuerpo") ||
				 clase.equals("Ojos") ||
				 clase.equals("Cejas") ||
				 clase.equals("Boca") ||
				 clase.equals("Peinado") ){
			System.out.println("\t**Ese tipo de categorias no se obtienen en gatcha ");
		}
		else {
			for (Observador i:observadores) {
				int re=i.actualizar(prenda,  clase);
				
				if (re==1) 
				System.out.println("Se notifico a" +i);
			}	
		}
		
	}
	

	public LinkedList<Observador> getObservadores() {
		return observadores;
	}
	
	

}
