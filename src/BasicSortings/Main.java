package BasicSortings;

public class Main {
    public static void main(String[] args) {
        SelectionSort sortS = new SelectionSort();
        BubbleSort sortBS = new BubbleSort();
        MergeSort sortMS = new MergeSort();
        int[] array = {4, 2, 6, 5, 1, 3};
        System.out.println("Before Sorting: ");
        for (int k : array) {
            System.out.print(k + " ");
        }
//        sortS.selectionSort(array);
//        sortBS.bubbleSort(array);
        int[] resultArray = sortMS.mergeSort(array);
        System.out.println("\nAfter Sorting: ");
        for (int j : resultArray) {
            System.out.print(j + " ");
        }
    }
}
