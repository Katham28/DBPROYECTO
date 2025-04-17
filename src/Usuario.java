
public class Usuario {
	
	private String user;
	private String password;
	private String correo;
	private int fondo;
	private int musica;
	private int cve_usuario;
	private int foto_perfil;

	public Usuario(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Usuario [user=" + user + ", password=" + password + ", correo=" + correo + ", fondo=" + fondo
				+ ", musica=" + musica + ", cve_usuario=" + cve_usuario + ", foto_perfil=" + foto_perfil + "]";
	}

	public int getCve_usuario() {
		return cve_usuario;
	}

	public void setCve_usuario(int cve_usuario) {
		this.cve_usuario = cve_usuario;
	}

	public Usuario() {
		
	}
	
	public Usuario(String user, String password, String correo) {
		super();
		this.user = user;
		this.password = password;
		this.correo = correo;
		this.fondo=1;
		this.musica=1;
	}
	
	public Usuario(String user, String password, String correo,int fondo,int musica,int foto) {
		super();
		this.user = user;
		this.password = password;
		this.correo = correo;
		this.fondo=fondo;
		this.musica=musica;
		this.foto_perfil=foto;
	}

	public int getFoto_perfil() {
		return foto_perfil;
	}


	public void setFoto_perfil(int foto_perfil) {
		this.foto_perfil = foto_perfil;
	}


	public int getFondo() {
		return fondo;
	}

	public void setFondo(int fondo) {
		this.fondo = fondo;
	}

	public int getMusica() {
		return musica;
	}

	public void setMusica(int musica) {
		this.musica = musica;
	}

	//Getters y setters
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
