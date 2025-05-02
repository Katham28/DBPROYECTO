
public class Controlador_Usuario {
	private Modelo_Usuario modelo_usuario= Modelo_Usuario.getInstancia();
	
	public Controlador_Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	protected void insertarUsuario (Usuario usa) {
		modelo_usuario.insertaUsuario(usa);
	}
	
	protected Usuario buscarUsuario(Usuario usa) {
		usa=modelo_usuario.buscarUsuario(usa);
		return usa;
	}
	
	protected int verificarUsuario(String usa) {
		int re=modelo_usuario.verificarUsuario(usa);
		return re;
	}
	
	protected int cambiar_fondo (int cve_usuario,int fondo) {
		modelo_usuario.cambiar_fondo(cve_usuario, fondo);
		return fondo;
	}
	
	protected int cambiar_foto (int cve_usuario,int foto) {
		modelo_usuario.cambiar_foto(cve_usuario, foto);
		return foto;
	}
	
	protected int cambiar_password (String user,String new_password) {
		int re= modelo_usuario.cambiar_password(user, new_password);
		return re;
	}
	
	protected int actualizarUsuario (Usuario usa) {
		int re=modelo_usuario.actualizar_datos(usa);
		return re;
	}
	
	protected Usuario buscarUsuario_Correo(String usa) {
		
		Usuario b= modelo_usuario.buscarUsuario_Correo(usa);
		return b;
	}
	
	//protected void cerrar_Conexion () {
		//modelo_usuario.cerrarConexion();
	//}
	

}
