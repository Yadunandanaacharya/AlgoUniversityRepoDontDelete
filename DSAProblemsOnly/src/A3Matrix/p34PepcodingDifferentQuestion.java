package A3Matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
3
5
11
12
13
14
15
21
22
23
24
25
31
32
33
34
35

3 5
11 12 13 14 15
21 22 23 24 25
31 32 33 34 35


 */

public class p34PepcodingDifferentQuestion {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMArray = bufferReader.readLine().split(" ");
        int n  = Integer.parseInt(nAndMArray[0]);
        int m  = Integer.parseInt(nAndMArray[1]);
//        int[][] inputSqaureMatrix = new int[n][m];
        int[][] arr = new int[n][m];
        int[] ansArray = new int[n * m];
        ArrayList<Integer> ansArray2 = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            String[] inputArrayString = bufferReader.readLine().split(" ");
            for (int j = 0; j<m; j++) {
                arr[i][j] = Integer.parseInt(inputArrayString[j]);
            }
        }

//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        int m = scn.nextInt();
//        int[][] arr = new int[n][m];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                arr[i][j] = scn.nextInt();
//            }
//        }

        int minrow = 0;
        int mincol = 0;
        int maxrow = arr.length - 1;
        int maxcol = arr[0].length - 1;


        int tne = n * m;     //total numbers of elements
        int count = 0;

        while (count < tne) {

            //left wall
            if (count < tne) {
                for (int i = minrow; i <= maxrow; i++) {
                    System.out.print(arr[i][mincol] + " ");
                    count++;
                }
            }
            mincol++;

            //bottom wall
            if (count < tne) {
                for (int i = mincol; i <= maxcol; i++) {
                    System.out.print(arr[maxrow][i] + " ");
                    count++;
                }
            }
            maxrow--;

            //right wall
            if (count < tne) {
                for (int i = maxrow; i >= minrow; i--) {
                    System.out.print(arr[i][maxcol] + " ");
                    count++;
                }
            }
            maxcol--;

            //top wall
            if (count < tne) {
                for (int i = maxcol; i >= mincol; i--) {
                    System.out.print(arr[minrow][i] + " ");
                    count++;
                }
            }
            minrow++;
        }
    }
}
