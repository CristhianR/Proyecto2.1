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
        //prueba del AVL
        AvlTree arbolAVL = new AvlTree();
        System.out.println("Prueba AVL: ");
        for(int i=0;i<=1000;i++){
            arbolAVL.Insertar(i, "x"+i);
        }
        
        long time1 = System.nanoTime();
        arbolAVL.Insertar(1001, "x"+1001);
        long time2 = System.nanoTime();
        long fin= time2-time1;
        Long insertar_avl=fin;
        System.out.println("Tiempo en insertar(con 1000 elementos): "+fin);
        
        time1 = System.nanoTime();
        arbolAVL.Eliminar(1000);
        time2 = System.nanoTime();
        fin= time2-time1;
        long eliminar_avl=fin;
        System.out.println("Tiempo en eliminar(con 1001 elementos): "+fin);
        
        time1 = System.nanoTime();
        arbolAVL.buscar(999, arbolAVL.getRoot());
        time2 = System.nanoTime();
        fin= time2-time1;
        long buscar_avl=fin;
        System.out.println("Tiempo en buscar(con 1000 elementos): "+fin);
        //---------------------------------------------
        SplayBST<Integer, Integer> st1 = new SplayBST<Integer, Integer>();
        System.out.println("Prueba Splay: ");
        for(int i=0;i<=1000;i++){
            st1.put(i, "x"+i);
        }
        
        time1 = System.nanoTime();
        st1.put(1001, "x1001");
        time2 = System.nanoTime();
        fin= time2-time1;
        long insertar_splay=fin;
        System.out.println("Tiempo en insertar(con 1000 elementos): "+fin);
        
        time1 = System.nanoTime();
        st1.remove(1000);
        time2 = System.nanoTime();
        fin= time2-time1;
        long eliminar_splay=fin;
        System.out.println("Tiempo en eliminar(con 1001 elementos): "+fin);
        
        time1 = System.nanoTime();
        st1.geta(999);
        time2 = System.nanoTime();
        fin= time2-time1;
        long buscar_splay=fin;
        System.out.println("Tiempo en buscar(con 1000 elementos): "+fin);
//        -----------------------------------------------------------------
        
        Main b=new Main(5);
	System.out.println("Prueba BP: ");
        for(int i=0;i<=1000;i++){
            b.insert(i);
        }
        time1 = System.nanoTime();
        b.insert(1001);
        time2 = System.nanoTime();
        fin= time2-time1;
        long insertar_bp=fin;
        System.out.println("Tiempo en insertar(con 1000 elementos): "+fin);
        
        time1 = System.nanoTime();
        b.delete(1000);
        time2 = System.nanoTime();
        fin= time2-time1;
        long eliminar_bp=fin;
        System.out.println("Tiempo en eliminar(con 1001 elementos): "+fin);
        
        time1 = System.nanoTime();
        b.findEntry(999);
        time2 = System.nanoTime();
        fin= time2-time1;
        long buscar_bp=fin;
        System.out.println("Tiempo en buscar(con 1000 elementos): "+fin);
//        ----------------------------------------------------------------
        abb arbolbb = new abb();
        System.out.println("Prueba bb: ");
        for(int i=0;i<=1000;i++){
            arbolbb.insertar(i, "x"+i);
        }
        time1 = System.nanoTime();
        arbolbb.insertar(1001, "x"+1001);
        time2 = System.nanoTime();
        fin= time2-time1;
        long insertar_abb=fin;
        System.out.println("Tiempo en insertar(con 1000 elementos): "+fin);
        
        time1 = System.nanoTime();
        arbolbb.eliminar(1000);
        time2 = System.nanoTime();
        fin= time2-time1;
        long eliminar_abb=fin;
        System.out.println("Tiempo en eliminar(con 1001 elementos): "+fin);
        
        time1 = System.nanoTime();
        arbolbb.existe(999);
        time2 = System.nanoTime();
        fin= time2-time1;
        long buscar_abb=fin;
        System.out.println("Tiempo en buscar(con 1000 elementos): "+fin);
//        -------------------------------------------------------------
        BT bt = new BT();
        System.out.println("Prueba B: ");
        for(int i=0;i<=1000;i++){
            bt.insert(i, "x"+i);
        }
        time1 = System.nanoTime();
        bt.insert(1001, "x"+1001);
        time2 = System.nanoTime();
        fin= time2-time1;
        long insertar_bt=fin;
        System.out.println("Tiempo en insertar(con 1000 elementos): "+fin);
        
        time1 = System.nanoTime();
        bt.buscar(1000);
        time2 = System.nanoTime();
        fin= time2-time1;
        long eliminar_bt=fin;
        System.out.println("Tiempo en eliminar(con 1001 elementos): "+fin);
        
        time1 = System.nanoTime();
        arbolbb.existe(999);
        time2 = System.nanoTime();
        fin= time2-time1;
        long buscar_bt=fin;
        System.out.println("Tiempo en buscar(con 1000 elementos): "+fin);
        
        
        System.out.println("Resultados finales");
        System.out.println("Insertar: Avl: "+insertar_avl+"   Splay: "+insertar_splay+"   BP: "+insertar_bp+"   BB: "+insertar_abb+"   BT: "+insertar_bt);
        System.out.println("Eliminar: Avl: "+eliminar_avl+"   Splay: "+eliminar_splay+"   BP: "+eliminar_bp+"   BB: "+eliminar_abb+"   BT: "+eliminar_bt);
        System.out.println("Buscar: Avl: "+buscar_avl+"   Splay: "+buscar_splay+"   BP: "+buscar_bp+"   BB: "+buscar_abb+"   BT: "+buscar_bt);
        
        System.out.println("Los mejores: Insertar: Splay con "+insertar_splay+",   Eliminar: AVL con "+eliminar_avl+"   Buscando: BP con: "+buscar_bp);
        
        
//    	//Prueba del arbol BP _______________________________
//    	Main b=new Main(5);
//		System.out.println("Prueba BP: ");
//  
//        b.insert(6);  
//        if (DEBUG)b.travel();  
//        b.insert(10);  
//        if (DEBUG)b.travel();  
//        b.insert(1);  
//        if (DEBUG)b.travel();  
//        b.insert(40);  
//        if (DEBUG)b.travel();  
//        b.insert(46);    
//  
//        b.delete(45);  
//        if (DEBUG2)b.travel(); 
//        
//        if (DEBUG)b.travel();  
//        b.findEntry(20);    
//        
//        System.out.println("");
//        System.out.println("");
//    	
//    	//Prueba del arbol AVL _______________________________
//        AvlTree arbolAVL = new AvlTree();
//        System.out.println("Prueba AVL: ");
//
//        arbolAVL.Insertar(6, "a");
//        arbolAVL.Insertar(10, "b");
//        arbolAVL.Insertar(1, "c");
//        arbolAVL.Insertar(40, "d");
//        arbolAVL.Insertar(46, "e");
//
//        arbolAVL.Eliminar(40);
//
//        arbolAVL.buscar(10, arbolAVL.getRoot());
//
//        arbolAVL.preOrden(arbolAVL.getRoot());
//
//        System.out.println("");
//        System.out.println("");
//
//        //Prueba del arbol bb _______________________________
//        abb arbolbb = new abb();
//        System.out.println("Prueba bb: ");
//  
//        arbolbb.insertar(6, "a");
//        arbolbb.insertar(10, "b");
//        arbolbb.insertar(1, "c");
//        arbolbb.insertar(40, "d");
//        arbolbb.insertar(46, "e");
// 	        
//        arbolbb.eliminar(40);
//        
//        arbolbb.existe(10);
//           
//        arbolbb.preOrder();
//        
//        System.out.println("");
//        System.out.println("");
//        
//        //Prueba del arbol B _______________________________
//        BT bt = new BT();
//        System.out.println("Prueba B: ");
//   
//        bt.insert(6, "a");
//        bt.insert(10, "b");
//        bt.insert(1, "c");
//        bt.insert(40, "d");
//        bt.insert(46, "e");
//        
//        bt.delete(40);
//        
//        bt.buscar(46);
//        
//        bt.preorder();
// 
//        System.out.println("");
//        System.out.println("");     
//               
//        //Prueba del arbol Splay _______________________________
//        SplayBST<Integer, Integer> st1 = new SplayBST<Integer, Integer>();
//        System.out.println("Prueba Splay: ");
//        
//        st1.put(6, "a");
//        st1.put(10, "b");
//        st1.put(1, "c");
//        st1.put(40, "d");
//        st1.put(46, "e");
//        
//        st1.remove(40);
//        
//        st1.geta(10);
//        
//        System.out.println("");
//        System.out.println("");
        
        
    }
    }   
