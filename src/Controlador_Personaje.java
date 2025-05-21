import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.ReplaceOptions;

public class Controlador_Personaje {
	private Modelo_Mongo modelo;
	public Controlador_Personaje(String usa) {
		// TODO Auto-generated constructor stub	
		 modelo.getInstance(usa);
	}
	
	   public void guardarRopa(Prenda prenda, String tipo) {
	       modelo.guardarRopa(prenda, tipo);
	    }

	    public void logGiro() {
	    	modelo.logGiro();
	    }

	    public long getSaveCount(Date startTime, Date endTime) {
	     
	    	return modelo.getSaveCount(startTime, endTime);
	    }


	    

	    public void guardarPersonaje(int ver, Prenda[] curPrenda,int puntaje) {
	        modelo.guardarPersonaje(ver, curPrenda, puntaje);
	    }


	    public Prenda[] leerPersonaje(int ver) {
	        Prenda[] prendas =modelo.leerPersonaje(ver);
	        return prendas;
	    }



	    public int leerPuntaje(int ver) {	        
	        
	        return modelo.leerPuntaje(ver);
	    }
	    
	    public LinkedList <Categoria> leerCateg(String categoria_nombre, LinkedList <Categoria> categ) {
	    	return modelo.leerCateg(categoria_nombre, categ);
	    }

	
	

}
