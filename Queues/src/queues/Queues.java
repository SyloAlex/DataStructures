package queues;

public class Queues {

    public static void main(String[] args) {
        Queue newQueue = new Queue();
        QueueFunctions f = new QueueFunctions();
        newQueue.queue(1);
        newQueue.queue(2);
        newQueue.queue(3);
        newQueue.queue(4);
        newQueue.queue(5);
        Queue copyQueue = new Queue();
        f.getCopy(newQueue, copyQueue);
        copyQueue.printQueue();
        System.out.println("//");
        newQueue.printQueue();
    }
    
}
