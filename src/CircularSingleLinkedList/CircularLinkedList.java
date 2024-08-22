package CircularSingleLinkedList;

import java.net.InetAddress;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        Node next;
        int value;

        Node(int value){
            this.value = value;
        }
    }
    CircularLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    public void printList(){
        Node temp = head;
        System.out.print(temp.value+" ");
        temp = temp.next;
        while(temp != head){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    //insert node at last / add node at last
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // insert node at beginning
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        tail.next = head;
        length++;
    }

    //remove first node from the circular linked list
    public Node removeFirst(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        tail.next = head;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }
}
