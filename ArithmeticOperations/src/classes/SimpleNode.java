package classes;

public class SimpleNode {
    
    private SimpleNode next;
    private String element;
    
    public SimpleNode(String element){
        this.element = element;
        this.next = null;
    }
    
    public SimpleNode(String element, SimpleNode next){
        this.element = element;
        this.next = next;
    }
    
    public String getElement(){
        return element;
    }
    
    public void setElement(String element){
        this.element = element;
    }
    
    public SimpleNode getNext(){
        return next;
    }
    
    public void setNext(SimpleNode next){
        this.next = next;
    }
    
}
