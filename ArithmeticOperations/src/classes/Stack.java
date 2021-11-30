package classes;

public class Stack {
    
    private SimpleNode top;
    private int size;
    
    public Stack(){
        this.top = null;
        this.size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public SimpleNode getTop(){
        return top;
    }
    
    public void setTop(SimpleNode top){
        this.top = top;
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public void emptyStack(){
        while (!isEmpty()){
            unstackNode();
            if (size == 1){
                top = null;
                size = 0;
            }
        }
    }

    public void stackNode(String element){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            top = newNode;
            size = size + 1;
        }else{
            newNode.setNext(top);
            top = newNode;
            size = size + 1;
        }
    }
    
    public void unstackNode(){
        if (isEmpty()){
            System.out.println("No hay elementos en el stack");
        }else{
            top = top.getNext();
            size = size - 1;
        }
    }

    public void printStack(){
        SimpleNode aux = top;
        for (int i = 0; i < size; i++){
            System.out.println(aux.getElement());
            aux = aux.getNext();
        }
    }
    
}
