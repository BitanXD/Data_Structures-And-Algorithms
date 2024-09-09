package Recursion;

public class ProductOfDigits {
    public static void main(String[] args){
        System.out.println(proDigits(12345));
    }
    static int proDigits(int n){
        if(n % 10 == n){
            return n;
        }
        return n % 10 * proDigits(n / 10);
    }
}
