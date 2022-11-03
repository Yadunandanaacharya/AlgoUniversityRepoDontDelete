package A3Matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*

https://www.youtube.com/watch?v=qEZoUVOqOs8&ab_channel=GeeksforGeeks
https://www.youtube.com/results?search_query=spiral+display+of+matrix+java
https://www.youtube.com/watch?v=1ZGJzvkcLsA&ab_channel=TECHDOSE
input:
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

3 6
1 2 3 4 5 6
7 8 9 10 11 12
13 14 15 16 17 18

ans:
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

3 4
1 2 3 4
5 6 7 8
9 10 11 12

ans:
1,2,3,4,8,12,11,10,9,5,6,7

3 5
11 12 13 14 15
21 22 23 24 25
31 32 33 34 35

ans:
11 12 13 14 15 25 35 34 33 32 31 21 22 23 24
 */

public class p34MatrixTraversal {
    public static void main(String[] args)throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMArray = bufferReader.readLine().split(" ");
        int n  = Integer.parseInt(nAndMArray[0]);
        int m  = Integer.parseInt(nAndMArray[1]);
        int[][] inputSqaureMatrix = new int[n][m];
        int[] ansArray = new int[n * m];
        ArrayList<Integer> ansArray2 = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            String[] inputArrayString = bufferReader.readLine().split(" ");
            for (int j = 0; j<m; j++) {
                inputSqaureMatrix[i][j] = Integer.parseInt(inputArrayString[j]);
            }
        }

        int top = 0; int bottom = n -1; int left = 0;
        int right = m -1; int direction = 0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                for(int i =left;i<=right;i++) {
                    System.out.print(inputSqaureMatrix[top][i] + " ");
                    ansArray2.add(inputSqaureMatrix[top][i]);
                }
                top++;
            }
            else if (direction == 1) {
                for(int i =top;i<=bottom;i++) {
                    System.out.print(inputSqaureMatrix[i][right] + " ");
                    ansArray2.add(inputSqaureMatrix[i][right]);
                }
                right--;
            }
            else if (direction == 2) {
                for(int i =right;i>=left;i--) {
                    System.out.print(inputSqaureMatrix[bottom][i] + " ");
                    ansArray2.add(inputSqaureMatrix[bottom][i]);
                }
                bottom--;
            }
            else if (direction == 3) {
                for(int i =bottom;i>=top;i--) {
                    System.out.print(inputSqaureMatrix[i][left] + " ");
                    ansArray2.add(inputSqaureMatrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }

    }
}
