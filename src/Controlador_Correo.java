
public class Controlador_Correo {
	private Modelo_Correo modelo_correo= Modelo_Correo.getInstancia();
	
	public Controlador_Correo() {
		// TODO Auto-generated constructor stub
	}
	
	protected int verificar_Codigo (String codigo) {
		int re=0;
		
		re=modelo_correo.verificar_Codigo(codigo);
		
		return re;
	}
	
	protected int enviarCorreo(String destinatario) {
		int re=modelo_correo.enviarCorreo(destinatario);
		return re;
	}

}
