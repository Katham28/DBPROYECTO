import java.sql.Connection;

public interface Strategy_gestion_prendas {
	public int agregar_prenda(Prenda prenda,Connection connect);
	public int eliminar_prenda(Prenda prenda, Connection connect);
	public int modificar_prenda(Prenda prenda, Connection connect);
	public Prenda buscar_uno(Prenda prenda,Connection connect);
	public Categoria buscar_todos(Connection connect);
}
