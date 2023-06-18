package AssignmentProblems.A26ClassicalDP;

import java.io.*;
import java.util.*;

/*
2
3 10
1 5 2
5 20
1 2 10 3 20
Sample 1 OUTPUT:
NO
YES

 */

public class JumpPossibility {
    public static int mod = 1000000007;

    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int noOfTestCases = scn.nextInt();
        while(noOfTestCases-- > 0){
            int  n = scn.nextInt();
            int  t = scn.nextInt();
            int[] arr = new int[n];

            for(int i = 0; i < arr.length; i++){
                arr[i] = scn.nextInt();
            }

            int[][] dp = new int[n+1][t+1];
            for(int a[] : dp){
                Arrays.fill(a,-1);
            }

            if (helper(arr,t,0,dp))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean helper(int[] arr, int target, int ind, int[][] dp){
        if (target == 0) return  true;
        if(ind >= arr.length) return false;
        if(dp[ind][target] != -1) return dp[ind][target] == 0 ? false : true;

        boolean notTake = helper(arr, target, ind + 1, dp);
        boolean take = false;

        if(arr[ind] <= target){
            take = helper(arr, target - arr[ind], ind + 1, dp);
        }

        dp[ind][target] = (notTake || take) ? 1 : 0;
        return notTake || take;
    }
}
