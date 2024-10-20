package Recursion;

public class RotatedBinarySearch {
    public static void main(String[] args){
        int[] array = {5,6,7,8,9,1,2,3};
        System.out.println(rbs(array, 5, 0, array.length - 1));
    }
    static int rbs(int[] array, int target, int start, int end){
        int middle = start + (end - start) / 2;
        if(start > end){
            return -1;
        }
        if(target == array[middle]){
            return middle;
        }
        if(array[start] <= array[middle]){
            if(target >= array[start] && target <= array[middle]){
                return rbs(array, target, start, middle - 1);
            }else{
                return rbs(array, target, middle + 1, end);
            }
        }
        if(target >= array[middle] && target <= array[end]){
            return rbs(array, target, middle + 1, end);
        }
        return rbs(array, target, start, middle - 1);
    }
}
