package Strings;
import java.util.*;
public class Palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String to check if it is Palindrome or not : ");
        String input = sc.nextLine();
        input = input.toLowerCase();
        if(isPalindrome(input)){
            System.out.println("Yes it is Palindrome");
        }else{
            System.out.println("No it is not Palindrome");
        }
    }
    public static boolean isPalindrome(String s){
        char[] charArr = s.toCharArray();
        int start = 0;
        int end = charArr.length-1;
        while(start++ < end--){
            if(charArr[start] != charArr[end]){
                return false;
            }
//            start++;
//            end--;
        }
        return true;
    }
}
