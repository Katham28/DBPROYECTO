import java.sql.Connection;

public class StrategyTatuaje implements Strategy_gestion_prendas{



	@Override
	public int agregar_prenda(Prenda prenda, Connection connect) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar_prenda(Prenda prenda, Connection connect) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modificar_prenda(Prenda prenda, Connection connect) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Prenda buscar_uno(Prenda prenda, Connection connect) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria buscar_todos(Connection connect) {
		// TODO Auto-generated method stub
		return null;
	}

	public StrategyTatuaje() {
		// TODO Auto-generated constructor stub
	}

}
