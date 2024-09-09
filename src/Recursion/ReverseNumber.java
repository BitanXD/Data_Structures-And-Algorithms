package Recursion;

public class ReverseNumber {
    public static void main(String[] args){
//        reverseNum(123);
//        System.out.println(sum);
        System.out.println(reverseNum2(1234));
    }
    static int sum = 0;
    static void reverseNum(int n){
        if(n == 0){
            return;
        }
        int remainder = n % 10;
        sum = sum * 10 + remainder;
        reverseNum(n / 10);
    }


    static int reverseNum2(int n) {
        int digits = (int)Math.log10(n) + 1;
        return helper(n, digits);
    }
    private static int helper(int n, int digits){
        if(n % 10 == n){
            return n;
        }
        int remainder = n % 10;
        return remainder * (int)Math.pow(10, digits - 1) + helper(n / 10, digits - 1);
    }
}
