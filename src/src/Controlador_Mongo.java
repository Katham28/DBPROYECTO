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
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;

public class Controlador_Mongo {
	Modelo_Mongo mongo; 
	
	public Controlador_Mongo(String usuario) {
		// TODO Auto-generated constructor stub
		mongo=Modelo_Mongo.getInstancia(usuario);
	}
	
	 public int actualizar_prenda (Prenda prenda,String categoria,String usuario) {
		
		 
			 return mongo.actualizar_prenda(prenda, categoria, usuario);	
	    }

	 
	    public void guardarRopa(Prenda prenda, String tipo) {
	    	
	        mongo.guardarRopa(prenda,  tipo);	
	    }

	    public void logGiro() {
	        mongo.logGiro();
	    }

	    public long getSaveCount(Date startTime, Date endTime) {
	        return mongo.getSaveCount(startTime, endTime);
	    }


	    public List<Integer> leerClaves(String tipo) {
	    	return mongo.leerClaves(tipo);
	    }

	    public void guardarPersonaje(int ver, Prenda[] curPrenda,int puntaje) {
	       mongo.guardarPersonaje(ver, curPrenda, puntaje);
	    }



	    public Prenda[] leerPersonaje(int ver) {
	    	return mongo.leerPersonaje(ver);
	    }

	  


	    public int leerPuntaje(int ver) {
	        return mongo.leerPuntaje(ver);
	    }
	    
	    public LinkedList <Categoria> leerCateg(String categoria_nombre, LinkedList <Categoria> categ) {
	        return mongo.leerCateg(categoria_nombre, categ);
	    }
	    
	  

	    
	    public void renombrarBaseDeDatos(String nombreActualBD,  String nuevoNombreBD) {
	    	mongo.renombrarBaseDeDatos(nombreActualBD, nuevoNombreBD);
	    	}
}
