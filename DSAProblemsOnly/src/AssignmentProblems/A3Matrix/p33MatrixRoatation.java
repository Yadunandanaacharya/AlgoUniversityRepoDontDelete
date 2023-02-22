package AssignmentProblems.A3Matrix;

/*
https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
https://medium.com/enjoy-algorithm/rotate-a-matrix-by-90-degrees-in-an-anticlockwise-direction-6326e80bb211

Given a square matrix A of size N×N, rotate it by 90 degrees in the anti-clockwise direction and output
the new rotate matrix.

Note: Since the input/output is huge in size, use fast input/output methods to avoid TLE.

1≤N≤1000

0≤Aij≤109

Sample 1:
3
1 2 3
4 5 6
7 8 9
Output:
3 6 9
2 5 8
1 4 7

Input:
4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

output
4 8 12 16
3 7 11 15
2 6 10 14
1 5 9 13
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p33MatrixRoatation {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(bufferReader.readLine());
        int[][] inputSqaureMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputArrayString = bufferReader.readLine().split(" ");
            for (int j = 0; j<n; j++) {
                inputSqaureMatrix[i][j] = Integer.parseInt(inputArrayString[j]);
            }
        }

        RotateMatrix(n, inputSqaureMatrix);
        DisplayMatrix(n, inputSqaureMatrix);
    }

    public  static void RotateMatrix(int N, int matrix[][]) {
        for(int i = 0; i < N;i++) {
            Reverse(i, matrix, N);
        }

        //doing transpose
        for(int i = 0; i < N; i++) {
            for (int j=i; j<N;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void DisplayMatrix(int N, int[][] matrix) {
        for(int i =0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    //method to reverse the given 2d array
    public static void Reverse(int i, int[][] matrix, int N) {
        //initialize start aand end index
        int start = 0;
        int end = N - 1;

        //until start<end keep swaping the elemnts present in start and end index
        while (start < end) {
            //swap the elment
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;

            //increment start and decrement end for swapping next iteration
            //matrix items;
            start++;
            end--;
        }
    }
}
