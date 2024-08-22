package Strings;
import java.util.*;
import java.util.Arrays;
public class StringEncoding {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to encode: ");
        String input = sc.nextLine();
        encodeString(input);
    }
    public static void encodeString(String input){
        char[] eachChar = input.toCharArray();
        String newStr = "";
        int count = 1;
        char prev_chr = eachChar[0];
        char[] copyEachChar = Arrays.copyOfRange(eachChar,1,eachChar.length);
        for(char chr : copyEachChar){
            if(chr == prev_chr){
                count++;
            }else{
                newStr = newStr + Integer.toString(count) + prev_chr;
                count = 1;
                prev_chr = chr;
            }
        }
        newStr = newStr + Integer.toString(count) + prev_chr;
        System.out.println("The Encoded String is: "+newStr);
    }
}
