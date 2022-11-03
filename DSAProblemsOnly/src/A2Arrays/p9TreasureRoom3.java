package A2Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.*;

/*
13 11
4 3 4 4 9 12 20 14 2 12 12 11 6
ans: 1 2 3

13 11
4 9 12 20 14 2 12 12 11 6 4 3 4
ans:1 12 13

13 11
4 9 12 20 14 2 12 12 11 6 6 3 4
ans:1 12 13

13 11
4 9 12 20 14 2 12 12 11 6 6 3 1
ans:1 12 13
 */
public class p9TreasureRoom3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndWArray = bufferReader.readLine().split(" ");
        String[] inputArrayString = bufferReader.readLine().split(" ");
        int N = Integer.parseInt(nAndWArray[0]); //array length
        int W = Integer.parseInt(nAndWArray[1]); //sum to find, width of door

        Map<Integer, Integer> targetSum = new LinkedHashMap<>();
        int[] inputArray = new int[N];
        int[] result = null;

        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(inputArrayString[i]);
            if (!targetSum.containsKey(inputArray[i]))
                targetSum.put(inputArray[i], i + 1);
        }

//        result = ThreeSumIndicesOfArray(inputArray, W);
        result = findThreeSum(inputArray, W);

        //this is only best way possible get all numbers whose sum is W later get indices of those numbers below here
        //this will be like o(n^2)+o(n^2)=2(o(n^2)) finally o(n^2) only
        boolean stopper = false;
        List<Integer> result2 = new ArrayList<>(3);
        for(int i =0;i<inputArray.length;i++) {
            if(stopper)
                stopper = false;
            for(int j=0;j<result.length&& stopper==false;j++){
                if(result[j] == inputArray[i] && stopper==false) {
                    result2.add(i+1);

                    stopper = true;
                }
            }
        }

        if (result2.size() > 0) {
            for (int i = 0; i < result2.size(); i++) {
                System.out.print(result2.get(i) + " ");
            }
        }
        else {
            System.out.println(-1);
        }

//        if(result != null && result.length > 0) {
//            for (int i = 0; i < result.length; i++) {
//                System.out.print(result[i] + " ");
//            }
//        }
//        else {
//            System.out.println(-1);
//        }
    }

    public static int[] ThreeSumIndicesOfArray(int[] inputArray, int sum) {
        HashSet<Integer> threeSumCheckerHashSet = new HashSet<Integer>(); //Won't insert duplicate items
        int[] result = null;
        boolean threeSumIndicesFound = false;

        for (int i = 0; i<inputArray.length - 2; i++) {
            int diff = sum - inputArray[i];
            for(int j=i + 1; j<inputArray.length;j++) {
                int nextDifference = diff - inputArray[j];
                if(threeSumCheckerHashSet.contains(nextDifference) && threeSumIndicesFound==false) {
                    result = new int[3];
                    result[0] = inputArray[i];
                    result[1] = diff - inputArray[j];
                    result[2] = inputArray[j];

                    threeSumIndicesFound = true;
                }
                threeSumCheckerHashSet.add(inputArray[j]);
            }
        }

        return  result;
    }

//    below code from https://www.callicoder.com/three-sum-problem/

    private static int[] findThreeSum(int[] nums, int target) {
        int[] result = null;
        int[] indices = new int[3];
        boolean threeSumIndicesFound = false;
        for (int i = 0; i < nums.length; i++) {
            int currentTarget = target - nums[i];
            Set<Integer> existingNums = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int diff = currentTarget - nums[j];
                if (existingNums.contains(diff) && threeSumIndicesFound == false) {
                    result = new int[3];
                    result[0] = nums[i];
                    result[1] = currentTarget - nums[j];
                    result[2] = nums[j];
                    indices[0] = i+1;
                    indices[1] = j+1;
                    indices[2] = i+1;
                    threeSumIndicesFound = true;
                } else {
                    existingNums.add(nums[j]);
                }
            }
        }
        return result;
    }
}
