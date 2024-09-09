package Recursion;

public class CountZeros {
    public static void main(String[] args){
        int count = 0;
        int result = countZeros(203020, count);
        System.out.println(result);
    }
    static int countZeros(int n, int count){
        if(n == 0){
            return count;
        }
        if(n % 10 == 0){
            return countZeros(n / 10, count + 1);
        }
        return countZeros(n / 10, count);
    }
}
