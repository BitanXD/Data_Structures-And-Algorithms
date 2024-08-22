package Matrix;

import java.util.Scanner;

public class SearchInSortedMatrix {

    public void search(int[][] matrix, int n, int x){
        int i = 0;
        int j = n - 1;
        while(i < n && j >= 0){
            if( matrix[i][j] == x){
                System.out.println(x + " is found at location " + i + "," + j);
                return;
            }
            if(matrix[i][j] > x){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Value not found");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 51}
        };
        int value;
        System.out.print("Enter the number to search: ");
        value = sc.nextInt();
    SearchInSortedMatrix obj = new SearchInSortedMatrix();
    obj.search(matrix, matrix.length, value);
    }


}
