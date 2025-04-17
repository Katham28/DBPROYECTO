import java.awt.Color;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;


public class Imagen {
	int b=10;
	ImageIcon [] imag = new ImageIcon [b];
	

	public ImageIcon getUno(int num) {
		ImageIcon unito= new ImageIcon(imag [num].getImage().getScaledInstance(200, 230, 400));
		return unito;
		
	}
	
	public ImageIcon getUnotam(int num,int i,int j,int k) {
		ImageIcon unito;
		try {
		unito= new ImageIcon(imag [num].getImage().getScaledInstance(i, j, k));
		} catch (Exception e) { // Excepción general para cualquier otro error
			 unito= new ImageIcon(getClass().getResource("error.png"));
		}
		return unito;
	}
	
	
	public ImageIcon getUnota(String name,int j,int k) {
		ImageIcon uno;
		ImageIcon unito;
		try {
			uno=new ImageIcon(getClass().getResource(""+name+".png"));
			unito= new ImageIcon(uno.getImage().getScaledInstance(300, 300, 300));
		} catch (Exception e) { // Excepción general para cualquier otro error
			 unito= new ImageIcon(getClass().getResource("error.png"));
		}
		
		return  unito;
	}
	
	public ImageIcon getfondo (String name) {
		ImageIcon uno=new ImageIcon(getClass().getResource(""+name+".jpg"));
		return  uno;
	}
	
	public ImageIcon getperfil(String name,int j,int k) {
		ImageIcon uno;
		ImageIcon unito;
		try {
			uno=new ImageIcon(getClass().getResource(""+name+".jpg"));
			unito= new ImageIcon(uno.getImage().getScaledInstance(300, 300, 300));
		} catch (Exception e) { // Excepción general para cualquier otro error
			 unito= new ImageIcon(getClass().getResource("error.png"));
		}
		
		return  unito;
	}


	public Imagen() {
		super();
	}


	public Imagen(int b) {
		super();
		this.b = b;
		for (int i=1;i<=4;i++) {
			imag[i]= new ImageIcon(getClass().getResource(""+(i)+".png"));
		}
	}



}