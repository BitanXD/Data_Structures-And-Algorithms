package LinkedList;

public class LL_Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(6);
        ll.append(4);
        ll.append(7);
        ll.append(3);
        ll.append(5);
        ll.printLinkedList(); //original linkedlist
        System.out.println("The last element is = " + ll.removeLastNode().value); //last element of the linked list
        ll.prepend(2); // add a node at the beginning
        ll.printLinkedList(); // print new updated node
        System.out.println("The first element is = " + ll.removeFirst().value); // first element in the linked list
        System.out.println("The node at index 2 is = " + ll.get(2).value); // get a node from given index
        System.out.println("Set value status = " + ll.set(0, 3)); // set a node with given index and value
        ll.printLinkedList();
        System.out.println("5 is found at index = " + ll.searchValue(5));
        System.out.println("Insert Status at index 3 = " + ll.insert(3, 2));
        ll.printLinkedList();
        System.out.println("Element removed at index 2 = " + ll.removeNode(2).value);
        ll.printLinkedList();
        /*
        System.out.print("The original list is = ");
        ll.printLinkedList();

        ll.reverseList();
        System.out.print("The revered list is = ");
        ll.printLinkedList();
        */
        System.out.println("The 2nd element from the end is = "+ll.nthNodeFromEnd(2).value);

        LinkedList ll2 = new LinkedList(10);
        ll2.append(10);
        ll2.append(10);
        ll2.append(20);
        ll2.append(20);
        ll2.append(20);
        ll2.append(30);
        System.out.print("New Sorted List is = ");
        ll2.printLinkedList();
        System.out.print("List after removing duplicates = ");
        ll2.removeDuplicatesFromSortedList();
        System.out.println(ll2.insertNode(50));
        ll2.printLinkedList();
        System.out.println(ll2.insertNode(40));
        ll2.printLinkedList();
//        ll2.removeNodeFromValue(4);
//        ll2.printLinkedList();
//        System.out.println(ll2.detectLoop());
//        System.out.println(ll2.startingNodeOfLoop());
//        ll2.createLoop();
        System.out.println(ll2.detectLoop());
//        System.out.println(ll2.startingNodeOfLoop().value);
        ll2.reverseBetween(1,3);
        ll2.printLinkedList();

        LinkedList ll3 = new LinkedList(7);
        ll3.append(4);
        ll3.append(9);

        LinkedList ll4 = new LinkedList(5);
        ll4.append(6);

        ll3.addTwoLists(ll3.get(0), ll4.get(0)); // add two lists


        LinkedList ll5 = new LinkedList(4);
        ll5.append(3);
        ll5.append(1);
        ll5.append(7);
        ll5.append(2);
        System.out.println("Unsorted List");
        ll5.printLinkedList();

        System.out.println("Sorted List");
        ll5.sortList(ll5.get(0));
        ll5.printLinkedList();
    }
}
