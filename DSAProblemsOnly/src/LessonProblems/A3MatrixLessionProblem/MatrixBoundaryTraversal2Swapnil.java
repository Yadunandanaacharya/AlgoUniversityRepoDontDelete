package LessonProblems.A3MatrixLessionProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
3 4
1 2 3 4
5 6 7 8
9 10 11 12

 */

public class MatrixBoundaryTraversal2Swapnil {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        int[][] inputMatrix2dArray = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] inputArrayLine = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                inputMatrix2dArray[i][j] = Integer.parseInt(inputArrayLine[j]);
            }
        }

        if (inputMatrix2dArray.length == 0 || inputMatrix2dArray[0].length == 0)
            System.out.println("null");
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                        System.out.print(inputMatrix2dArray[i][j] + " ");
                    } else
                        System.out.print("");
                }
            }
        }
    }
}
