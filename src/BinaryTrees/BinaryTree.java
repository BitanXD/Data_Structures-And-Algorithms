package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private Node root;

    private class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);
        Node sixth = new Node(6);
        Node seventh = new Node(7);


        root = first;

        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.left = sixth;
        third.right = seventh;
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void iterativePreOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public void iterativeInOrder(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public void iterativePostOrder(Node root){
        Node current = root;
        Stack<Node> stack = new Stack<>();

        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }else{
                    current = temp;
                }
            }
        }
    }

    public void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    public int findMax(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result){
            result = left;
        }
        if(right > result){
            result = right;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.println("Pre Order traversal (Recursive method): ");
        bt.preOrder(bt.root);
        System.out.println("\nIterative Pre Order traversal: ");
        bt.iterativePreOrder(bt.root);
        System.out.println("\nIn Order traversal: ");
        bt.inOrder(bt.root);
        System.out.println("\nIterative In Order traversal: ");
        bt.iterativeInOrder(bt.root);
        System.out.println("\nPost Order traversal: ");
        bt.postOrder(bt.root);
        System.out.println("\nIterative Post Order traversal: ");
        bt.iterativePostOrder(bt.root);
        System.out.println("\nLevel Order traversal: ");
        bt.levelOrderTraversal(bt.root);
        System.out.println("\nMaximun value in the tree is: "+ bt.findMax(bt.root));

    }
}
