import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StrategyCuerpo implements Strategy_gestion_prendas {
	
	public StrategyCuerpo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int agregar_prenda(Prenda prenda, Connection connect) {
		String sql= "INSERT INTO Cuerpo (descripcion,name_archivo,name,puntaje)"
				+ "VALUES (?,?,?,?)";
		
		try {
			PreparedStatement consulta= connect.prepareStatement(sql);
			
		 consulta.setString(1,prenda.getDescripcion());
		 consulta.setString(2,prenda.getName_archivo());
		 consulta.setString(3,prenda.getName());
		 consulta.setInt(4, prenda.getPuntaje());
		 
		 consulta.executeUpdate();
		 consulta.close();
		 
		} catch (SQLException e) {
			System.out.println("ERROR insertando en Cuerpo");
			e.printStackTrace();
		}
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
		int re=0;
		Prenda b=new Prenda ();
		String sql= "SELECT * FROM Cuerpo where   name= ? ";
		PreparedStatement consulta=null;
		ResultSet resultado=null;
		try {
		 consulta= connect.prepareStatement(sql);

		 consulta.setString(1, prenda.getName());
		 
		 resultado=consulta.executeQuery ();
		 
		 if (resultado.next()) {
			 
			 b.setName_archivo(resultado.getString("name_archivo"));
			 b.setName(resultado.getString("name"));
			 b.setPuntaje(resultado.getInt("puntaje"));
			 b.setDescripcion(resultado.getString("descripcion"));
			 
			System.out.println(b);
			 System.out.println("Encontrado");
			 re=1;
				
		 }
		 else {
			 re=0;
			 System.out.println("NO Encontrado");
			 
		 }
		 
		 consulta.executeUpdate();
		 consulta.close();
		 
		} catch (SQLException e) {
			System.out.println("ERROR insertando en Cuerpo");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

		if (re==1)
			return b;
		
		return null;
	}

	@Override
	public Categoria buscar_todos(Connection connect) {
		int re=0;
		Categoria categ= new Categoria ("Cuerpo",0);
		Prenda b=new Prenda ();
		String sql= "SELECT * FROM Cuerpo ";
		PreparedStatement consulta=null;
		ResultSet resultado=null;
		try {
		 consulta= connect.prepareStatement(sql);		 
		 resultado=consulta.executeQuery ();
		 
		 while (resultado.next()) {
			 b.setName_archivo(resultado.getString("name_archivo"));
			 b.setName(resultado.getString("name"));
			 b.setPuntaje(resultado.getInt("puntaje"));
			 b.setDescripcion(resultado.getString("descripcion"));
			 
			categ.agregar(b);	
		 }
		
		 consulta.executeUpdate();
		 consulta.close();
		 
		} catch (SQLException e) {
			System.out.println("ERROR insertando en Cuerpo");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

		System.out.println(categ);
		return categ;
	}

	


	
}
