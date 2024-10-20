package Recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args){
        int[] array = {1,4,2,3,5};
        sort(array, array.length - 1, 0, 0);
        System.out.println(Arrays.toString(array));
    }
    static void sort(int[] array, int row, int col, int max){
        if(row == 0){
            return;
        }
        if(col < row){
            if(array[col] > array[max]){
                sort(array, row, col + 1, col);
            }else{
                sort(array, row, col + 1, max);
            }
        }else{
//            swap
            int temp = array[max];
            array[max] = array[row - 1];
            array[row - 1] = temp;
            sort(array, row - 1, 0, 0);
        }
    }
}
