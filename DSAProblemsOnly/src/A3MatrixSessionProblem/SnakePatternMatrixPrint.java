package A3MatrixSessionProblem;

/*
3 4
1 2 3 4
5 6 7 8
9 10 11 12

3 4
1 2 3
4 5 6 7
8 9
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SnakePatternMatrixPrint {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMArray = br.readLine().split(" ");
        int n = Integer.parseInt(nAndMArray[0]);
        int m = Integer.parseInt(nAndMArray[1]);

        int[][] inputMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputArrayMatrix = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                inputMatrix[i][j] = Integer.parseInt(inputArrayMatrix[j]);
            }
        }

        if (inputMatrix.length == 0 || inputMatrix[0].length == 0) {
            System.out.println("null");
        }
        else {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(inputMatrix[i][j] + " ");
                    }
                } else {
                    for (int j = m - 1; j >= 0; j--) {
                        System.out.print(inputMatrix[i][j] + " ");
                    }
                }
            }
        }
    }

}