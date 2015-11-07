package paquete;

/**
 * Creacion de clase SLL, lista enlzadar
 * @author cristhian
 */
public class SLL {
    
    private SLLNode first;
    private int length;
    /**
     * Constructor
     */
    SLL(){
        this.first=null;
    }

    public void addNode(SLLNode node) {
        length +=1;
        if(getFirst()==null){
            setFirst(node);
        }
        else{
            node.setSucc(getFirst());
            setFirst(node);
            
            
        }
    }

    public Object getNode() {
        /*temp*/
        return getFirst();
    }

    public void clear() {
        setFirst(null);
    }

    /**
     * @return the first
     */
    public SLLNode getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(SLLNode first) {
        this.first = first;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    
}
}