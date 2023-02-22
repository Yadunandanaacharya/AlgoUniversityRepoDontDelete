package AssignmentProblems.A5PrefixSumRangeQuery;

import java.io.*;
import java.lang.*;

public class p35MatrixSearch2 {
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
        int start = 0; int end=N*M;
        for (int k = 0; k<searchItems.length;k++) {
            int searchItem = Integer.parseInt(searchItems[k]);
            while(start < end) {
                int i=0; int j=M-1;
                if (input2dArray[i][j] == searchItem) {
                    System.out.println(i + " " + j);
                    break;
                }
                else if (searchItem > input2dArray[i][j])
                    i--;
                else if (searchItem > input2dArray[i][j])
                    j++;
            }
        }
    }
}
