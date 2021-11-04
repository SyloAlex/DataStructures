package queues;

public class SimpleNode {
    
    private SimpleNode next;
    private Object element;
    
    public SimpleNode(Object element){
        this.element = element;
        this.next = null;
    }
    
    public SimpleNode(Object element, SimpleNode next){
        this.element = element;
        this.next = next;
    }
    
    public SimpleNode getNext(){
        return next;
    }
    
    public void setNext(SimpleNode next){
        this.next = next;
    }
    
    public Object getElement(){
        return element;
    }
    
    public void setElement(Object element){
        this.element = element;
    }
    
}
