package AssignmentProblems.A5PrefixSumRangeQuery;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.opentechguides.com/how-to/article/java/215/java-binary-search.html

public class p35MatrixSearBinarySear3 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayNMQ = br.readLine().split(" ");
        int N = Integer.parseInt(arrayNMQ[0]);
        int M = Integer.parseInt(arrayNMQ[1]);
        int Q = Integer.parseInt(arrayNMQ[2]);

        int[][] input2dArray = new int[N][M];
        for(int i = 0; i < N;i++) {
            String[] array2dItems = br.readLine().split(" ");
            for (int j = 0; j < M;j++) {
                input2dArray[i][j] = Integer.parseInt(array2dItems[j]);
            }
        }

        String[] searchItems = br.readLine().split(" ");
        int[] searchItemArray = new int[Q];
        for (int k = 0; k<searchItems.length;k++) {
            int searchItem = Integer.parseInt(searchItems[k]);
            searchItemArray[k] = searchItem;
        }

        for (int k = 0; k<searchItemArray.length;k++) {
            BinarySearchOnMatrix(input2dArray, searchItemArray[k], N, M);
        }

    }

    public static void BinarySearchOnMatrix(int[][] twoDArray, int searchItem, int rows, int cols) {
        int left = 0; int right = rows * cols - 1;
        int mid = left + ((right - left)/2);
        int midRow = mid / cols;
        int midCol = mid % cols;
        int midVal = twoDArray[midRow][midCol];

        while (left <= right) {
             mid = left + ((right - left)/2);
             midRow = mid / cols;
             midCol = mid % cols;
             midVal = twoDArray[midRow][midCol];

            if(midVal == searchItem) {
                System.out.println(midRow + " " + midCol);
                break;
            }
            else if (midVal < searchItem)
                left = mid + 1;
            else if (midVal > searchItem)
                right = mid - 1;
        }
    }
}
