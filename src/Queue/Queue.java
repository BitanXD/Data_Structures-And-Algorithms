package Queue;
import java.util.NoSuchElementException;

// Queue follows FIFO - First In First Out i.e. insertion from rear and deletion from front only/
public class Queue {
    private Node front;
    private Node rear;
    private int length;

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public Queue(int value){
        Node newNode = new Node(value);
        front = newNode;
        rear = newNode;
        length++;
    }
    public boolean isEmpty(){
        if(length == 0){
            return true;
        }
        return false;
    }
    public void printQueue(){
        Node temp = front;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    // inserting in a queue ----> enqueue
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
            front = newNode;
        }else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }

    public Node dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty !!!");
        }
        Node temp = front;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return temp;
    }
    //first method ---> first refers to the value denoted by front pointer

    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty !!!");
        }else {
            return front.value;
        }
    }

    //last method -----> last refers to the value denoted by the rear pointer
    public int last(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty !!!");
        }
        return rear.value;
    }

}
