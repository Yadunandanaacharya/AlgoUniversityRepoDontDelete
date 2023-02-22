package LessonProblems.A3MatrixLessionProblem;

/*
3 4 3
1 2 3 4
5 6 7 8
9 10 11 12
ans: searching 3 is 0,2

Above matrix is sorted both row wise and column wise
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SearchInRowAndColSortedMatrix {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMInputArray = br.readLine().split(" ");
        int n = Integer.parseInt(nAndMInputArray[0]);
        int m = Integer.parseInt(nAndMInputArray[1]);
        int itemToBeSearched = Integer.parseInt(nAndMInputArray[2]);

        int[][] inputMatrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] inputArray = br.readLine().split(" ");
            for (int j = 0; j<m;j++){
                inputMatrix[i][j] = Integer.parseInt(inputArray[j]);
            }
        }

        /*start from top row right most corner move left if mat[i][j]>x
        move down if x>mat[i][j]
         */
        int i = 0; int j = m - 1;   //i-row, j-col
        while (i>=0 && j<m) {
            if (inputMatrix[i][j] == itemToBeSearched) {
                System.out.println("i at " + i + " and j at " + j);
                return;
            }

            if (inputMatrix[i][j] > itemToBeSearched)
                j--;
            else
                i++;
        }
    }
}
