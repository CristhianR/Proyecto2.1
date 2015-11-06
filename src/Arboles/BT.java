
package Arboles;
/**
 * Se declara la clase BT
 *se encuentra toda la logica del arbol
 * @author Roberto Pereira
 * @version 06/11/15
 */
class BT {
    private BSTNodes root;
 
    /* Constructor */
    public BT() 
    {
        root = null;
    }
 
    // Funcion para averiguar si el arbol esta vacio
    public boolean isEmpty() 
    {
        return root == null;
    }
 
    // Funcion para insertar key y el valor del nodo 
    public void insert(int data, Object valor) 
    {
        root = insert(root, data, valor);
    }
 
    /**
     * Funcion insert para insertar el key recursivamente 
     * @param node: El arbol en que se encuentra
     * @param data: Key del nodo
     * @param valor: Valor del nodo a insertar
     * @return el nodo
     */
    private BSTNodes insert(BSTNodes node, int data, Object valor) 
    {   
        
        if (node == null)
            node = new BSTNodes(data, valor);
        else 
        {
            if (data <= node.getData())
                node.left = insert(node.left, data, valor);
            else
                node.right = insert(node.right, data, valor);
        }
        return node;
    }
 
    /**
     * Funcion delete para eliminar un nodo
     * @param k: El key del nodo
     */
    public void delete(int k)
    {
        if (isEmpty())
            System.out.println("Tree Empty");
        else if (search(k) == false)
            System.out.println("Sorry " + k + " is not present");
        else 
        {
            root = delete(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }
 
    private BSTNodes delete(BSTNodes root, int k) 
    {
        BSTNodes p, p2, n;
        if (root.getData() == k) 
        {
            BSTNodes lt, rt;
            lt = root.getLeft();
            rt = root.getRight();
            if (lt == null && rt == null)
                return null;
            else if (lt == null) 
            {
                p = rt;
                return p;
            }
            else if (rt == null) 
            {
                p = lt;
                return p;
            } 
            else 
            {
                p2 = rt;
                p = rt;
                while (p.getLeft() != null)
                    p = p.getLeft();
                p.setLeft(lt);
                return p2;
            }
        }
        if (k < root.getData()) 
        {
            n = delete(root.getLeft(), k);
            root.setLeft(n);
        }
        else 
        {
            n = delete(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }
 
    // Funcion para contar el numero de nodos
    public int countNodes() 
    {
        return countNodes(root);
    }
 
    // Funcion para contar numeros de nodos recursivamente
    private int countNodes(BSTNodes r) 
    {
        if (r == null)
            return 0;
        else 
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
 
    /**
     * Funcion para buscar nodo
     * @param val: El key del nodo a buscar
     * @return true o false
     */
    public boolean search(int val) 
    {
        return search(root, val);
    }
 
    // Funcion para buscar un nodo recursivamente
    private boolean search(BSTNodes r, int val) 
    {
        boolean found = false;
        while ((r != null) && !found) 
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else 
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /**
     * Funcion para buscar nodo
     * @param val: El key del nodo a buscar
     * @return true o false
     */
    public boolean buscar(int val) 
    {
        return buscar(root, val);
    }
    // Funcion para buscar el nodo recursivamente e imprime dicho nodo
    private boolean buscar(BSTNodes r, int val) 
    {
        boolean found = false;
        
        while ((r != null) && !found) 
        {
            int rval = r.getData();
            if (val < rval)
                r = r.getLeft();
            else if (val > rval)
                r = r.getRight();
            else 
            {
                System.out.println(r.getValor());
                r.getValor();
                found = true;
                break;
            }
            found = buscar(r, val);
        }
        return found;
    }
 
    /**
     * Funcion para inorder del arbol 
     */
    public void inorder() 
    {
        inorder(root);
    }
 
    private void inorder(BSTNodes r) 
    {
        if (r != null) 
        {
            inorder(r.getLeft());
            System.out.print(r.getData() + " ");
            inorder(r.getRight());
        }
    }
    /**
     * Funcion para preorder del arbol 
     */
    public void preorder() 
    {
        preorder(root);
    }
 
    private void preorder(BSTNodes r) 
    {
        if (r != null) 
        {
            System.out.print(r.getData() + " ");
            preorder(r.getLeft());
            preorder(r.getRight());
        }
    }
 
    /**
     * Funcion para postorder del arbol 
     */
    public void postorder() 
    {
        postorder(root);
    }
 
    private void postorder(BSTNodes r) 
    {
        if (r != null) 
        {
            postorder(r.getLeft());
            postorder(r.getRight());
            System.out.print(r.getData() + " ");
        }
    }

}