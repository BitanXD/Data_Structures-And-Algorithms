package Queue;

public class Main {
    public static void main(String[] args){
        Queue q = new Queue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.printQueue();
        q.dequeue();

        q.enqueue(1);
        q.enqueue(5);
        q.printQueue();
        System.out.println("The first element is the queue is = " + q.first());
        System.out.println("The last element is the queue is = " + q.last());
    }
}
