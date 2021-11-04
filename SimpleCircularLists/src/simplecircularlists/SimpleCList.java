package simplecircularlists;

public class SimpleCList {
    
    private SimpleNode first;
    private SimpleNode last;
    private int size;
    
    public SimpleCList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public SimpleNode getFirst(){
        return first;
    }
    
    public void setFirst(SimpleNode first){
        this.first = first;
    }
    
    public SimpleNode getLast(){
        return last;
    }
    
    public void setLast(SimpleNode last){
        this.last = last;
    }
    
    public int getSize(){
        return size;
    }
    
    public void emptyList(){
        while (size > 1){
            this.deleteLast();
        }
        first = null;
        last = null;
        size = 0;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    //Search node and index in every location
    public SimpleNode getNode(int position){
        SimpleNode aux = first;
        if (position < 0 || position >= size){
            return null;
        }else{
            for (int i = 0; i < size; i++){
                if (i == position){
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
        }
        return aux;
    }
    
    public int getIndex(Object element){
        SimpleNode aux = first;
        for (int i = 0; i < size; i++){
            if (aux.getElement() == element){
                return i;
            }else{
                aux = aux.getNext();
            }
        }
        return -1;
    }
    
    //Add nodes to list
    
    public void addEmpty(Object element){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            first = newNode;
            last = newNode;
            newNode.setNext(newNode);
            size = size + 1;
        }
    }
    
    public void addFirst(Object element){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            newNode.setNext(first);
            last.setNext(newNode);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(Object element){
        SimpleNode newNode = new SimpleNode(element);
        if (isEmpty()){
            this.addEmpty(element);
        }else{
            newNode.setNext(first);
            last.setNext(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addNode(Object element, int position){
        if (isEmpty()){
            addFirst(element);
        }else{
            if (position == 0){
                addFirst(element);
            }else if (position == size){
                addLast(element);
            }else if (position < 0 || position > size){
                System.out.println("La lista no tiene esa posicion");
            }else{
                SimpleNode aux = getNode(position - 1);
                SimpleNode newNode = new SimpleNode(element, aux.getNext());
                aux.setNext(newNode);
                size = size + 1;
            }
        }
    }
    
    public void addPostPosition(Object element, int position){
        addNode(element, position + 1);
    }
    
    //Delete node in any position
    public void deleteFirst(){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            last.setNext(first.getNext());
            first = first.getNext();
            size = size - 1;
        }
    }
    
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            SimpleNode aux = getNode(size - 2);
            aux.setNext(last.getNext());
            last = aux;
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
            }else if (position < 0 || position >= size){
                System.out.println("La lista no llega a esa posicion");
            }else{
                SimpleNode aux = getNode(position - 1);
                aux.setNext(aux.getNext().getNext());
                size = size - 1;
            }
        }
    }
    
    public void deletePostPosition(int position){
        deleteNode(position + 1);
    }
    
    public void deletePrePosition(int position){
        deleteNode(position - 1);
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
