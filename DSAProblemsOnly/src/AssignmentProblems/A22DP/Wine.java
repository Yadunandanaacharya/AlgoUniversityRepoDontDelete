package AssignmentProblems.A22DP;

import java.io.*;
import java.util.*;

public class Wine {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] bottlePricesString = br.readLine().trim().split(" ");

        int[] bottlePrice = new int[n];
        for (int i = 0; i < n; i++) {
            bottlePrice[i] = Integer.parseInt(bottlePricesString[i]);
        }

        int[] dpArray = new int[n + 1];
        Arrays.fill(dpArray, 0);
        int i = bottlePrice[0];
        int j = bottlePrice[n - 1];
        RecursiveMaximumBottlePriceFinder(n, dpArray, i, j, bottlePrice);
    }

    public static int RecursiveMaximumBottlePriceFinder(int n, int[] dpArray, int i, int j, int[] bottlePrice) {
        if (i > j){
            return 0;
        }

        double modIs = Math.pow(10,9) + 7;

        int left = RecursiveMaximumBottlePriceFinder(n , dpArray, i + 1, j, bottlePrice);
        left = (int)(((left % modIs) + ((bottlePrice[i] * (n - j + i)) % modIs ))  % modIs);
        int right = RecursiveMaximumBottlePriceFinder(n , dpArray, i, j - 1, bottlePrice);
        right = (int)(((right % modIs) + ((bottlePrice[j] * (n - j + i)) % modIs ))  % modIs);
        int maxValue = Math.max(left, right);
        dpArray[n] = maxValue;

        return dpArray[n];
    }
}

/*
4
1 4 2 3

if n=1 means only 1 bottle
price=2
then 1 * 2 =  2 we return

if n=2 means only 2 bottle
2, 5
first find left side bottle calculation
dpArray = [0, 0, 0]
for 1st bottle at index 0
so maxValueLeft = 0;
so maxValueRight = 0;

maxValueLeft = RecursiveMaxBottlePrice(2);
RecursiveMaxBottlePrice(2) => this takes left so 1*2=2
next we take 5 so 2nd year => 2 * 5 = 10
2 + 10 = 12
next: dpArray = [0, 2, 10]

maxValueRight = RecursiveMaxBottlePrice(5);
RecursiveMaxBottlePrice(5) => this takes left so 1 * 5 = 5;
next: dpArray = [5, 0, 0]
next we take 2 so 2nd year => 1 * 2 = 2
5 + 2 = 7
now compare max out of left and right
math.max(maxValueLeft, maxValueRight) = 10
dpArray = [0, 5, 2]


if n=4 means  4 bottle
1 4 2 3
first find left side bottle calculation
dpArray = [0, 0, 0, 0, 0]
for 1st bottle at index 0
so maxValueLeft = 0;
so maxValueRight = 0;

maxValueLeft = RecursiveMaxBottlePrice(1);
RecursiveMaxBottlePrice(1) => this takes left so 1*2=2
dpArray = [0, 2, 0, 0, 0]

next we take 5 so 2nd year => 2 * 5 = 10
2 + 10 = 12
next: dpArray = [2, 10, 0]

maxValueRight = RecursiveMaxBottlePrice(5);
RecursiveMaxBottlePrice(5) => this takes left so 1 * 5 = 5;
next: dpArray = [5, 0, 0]
next we take 2 so 2nd year => 1 * 2 = 2
5 + 2 = 7
now compare max out of left and right
math.max(maxValueLeft, maxValueRight) = 10
dpArray = [5, 2, 0]

if n=4 means  4 bottle
1 4 2 3
n - j + i
1 then: 4 - 3 + 1 = 2
 */