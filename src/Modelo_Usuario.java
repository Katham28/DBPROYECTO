import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Modelo_Usuario {
	
	
	private static Modelo_Usuario instancia;
	private Connection connect=null;
	private LinkedList <Usuario> usuarios=new LinkedList ();
	
	private Modelo_Usuario () {
		try {
			connect=DriverManager.getConnection("jdbc:sqlite:BD_relacional.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static Modelo_Usuario getInstancia () {
		if (instancia==null) {
			instancia=new Modelo_Usuario();
		}
			return instancia;
			}
		
	
	public void insertaUsuario (Usuario p) {
		String sql= "INSERT INTO Usuario (user,password,correo,num_fondo,num_musica,num_foto_perfil)"
				+ "VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement consulta= connect.prepareStatement(sql);
			
		 consulta.setString(1,p.getUser());
		 consulta.setString(2,p.getPassword());
		 consulta.setString(3,p.getCorreo());
		 consulta.setInt(4, p.getFondo());
		 consulta.setInt(5, p.getMusica());
		 consulta.setInt(6, p.getFoto_perfil());
		 
		 consulta.executeUpdate();
		 consulta.close();
		 
		} catch (SQLException e) {
			System.out.println("ERROR insertando Usuario");
			e.printStackTrace();
		}
	}
	
	
	public int verificarUsuario(String user) {
		int re=0;
		String sql= "SELECT * FROM Usuario where user = ? ";
		PreparedStatement consulta=null;
		ResultSet resultado=null;
		try {
		 consulta= connect.prepareStatement(sql);
		 consulta.setString(1, user);
		 resultado=consulta.executeQuery ();
		 
		 if(resultado.next()) {
			 //Usuario b=new Usuario ();
			 //b.setUser(resultado.getString("user"));
			 //	b.setPassword(resultado.getString("password"));
			//	b.setCorreo(resultado.getString("correo"));
			//	b.setFondo(resultado.getInt("num_fondo"));
			//	b.setMusica(resultado.getInt("num_musica"));
			//	b.setCve_usuario(resultado.getInt("cve_usuario"));
			
			//System.out.println(b);
			 System.out.println("Encontrado");
			 re=1;
		 }
		 else {
			 re=0;
			 System.out.println("NO Encontrado");
			 
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR buscando Usuario");
			e.printStackTrace();
		}
		finally {
			 
			try {
				if (resultado != null) resultado.close();
				 if (consulta != null) consulta.close();
			} catch (SQLException e) {
				System.out.println("ERROR CERRANDO");
			}
		
	}
		
		return re;
		
	}
	
	public Usuario buscarUsuario  (Usuario p) {
		String sql= "SELECT * FROM Usuario where password = ? and user = ? ";
		PreparedStatement consulta=null;
		ResultSet resultado=null;
		
		try {
			
		consulta= connect.prepareStatement(sql);
		 consulta.setString(1, p.getPassword());
		 consulta.setString(2, p.getUser());
		 
		 resultado=consulta.executeQuery ();
		 
		 if(resultado.next()) {
			 Usuario b=new Usuario ();
				b.setUser(resultado.getString("user"));
				b.setPassword(resultado.getString("password"));
				b.setCorreo(resultado.getString("correo"));
				b.setFondo(resultado.getInt("num_fondo"));
				b.setMusica(resultado.getInt("num_musica"));
				b.setCve_usuario(resultado.getInt("cve_usuario"));
				b.setFoto_perfil(resultado.getInt("num_foto_perfil"));
			System.out.println(b);
			
			
			return b;
		 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR buscando Usuario");
			e.printStackTrace();
		}
		finally {
			 
				try {
					if (resultado != null) resultado.close();
					 if (consulta != null) consulta.close();
				} catch (SQLException e) {
					System.out.println("ERROR CERRANDO");
				}
			
		}
		
		return null;
	}
	
	public void cambiar_fondo (int cve_usuario,int fondo) {
		String sql= "UPDATE Usuario set num_fondo=? where cve_usuario=?";
		
		try {
			PreparedStatement consulta= connect.prepareStatement(sql);
			
		 consulta.setInt(1,fondo);
		 consulta.setInt(2,cve_usuario);

		 
		 consulta.executeUpdate();
		 consulta.close();
		 
		} catch (SQLException e) {
			System.out.println("ERROR actualizando fondo");
			e.printStackTrace();
		}
	}
	
	public void cambiar_foto (int cve_usuario,int num_foto_perfil) {
		String sql= "UPDATE Usuario set num_foto_perfil=? where cve_usuario=?";
		
		try {
			PreparedStatement consulta= connect.prepareStatement(sql);
			
		 consulta.setInt(1,num_foto_perfil);
		 consulta.setInt(2,cve_usuario);

		 
		 consulta.executeUpdate();
		 consulta.close();
		 
		} catch (SQLException e) {
			System.out.println("ERROR actualizando foto");
			e.printStackTrace();
		}
	}
	
	public int actualizar_datos (Usuario usa) {
		int re=0;
		String sql= "UPDATE Usuario set correo=?,password=?,user=? where cve_usuario=?";
		
		try {
			PreparedStatement consulta= connect.prepareStatement(sql);
			
		 consulta.setString(1,usa.getCorreo());
		 consulta.setString(2,usa.getPassword());
		 consulta.setString(3,usa.getUser());
		 consulta.setInt(4,usa.getCve_usuario());

		 
		 consulta.executeUpdate();
		 consulta.close();
		 re=0;
		 
		} catch (SQLException e) {
			System.out.println("ERROR actualizando");
			re=1;
			
		}
		
		return re;
		
	}
	

}
