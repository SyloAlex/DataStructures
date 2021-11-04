package main;

public class DoubleLists {
    
    private DoubleNode first;
    private DoubleNode last;
    private int size;
    
    public  DoubleLists(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public DoubleNode getFirst(){
        return first;
    }
    
    public void setFirst(DoubleNode newFirst){
        this.first = newFirst;
    }
    
    public DoubleNode getLast(){
        return last;
    }
    
    public void setLast(DoubleNode newLast){
        this.last = newLast;
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
    
    public void addEmpty(Object element){
        DoubleNode newNode = new DoubleNode(element);
        if (this.isEmpty()){
            first = newNode;
            last = newNode;
            size = size + 1;
        }
    }
    
    //Add node in any position
    public void addFirst(Object element){
        DoubleNode newNode = new DoubleNode(element);
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            first.setPrev(newNode);
            newNode.setNext(first);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(Object element){
        DoubleNode newNode = new DoubleNode(element);
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            last.setNext(newNode);
            newNode.setPrev(last);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addNode(Object element, int position){
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            if (position < 0 || position > size){
                System.out.println("La lista no contiene esa posici[on");
            }else if (position == 0){
                addFirst(element);
            }else if (position == size){
                addLast(element);
            }else{
                DoubleNode newNode = new DoubleNode(element);
                DoubleNode aux = getNode(position - 1);
                newNode.setNext(aux.getNext());
                newNode.setPrev(aux);
                newNode.getNext().setPrev(newNode);
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    public void addPostNode(Object element, int position){
        addNode(element, position + 1);
    }
    
    //Delete node in any location
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            first.getNext().setPrev(null);
            first = first.getNext();
            size = size - 1;
        }
    }
    
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            last.getPrev().setNext(null);
            last = last.getPrev();
            size = size - 1;
        }
    }
    
    public void deleteNode(int position){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            if (position == 0){
                deleteFirst();
            }else if (position == size - 1){
                deleteLast();
            }else if (position >= size || position < 0){
                System.out.println("La lista no contiene esa posici[on");
            }else{
                DoubleNode aux = getNode(position);
                aux.getPrev().setNext(aux.getNext());
                aux.getNext().setPrev(aux.getPrev());
                size = size - 1;
            }
        }
    }
    
    public void deletePreNode(int position){
        deleteNode(position - 1);
    }
    
    public void deletePostNode(int position){
        deleteNode(position + 1);
    }
    
    //Search node and position
    public DoubleNode getNode(int position){
        DoubleNode aux = first;
        if (position <= size - 1){
            for (int i = 0; i < size; i++){
                if (i == position){
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
        }else{
            aux = null;
        }
        return aux;
    }
    
    public int getIndex(Object element){
        DoubleNode aux = first;
        for (int i = 0; i < size; i++){
            if (aux.getElement() == element){
                return i;
            }else{
                aux = aux.getNext();
            }
        }
        return -1;
    }
    
    //Print all nodes
    public void printList(){
        DoubleNode aux = first;
        for (int i = 0; i < size; i++){
            System.out.print(aux.getElement());
            aux = aux.getNext();
        }
    }
}
