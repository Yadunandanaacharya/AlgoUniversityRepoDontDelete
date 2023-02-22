package ContestProblems.Contest2Matrix;

import java.util.*;
import java.io.*;

/*
5 4 4 5
13 18 18 13
7 16 9 18
3 8 5 16
14 7 18 7
4 6 2 11

output:
13 18 18 13 7
16 9 18 3 8
5 16 14 7 18
7 4 6 2 11
 */

//https://leetcode.com/problems/reshape-the-matrix/solutions/675984/java-solution-with-comments/
public class Reshape1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputString = br.readLine().split(" ");
        int n = Integer.parseInt(inputString[0]);
        int m = Integer.parseInt(inputString[1]);
        int r = Integer.parseInt(inputString[2]);
        int c = Integer.parseInt(inputString[3]);

        int[][] input2dMatrix = new int[n][m];
        for (int i = 0; i<input2dMatrix.length;i++){
            String[] input2dArrayContents = br.readLine().split(" ");
            for(int j= 0;j<input2dMatrix[i].length;j++) {
                input2dMatrix[i][j] = Integer.parseInt(input2dArrayContents[j]);
            }
        }


        if (input2dMatrix.length == 0 || input2dMatrix[0].length == 0) {
            System.out.println("null");
        }
        else {
            int[][] output2dMatrix = new int[r][c];
//n*m  r*c  5 4 4 5
//                m*n  r*s then m==r and n==s
            if (n*m == r*c) {
                int rowIndex = 0;
                int colIndex = 0;
                for (int i = 0; i<input2dMatrix.length;i++){
                    for(int j= 0;j<input2dMatrix[i].length;j++) {
                        if(colIndex < output2dMatrix[rowIndex].length) {
                            output2dMatrix[rowIndex][colIndex++] = input2dMatrix[i][j];
                        }
                        else {
                            rowIndex++;
                            colIndex = 0;
                            output2dMatrix[rowIndex][colIndex++]=input2dMatrix[i][j];
                        }
                    }
                }

                for (int i = 0; i<output2dMatrix.length;i++){
                    for(int j= 0;j<output2dMatrix[i].length;j++) {
                        System.out.print(output2dMatrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            else {
                for (int i = 0; i<input2dMatrix.length;i++){
                    for(int j= 0;j<input2dMatrix[i].length;j++) {
                        System.out.print(input2dMatrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
