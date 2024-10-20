package Backtracking.MazeProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeProblem {
    public static void main(String[] args){
        // printing the no of ways to move from first box to the last box
        // movement allowed only right and down
//        System.out.println(countNoOfPaths(3,3));

        // print the paths in which we can travel
//        path("",3,3);

        //print path as a list
//        System.out.println(pathReturn("",3,3));

        //print path when diagonal movement is allowed
//        pathDiagonal("",3,3);

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        // print path with obstacles
//        pathWithObstacles("", maze, 0, 0);
        // print path with obstacles in a arraylist
//        System.out.println(pathWithObstaclesReturn("", maze, 0, 0));
//        allPath("", maze, 0, 0);


        // print the all paths in a matrix format
        int[][] path = new int[maze.length][maze[0].length];
        allPathMatrix("", maze, path, 0, 0, 1);
    }

    static int countNoOfPaths(int row, int col){
        if( row == 1 || col == 1){
            return 1;
        }
        int left = countNoOfPaths(row - 1, col);
        int right = countNoOfPaths(row, col - 1);

        return left + right;
    }

    static void path(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }
        if(row > 1){
            path(p+'D', row - 1, col);
        }
        if(col > 1){
            path(p+'R', row, col - 1);
        }
    }

    static ArrayList<String> pathReturn(String p, int row, int col){
        if(row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(row > 1){
            list.addAll(pathReturn(p+'D', row - 1, col));
        }
        if(col > 1){
            list.addAll(pathReturn(p+'R', row, col - 1));
        }
        return list;
    }

    static void pathDiagonal(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }
        if(row > 1){
            pathDiagonal(p+'D', row - 1, col);
        }
        if(col > 1){
            pathDiagonal(p+'R', row, col - 1);
        }
        if(row > 1 && col > 1){
            pathDiagonal(p+'d', row - 1, col - 1);
        }
    }

    static void pathWithObstacles(String p, boolean[][] maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        if(row < maze.length - 1){
            pathWithObstacles(p+'D', maze, row + 1, col);
        }
        if(col < maze[0].length - 1){
            pathWithObstacles(p+'R', maze, row, col + 1);
        }
    }

    static ArrayList<String> pathWithObstaclesReturn(String p, boolean[][] maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(!maze[row][col]){
            return list;
        }
        if(row < maze.length - 1){
            list.addAll(pathWithObstaclesReturn(p+'D', maze, row + 1, col));
        }
        if(col < maze[0].length - 1){
            list.addAll(pathWithObstaclesReturn(p+'R', maze, row, col + 1));
        }
        return list;
    }

    static  void allPath(String p, boolean[][]maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        // i am considering this block in my path
        maze[row][col] = false;

        if(row < maze.length - 1){
            allPath(p + 'D', maze, row + 1, col);
        }
        if(col < maze[0].length - 1){
            allPath(p + 'R', maze, row, col + 1);
        }
        if(row > 0){
            allPath(p + 'U', maze, row - 1, col);
        }
        if(col > 0){
            allPath(p + 'L', maze, row, col - 1);
        }

        // this line is where the function will be over so before the function gets removed
        // also remove the changes that were made by the function - this is backtracking

        maze[row][col] = true;
    }

    static void allPathMatrix(String p, boolean[][] maze, int[][]path, int row, int col, int step){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            path[row][col] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
        }
        if(!maze[row][col]){
            return;
        }
        // i am considering this block in my path
        maze[row][col] = false;
        path[row][col] = step;

        if(row < maze.length - 1){
            allPathMatrix(p + 'D', maze, path, row + 1, col, step + 1);
        }
        if(col < maze[0].length - 1){
            allPathMatrix(p + 'R', maze, path, row, col + 1, step + 1);
        }
        if(row > 0){
            allPathMatrix(p + 'U', maze, path, row - 1, col, step + 1);
        }
        if(col > 0){
            allPathMatrix(p + 'L', maze, path, row, col - 1, step + 1);
        }

        // this line is where the function will be over so before the function gets removed
        // also remove the changes that were made by the function - this is backtracking

        maze[row][col] = true;
        path[row][col] = 0;
    }
}
