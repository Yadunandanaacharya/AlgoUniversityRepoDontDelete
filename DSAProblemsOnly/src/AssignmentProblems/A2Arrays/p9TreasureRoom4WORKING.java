package AssignmentProblems.A2Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
https://www.techiedelight.com/find-triplet-given-with-given-sum/
 */

/*
input:
13 11
4 3 4 4 9 12 20 14 2 12 12 11 6

output:
1 2 3 or 1 2 5 or 2 9 13 any of this we can return
 */

public class p9TreasureRoom4WORKING {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        // insert (element, index) pair into the map for each array element
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        boolean ansFound = false;
        int[] ansArray = null;
        // consider each element except the last element
        for (int i = 0; i < arr.length - 1; i++)
        {
            // start from the i'th element until the last element
            for (int j = i + 1; j < arr.length; j++)
            {
                // remaining sum
                int val = x - (arr[i] + arr[j]);

                // if the remaining sum is found, we have found a triplet
                if (map.containsKey(val))
                {
                    // if the triplet doesn't overlap, return true
                    if (map.get(val) != i && map.get(val) != j && ansFound == false) {
                        ansArray = new int[3];
                        ansArray[0] = i+1;
                        ansArray[1] = j +1;
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
