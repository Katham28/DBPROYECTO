import java.util.LinkedList;

import javax.swing.ImageIcon;

public class ropa {
	private String name;
	private String name_archivo;
	private String descripcion;
	private int puntaje;
	ImageIcon imagen;
	private int clave;
	

	public ropa(String name) {
		this.name = name;
	
	}
	
	
	public ropa(int clave, String name, String descripcion, String name_imagen) {
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
	
	public ropa(String name,String descripcion,String name_imagen,int puntaje) {
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
	
	public ropa(String name,String descripcion,String name_imagen,int puntaje, int clave) {
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
	
	public ropa(String name,String descripcion,String name_imagen) {
		this.name = name;
		try {
		ImageIcon unito= new ImageIcon(getClass().getResource(name_imagen+".png"));
		} catch (Exception e) { // Excepción general para cualquier otro error
			ImageIcon unito= new ImageIcon(getClass().getResource("error.png"));
		}
		this.descripcion=descripcion;	
		this.name_archivo=name_imagen;
	}
	
	public ropa(String name,String name_imagen) {
		this.name = name;
		try {
		ImageIcon unito= new ImageIcon(getClass().getResource(name_imagen+".png"));
		} catch (Exception e) { // Excepción general para cualquier otro error
		    ImageIcon unito= new ImageIcon(getClass().getResource("error.png"));
		}
		this.name_archivo=name_imagen;

	}
	
	//
	
	
	
	//
	
	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getName_archivo() {
		return name_archivo;
	}

	public void setName_archivo(String name_archivo) {
		this.name_archivo = name_archivo;
	}

	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return ""+ name;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
