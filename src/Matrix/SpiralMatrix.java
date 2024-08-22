package Matrix;

import java.util.Scanner;

public class SpiralMatrix {
    public void printSpiral(int[][] matrix, int row, int column){
        int i, k = 0, l = 0;
        while(k < row && l < column){
            for(i = )
        }
    }

    public static void main(String[] arge){
        Scanner sc = new Scanner(System.in);

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        SpiralMatrix obj = new SpiralMatrix();
        obj.printSpiral(matrix, 4, 4);
    }
}
