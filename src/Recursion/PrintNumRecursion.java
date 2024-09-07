package Recursion;

public class PrintNumRecursion {
    public static void main(String[] args) {
        print(1);
    }
    static void print(int n){
//        System.out.println(n);
        if(n == 5){
            return;
        }
        System.out.println(n);
        print(n + 1);
    }
}
