package Arrays;

public class StackMain {
    public static void main(String[] args){
        StackUsingArray sa = new StackUsingArray(3);
        sa.push(1);
        sa.push(2);
        sa.push(3);
//        sa.push(4); throws run time exception as stack is already full
        sa.printStack();
        System.out.println(sa.pop());
        sa.printStack();
        System.out.println(sa.peek());
        sa.reverseStringUsingStack("Bitan");
        int[] arr = {4,7,3,4,8,1};
        System.out.println("Input Array : ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int[] resultArr = sa.nextGreaterElement(arr);
        System.out.println("Output Array : ");
        for(int i : resultArr){
            System.out.print(i + " ");
        }
    }
}
