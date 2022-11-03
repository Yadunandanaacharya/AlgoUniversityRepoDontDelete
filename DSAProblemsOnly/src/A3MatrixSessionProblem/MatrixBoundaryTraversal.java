package A3MatrixSessionProblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
3 4
1 2 3 4
5 6 7 8
9 10 11 12

3 4
1 2 3
4 5 6 7
8 9

some test cases
1 4
1 2 3 4

ans: 1 2 3 4

4 1
1
2
3
4

ans: 1 2 3 4
 */

public class MatrixBoundaryTraversal {
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

        HashSet<Integer> boundaryItems = new HashSet<>();
        for (int i = 0; i < n;i++) {
            for(int j = 0; j < m; j++) {
                if (i==0 || j == 0 || i == n-1 || j == m-1){
                    if (!boundaryItems.contains(inputMatrix2dArray[i][j]))
                        boundaryItems.add(inputMatrix2dArray[i][j]);
                }
            }
        }

        for (int item : boundaryItems)
            System.out.print(item + " ");
    }
}
