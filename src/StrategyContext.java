
public class StrategyContext {
	Strategy_gestion_prendas strategy_gestion_prendas;
	public StrategyContext() {
		this.strategy_gestion_prendas = new StrategyCuerpo ();
	}
	public Strategy_gestion_prendas getStrategy_gestion_prendas() {
		return strategy_gestion_prendas;
	}
	public void setStrategy_gestion_prendas(String name) {
		if (name.equals("Cuerpo")) {
			this.strategy_gestion_prendas = new StrategyCuerpo ();
		}else if (name.equals("Ojos")) {
			this.strategy_gestion_prendas = new StrategyOjos ();
		 }else if (name.equals("Cejas")) {
			 this.strategy_gestion_prendas = new StrategyCejas ();
		 }else if (name.equals("Boca")) {
			 this.strategy_gestion_prendas = new StrategyBoca ();
		}  else if (name.equals("Vello")) {
			this.strategy_gestion_prendas = new StrategyVello ();
		}	else if (name.equals("Tatuaje")) {
			this.strategy_gestion_prendas = new StrategyTatuaje ();
		} else if (name.equals("Piercing")) {
			this.strategy_gestion_prendas = new StrategyPiercing ();
		} else if (name.equals("Capa")) {
			this.strategy_gestion_prendas = new StrategyCapa();
		}else if (name.equals("Peinado")) {
			this.strategy_gestion_prendas = new StrategyPeinado ();
		}else if (name.equals("Pantalon")) {
			this.strategy_gestion_prendas = new StrategyPantalon ();
		}else if (name.equals("Sombrero")) {
			this.strategy_gestion_prendas = new StrategySombrero ();
		}else if (name.equals("Lentes")) {
			this.strategy_gestion_prendas = new StrategyLentes ();
		}
		else if (name.equals("Calcetas")) {
			this.strategy_gestion_prendas = new StrategyCalcetas ();
		}else if (name.equals("Top")) {
			this.strategy_gestion_prendas = new StrategyTop ();
		} else //if (name.equals("Calzado"))
		{
			this.strategy_gestion_prendas = new StrategyCalzado ();
		}	
	}
	
	

}
