package BinaryTrees;

public class BinarySearchTree {
    private TreeNode root;

    public class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }
    public void insertNode(int value){
        root = insert(root, value);
    }
    public TreeNode insert(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
        }
        return root;
    }
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+ " ");
        inOrder(root.right);
    }
    public TreeNode search(TreeNode root, int key){
        if(root == null || root.data == key){
            return root;
        }
        if(key < root.data){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }
    boolean isValidBst(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }
        boolean left = isValidBst(root.left, min, root.data);
        if(left){
            boolean right = isValidBst(root.right, root.data, max);
            return right;
        }
        return false;
    }
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(5);
        bst.insertNode(7);
        bst.insertNode(3);
        bst.insertNode(8);
        System.out.println("In order Tree traversal: ");
        bst.inOrder();
        System.out.println();
        if(null != bst.search(bst.root, 4)){
            System.out.println("Key is found");
        }else {
            System.out.println("Key is not found");
        }
        if(bst.isValidBst(bst.root, Long.MIN_VALUE, Long.MAX_VALUE)){
            System.out.println("BST is valid");
        }else {
            System.out.println("BST is not valid");
        }
    }
}
