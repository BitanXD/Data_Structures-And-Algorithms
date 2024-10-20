package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] array = {4,3,2,1};
        sort(array, array.length - 1, 0);
        System.out.println(Arrays.toString(array));
    }
    static void sort(int[] array, int row, int col){
         if(row == 0){
             return;
         }
         if(col < row){
             if(array[col] > array[col + 1]){
                 //swap
                 int temp = array[col];
                 array[col] = array[col + 1];
                 array[col + 1] = temp;
             }
             sort(array, row, col + 1);
         }else{
             sort(array, row - 1, 0);
         }
    }
}
