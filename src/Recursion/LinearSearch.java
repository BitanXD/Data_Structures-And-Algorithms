package Recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args){
        int[] array = {1,3,5,18,9,2,5,2,5};
        int target = 5;
//        if(linearSearch(array, target, 0)){
//            System.out.println("Target Found at Index " + findIndex(array, target, 0));
//        }else{
//            System.out.println("Target Not Found");
//        }
//        findAllIndex(array, target, 0);
//        System.out.println("All index of 5 are");
//        System.out.println(list);
        System.out.println(findAllIndex(array, target, 0, new ArrayList<>()));
    }
    static boolean linearSearch(int[] array, int target, int index){
        if(index == array.length){
            return false;
        }
        return array[index] == target || linearSearch(array, target, index + 1);
    }

    static int findIndex(int[] array, int target, int index){
        if(index == array.length){
            return -1;
        }
        if(array[index] == target){
            return index;
        }else{
            return findIndex(array, target, index + 1);
        }
    }
    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] array, int target, int index){
        if(index == array.length){
            return;
        }
        if(array[index] == target){
            list.add(index);
        }
        findAllIndex(array, target, index + 1);
    }

    static ArrayList<Integer> findAllIndex(int[] array, int target, int index, ArrayList<Integer> list){
        if(index == array.length){
            return list;
        }
        if(array[index] == target){
            list.add(index);
        }
        return findAllIndex(array, target, index + 1, list);
    }
}
