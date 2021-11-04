package queues;

public class QueueFunctions {
    
    public QueueFunctions(){
        
    }
    
    public Queue reverseQueue(Queue newQueue){
        if(!newQueue.isEmpty()){
            SimpleNode aux = newQueue.getFront();
            newQueue.deQueue();
            newQueue = this.reverseQueue(newQueue);
            newQueue.queue(aux.getElement());
        }
        return newQueue;
    }
    
    public Queue copyQueue(Queue original, Queue copy){
        if(!original.isEmpty()){
            SimpleNode aux = original.getFront();
            original.deQueue();
            copy.queue(aux.getElement());
            copy = this.copyQueue(original, copy);
            original.queue(aux.getElement());
        }
        return copy;
    }
    
    public void getCopy(Queue original, Queue copy){
        copy = this.copyQueue(original, copy);
        this.reverseQueue(original);
    }
    
}
