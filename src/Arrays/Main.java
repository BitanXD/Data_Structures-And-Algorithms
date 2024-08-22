package Arrays;
import java.util.*;
import java.math.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //array declaration and initialisation
//        int[] array = new int[5];
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] array1 = new int[n];
//        array = new int[5];
        System.out.println("Enter the array elements: ");
        for(int i = 0; i< array1.length; i++){
            array1[i] = sc.nextInt();
        }
        printArray(array1);
//        removeEven(array1);
//        reverseArray(array1);
//        minimumValue(array1);
//        findSecondMax(array1);
//        moveZeroesToEnd(array1);
//        missingNumber(array1);
        rotateArray(array1,3);
    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void removeEven(int[] array){
        int countOdd = 0;
        for(int i : array){
            if(i % 2 != 0){
                countOdd++;
            }
        }
        int[] newArr = new int[countOdd];
        int index = 0;
        for(int i : array){
            if(i % 2 != 0){
                newArr[index++] = i;
            }
        }
        printArray(newArr);
    }
    public static void reverseArray(int[] array){
//        int start = 0;
//        int end = array.length;
        for(int start = 0, end = array.length-1; start < end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        printArray(array);
    }
    public static void minimumValue(int[] array){
        int minimum = Integer.MAX_VALUE;
        for(int i : array){
            if(i < minimum){
                minimum = i;
            }
        }
        System.out.println("The Minimum value in the array is = "+minimum);
    }
    public static void findSecondMax(int[] array){
        int maximum = Integer.MIN_VALUE;
        int secondMaximum = Integer.MIN_VALUE;
        for(int i : array){
            if(i > maximum){
                secondMaximum = maximum;
                maximum = i;
            }else if(i > secondMaximum && i != maximum){
                secondMaximum = i;
            }
        }
        System.out.println("The Second Maximum value in the array is = "+secondMaximum);
    }
    public static void moveZeroesToEnd(int[] array){
        int j = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0 && array[j] == 0){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            if(array[j] != 0){
                j++;
            }
        }
        printArray(array);
    }
// Given an array of n-1 distinct numbers in the range of 1 to n. Find the missing number in it.
    public static void missingNumber(int[] array){
        int missing;
        int n = array.length + 1;
        int sumOrg = n * (n + 1) / 2;
        System.out.println(sumOrg);
        missing = sumOrg;
        for(int i : array){
            missing = missing - i;
        }
        System.out.println("The missing number in the array is = "+ missing);
    }
//rotate array on the given index point
    public static void rotateArray(int[] array, int k){
        k = k % array.length;
        for(int start = 0, end = array.length-k-1; start < end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }for(int start = array.length-k, end = array.length-1; start < end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }for(int start = 0, end = array.length-1; start < end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        printArray(array);
    }
}
