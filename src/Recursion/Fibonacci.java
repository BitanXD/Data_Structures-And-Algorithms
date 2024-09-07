package Recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which fibonacci number do you want to find? ");
        int num = sc.nextInt();
        int result = findNthFibonacci(num);
        System.out.println("Result = " + result);
    }
    static int findNthFibonacci(int n){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
    }
}
