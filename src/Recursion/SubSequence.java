package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args){
//        subSet("","abc");
//        System.out.println(subSetReturn("", "abc"));
        char ch = 'a';
//        System.out.println((int)(ch)); // 97
//        System.out.println((ch + 0)); // 97
        System.out.println(subSetReturnAscii("", "abc"));
    }
    static void subSet(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSet(p + ch, up.substring(1));
        subSet(p, up.substring(1));
    }

    static ArrayList<String> subSetReturn(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left =  subSetReturn(p + ch, up.substring(1));
        ArrayList<String> right = subSetReturn(p, up.substring(1));

        left.addAll(right);
        return left;
    }
    static ArrayList<String> subSetReturnAscii(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left =  subSetReturnAscii(p + ch, up.substring(1));
        ArrayList<String> right = subSetReturnAscii(p, up.substring(1));
        ArrayList<String> ascii = subSetReturnAscii(p + (int)(ch), up.substring(1));

        left.addAll(right);
        left.addAll(ascii);
        return left;
    }
}
