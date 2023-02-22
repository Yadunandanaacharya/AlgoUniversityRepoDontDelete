package AssignmentProblems.A5PrefixSumRangeQuery;

import java.util.*;
import java.io.*;
import java.lang.*;

//always type above import since io.* will import everything
//this is like naive or brute force approach this migth give tle error
public class p35MatrixSearch {
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
        for (int k = 0; k<searchItems.length;k++) {
            for(int i = 0; i < input2dArray.length;i++) {
                for (int j = 0; j < input2dArray[i].length;j++) {
                    if (Integer.parseInt(searchItems[k]) == input2dArray[i][j])
                        System.out.println(i + " " + j);
                }
            }
        }

    }
}
