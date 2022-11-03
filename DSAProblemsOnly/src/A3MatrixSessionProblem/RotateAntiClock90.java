package A3MatrixSessionProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RotateAntiClock90 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);

        int[][] inputMatrix = new int[n][m];
        for (int i = 0; i < n; i++){
            String[] inputArray = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                inputMatrix[i][j] = Integer.parseInt(inputArray[j]);
        }

        int[][] transposeMatrix = null;
        TransposeMatrix(inputMatrix, n, m,transposeMatrix);
    }

    public static int[][] TransposeMatrix(int[][] inputMatrix, int n, int m, int[][] transposeeMatrix) {
//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//
//            }
//        }
        return  transposeeMatrix;
    }
}
