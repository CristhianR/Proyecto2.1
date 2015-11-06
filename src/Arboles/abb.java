package Arboles;
/**
 * Se declara la clase abb
 * @author cristhian
 * @version 01/10/15
 */

public class abb {
 
    private class nodoArbol { //Clase nodo con constructor
        private abb hd;
        private abb hi;
        private int dato;
        private Object val;
        
 
        private void nodoArbol(){
            hd = null;
            hi = null;
            dato = 0;
            val = null;
        }
    }
 
    public nodoArbol raiz;
 
    public void abb(){ //Crea una raiz al instanciar un arbol
        nodoArbol raiz = new nodoArbol();
    }
 
    public boolean esVacio(){ // Revisa si el arbol esta vacio
        return (raiz == null);
    }
    /**
     * Clase encargada de insertar elemntos al arbol
     * @param a: Key del nodo
     * @param valor: Valor del nodo
     */
    public void insertar(int a, Object valor){ 
        if (esVacio()) { //comprueba si es vacio
            nodoArbol nuevo = new nodoArbol(); //Si lo es, crea una raiz
            nuevo.val = valor;
            nuevo.dato = a;
            nuevo.hd = new abb();
            nuevo.hi = new abb();
            raiz = nuevo;
        }
        else {
            if (a > raiz.dato) { // si la insercion es mayor a la busqueda
                (raiz.hd).insertar(a, valor); //aplica insercion de "a" en el hijo derecho
            }
            if (a < raiz.dato){
                (raiz.hi).insertar(a, valor); //aplica insercion de "a" en el hijo izquierdo
            }
        }
    }  
    /**
     * Funcion para pretorder del arbol 
     */
    public void preOrder(){
        if (!esVacio()) {
            System.out.print( raiz.dato + ", "  );
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }
    /**
     * Funcion para inorder del arbol 
     */
    public void inOrder(){ // Ordena los nodos de menor a mayor
        if (!esVacio()) {
            raiz.hi.inOrder();
            System.out.print( raiz.dato + ", "  );
            raiz.hd.inOrder();
        }
    }
    /**
     * Funcion para postorder del arbol 
     */
    public void posOrder(){
        if (!esVacio()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print( raiz.dato + ", "  );
 
        }
    }
    /**
     * Clase que busca un valor int y lo devuelve como un arbol de un solo nodo
     * @param a: Key del nodo
     * @return raiz o null
     */
    public abb buscar(int a){ 
        abb arbolito = null;
        if (!esVacio()) { //si no es vacio
            if (a == raiz.dato) { //si el valor a es igual al dato de la raiz
            return this; //retorna la raiz
            }
            else {
                if (a < raiz.dato) { //si el valor a es menor al dato de la raiz
                    arbolito = raiz.hi.buscar(a); // busca en el hijo izquierdo de la raiz
                }
                else {  //si el valor a es mayor al dato de la raiz
                    arbolito = raiz.hd.buscar(a); // busca en el hijo derecho de la raiz
                }
            }
        }
        return arbolito;
    }
    /**
     * Clase que busca un valor int y lo devuelve como un arbol de un solo nodo
     * @param a: Key del nodo
     * @return imprime el nodo
     */
    public void existe(int a){ //Comprueba si existe el valor a en un arbol
    if (!esVacio()) { //si no es vacio
            if (a == raiz.dato) { //si el valor de a es igual al dato de la raiz
            System.out.println(raiz.val);
            }
            else {
                if (a < raiz.dato) { //si el valor de a es menor al dato de la raiz
                    raiz.hi.existe(a); // busca en el hijo derecho de la raiz
                }
                else { //si el valor de a es mayor al dato de la raiz
                    raiz.hd.existe(a); // busca en el hijo derecho de la raiz
                }
            }
        }		
    }
    /**
     * Clase cantidad que calcula la cantidad de nodos de un arbol
     * @return cantidad de nodos de un arbol
     */
    public int cantidad(){ 
        if (esVacio()) { // Si esta vacio
            return 0;
        }
        else {
            return (1 + raiz.hd.cantidad() + raiz.hi.cantidad()); //cuenta 1 y cuenta los hijos derechos e izquierdos
        }
    }
    /**
     * Clase altura que calcula los niveles del arbol
     * @return los niveles del arbol
     */
    public int altura() { 
        if (esVacio()) {
            return 0;
        }
        else {
            return (1 + Math.max(((raiz.hi).altura()), ((raiz.hd).altura())));
        }
    }
    /**
     * Clase que busca una hoja sin hijos
     * @return el nodo hijo
     */
    public int buscarMin() { 
        abb arbolActual = this;
        while( !arbolActual.raiz.hi.esVacio() ) {
            arbolActual = arbolActual.raiz.hi;
        }
        int devuelvo= arbolActual.raiz.dato;
        arbolActual.raiz=null;
        return devuelvo;
    }
 
    public int buscarMan() {
        abb arbolActual = this;
        while( !arbolActual.raiz.hd.esVacio() ) {
            arbolActual = arbolActual.raiz.hd;
        }
        int devuelvo= arbolActual.raiz.dato;
            arbolActual.raiz=null;
        return devuelvo;
    }
    /**
     * Clase que comprueba si es hoja
     * @return true or false
     */
    public boolean esHoja() { 
        boolean hoja = false;
        if( (raiz.hi).esVacio() && (raiz.hd).esVacio() ) {
            hoja = true;
        }
        return hoja;
    }
    /**
     * Clase eliminar que ejecuta el removimiento de un nodo del arbol
     * @param a: Key del nodo 
     */
    public void eliminar(int a) { // elimina nodos 
        abb paraEliminar = buscar(a); //crea un arbol para eliminar
        if (!paraEliminar.esVacio()) { // si el arbol no es vacio
            if (paraEliminar.esHoja()) { // si es hoja
                paraEliminar.raiz = null; // elimina el arbol convirtiendo la raiz en nula
            }
            else {
                if (!paraEliminar.raiz.hi.esVacio() && !paraEliminar.raiz.hd.esVacio()) { // si los hijos no son vacios
                    paraEliminar.raiz.dato = paraEliminar.raiz.hd.buscarMin(); // busca el minimo del hijo derecho y lo convierte en raiz
                }
                else {
                    if (paraEliminar.raiz.hi.esVacio()) { //si el hijo izquierdo de la raiz es vacio
                        paraEliminar.raiz = paraEliminar.raiz.hd.raiz; //aplica eliminar en la raiz del hijo derecho de la raiz
                    }else{
                        paraEliminar.raiz = paraEliminar.raiz.hi.raiz; //aplica eliminar en la raiz del hijo izquierdo de la raiz
                    }
                }
            }
        }
    }
}
