package Recursion;

public class StreamOfChar {
    public static void main(String[] args){
        skip("","bcaacdahd");
        System.out.println(skip("bcaacgascd"));
        System.out.println(skipWord("beginapplebitanapple"));
    }
    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p,up.substring(1));
        }else{
            skip(p + ch, up.substring(1));
        }
    }

    static String skip(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skip(up.substring(1));
        }else{
            return ch + skip(up.substring(1));
        }
    }

    static String skipWord(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipWord(up.substring(5));
        }else{
            return up.charAt(0) + skipWord(up.substring(1));
        }
    }
}
