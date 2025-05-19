import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StrategySombrero implements Strategy_gestion_prendas {

	
	public String tabla="Sombrero";
	@Override
	public int agregar_prenda(Prenda prenda, Connection connect) {
	    String sql = "INSERT INTO "+ tabla + "(descripcion, name_archivo, name, puntaje) VALUES (?, ?, ?, ?)";
	    try {
	        PreparedStatement consulta = connect.prepareStatement(sql);

	        consulta.setString(1, prenda.getDescripcion());
	        consulta.setString(2, prenda.getName_archivo());
	        consulta.setString(3, prenda.getName());
	        consulta.setInt(4, prenda.getPuntaje());

	        int filasInsertadas = consulta.executeUpdate();
	        consulta.close();

	        System.out.println("Se insertaron " + filasInsertadas + " filas.");
	        return filasInsertadas;

	    } catch (SQLException e) {
	        System.out.println("ERROR insertando en"+ tabla );
	        e.printStackTrace();
	        return -1; // Indica error
	    }
	}


	@Override
	public int eliminar_prenda (Prenda name, Connection connect) {
	    String sql = "DELETE FROM  "+ tabla + " WHERE name = ?";
	    try {
	        PreparedStatement consulta = connect.prepareStatement(sql);
	        consulta.setString(1, name.getName());

	        int filasEliminadas = consulta.executeUpdate();
	        consulta.close();

	        System.out.println("Se eliminaron " + filasEliminadas + " filas.");
	        return filasEliminadas;

	    } catch (SQLException e) {
	        System.out.println("ERROR eliminando en " + tabla);
	        e.printStackTrace();
	        return -1; // Indica error
	    }
	}

	@Override
	public int modificar_prenda(Prenda prenda, Connection connect) {
	    String sql = "UPDATE "+ tabla + "  SET descripcion = ?, name_archivo = ?, puntaje = ? WHERE name = ?";
	    try {
	        PreparedStatement consulta = connect.prepareStatement(sql);

	        consulta.setString(1, prenda.getDescripcion());
	        consulta.setString(2, prenda.getName_archivo());
	        consulta.setInt(3, prenda.getPuntaje());
	        consulta.setString(4, prenda.getName()); //

	        int filasActualizadas = consulta.executeUpdate();
	        consulta.close();

	        System.out.println("Se actualizaron " + filasActualizadas + " filas.");
	        return filasActualizadas;

	    } catch (SQLException e) {
	        System.out.println("ERROR modificando en"+ tabla);
	        e.printStackTrace();
	        return -1; // Indica error
	    }
	}


	@Override
	public Prenda buscar_uno(Prenda prenda, Connection connect) {
	    String sql = "SELECT * FROM "+ tabla + "  WHERE name = ?";
	    
	    try (
	        PreparedStatement consulta = connect.prepareStatement(sql)
	    ) {
	        consulta.setString(1, prenda.getName());

	        try (ResultSet resultado = consulta.executeQuery()) {
	            if (resultado.next()) {
	                Prenda b = new Prenda();
	                b.setName_archivo(resultado.getString("name_archivo"));
	                b.setName(resultado.getString("name"));
	                b.setPuntaje(resultado.getInt("puntaje"));
	                b.setDescripcion(resultado.getString("descripcion"));

	                System.out.println(b);
	                System.out.println("Encontrado");
	                return b;
	            } else {
	                System.out.println("NO Encontrado");
	                return null;
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println("ERROR buscando en" + tabla);
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public Categoria buscar_todos(Connection connect) {
	    Categoria categ = new Categoria("Cuerpo", 0);
	    String sql = "SELECT * FROM "+ tabla + " ";

	    try (
	        PreparedStatement consulta = connect.prepareStatement(sql);
	        ResultSet resultado = consulta.executeQuery();
	    ) {
	        while (resultado.next()) {
	            Prenda b = new Prenda();
	            b.setName_archivo(resultado.getString("name_archivo"));
	            b.setName(resultado.getString("name"));
	            b.setPuntaje(resultado.getInt("puntaje"));
	            b.setDescripcion(resultado.getString("descripcion"));

	            categ.agregar(b);
	        }
	    } catch (SQLException e) {
	        System.out.println("ERROR buscando en"+ tabla);
	        e.printStackTrace();
	    }

	    categ.imprimir();
	    return categ;
	}

	

	public StrategySombrero() {
		// TODO Auto-generated constructor stub
	}

}
