package main.java;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JLabel;

public class Modelo_Reporte {
	private static Modelo_Reporte instancia; 
	
	Controlador_Prenda b;

	 Modelo_Mongo mongo;
	String [] categor = new String[15];
    Imagen imagenes= new Imagen ();
    JLabel ima = new JLabel();
	private LinkedList <Categoria> categ= new LinkedList ();
    LinkedList<Categoria> armario;
    
	public static Modelo_Reporte getInstancia () {
		if (instancia==null) {
			instancia=new Modelo_Reporte();
		}
			return instancia;
		}

	public Modelo_Reporte() {
		// TODO Auto-generated constructor stub
		b= new  Controlador_Prenda ();
	

 
	}
	
	
	public  void reporte_all_prendas() {
		armario=b.cargar_todo();

		
		 try (FileWriter writer = new FileWriter("Todas las prendas.txt")) {
	            writer.write("=== Reporte de prendas ===\n\n");

	            for (int i = 0; i < armario.size(); i++) {
	                writer.write("=="+(i + 1) + ". " + armario.get(i).getName() + "\n");
	                
	                for (Prenda b : armario.get(i).getAtuendos()) {
	                    writer.write("\t"+ "- " + b+ "\n");

	                }

	                
	            }
	            System.out.println("Archivo TXT creado");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
		

	
	public void reporte_prendas_usuario(String usuario) {
		Controlador_Prenda b=new Controlador_Prenda ();
		Modelo_Mongo mongo = new Modelo_Mongo(usuario);
		 categ.add(b.buscar_categ("Cuerpo"));
		 categ.add(b.buscar_categ("Ojos"));
		 categ.add(b.buscar_categ("Cejas"));
		 categ.add(b.buscar_categ("Boca"));

		 categ=mongo.leerCateg("Vello", categ);
		 categ=mongo.leerCateg("Lentes", categ);
		 
		 categ.add(b.buscar_categ("Peinado"));
		 
		 categ=mongo.leerCateg("Tatuaje", categ);
		 categ=mongo.leerCateg("Calcetas", categ);
		 categ=mongo.leerCateg("Top", categ);
		 categ=mongo.leerCateg("Pantalon", categ);
		 categ=mongo.leerCateg("Sombrero", categ);
		 categ=mongo.leerCateg("Calzado", categ);
		 categ=mongo.leerCateg("Piercing", categ);
		 categ=mongo.leerCateg("Capa", categ);
		
		armario=categ;
		
		 try (FileWriter writer = new FileWriter(""+usuario+".txt")) {
	            writer.write("=== Reporte de prendas de "+ usuario+"===\n\n");

	            for (int i = 0; i < armario.size(); i++) {
	                writer.write("=="+(i + 1) + ". " + armario.get(i).getName() + "\n");
	                
	                for (Prenda c : armario.get(i).getAtuendos()) {
	                    writer.write("\t"+ "- " + c+ "\n");

	                }

	                
	            }
	            System.out.println("Archivo TXT creado");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

		
	}


