package AssignmentProblems.A12Recursion;

import java.util.*;
import java.io.*;

public class p71SubsetSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputArrayString = br.readLine().split(" ");
        long[] inputArray = new long[n];
        for (int i =0;i<n;i++){
            inputArray[i] = Long.parseLong(inputArrayString[i]);
        }

        long sum1 = 0, sum2 = 0;
        System.out.println(SubSetSum(0, inputArray, sum1, sum2));
    }

    public static long SubSetSum(int i, long[] arr, long sum1, long sum2){
        if (i == arr.length) return Math.abs(sum1 - sum2);

        long group1 = SubSetSum(i + 1, arr, sum1 + arr[i], sum2);
        long group2 = SubSetSum(i + 1, arr, sum1, sum2 + arr[i]);

        return Math.min(group1, group2);
    }
}
