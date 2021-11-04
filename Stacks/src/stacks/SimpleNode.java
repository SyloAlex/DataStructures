package stacks;

public class SimpleNode {
    
    private SimpleNode next;
    private int element;
    
    public SimpleNode(int element){
        this.element = element;
        this.next = null;
    }
    
    public SimpleNode(int element, SimpleNode next){
        this.element = element;
        this.next = next;
    }
    
    public int getElement(){
        return element;
    }
    
    public void setElement(int element){
        this.element = element;
    }
    
    public SimpleNode getNext(){
        return next;
    }
    
    public void setNext(SimpleNode next){
        this.next = next;
    }
    
}
