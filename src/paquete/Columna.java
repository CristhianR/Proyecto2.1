package paquete;

import java.util.ArrayList;

public class Columna {
	
	String nombre;
	String tipo;
	int largo;
	ArrayList<Object> datos = new ArrayList<Object>();
	
	public Columna(	String nombre, String tipo, int largo){
		this.nombre = nombre;
		this.tipo = tipo;
		this.largo = largo;
	}
	
	boolean validar(Object dato){
		if ((dato.getClass().getSimpleName().toString()).equals(tipo)){
			if (dato.toString().length() <= largo){
				return true;
			}
			return false;
		}
		return false;
	}
	
	void insertarDato(Object dato){
		datos.add(dato);
	}
	
	void insertarDatos(ArrayList<Object> lista){
		int size = lista.size();
		for (int indice = 0; indice < size; indice ++){
			insertarDato(lista.get(indice));
		}
	}
	
	void borrarDato(int indice){
		int size = datos.size();
		if (indice < size) {
			datos.remove(indice);
		}
		
	}
	
	
}
