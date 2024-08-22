package DoublyLinkedList;

public class Main {
    public static void main(String[] args){
        DoubleLinkedList dll = new DoubleLinkedList(4);
        dll.prepend(5);
        dll.append(6);
        dll.append(7);
        dll.append(8);
        dll.append(9);
        dll.printList();
        dll.swapAdjacent();
//        dll.printList();
//        dll.set(2,7);
        dll.printList();
    }
}
