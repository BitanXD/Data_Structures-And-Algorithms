package Arrays;

import java.util.Stack;

// stack follows LIFO - Last In First Out
public class StackUsingArray {
    private int top;
    private int[] arr;

    public StackUsingArray(int capacity){
        top = -1;
        arr = new int[capacity];
    }
    public StackUsingArray(){
        this(10);
    }

    public void printStack(){
        for(int i = 0; i <= top; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void push(int value){
        if(isFull()){
            throw new RuntimeException("Stack is full !!!");
        }
        top++;
        arr[top] = value;
    }
    public boolean isFull(){
        return arr.length == size();
    }
    public int size(){
        return top + 1;
    }
// remove top element
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty !!!");
        }
//        return arr[top--];
        int result = arr[top];
        top--;
        return result;
    }
    public boolean isEmpty(){
        return top < 0;
    }
// return value at the top index
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty !!");
        }
        return arr[top];
    }

    public void reverseStringUsingStack(String str){
        Stack<Character> stack = new Stack<>();
        char[] chr = str.toCharArray();
        for(char c : chr){
            stack.push(c);
        }
        for(int i = 0; i < str.length(); i++){
            chr[i] = stack.pop();
        }
        System.out.println("Before Reverse String was = " + str);
        System.out.println("After Reverse String is = " + new String(chr));
    }

    // for each element in the array find the next greater element in that array.
    // the next greater element is the first element to the right which is greater
    // than the current element. if no greater element return -1 in the array in that place.

    public int[] nextGreaterElement(int[] arr){
        int[] resultArr = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i >= 0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= arr[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                resultArr[i] = -1;
            }else{
                resultArr[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return resultArr;
    }

    // valid / balanced parenthesis checker
    // 1. (()) ---> valid
    // 2. ((()) -----> not valid
    // 3. )(( ------> not valid

    public boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    char top = stack.peek();
                    if( c == ')' && top == '('){
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public void sortStack(Stack<Integer> stack){
        Stack<Integer> additionalStack = new Stack<>();
        while(!stack.isEmpty()){
            int temp = stack.pop();

            while(!additionalStack.isEmpty() && additionalStack.peek() > temp){
                stack.push(additionalStack.pop());
            }
            additionalStack.push(temp);
        }
        while(!additionalStack.isEmpty()){
            stack.push(additionalStack.pop());
        }
    }
}
