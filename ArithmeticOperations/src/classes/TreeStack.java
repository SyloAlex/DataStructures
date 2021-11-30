package classes;

public class TreeStack {
    
    private BinaryTree top;
    private int size;
    
    public TreeStack(){
        this.top = null;
        this.size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public BinaryTree getTop(){
        return top;
    }
    
    public void setTop(BinaryTree top){
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

    public void stackNode(BinaryTree element){
        if (isEmpty()){
            top = element;
            size = size + 1;
        }else{
            element.setNext(top);
            top = element;
            size = size + 1;
        }
    }
    
    public BinaryTree unstackNodeReturn(){
        if (isEmpty()){
            return null;
        }else{
            BinaryTree aux = top;
            top = top.getNext();
            size = size - 1;
            return aux;
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
    
}
