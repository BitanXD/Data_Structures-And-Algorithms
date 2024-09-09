package Recursion;

public class N_to_1 {
    public static void main(String[] args){
//        func1(5);
        func2(5);
    }
    static void func1(int n){
        if( n == 0 ){
            return;
        }
        System.out.println(n);
        func1(n-1);
    }
    /*
    * output:
    * 5
    * 4
    * 3
    * 2
    * 1
     */
    static void func2(int n){
        if( n == 0 ){
            return;
        }
        func2(n-1);
        System.out.println(n);
    }
    /*
     * output:
     * 1
     * 2
     * 3
     * 4
     * 5
     */
}
