package Stack;
//Stack follows LIFO data structure i.e Last In First Out
public class Main {
    public static void main(String[] args){
        Stack s = new Stack(0);
        s.push(1);
        s.printStack();
        System.out.println(s.pop().value);
        System.out.println(s.pop().value);
        s.push(1);
        s.printStack();
    }
}
