package AssignmentProblems.A7Hashing;

import java.util.*;
import java.io.*;

/*
7
2 6 1 9 4 5 3

10
2 6 1 9 4 5 3 2 3 5

 */

public class p24ConsecutivAlgoU {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println("after sorting " + Arrays.toString(arr));
        System.out.println();

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 0; i < N;i++){
            set.add(arr[i]);
        }

        System.out.println("Set removes all duplicate items of array");
        System.out.println("after sorting printing set " + set);
        System.out.println();
        /*
        below is process of removing duplicate items from list above first we sorted
        and addded all our list items into set so set will have unique items
        now below we put back set items into our array back so this array will only have
        unique items
         */

        int j = 0;
        for (Integer i:set){
            arr[j] = i;
            j++;
        }

        System.out.println("since set has unique items it's size is less than arr");
        System.out.println("duplicate items remain at the end");
        System.out.println("iterating set and adding unique items to input arr " + Arrays.toString(arr));
        System.out.println();

        System.out.println("since set has unique items it's size is less than arr");
        int consecutiveness = 1, maxConsecutiveness = 0;
        for (int i = 0; i<set.size() - 1;i++){
            if (arr[i+1] - arr[i] == 1){
                System.out.println("for loop in IF: next item " + arr[i+1] + " current item " + arr[i]);
                consecutiveness++;
            }else{
                System.out.println("for loop in else: next item " + arr[i+1] + " current item " + arr[i]);
                maxConsecutiveness = Math.max(maxConsecutiveness, consecutiveness);
                consecutiveness = 1;
            }
        }

        maxConsecutiveness = Math.max(maxConsecutiveness, consecutiveness);
        System.out.println(maxConsecutiveness);
    }
}
