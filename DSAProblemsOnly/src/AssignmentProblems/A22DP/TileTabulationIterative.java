package AssignmentProblems.A22DP;

import java.util.*;
import java.io.*;

public class TileTabulationIterative {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] dpArray = new int[n + 1];
        Arrays.fill(dpArray, -1);

        int firstAns = 1;
        int secondAns = 2;
        int finalAns = 0;

//        dpArray[1] = 1;
//        dpArray[2] = 2;
//        for(int i = 3; i <= n; i++) {
//            dpArray[i] = ((dpArray[i - 1]   % 1000000007)  + (dpArray[i - 2]  % 1000000007))  % 1000000007;
//        }

        for(int i = 3; i <= n; i++) {
            finalAns = (firstAns + secondAns)   % 1000000007;
            firstAns = secondAns;
            secondAns = finalAns;
        }

        System.out.println(finalAns);
    }
}

//n=5
//
//        first=1
//        second=2
//
//        for i=3
//final= 1+2=3
//        first=2
//        second=3
//
//        i=4
//final=2+3=5
//        first=3
//        second=5
//
//        i=5
//final=3+5
//        fist=5
//        secnd=8
//
//        ans=8

