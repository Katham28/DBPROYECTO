package main.java;
import java.io.FileWriter;
import java.io.IOException;

public class Controlador_Reporte {

	private Modelo_Reporte modelo_reporte= Modelo_Reporte.getInstancia();
	
	
	public Controlador_Reporte() {
		// TODO Auto-generated constructor stub
	}
	

	protected  void reporte_all_prendas() {
		modelo_reporte.reporte_all_prendas();
	
	    }
		

	
	protected void reporte_prendas_usuario(String usuario) {
		modelo_reporte.reporte_prendas_usuario( usuario);
	}

}
