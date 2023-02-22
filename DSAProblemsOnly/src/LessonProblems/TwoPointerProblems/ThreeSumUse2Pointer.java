package LessonProblems.TwoPointerProblems;

import java.util.Arrays;
import java.util.Scanner;

/*
13 11
4 3 4 4 9 12 20 14 2 12 12 11 6

output:
1 2 3
 */

public class ThreeSumUse2Pointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        boolean ansFound = false;
        int i = 0; int j = 0; int k = 0;
        for(i = 0; i < arr.length - 1; i++) {
            j = i + 1;
            k = arr.length - 1;

            while (k > j) {
                int sumIs = arr[i] + arr[j] + arr[k];
                if (sumIs > x)
                    k--;
                else if (sumIs < x)
                    j++;
                else if (sumIs == x && ansFound == false) {
                    ansFound = true;
                }
            }
        }

        if (ansFound)
            System.out.println(i + " " + j + " " + k);
        else
            System.out.println(-1);
    }
}
