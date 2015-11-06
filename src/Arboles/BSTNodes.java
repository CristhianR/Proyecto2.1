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
/* Class BSTNode */
class BSTNodes {
    BSTNodes left, right;
    int data;
    Object valor;
 
    /* Constructor */
    public BSTNodes() 
    {
        left = null;
        right = null;
        data = 0;
        valor = null;
        
    }
 
    /* Constructor */
    public BSTNodes(int n, Object valo) 
    {
        left = null;
        right = null;
        data = n;
        valor = valo;
    }
    public Object getValor() 
    {
       return valor;
    }
    
    /* Function to set left node */
    public void setLeft(BSTNodes n) 
    {
        left = n;
    }
 
    /* Function to set right node */
    public void setRight(BSTNodes n) 
    {
        right = n;
    }
 
    /* Function to get left node */
    public BSTNodes getLeft() 
    {
        return left;
    }
 
    /* Function to get right node */
    public BSTNodes getRight() 
    {
        return right;
    }
 
    /* Function to set data to node */
    public void setData(int d) 
    {
        data = d;
    }
 
    /* Function to get data from node */
    public int getData() 
    {
        return data;
    }
}
 

