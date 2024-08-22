package Matrix;

import java.util.Scanner;

public class SpiralMatrix {
    public void printSpiral(int[][] matrix, int row, int column){
        int i, k = 0, l = 0;
        while(k < row && l < column){
            for(i = l; i < column; i++){  // left to right
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            for(i = k; i < row; i++){   // top to bottom
                System.out.print(matrix[i][column-1] + " ");
            }
            column--;
            if(k < row){
                for(i = column - 1; i >= l; i--){   // right to left
                    System.out.print(matrix[row - 1][i] + " ");
                }
                row--;
            }
            if(l < column){
                for(i = row - 1; i >= k; i--){   // bottom to top
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args){
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
