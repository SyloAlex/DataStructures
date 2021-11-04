/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
