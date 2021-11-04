package queues;

public class Queue {
    
    private SimpleNode front;
    private SimpleNode rear;
    private int size;
    
    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public SimpleNode getFront() {
        return front;
    }

    public void setFront(SimpleNode front) {
        this.front = front;
    }

    public SimpleNode getRear() {
        return rear;
    }

    public void setRear(SimpleNode rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return this.front == null;
    }
    
    public void queueEmpty(Object element){
        if (this.isEmpty()){
            SimpleNode newNode = new SimpleNode(element);
            this.front = newNode;
            this.rear = newNode;
            this.size = size + 1;
        }
    }
    
    public void queue(Object element){
        if (this.isEmpty()){
            this.queueEmpty(element);
        }else{
            SimpleNode newNode = new SimpleNode(element);
            this.rear.setNext(newNode);
            this.rear = newNode;
            this.size = size + 1;
        }
    }
    
    public void deQueue(){
        if (!this.isEmpty()){
            if (this.size > 1){
                this.front = this.front.getNext();
                this.size = size - 1;
            }else{
                this.front = null;
                this.rear = null;
                this.size = 0;
            }
        }
    }
    
    public void printQueue(){
        int i = 0;
        while (i < this.size){
            SimpleNode aux = this.front;
            if (i < this.size - 1){
                System.out.print(aux.getElement() + " -> ");
            }else{
                System.out.print(aux.getElement()+ " -> null");
            }
            this.deQueue();
            this.queue(aux.getElement());
            i++;
        }
    }
    
}
