/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Arkone
 */
class BT {
    private BSTNodes root;
 
    /* Constructor */
    public BT() 
    {
        root = null;
    }
 
    /* Function to check if tree is empty */
    public boolean isEmpty() 
    {
        return root == null;
    }
 
    /* Functions to insert data */
    public void insert(int data, Object valor) 
    {
        root = insert(root, data, valor);
    }
 
    /* Function to insert data recursively */
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
 
    /* Functions to delete data */
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
 
    /* Functions to count number of nodes */
    public int countNodes() 
    {
        return countNodes(root);
    }
 
    /* Function to count number of nodes recursively */
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
 
    /* Functions to search for an element */
    public boolean search(int val) 
    {
        return search(root, val);
    }
 
    /* Function to search for an element recursively */
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
    
    public boolean buscar(int val) 
    {
        return buscar(root, val);
    }
    
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
 
    /* Function for inorder traversal */
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
 
    /* Function for preorder traversal */
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
 
    /* Function for postorder traversal */
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