package Arboles;

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
    
    
    public AvlNode(int data,  Object val){
        this.data=data;
        this.left=null;
        this.right=null;
        this.balance=0;
        this.val=val;
    }
    public AvlNode(int data, AvlNode left, AvlNode rigth, Object val) {
        this.data = data;
        this.left = left;
        this.right = rigth;
        this.val = val;
    }
    static int size (AvlNode n){
        if (n==null){
            return 0;
        }
        return 1+ size(n.left)+size(n.right);
    }
}