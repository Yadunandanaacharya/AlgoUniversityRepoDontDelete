package AssignmentProblems.A2Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p9TreasureRoom1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndWArray = bufferReader.readLine().split(" ");
        String[] inputArrayString = bufferReader.readLine().split(" ");
        int N = Integer.parseInt(nAndWArray[0]); //array length
        int W = Integer.parseInt(nAndWArray[1]); //sum to find, width of door

        List<Integer> list = new ArrayList<Integer>();
        int[] resultArray = null;
        boolean resultFound = false;
        int[] inputArray = new int[N];
        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(inputArrayString[i]);
        }

        //brute force approach
//        for (int i = 0; i < inputArray.length; i++) {
//            for (int j = 0; j < inputArray.length; j++) {
//                for (int k = 0; k <inputArray.length; k++) {
//                    if(inputArray[i] + inputArray[j] + inputArray[k] == W && resultFound == false) {
//                        resultArray[0] = i+1;
//                        resultArray[1] = j+1;
//                        resultArray[2] = k+1;
//                        resultFound = true;
//                    }
//                }
//            }
//        }

        for (int i = 0; i < inputArray.length -2; i++) {
            for (int j = i+1; j < inputArray.length -1; j++) {
                for (int k = j+1; k <inputArray.length; k++) {
                    if(inputArray[i] + inputArray[j] + inputArray[k] == W && resultFound == false) {
                        resultArray = new int[3];
                        resultArray[0] = i+1;
                        resultArray[1] = j+1;
                        resultArray[2] = k+1;
                        resultFound = true;
                    }
                }
            }
        }
//        threeSumNumbers(inputArray, W, resultArray);
        if(resultArray != null && resultArray.length > 0) {
            for (int i = 0; i < resultArray.length; i++) {
                System.out.print(resultArray[i] + " ");
            }
        }
        else {
            System.out.println(-1);
        }
    }

    public static int[] threeSumNumbers(int[] inputArray, int W, int[] resultArray) {
        boolean ansFound = false;

        Map<Integer, Integer> targetSum = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            int value = Math.abs(inputArray[i]);
            int diff = (W - value);

            if(!targetSum.containsKey(diff)) {
                targetSum.put(value,i+1);
            }
            else if (targetSum.containsKey(diff) && ansFound == false) {
                int iThNum =   targetSum.get(diff);
                int jThNum =   i + 1;
                ansFound = true;
                resultArray = new int[3];
                resultArray[0] = iThNum;
                resultArray[1] = jThNum;
                resultArray[2] = i+2;
            }
        }

        return resultArray;
    }
}
