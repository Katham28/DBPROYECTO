import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.MongoNamespace;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.UpdateResult;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Modelo_Mongo {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private static Modelo_Mongo instancia;
    public Modelo_Mongo(String usuario) {
        String uri = "mongodb+srv://Katham:Katia280704@cluster0.crmou.mongodb.net/\r\n"+ "";
        
        mongoClient = MongoClients.create(uri);
        String dbName = usuario;
        database = mongoClient.getDatabase(dbName);
        System.out.println("Connected to database: " + dbName);
    }

	public static Modelo_Mongo getInstancia (String usuario) {
		if (instancia==null) {
			instancia=new Modelo_Mongo(usuario);
		}
		
			return instancia;
		}
	
	public void set_Mongodatabase(String usuario) {
		  database = mongoClient.getDatabase(usuario);
	}
	
	
    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Sesion Mongo Cerrada");
        } else {
            System.out.println("ERROR: no hay sesion por cerrar.");
        }
    }
    

    public void guardarRopa(Prenda prenda, String tipo) {
        MongoCollection<Document> collection = database.getCollection(tipo);

        Document existingDoc = collection.find(eq("name", prenda.getName())).first();
        if (existingDoc != null) {
            System.out.println("ERROR: Duplicate entry. Ropa with name " + prenda.getName() + " already exists.");
            return;
        }

        Document doc = new Document("name_archivo", prenda.getName_archivo())
                        .append("name", prenda.getName())
                        .append("puntaje", prenda.getPuntaje())
                        .append("descripcion", prenda.getDescripcion());
        collection.insertOne(doc);
        System.out.println("Prenda ha sido guardada a coleccion: " + tipo);
    }

    public void logGiro() {
        MongoCollection<Document> collection = database.getCollection("LogGiros");
        Instant now = Instant.now();
        Document log = new Document("timestamp", Date.from(now));
        collection.insertOne(log);
        System.out.println("Giro logged at: " + now);
    }

    public long getSaveCount(Date startTime, Date endTime) {
        MongoCollection<Document> collection = database.getCollection("LogGiros");
        return collection.countDocuments(and(
            gte("timestamp", startTime),
            lt("timestamp", endTime)
        ));
    }

    public MongoCollection<Document> getCollection(String tipo) {
        return database.getCollection(tipo);
    }

    public List<Integer> leerClaves(String tipo) {
        MongoCollection<Document> collection = database.getCollection(tipo.toUpperCase());
        List<Integer> claves = new ArrayList<>();

        for (Document doc : collection.find()) {
            claves.add(doc.getInteger("clave"));
        }

        // Print the claves before returning
        System.out.println("Claves: " + claves);

        return claves;
    }

    public void guardarPersonaje(int ver, Prenda[] curPrenda,int puntaje) {
        MongoCollection<Document> collection = database.getCollection("personajes");

        Document doc = new Document("ver", ver)
        		.append("puntaje_total",puntaje )
                .append("Cuerpo", prendaToDocument(curPrenda[0]))
                .append("Ojos", prendaToDocument(curPrenda[1]))
                .append("Cejas", prendaToDocument(curPrenda[2]))
                .append("Boca", prendaToDocument(curPrenda[3]))
                .append("Vello", prendaToDocument(curPrenda[4]))
                .append("Lentes", prendaToDocument(curPrenda[5]))
                .append("Peinado", prendaToDocument(curPrenda[6]))
                .append("Tatuaje", prendaToDocument(curPrenda[7]))
                .append("Calcetas", prendaToDocument(curPrenda[8]))
                .append("Top", prendaToDocument(curPrenda[9]))
                .append("Pantalon", prendaToDocument(curPrenda[10]))
                .append("Sombrero", prendaToDocument(curPrenda[11]))
                .append("Calzado", prendaToDocument(curPrenda[12]))
                .append("Piercing", prendaToDocument(curPrenda[13]))
                .append("Capa", prendaToDocument(curPrenda[14]));

        collection.replaceOne(eq("ver", ver), doc, new ReplaceOptions().upsert(true));
        System.out.println("Personaje ha sido guardado con ver: " + ver);
    }

    private Document prendaToDocument(Prenda prenda) {
        return new Document("puntaje", prenda.getPuntaje())
                .append("name", prenda.getName())
                .append("descripcion", prenda.getDescripcion())
                .append("name_archivo", prenda.getName_archivo());
        // Agrega más campos si es necesario
    }


    public Prenda[] leerPersonaje(int ver) {
    	System.out.println("buscando:"+ver);
    	 MongoCollection<Document> collection = database.getCollection("personajes");
    	 Document doc = collection.find(eq("ver", ver)).first();

        if (doc == null) {
            System.out.println("No se encontró un personaje con ver: " + ver);
            
            
            return null;
        }

        Prenda[] prendas = new Prenda[15];
        prendas[0] = documentToPrenda((Document) doc.get("Cuerpo"));
        prendas[1] = documentToPrenda((Document) doc.get("Ojos"));
        prendas[2] = documentToPrenda((Document) doc.get("Cejas"));
        prendas[3] = documentToPrenda((Document) doc.get("Boca"));
        prendas[4] = documentToPrenda((Document) doc.get("Vello"));
        prendas[5] = documentToPrenda((Document) doc.get("Lentes"));
        prendas[6] = documentToPrenda((Document) doc.get("Peinado"));
        prendas[7] = documentToPrenda((Document) doc.get("Tatuaje"));
        prendas[8] = documentToPrenda((Document) doc.get("Calcetas"));
        prendas[9] = documentToPrenda((Document) doc.get("Top"));
        prendas[10] = documentToPrenda((Document) doc.get("Pantalon"));
        prendas[11] = documentToPrenda((Document) doc.get("Sombrero"));
        prendas[12] = documentToPrenda((Document) doc.get("Calzado"));
        prendas[13] = documentToPrenda((Document) doc.get("Piercing"));
        prendas[14] = documentToPrenda((Document) doc.get("Capa"));

        int puntaje = doc.getInteger("puntaje_total");
        System.out.println("Personaje leído con puntaje total: " + puntaje);

        return prendas;
    }

    private Prenda documentToPrenda(Document doc) {
        if (doc == null) return null;

        Prenda prenda = new Prenda();
        prenda.setPuntaje(doc.getInteger("puntaje", 0));
        prenda.setName(doc.getString("name"));
        prenda.setDescripcion(doc.getString("descripcion"));
        prenda.setName_archivo(doc.getString("name_archivo"));
        return prenda;
    }


    public int leerPuntaje(int ver) {
        MongoCollection<Document> collection = database.getCollection("personajes");

        // Find the document with the specified ver
        Document doc = collection.find(eq("ver", ver)).first();
        if (doc != null) {
            // Retrieve the puntaje
            return doc.getInteger("puntaje", 0);
        } else {
            System.out.println("No se encontró el personaje con ver: " + ver);
            return 0;
        }
    }
    
    public LinkedList <Categoria> leerCateg(String categoria_nombre, LinkedList <Categoria> categ) {
        Categoria cat= new Categoria (categoria_nombre,0);
    	MongoCollection<Document> collection = database.getCollection(categoria_nombre);
        
        for (Document doc : collection.find()) {
            String name_archivo = doc.getString("name_archivo");
            String name = doc.getString("name");
            int puntaje = doc.getInteger("puntaje");
            String descripcion = doc.getString("descripcion");

            cat.agregar(new Prenda(name,descripcion,name_archivo,puntaje));
        }
        
        categ.add(cat);
        return categ;
    }
    
  

    
    public void renombrarBaseDeDatos(String nombreActualBD,  String nuevoNombreBD) {
    	System.out.println("cambiando name bd");    
    	// 1. Verificar si la BD actual existe
    	    if (!mongoClient.listDatabaseNames().into(new java.util.ArrayList<>()).contains(nombreActualBD)) {
    	        System.out.println("La base de datos '" + nombreActualBD + "' no existe.");
    	        return;
    	    }

    	    // 2. Verificar si la nueva BD ya existe (para evitar sobrescribir)
    	    if (mongoClient.listDatabaseNames().into(new java.util.ArrayList<>()).contains(nuevoNombreBD)) {
    	        System.out.println("Ya existe una base de datos con el nombre '" + nuevoNombreBD + "'.");
    	        return;
    	    }

    	    // 3. Copiar la BD actual a la nueva (MongoDB no permite renombrar directamente)
    	    MongoDatabase bdActual = mongoClient.getDatabase(nombreActualBD);
    	    MongoDatabase bdNueva = mongoClient.getDatabase(nuevoNombreBD);

    	    // Copiar todas las colecciones de la BD actual a la nueva
    	    for (String nombreColeccion : bdActual.listCollectionNames()) {
    	        bdActual.getCollection(nombreColeccion)
    	                .aggregate(java.util.Collections.emptyList())
    	                .forEach(doc -> bdNueva.getCollection(nombreColeccion).insertOne(doc));
    	    }

    	    // 4. Eliminar la BD antigua (opcional)
    	     bdActual.drop();

    	    System.out.println("Base de datos renombrada de '" + nombreActualBD + "' a '" + nuevoNombreBD + "'.");
    	}

    
    public int actualizar_prenda(Prenda prenda, String usuario,String categoria) {
        int re = 0;
        
        try {
           
            System.out.println("Connected to database: " + usuario);
            // Get the collection with the category name
            // 1. Conexión fija a "Planti" y colección "Pantalon"
            database = mongoClient.getDatabase(usuario);
            MongoCollection<Document> collection = database.getCollection(categoria);
            
            // 2. Filtro: Buscar SOLO por "name" (único identificador)
            Document query = new Document("name", prenda.getName());
            
            // 3. Campos a actualizar (ignorando "name" porque es inmutable)
            Document updates = new Document()
                .append("name_archivo", prenda.getName_archivo())
                .append("puntaje", prenda.getPuntaje())
                .append("descripcion", prenda.getDescripcion());
            
            // 4. Ejecutar actualización (no reemplazar todo el documento)
            UpdateResult result = collection.updateOne(
                query, 
                new Document("$set", updates)  // Solo modifica los campos especificados
            );
            
            

            // 5. Resultado
            re = result.getModifiedCount() > 0 ? 1 : 0;
            System.out.println(re == 1 ? "Campos actualizados correctamente" 
                                     : "No se modificó (¿name no existe?)");
            
        } catch (MongoException e2) {
            //System.err.println("Error de MongoDB al actualizar la prenda: " + e2.getMessage());
            re = 0; // Error
        } catch (Exception e) {
            System.err.println("Error inesperado al actualizar la prenda: " + e.getMessage());
            re = -1; // Error
        }
        
        return re;
    }
}
