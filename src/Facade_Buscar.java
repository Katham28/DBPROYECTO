import java.sql.Connection;
import java.util.LinkedList;

public class Facade_Buscar {
	StrategyContext strategycontext= new StrategyContext();
	public Facade_Buscar() {
		// TODO Auto-generated constructor stub
	}
	
	public Prenda buscar_Una_Prenda(Prenda prenda, String categ, Connection connect) {		
		strategycontext.setStrategy_gestion_prendas(categ);
		
		Prenda b=strategycontext.strategy_gestion_prendas.buscar_uno(prenda, connect);
		
		return b;
	}
	
	public Categoria buscar_1_categ(String categ, Connection connect) {		
		strategycontext.setStrategy_gestion_prendas(categ);
		Categoria categor= strategycontext.getStrategy_gestion_prendas().buscar_todos(connect);
		return categor;
	}
	
	
	
	public  LinkedList<Categoria> buscar_todos_Categ (Connection connect){
		LinkedList <Categoria> guardarropa= new LinkedList();
		String[] categ = new String[15];
		categ[0]="Cuerpo";
		categ[1]="Ojos";
		categ[2]="Cejas";
		categ[3]="Boca";
		categ[4]="Vello";
		categ[5]="Lentes";
		categ[6]="Peinado";
		categ[7]="Tatuaje";
		categ[8]="Calcetas";
		categ[9]="Top";
		categ[10]="Pantalon";
		categ[11]="Sombrero";
		categ[12]="Calzado";
		categ[13]="Piercing";
		categ[14]="Capa";
		
		
		for (int i=0;i<15;i++) {
			strategycontext.setStrategy_gestion_prendas(categ[i]);
			guardarropa.add(strategycontext.strategy_gestion_prendas.buscar_todos( connect));
		}
		
		return guardarropa;
		
	}

}
