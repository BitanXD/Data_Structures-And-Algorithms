package Recursion;

public class isPalindrome {
    public static void main(String[] args){
        System.out.println(isPalin(121));
    }
    static int reverse(int n){
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
    static boolean isPalin(int n){
        return n == reverse(n);
    }
}
