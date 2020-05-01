package es.studium.Programa;

public class Main {
	public static void main(String[] args) {
		Modelo modelo = new Modelo();		
		Vista vista = new Vista();	
		new Controlador(modelo, vista);	
	}

}