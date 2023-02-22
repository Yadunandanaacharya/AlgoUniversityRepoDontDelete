package ContestProblems.Contest1Arrays;

import java.util.*;
import java.io.*;

/*
10 6 5
2
10
1
5
9
 */

public class FillWithZeros2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArraStr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArraStr[0]);
        int k = Integer.parseInt(inputArraStr[1]);
        int q = Integer.parseInt(inputArraStr[2]);

        int[] inputArra = new int[n];
        for (int i = 0; i<n;i++) {
            inputArra[i] = 0;
        }

        for (int i = 0; i <q;i++) {
            int indexToFill1 = Integer.parseInt(br.readLine());
            if (indexToFill1 == n){
                inputArra[indexToFill1 - 1] = 1;
            }
            inputArra[indexToFill1 - 1] = 1;
        }

        int countOfOnes = 0;
        for (int i = 0; i<k;i++) {
            if(inputArra[i] == 1)
                countOfOnes++;
        }

        int minNoOfOnesRequired = countOfOnes;
        for (int i =k;i<n;i++) {
            if(inputArra[i] == 1)
                countOfOnes++;
            if(inputArra[i-k] == 1)
                countOfOnes--;

            minNoOfOnesRequired = Math.min(minNoOfOnesRequired, countOfOnes);
        }
        System.out.println(minNoOfOnesRequired);
    }
}
