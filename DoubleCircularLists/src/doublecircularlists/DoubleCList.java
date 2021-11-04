/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublecircularlists;

public class DoubleCList {
    
    private DoubleNode first;
    private DoubleNode last;
    private int size;
    
    public DoubleCList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public DoubleNode getFirst(){
        return first;
    }
    
    public void setFirst(DoubleNode first){
        this.first = first;
    }
    
    public DoubleNode getLast(){
        return last;
    }
    
    public void setLast(DoubleNode last){
        this.last = last;
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public void emptyList(){
        while (isEmpty() == false){
            deleteFirst();
            if (first == last){
                first = null;
                last = null;
                size = 0;
            }
        }
    }
    
    //Search node and index
    public DoubleNode getNode(int position){
        DoubleNode aux = first;
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
    
    //Add node in any location
    public void addEmpty(Object element){
        DoubleNode newNode = new DoubleNode(element);
        first = newNode;
        last = newNode;
        first.setNext(last);
        first.setPrev(last);
        size = size + 1;
    }
    
    public void addFirst(Object element){
        if (isEmpty()){
            addEmpty(element);
        }else{
            DoubleNode newNode = new DoubleNode(element);
            newNode.setPrev(last);
            newNode.setNext(first);
            last.setNext(newNode);
            first.setPrev(newNode);
            first = newNode;
            size = size + 1;
        }
    }
    
    public void addLast(Object element){
        if (isEmpty()){
            addEmpty(element);
        }else{
            DoubleNode newNode = new DoubleNode(element);
            newNode.setPrev(last);
            newNode.setNext(first);
            last.setNext(newNode);
            first.setPrev(newNode);
            last = newNode;
            size = size + 1;
        }
    }
    
    public void addNode(Object element, int position){
        if (isEmpty()){
            addEmpty(element);
        }else{
            if (position == 0){
                addFirst(element);
            }else if (position == size){
                addLast(element);
            }else if (position < 0 || position > size){
                System.out.println("La lista no llega a esa posicion");
            }else{
                DoubleNode aux = getNode(position);
                DoubleNode newNode = new DoubleNode(element);
                newNode.setPrev(aux.getPrev());
                newNode.setNext(aux);
                aux.getPrev().setNext(newNode);
                aux.setPrev(newNode);
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
            last.setNext(first.getNext());
            first.getNext().setPrev(last);
            first = first.getNext();
            size = size - 1;
        }
    }
    
    public void deleteLast(){
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            last.getPrev().setNext(first);
            first.setPrev(last.getPrev());
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
            }else if(position == size - 1){
                deleteLast();
            }else if(position < 0 || position >= size){
                System.out.println("La lista no llega a esa posicion");
            }else{
                DoubleNode aux = getNode(position);
                aux.getPrev().setNext(aux.getNext());
                aux.getNext().setPrev(aux.getPrev());
                size = size - 1;
            }
        }
    }
    
    public void deletePrePosition(int position){
        deleteNode(position - 1);
    }
    
    public void deletePostPosition(int position){
        deleteNode(position + 1);
    }
    
    //Print all nodes
    public void printList(){
        DoubleNode aux = first;
        if (isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            for (int i = 0; i < size; i++){
                System.out.print(aux.getElement());
                aux = aux.getNext();
            }
        }
    }
}
