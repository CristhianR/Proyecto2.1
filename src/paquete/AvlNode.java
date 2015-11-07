package paquete;

/**
 *Se declara la clase AvleNode.
 * Por lo general los nodos son como hojas del arbol.
 * @author cristhian
 * @version 01/10/15
 */

public class AvlNode{
    int data;
    int balance;
    AvlNode left, right;
    Object val;
    
    /**
     * Clase AVLNode para la creacion de un nodo
     * @param data: Key para ordenarlo en el arbol
     * @param val: Valor a guardar
     */
    public AvlNode(int data,  Object val){
        this.data=data;
        this.left=null;
        this.right=null;
        this.balance=0;
        this.val=val;
    }
    /**
     * Clase AVLNode parametros de un nodo para las funciones del arbol
     * @param data: Key para ordenarlo en el arbol
     * @param left: Nodo izquierdo
     * @param rigth: Nodo derecho
     * @param val: Valor a guardar 
     */
    public AvlNode(int data, AvlNode left, AvlNode rigth, Object val) {
        this.data = data;
        this.left = left;
        this.right = rigth;
        this.val = val;
    }
    /**
     * 
     * @param n: El numero de nodo 
     * @return Cantidad de nodos
     */
    static int size (AvlNode n){
        if (n==null){
            return 0;
        }
        return 1+ size(n.left)+size(n.right);
    }
}