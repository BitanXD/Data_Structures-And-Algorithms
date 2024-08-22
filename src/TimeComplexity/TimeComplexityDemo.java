package TimeComplexity;

public class TimeComplexityDemo {
    public static void main(String[] args){
        double now = System.currentTimeMillis();
        TimeComplexityDemo demo = new TimeComplexityDemo();
        int result1 = demo.findSum(999999);
        System.out.println("TIme taken is " + (System.currentTimeMillis()-now) + " millisecond");
    }
//    the below code will take less time

    public int findSum(int n){
        return n*(n+1)/2;
    }
//the below code will take more time than the above code function

//    public int findSum(int n){
//        int sum = 0;
//        for(int i = 1; i <= n; i++){
//            sum+=i;
//        }
//        return sum;
//    }
}

//Space complexity is the amount of space or memory taken by the algorithm to run