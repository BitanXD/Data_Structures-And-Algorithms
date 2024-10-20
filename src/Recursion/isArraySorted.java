package Recursion;

public class isArraySorted {
    public static void main(String[] args){
        /*
        int[] array = {1,2,3,4,5,6}; // array is sorted
//        int[] array = {1,5,3,4,5,6}; // array is not sorted
        int flag = 1;
        for (int i = 0; i < array.length - 1; i++){
            if(array[i] <= array[i + 1]){
                continue;
            }else {
                flag = 0;
                break;
            }
        }
        if(flag == 1){
            System.out.println("Array is sorted");
        }else{
            System.out.println("Array is not sorted");
        }

         */

//        int[] array = {1,2,3,4,5,6}; // array is sorted
        int[] array = {1,5,3,4,5,6}; // array is not sorted
        if(isSorted(array, 0)){
            System.out.println("Array is sorted");
        }else{
            System.out.println("Array is not sorted");
        }
    }
    static boolean isSorted(int[] array, int index){
        if(index == array.length - 1){
            return true;
        }
        return array[index] < array[index + 1] && isSorted(array, index + 1);
    }
}
