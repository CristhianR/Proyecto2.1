package Arboles;
/**
 * Se declara la clase Main
 * Manipulacion de los arboles
 * @author Roberto Pereira
 * @version 06/11/15
 */
public class Main   
{   
    public int n;   
    BEntry root;   
    static boolean DEBUG=false;   
    static boolean DEBUG2=true;   
    Main(int n)   
    {   
        this.n=n;   
        root=new BEntry(n);   
        root.addRootListener(this);   
        root.isRoot=true;   
    }   
    void insert(int index)   
    {   
        BNode node=findNode(index);   
        if (node==null)   
        {   
            BEntry entry=findEntry(index);   
            BNode newNode=new BNode(index);   
            entry.insert(newNode);   
        }          
    }   
    void delete(int index)   
    {   
        BNode node=findNode(index);   
        if (node!=null)   
        {   
            BEntry entry=node.inWhichEntry;   
            //System.out.println("   "+node.inWhichEntry);   
            entry.delete(node);   
        }   
    }   
   
    void print()   
    {   
        root.print(0);   
    }   
    BNode findNode(int index)   
    {   
        return (root.findEntry(index)).findNode(index);   
    }   
    BEntry findEntry(int index)   
    {   
        return root.findEntry(index);   
    }   
       
    void RootChanged(BEntry entry)   
    {   
        //System.out.println("root"+root.info());   
        //System.out.println();   
        this.root=entry;   
        //System.out.println("new root is"+root.info());   
        entry.isRoot=true;   
        entry.addRootListener(this);   
    }   
    String printdebug()   
    {   
        StringBuffer sb=new StringBuffer();   
        root.printdebug(0,sb);   
        return sb.toString();   
    }   
    void travel()   
    {   
        this.print();   
        System.out.println("++++++++++++++++++++++++");   
        for (BEntry entry=root.leftMost();entry!=null;entry=entry.next )   
        {   
            entry.print(0);   
        }   
        System.out.println("-------------------------------------------------");   
    }   
    void travel2()   
    {   
        this.print();   
        System.out.println("++++++++++++++++++++++++");   
        for (BEntry entry=root.rightMost();entry!=null;entry=entry.previous )   
        {   
            entry.print(0);   
        }   
        System.out.println("-------------------------------------------------");   
    }   
       public static void main(String[] args)    
    {   
    	//Prueba del arbol BP _______________________________
    	Main b=new Main(5);
		System.out.println("Prueba BP: ");
  
        b.insert(6);  
        if (DEBUG)b.travel();  
        b.insert(10);  
        if (DEBUG)b.travel();  
        b.insert(1);  
        if (DEBUG)b.travel();  
        b.insert(40);  
        if (DEBUG)b.travel();  
        b.insert(46);    
  
        b.delete(45);  
        if (DEBUG2)b.travel(); 
        
        if (DEBUG)b.travel();  
        b.findEntry(20);    
        
        System.out.println("");
        System.out.println("");
    	
    	//Prueba del arbol AVL _______________________________
        AvlTree arbolAVL = new AvlTree();
        System.out.println("Prueba AVL: ");

        arbolAVL.Insertar(6, "a");
        arbolAVL.Insertar(10, "b");
        arbolAVL.Insertar(1, "c");
        arbolAVL.Insertar(40, "d");
        arbolAVL.Insertar(46, "e");

        arbolAVL.Eliminar(40);

        arbolAVL.buscar(10, arbolAVL.getRoot());

        arbolAVL.preOrden(arbolAVL.getRoot());

        System.out.println("");
        System.out.println("");

        //Prueba del arbol bb _______________________________
        abb arbolbb = new abb();
        System.out.println("Prueba bb: ");
  
        arbolbb.insertar(6, "a");
        arbolbb.insertar(10, "b");
        arbolbb.insertar(1, "c");
        arbolbb.insertar(40, "d");
        arbolbb.insertar(46, "e");
 	        
        arbolbb.eliminar(40);
        
        arbolbb.existe(10);
           
        arbolbb.preOrder();
        
        System.out.println("");
        System.out.println("");
        
        //Prueba del arbol B _______________________________
        BT bt = new BT();
        System.out.println("Prueba B: ");
   
        bt.insert(6, "a");
        bt.insert(10, "b");
        bt.insert(1, "c");
        bt.insert(40, "d");
        bt.insert(46, "e");
        
        bt.delete(40);
        
        bt.buscar(46);
        
        bt.preorder();
 
        System.out.println("");
        System.out.println("");     
               
        //Prueba del arbol Splay _______________________________
        SplayBST<Integer, Integer> st1 = new SplayBST<Integer, Integer>();
        System.out.println("Prueba Splay: ");
        
        st1.put(6, "a");
        st1.put(10, "b");
        st1.put(1, "c");
        st1.put(40, "d");
        st1.put(46, "e");
        
        st1.remove(40);
        
        st1.geta(10);
        
        System.out.println("");
        System.out.println("");
    }
    }   
