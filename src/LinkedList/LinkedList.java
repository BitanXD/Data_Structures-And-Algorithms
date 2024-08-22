package LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //printing
    public void printLinkedList(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    //appending new node
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    //remove last node
    public Node removeLastNode(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
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
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    //remove first Node
    public Node removeFirst(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    // get a node value from the given index
    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    // set a value at a given index
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }else{
            return false;
        }
    }

    // searching a node from given value
    public int searchValue(int value){
        Node temp = head;
        int index = -1;
        while(temp != null){
            index++;
            if(value == temp.value){
                return index;
            }
            temp = temp.next;
        }
        return -1;
    }

    //insert a node at given index, value also given
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
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    //remove a node from given index
    public Node removeNode(int index){
        if(index < 0 || index > length){
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == length){
            return removeLastNode();
        }
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    //reverse the linkedList
    public void reverseList(){
        Node current = head;
        head = tail;
        tail = current;
        Node previous = null;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
    }

    //find nth node from the end of the list
    public Node nthNodeFromEnd(int n){
        Node fast = head;
        Node slow = head;
        int index = 0;
        while(index++ < n){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public Node sortList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;

        Node left = sortList(head);
        Node right = sortList(slow);

        return merge(left,right);
    }

    public Node merge(Node list1, Node list2){
        Node sorted_temp = new Node(0);
        Node current_node = sorted_temp;

        while(list1 != null && list2 != null){
            if(list1.value < list2.value){
                current_node.next = list1;
                list1 = list1.next;
            }else{
                current_node.next = list2;
                list2 = list2.next;
            }
            current_node = current_node.next;
        }
        if(list1 != null){
            current_node.next = list1;
            list1 = list1.next;
        }if(list2 != null){
            current_node.next = list2;
            list2 = list2.next;
        }
        return sorted_temp.next;
    }

    //remove duplicates from a sorted linked list
    public void removeDuplicatesFromSortedList(){
        Node current = head;
        while(current != null && current.next != null){
            if(current.value == current.next.value){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        printLinkedList();
    }

    //insert a node with given value only in a sorted linked list
    public boolean insertNode(int value){
        if(head == null){
            prepend(value);
            return true;
        }
        Node newNode = new Node(value);
        Node current = head;
        Node temp = null;
        while (current != null && current.value < value){
            temp = current;
            current = current.next;
        }
        temp.next = newNode;
        newNode.next = current;
        return true;
    }

    //remove a node with the value given to be removed from the list
    public Node removeNodeFromValue(int value){
        if(head == null){
            return null;
        }
        Node current = head;
        Node temp = null;
        while (current != null && current.value != value){
            temp = current;
            current = current.next;
        }
        temp.next = current.next;
        return temp;
    }

    //detect a loop in a linked list
    public boolean detectLoop(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    //find the starting node of a loop in a linked list
    //Floyd's Cycle Detection algorithm
    public Node startingNodeOfLoop(){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                //here slow pointer contains the meeting location of slow and fast
                //to find the starting of the loop we need to find temp == slow by iterating throughout
                //the list moving both temp and slow by one step untill they meet
                Node temp = head;
                while(slow != temp){
                    temp = temp.next;
                    slow = slow.next;
                }
                removeLoop(slow);
                return slow;
            }
        }
        return null;
    }

    //remove loop from a looped linked list
    public void removeLoop(Node slow){
        Node temp = head;
        while(slow.next != temp.next){
            temp = temp.next;
            slow = slow.next;
        }
        slow.next = null;
    }

    //creating a random loop on user choice basis

    public void createLoop(){
        Node loppInitiate = get(4);
        Node loopEnd = get(1);
        loppInitiate.next = loopEnd;
    }

    //reverse a list between the given indexes
    public void reverseBetween(int start, int end){
        if(head == null){
            return;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        Node previous = dummy;
        // below loop moves the previous node just before the start index of the sub-list
        for(int i = 0;i < start; i++){
            previous = previous.next;
        }
        Node current = previous.next; // this is equal to the start index/node of the sub-ist
        for(int i = 0;i < end - start; i++){
            Node temp = current.next;
            current.next = temp.next;
            temp.next = previous.next;
            previous.next = temp;
        }
        head = dummy.next;
    }

    //add two numbers using linked list
//    the numbers are stored in reverse order i.e
//    list 1 = 1->2->3  the number is 321
//    list 2 = 4->5->6  the number is 654
//    and the resulting sum will be 321 + 654 = 975
    public void addTwoLists(Node list1, Node list2){
        Node dummy = new Node(0);
        Node endNode = dummy;
        int carry = 0;
        while(list1 != null || list2 != null){
            int x = (list1 != null) ? list1.value : 0;
            int y = (list2 != null) ? list2.value : 0;
            int sum = carry + x + y;
            carry = sum/10;
            endNode.next = new Node(sum % 10);
            endNode = endNode.next;
            if(list1 != null){
                list1 = list1.next;
            }if(list2 != null){
                list2 = list2.next;
            }
        }
        if(carry > 0){
            endNode.next = new Node(carry);
        }
        head = dummy.next;
        printLinkedList();
    }
}