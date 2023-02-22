package ContestProblems.Contest2Matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p34TOEPLITZ {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputString = br.readLine().split(" ");
        int n = Integer.parseInt(inputString[0]);
        int m = Integer.parseInt(inputString[1]);

        int[][] input2dMatrix = new int[n][m];
        for (int i = 0; i<input2dMatrix.length;i++){
            String[] input2dArrayContents = br.readLine().split(" ");
            for(int j= 0;j<input2dMatrix[i].length;j++) {
                input2dMatrix[i][j] = Integer.parseInt(input2dArrayContents[j]);
            }
        }

        for (int i = 2; i<n;i++){
            for(int j= 0;j<2;j++) {
                if ((i == n-1 && j==0) || (i==0 && j==m-1)) {
                    continue;
                }
//                if (input2dMatrix[i][j] == )
            }
        }

    }
}
