package AssignmentProblems.A2Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
7 8
7 5 3 6 9 2 9

 */

public class p8TreasureRoomEasy1 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndWArray = bufferReader.readLine().split(" ");
        String[] inputArrayString = bufferReader.readLine().split(" ");
        int N = Integer.parseInt(nAndWArray[0]); //array length
        int W = Integer.parseInt(nAndWArray[1]); //sum to find, width of door

        List<Integer> list = new ArrayList<Integer>();
        int[] inputArray = new int[N];
        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(inputArrayString[i]);
        }

        twoSumNumbers(inputArray, W, list);
        if(list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
        else {
            System.out.println(-1);
        }

        //for below code you'll get time limit exceeded so don't use this code
 /*       for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[i] + inputArray[j] == W && ansFound == false) {
                    int a= i + 1;
                    int b= j + 1;
                    ansFound = true;
                    System.out.println(a +" "+ b);
                }
            }
        }
*/
    }
/* submit this problem only after some body start discussing about edge cases since
there is possible that -ve numbers could be there
 */

    /*
    this is taking only o(n) time and o(n) space which is very efficient
    compared to taking 2 loops where time is o(n^2)
     */
    public static void twoSumNumbers(int[] inputArray, int W, List<Integer> list) {
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
                list.add(iThNum);
                list.add(jThNum);
            }
        }
    }
}
