package paquete;

import java.util.ArrayList;


public class Columna {
	
	String nombre;
	String tipo;
	int largo;
	ArrayList<Object> datos = new ArrayList<Object>();
        AvlTree avlTree = null;
        SplayBST splayTree = null;
        abb BSTree = null;
        BT BTree = null;
        
	
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
        
        void indexarABB(){
            BSTree = new abb();
            int size = datos.size();
            for (int indice = 0; indice < size; indice++){
                BSTree.insertar(indice, datos.get(indice));
            }   
        }
        
        void indexarAVL(){
            avlTree = new AvlTree();
            int size = datos.size();
            for (int indice = 0; indice < size; indice++){
                avlTree.Insertar(indice, datos.get(indice));
            }   
        }
	
        void indexarB(){
            BTree = new BT();
            int size = datos.size();
            for (int indice = 0; indice < size; indice++){
                BTree.insert(indice, datos.get(indice));
            }   
        }
        
        void indexarSplay(){
            splayTree = new SplayBST();
            int size = datos.size();
            for (int indice = 0; indice < size; indice++){
                splayTree.put(indice, datos.get(indice));
            }   
        }
        
       void desindexarABB(){
            BSTree = null;
        }
        
        void desindexarAVL(){
            avlTree = null; 
        }
	
        void desindexarB(){
            BTree = null;
        }
        
        void desindexarSplay(){
            splayTree = null; 
        }
	
}
