package doublecircularlists;

public class DoubleNode {
    
    private DoubleNode next;
    private DoubleNode prev;
    private Object element;
    
    public DoubleNode(Object element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
    
    public DoubleNode(Object element, DoubleNode next, DoubleNode prev){
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
    
    public DoubleNode getNext(){
        return next;
    }
    
    public void setNext(DoubleNode next){
        this.next = next;
    }
    
    public DoubleNode getPrev(){
        return prev;
    }
    
    public void setPrev(DoubleNode prev){
        this.prev = prev;
    }
    
    public Object getElement(){
        return element;
    }
    
    public void setElement(Object element){
        this.element = element;
    }
}
