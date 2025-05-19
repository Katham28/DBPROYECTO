import javax.swing.ImageIcon;

public class Prenda {
	
	public Prenda(String name) {
		super();
		this.name = name;
	}

	private String name;
	private String name_archivo;
	private String descripcion;
	private int puntaje;
	ImageIcon imagen;
	private int clave;

	
	public Prenda() {
		
	}

	//CONSTRUCTORES
	public Prenda(int clave, String name, String descripcion, String name_imagen) {
	    this.name = name;
	    try {
	        ImageIcon unito = new ImageIcon(getClass().getResource(name_imagen + ".png"));
	        if (unito.getIconWidth() > 0) {
	            this.name_archivo = name_imagen;
	        } else {
	            this.name_archivo = "error";
	        }
	    } catch (Exception e) {
	        this.name_archivo = "error";
	    }
	    this.descripcion = descripcion;
	    this.clave = clave;
	}
	
	@Override
	public String toString() {
		return "Prenda [name=" + name + ", name_archivo=" + name_archivo + ", descripcion=" + descripcion + ", puntaje="
				+ puntaje + "]";
	}

	public Prenda(String name,String descripcion,String name_imagen,int puntaje) {
		this.name = name;
		try {
		ImageIcon unito= new ImageIcon(getClass().getResource(name_imagen+".png"));
		} catch (Exception e) { // Excepción general para cualquier otro error
		    ImageIcon unito= new ImageIcon(getClass().getResource("error.png"));
		}
		
		this.descripcion=descripcion;	
		this.name_archivo=name_imagen;
		this.puntaje=puntaje;
		}
	
	public Prenda(String name,String descripcion,String name_imagen,int puntaje, int clave) {
		this.name = name;
		try {
		ImageIcon unito= new ImageIcon(getClass().getResource(name_imagen+".png"));
		} catch (Exception e) { // Excepción general para cualquier otro error
		    ImageIcon unito= new ImageIcon(getClass().getResource("error.png"));
		}
		
		this.descripcion=descripcion;	
		this.name_archivo=name_imagen;
		this.puntaje=puntaje;
		this.clave = clave;
		}
	
	public Prenda (String name,String descripcion,String name_imagen) {
		this.name = name;
		try {
		ImageIcon unito= new ImageIcon(getClass().getResource(name_imagen+".png"));
		} catch (Exception e) { // Excepción general para cualquier otro error
			ImageIcon unito= new ImageIcon(getClass().getResource("error.png"));
		}
		this.descripcion=descripcion;	
		this.name_archivo=name_imagen;
	}
	
	public Prenda (String name,String name_imagen) {
		this.name = name;
		try {
		ImageIcon unito= new ImageIcon(getClass().getResource(name_imagen+".png"));
		} catch (Exception e) { // Excepción general para cualquier otro error
		    ImageIcon unito= new ImageIcon(getClass().getResource("error.png"));
		}
		this.name_archivo=name_imagen;

	}

	
	
	//GETTERS Y SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_archivo() {
		return name_archivo;
	}

	public void setName_archivo(String name_archivo) {
		this.name_archivo = name_archivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

}
