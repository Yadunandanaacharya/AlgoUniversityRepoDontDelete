package AssignmentProblems.A26ClassicalDP;

import java.io.*;
import java.util.*;

/*
The first line of input contains a single integer t (1≤t≤300), that denotes the number of test-cases.
The next 2t lines describe the test-cases.
The first line of each test-case contains two integers N (1≤N≤3000) and S (1≤S≤5000) that denotes the
number of different blocks and the required height respectively.
The next line contains N distinct integers h (1≤hi≤109) denoting the block heights.
Note that it is guaranteed that the sum of N and S does not exceed 3000 and 5000 respectively,
across all test-cases.

Sample 1 INPUT:
2
3 10
1 5 2
5 20
1 2 10 3 20
Sample 1 OUTPUT:
10
60

1
5 20
1 2 10 3 20
output: 60
 */

public class WaysOfBuilding {
    static final int Mod = 1000000007;
    static int height,noOfBlocks,result;
    static int[] buildingBlocksArr;
    static int[][] dpArr;

    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        for (int k=0; k<testCases;k++){
            noOfBlocks = scn.nextInt();
            height = scn.nextInt();

            dpArr = new int[noOfBlocks + 1][height + 1];
            for (int m=0; m<=noOfBlocks; m++){
                for(int n=0; n<=height; n++){
                    dpArr[m][n] = -1;
                }
            }

            buildingBlocksArr = new int[noOfBlocks];
            for(int i = 0; i <noOfBlocks; i++)
                buildingBlocksArr[i]= scn.nextInt();

            System.out.println(BuildingCombination(noOfBlocks -1, height));
        }
    }

    private static int BuildingCombination(int index, int currHeight){
        if (currHeight < 0 || index == -1) return 0;
        if (dpArr[index][currHeight] != -1) return dpArr[index][currHeight];

        if (currHeight == 0)
            return dpArr[index][currHeight] = 1;

        return dpArr[index][currHeight] = (BuildingCombination(index, currHeight -
                buildingBlocksArr[index]) % Mod
                + BuildingCombination(index -1, currHeight)
        % Mod) % Mod;
    }
}
