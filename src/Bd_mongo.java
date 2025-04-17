import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Bd_mongo {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public Bd_mongo(String usuario) {
        String uri = "mongodb+srv://link:inPark@cluster0.kh8vi.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        mongoClient = MongoClients.create(uri);
        String dbName = usuario;
        database = mongoClient.getDatabase(dbName);
        System.out.println("Connected to database: " + dbName);
    }

    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Sesion Mongo Cerrada");
        } else {
            System.out.println("ERROR: no hay sesion por cerrar.");
        }
    }

    public void guardarRopa(ropa prenda, String tipo) {
        MongoCollection<Document> collection = database.getCollection(tipo);

        Document existingDoc = collection.find(eq("clave", prenda.getClave())).first();
        if (existingDoc != null) {
            System.out.println("ERROR: Duplicate entry. Ropa with clave " + prenda.getClave() + " already exists.");
            return;
        }

        Document doc = new Document("clave", prenda.getClave())
                        .append("nombre", prenda.getName())
                        .append("descripcion", prenda.getDescripcion());
        collection.insertOne(doc);
        System.out.println("Ropa ha sido guardada a coleccion: " + tipo);
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

    public void guardarPersonaje(int ver, int[] curClaves, int puntaje) {
        MongoCollection<Document> collection = database.getCollection("personajes");

        // Convert int[] to List<Integer>
        List<Integer> curClavesList = Arrays.stream(curClaves).boxed().collect(Collectors.toList());

        // Check if a document with the same ver already exists
        Document existingDoc = collection.find(eq("ver", ver)).first();
        if (existingDoc != null) {
            // If it exists, delete the existing document
            collection.deleteOne(eq("ver", ver));
        }

        // Create a new document with ver, curClavesList, and puntaje
        Document doc = new Document("ver", ver)
                        .append("curClaves", curClavesList)
                        .append("puntaje", puntaje);

        // Insert the new document
        collection.insertOne(doc);
        System.out.println("Personaje ha sido guardado con ver: " + ver);
    }

    public int[] leerPersonaje(int ver) {
        MongoCollection<Document> collection = database.getCollection("personajes");

        // Find the document with the specified ver
        Document doc = collection.find(eq("ver", ver)).first();
        if (doc != null) {
            // Retrieve the curClaves list and convert it to an int array
            List<Integer> curClavesList = doc.getList("curClaves", Integer.class);
            int[] curClavesArray = curClavesList.stream().mapToInt(Integer::intValue).toArray();
            return curClavesArray;
        } else {
            System.out.println("No se encontró el personaje con ver: " + ver);
            return null;
        }
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
}
