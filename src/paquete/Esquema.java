package paquete;

import java.util.ArrayList;

public class Esquema {
	//LList lista = new LList();
	String nombre;
	ArrayList<Columna> columnas = new ArrayList<Columna>();
	
	public Esquema(String nombre){
		this.nombre = nombre;
	}
	
	String getNombre(){
		return nombre;
	}
	
	void añadirColumna(Columna columna){
		columnas.add(columna);
	}
	
	void añadirColumnas(ArrayList<Columna> lista){
		int size = lista.size();
		for (int indice = 0; indice < size; indice ++){
			añadirColumna(lista.get(indice));
		}
	}
        
        boolean agregarDatos(ArrayList<Object> datos){
            int size = columnas.size();
            boolean validar = false;
            for (int indice = 0; indice < size; indice ++){
                validar = columnas.get(indice).validar(datos.get(indice));
            }
            if (validar == true){
                for (int indice = 0; indice < size; indice ++){
                    columnas.get(indice).insertarDato(datos.get(indice));
                    return validar;
                }
            }
            return validar;
        }
        
        int buscarColumna(String nombreColumna){
            int size = columnas.size();
            for (int indice = 0; indice < size; indice++){
                if (columnas.get(indice).nombre.equals(nombreColumna)){
                    return indice;
                }
            }
            return -1;
        }
        
        boolean buscarDato(Object dato, int indiceColumna){
            int size = columnas.get(indiceColumna).datos.size();
            for (int indice = 0; indice < size; indice++){
                if (columnas.get(indiceColumna).datos.get(indice).equals(dato)){
                    return true;
                }
            }
            return false;
   
        }

}
