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
//        if(n == 1){
//            return 1;
//        }
//        if(n == 0){
//            return 0;
//        }
        if(n < 2){
            return n;
        }
        return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
    }
}
// 0 , 1 , 1 , 2 , 3 , 5 , 8 , 13 , 21 , ...