package A2Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
7 11
4 4 4 4 4 4 3
3 4 4 4 4 4 4
4 4 4 3 4 4 4
9 8 7 3 2 4 4
9 8 7 3 2 1 4

13 11
4 3 4 4 9 12 20 14 2 12 12 11 6
4 3 9 9 9 9 9 9 9 9 9 9 4
9 8 7 9 8 7 3 9 8 7 10 4 4

5 12
4 4 4 4 4
 */

public class p9ChangedWorking4 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        boolean ansFound = false;
        int[] ansArray = null;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int val = x - (arr[i] + arr[j]);
                if (map.containsKey(val) && ansFound == false) {
                    if (map.get(val) != i && map.get(val) != j) {
                        ansArray = new int[3];
                        ansArray[0] = i + 1;
                        ansArray[1] = j + 1;
                        ansArray[2] = map.get(val) + 1;
                        ansFound = true;
                    }
                }
            }
        }

        if (ansFound && ansArray!= null && ansArray.length > 0) {
            Arrays.sort(ansArray);
            System.out.println(ansArray[0] + " " + ansArray[1] + " " + ansArray[2]);
        }
        else
            System.out.println(-1);
    }
}
