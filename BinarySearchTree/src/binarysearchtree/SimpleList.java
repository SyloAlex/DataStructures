package binarysearchtree;

public class SimpleList {
    
    private SimpleNode first;
    private SimpleNode last;
    private int size;
    
    public  SimpleList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public SimpleNode getFirst(){
        return first;
    }
    
    public void setFirst(SimpleNode newFirst){
        this.first = newFirst;
    }
    
    public SimpleNode getLast(){
        return last;
    }
    
    public void setLast(SimpleNode newLast){
        this.first = newLast;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void emptyList(){
        while (size > 1){
            this.deleteLast();
        }
        first = null;
        last = null;
        size = 0;
    }
    
    //Search Nodes and Indez
    
    public SimpleNode getNode(int position){
        SimpleNode aux = first;
        for (int i = 0; i < size; i++){
            if (i == position){
                return aux;
            }else{
                aux = aux.getNext();
            }
        }
        return null;
    }
    
    public Object getIndex(Object element){
        SimpleNode aux = first;
        for (int i = 0; i < size; i++){
            if (aux.getElement() == element){
                return i;
            }else{
                aux = aux.getNext();
            }
        }
        return null;
    }
    
    //Adding Nodes in various positions
    public void addEmpty(Object element){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            first = newNode;
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addFirst(Object element){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(Object element){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addOrdered(int element){
        SimpleNode aux = first;
        boolean flag = false;
        if (isEmpty()){
            addFirst(element);
        }else{
            for (int i = 0; i < size; i++){
                if ((int)aux.getElement() > element){
                    addNode(element, i);
                    flag = true;
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
            if (!flag){
                addLast(element);
            }
        }
    }
    
    public void addNode(Object element, int position){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            if (position == 0){
                newNode.setNext(first);
                first = newNode;
                size = size + 1;
            }else if (position == size){
                last.setNext(newNode);
                last = newNode;
                size = size + 1;
            }else if(position < 0 || position >= size){
                System.out.println("La lista no tiene esa posicion");
            }else{
                SimpleNode aux = getNode(position - 1);
                if (aux != null){
                    newNode.setNext(aux.getNext());
                    aux.setNext(newNode);
                    size = size + 1;
                }else{
                    System.out.println("La lista no tiene esa posicion");
                }
            }
        }
    }

    public void addPostPosition(Object element, int position){
        this.addNode(element, position + 1);
    }
    //Delete nodes in various locations
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            SimpleNode aux = first.getNext();
            first = aux;
            size = size - 1;            
        }
    }
    
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("No se puede eliminar, la lista esta vacia");
        }else{
            last = getNode(size - 2);
            last.setNext(null);
            size = size - 1;           
        }
    }
    
    public void deleteNode(int position){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            if (position == 0){
                this.deleteFirst();
            }else if (position == size - 1){
                this.deleteLast();
            }else if (position >= size || position < 0){
                System.out.println("La lista no tiene esa posicion");
            }else{
                SimpleNode aux = getNode(position - 1);
                aux.setNext(aux.getNext().getNext());
                size = size - 1;
            }
        }
    }

    public void deletePrePosition(int position){
        this.deleteNode(position - 1);
    }
    
    public void deletePostPosition(int position){
        this.deleteNode(position + 1);
    }
    
    //Print all nodes
    public void printList(){
        SimpleNode aux = first;
        for (int i = 0; i < size; i++){
            System.out.print(aux.getElement());
            aux = aux.getNext();
        }
    }
    
}
