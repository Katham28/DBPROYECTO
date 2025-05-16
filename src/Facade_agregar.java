import java.sql.Connection;

public class Facade_agregar {
	StrategyContext strategycontext= new StrategyContext();
	
	public Facade_agregar() {
		// TODO Auto-generated constructor stub
	}
	
	public int agregar(Prenda prenda, String categ, Connection connect) {
		//busco la prenda, si existe retorno 0 para marcar que si existia, 
		//sino  1 para proseguir a la agregada
		
		int re=0;
		strategycontext.setStrategy_gestion_prendas(categ);
		
		Prenda b=strategycontext.strategy_gestion_prendas.buscar_uno(prenda, connect);
		
		if (b==null) {
			return re;
		}
		else {
			re=1;
			strategycontext.strategy_gestion_prendas.agregar_prenda(prenda, connect);
		}
		
		return re;
	}
	
	
	
	

}
