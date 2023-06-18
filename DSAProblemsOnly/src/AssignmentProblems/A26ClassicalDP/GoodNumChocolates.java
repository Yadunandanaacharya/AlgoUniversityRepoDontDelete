package AssignmentProblems.A26ClassicalDP;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/*
Sample 1 INPUT:
2
8
3 5 8 9 10 17 17 20
8
1 5 8 9 10 17 17 20
Sample 1 OUTPUT:
24
22

 */

public class GoodNumChocolates {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (testCases-- > 0)
        {
            int n = scn.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = scn.nextInt();

            int[][] dpArray =  new int[n+1][n+1];
            for (int i = 0; i < n+1; i++){
                for (int j=0; j < n+1; j++){
                    dpArray[i][j] = -1;
                }
            }
            list.add(Solve(0,n,dpArray,arr));
        }

        for(int i : list)
            System.out.println(i);
    }


    private static int Solve(int currentIndex, int target, int[][] dp, int[] arr){
        if(currentIndex >= target) return 0;
        if (dp[currentIndex][target] != -1) return dp[currentIndex][target];

        int consider = arr[currentIndex] + Solve(currentIndex, target - (currentIndex + 1), dp, arr);
        int notConsider = Solve(currentIndex + 1, target, dp, arr);
        int ans = Math.max(consider, notConsider);
        dp[currentIndex][target] = ans;
        return dp[currentIndex][target];
    }
}
