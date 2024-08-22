package CircularSingleLinkedList;

public class Main {
    public static void main(String[] args){
        CircularLinkedList cl = new CircularLinkedList(1);
        cl.append(2);
        cl.append(3);
        cl.append(4);
        cl.printList();
        cl.prepend(0);
        cl.printList();
        System.out.println("First node is = "+cl.removeFirst().value);
        cl.printList();
    }
}
