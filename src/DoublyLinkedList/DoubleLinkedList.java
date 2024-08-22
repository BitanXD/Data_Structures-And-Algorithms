package DoublyLinkedList;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }
    public DoubleLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //printing the double linked list
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    //append a new node
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0){
            return null;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    //prepend a node
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    //remove first node from the double linked list
    public Node removeFirst(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;

        if(length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    //get a node from a given index
    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index < length/2){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else{
            temp = tail;
            for(int i = length-1; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }

    //set a node where index and value is given(this is a update function)
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    //insert a node at given index
    public boolean insert(int index, int value){
        if(index < 0 || index > length){
            return false;
        }
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);// this is the new node
        Node before = get(index-1); // this will return the node just before the given index
        Node after = before.next; // this is the node at index

        // newNode will go between before and after

        newNode.next = after;
        newNode.prev = before;
        before.next = newNode;
        after.prev = newNode;
        length++;

        return true;
    }

    //swap first and last nodes values i.e head = tail and tail = head
    //if length is less than 2 then do not perform the operation
    public void swapValues(){
        if(length < 2){
            return;
        }
        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    // reverse the double linked list
    public void reverseList(){
        Node current = head;
        Node temp = null;
        while(current != null){
            temp = current.prev; //this stores the previous pointer of current node
            current.prev = current.next; // pointer of previous node is set to pointer of next node
            current.next = temp; // pointer of next node  is set to pointer of previous node
            current = current.prev; // current node is moved one step ahead in the list
        }
        // now perform swap of head and tail pointers
        temp = head;
        head = tail;
        tail = temp;
    }
    //check for palindrome (should read same forward and backward)
    public boolean isPalindrome(){
        if(length <= 1){
            return true;
        }
        Node forward = head;
        Node backward = tail;
        for(int i = 0; i< length/2; i++){
            if(forward.value != backward.value){
                return false;
            }
            forward = forward.next;
            backward = backward.prev;
        }
        return true;
    }
    //swap nodes in pair i.e swap the values of the adjacent nodes in the linked list

    public void swapAdjacent(){
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        while (head != null && head.next != null){
            Node firstNode = head;
            Node secondNode = head.next;

            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            secondNode.prev = previousNode;
            firstNode.prev = secondNode;

            if(firstNode.next != null){
                firstNode.next.prev = firstNode;
            }

            head = firstNode.next;
            previousNode = firstNode;
        }
        head = dummyNode.next;
        if(head != null){
            head.prev = null;
        }
    }
}
