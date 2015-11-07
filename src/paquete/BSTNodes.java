package paquete;

/**
 * Se declara la clase BSTNodes
 * Por lo general los nodos son como hojas del arbol
 * @author Roberto Pereira
 * @version 06/11/15
 */
class BSTNodes {
    BSTNodes left, right;
    int data;
    Object valor;
 
    /**
     * Clase BSTNodes, constructor 
     */
    public BSTNodes() 
    {
        left = null;
        right = null;
        data = 0;
        valor = null;
        
    }
 
    /**
     * Clase BSTNodes, constructor.
     * @param n: El kay del nodo
     * @param valo: Valor a guardar en el nodo
     */
    public BSTNodes(int n, Object valo) 
    {
        left = null;
        right = null;
        data = n;
        valor = valo;
    }
    //// Funcion para obtener valor del nodo
    public Object getValor() 
    {
       return valor;
    }
    
    // Funcion para asignar nodo izquierdo 
    public void setLeft(BSTNodes n) 
    {
        left = n;
    }
 
    // Funcion para asignar nodo derecho
    public void setRight(BSTNodes n) 
    {
        right = n;
    }
 
    // Funcion para obtener nodo izquierdo 
    public BSTNodes getLeft() 
    {
        return left;
    }
 
    // Funcion para obtener nodo derecho
    public BSTNodes getRight() 
    {
        return right;
    }
 
    // Funcion para asignar el key del nodo
    public void setData(int d) 
    {
        data = d;
    }
 
    // Funcion para obtener key del nodo
    public int getData() 
    {
        return data;
    }
}
 

