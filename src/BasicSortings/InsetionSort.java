package BasicSortings;

import java.util.Arrays;

public class InsetionSort {
    public static void main(String[] args){
        int[] array = {5,4,3,2,1,6};
        sort(array);
    }
    static void sort(int[] array){
        int size = array.length;
        for(int step = 1;step < size;step++){
            int key = array[step];
            int j = step - 1;

            while(j >= 0 && key <= array[j]){
                array[j+1] = array[j];
                --j;
            }
            array[j+1] = key;
        }
        System.out.println(Arrays.toString(array));
    }
}
