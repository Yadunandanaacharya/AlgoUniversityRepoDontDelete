package AssignmentProblems.A22DP;
import java.io.*;
import java.util.*;

/*
since recursion calls will be bigger taken small example for
making dry run easier
2
1 2
ans:5
 */


public class WineShelfSoln {
    public static long[][] dp;
    public static int[] winePricesArray;

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        winePricesArray = new int[n];

        String[] inputStr = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            winePricesArray[i] = Integer.parseInt(inputStr[i]);
        }

        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(ProfitRecurMethod(winePricesArray, 0, n-1, dp));
    }

    private static long ProfitRecurMethod(int[] winePricesArray, int iFromLeft, int jFromRigt, long[][] dp) {
        int year = winePricesArray.length- jFromRigt +  iFromLeft; //- 1

        //base case checking index from left side greater than right side means
        //you're going from left to right side when i>j means you've crossed mid point
        if (iFromLeft > jFromRigt) return 0;

        //if visited early means in that position of dp 2d array some data is there we return it
        if (dp[iFromLeft][jFromRigt] != -1)
            return dp[iFromLeft][jFromRigt];

        //unvisited
        //mod: 10^9+7 can be written as: 1000000007
        dp[iFromLeft][jFromRigt] = Math.max((winePricesArray[iFromLeft] * year +
                        ProfitRecurMethod(winePricesArray,iFromLeft + 1, jFromRigt, dp))% 1000000007
                , (winePricesArray[jFromRigt] * year + ProfitRecurMethod(winePricesArray,iFromLeft, jFromRigt - 1, dp))% 1000000007);

        return dp[iFromLeft][jFromRigt];
    }
}