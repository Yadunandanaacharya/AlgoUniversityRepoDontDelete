package A2Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
Input
10 3
9 9 9 8 6 7 1 9 9 2
Output
-1
Example 2
Input
13 11
4 3 4 4 9 12 20 14 2 12 12 11 6
Output
1 2 3

13 11
4 3 4 4 9 12 20 14 2 12 12 11 6
Output
1 2 3

13 11
3 4 4 5 6 7 8 9 10 11 12 13 14

13 11
3 4 4 4 4 4 4 4 4 4 4 4 4
failing above test
 */

public class p9TreasureRoom4Use2Pointer {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        int[] ansArray = null;
        HashSet<Integer> setIs = new HashSet<>();
        boolean hashSetFull = false;
        boolean ansFound = false;

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int[] arrSorted = arr.clone();
        Arrays.sort(arrSorted);

        for(int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;

            while (k > j && ansFound == false) {
                int sumIs = arrSorted[i] + arrSorted[j] + arrSorted[k];
                if (sumIs > x)
                    k--;
                else if (sumIs < x)
                    j++;
                else if (sumIs == x && ansFound == false) {
                    ansArray = new int[3];
                    ansArray[0] = arrSorted[i];
                    ansArray[1] = arrSorted[j];
                    ansArray[2] = arrSorted[k];
                    ansFound = true;
                }
            }
        }

        if (ansFound && ansArray != null && ansArray.length == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j<ansArray.length; j++) {
                    if (arr[i] == ansArray[j] && hashSetFull == false) {
                        setIs.add(i+1);

                        if (setIs.size() == 3)
                            hashSetFull = true;
                    }
                }
            }
        }

        if (ansFound && setIs.size() == 3) {
            for(int i :setIs){
                System.out.print(i + " ");
            }
        }
        else
            System.out.println(-1);
    }
}
