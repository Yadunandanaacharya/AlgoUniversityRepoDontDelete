package A3MatrixSessionProblem;


/*
3 4
1 2 3 4
5 6 7 8
9 10 11 12

ans:
1 5 9
2 6 10
3 7 11
4 8 12


3 3
1 2 3
4 5 6
7 8 9

ans:
1 4 7
2 5 8
3 6 9
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TransposeMatrix1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nandM = br.readLine().split(" ");
        int n = Integer.parseInt(nandM[0]);
        int m = Integer.parseInt(nandM[1]);

        int[][] inputMatrix = new int[n][m];
        for(int i = 0; i < n;i++){
            String[] inputArray = br.readLine().split(" ");
            for(int j = 0; j <m; j++) {
                inputMatrix[i][j] = Integer.parseInt(inputArray[j]);
            }
        }

        int[][] transposedMatrix = new int[m][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j <m; j++) {
                transposedMatrix[j][i] = inputMatrix[i][j];
            }
        }

        for(int i = 0; i < transposedMatrix.length;i++){
            for(int j = 0; j <transposedMatrix[i].length; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
