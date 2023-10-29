package AssignmentProblems.A22DP;

import java.util.*;
import java.io.*;

public class Tiling {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dpArray = new int[n + 1];
        Arrays.fill(dpArray, -1);
        System.out.println(RecursiveTiler(n, dpArray));;
    }

    public static int RecursiveTiler(int n, int[] dpArray) {
        if(n <= 2) {  //means n=0 or n=1 or n=2 return n itself
            return n;
        }

        if (dpArray[n] != -1) { //this means in dpArray some values are there return it
            return dpArray[n];
        }
        else {
            dpArray[n] = (RecursiveTiler(n - 1, dpArray) +  RecursiveTiler(n - 2, dpArray)) % 1000000007;
        }

        return dpArray[n];
    }
}
