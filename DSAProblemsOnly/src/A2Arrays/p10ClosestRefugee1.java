package A2Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
https://www.youtube.com/watch?v=-lfHWWMmXXM&ab_channel=RachitJain

Input
7
6 7 5 9 3 2 8
Output
1
 */

public class p10ClosestRefugee1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        int integerN  = Integer.parseInt(bufferReader.readLine());
        String[] inputArrayString = bufferReader.readLine().split(" ");

        boolean ansFound = false;
        int[] inputArray = new int[integerN];
        for (int i = 0; i < integerN; i++) {
            inputArray[i] = Integer.parseInt(inputArrayString[i]);
        }

        int count = 0;
        Map<Integer,Integer> missingNumberFindMapper = new HashMap<>();
        for(int i = 0; i < inputArray.length; i++) {
            if(!missingNumberFindMapper.containsKey(inputArray[i]))
                missingNumberFindMapper.put(inputArray[i],i);
        }

        //this will not work takes more space time exceeded error you get
        //submission gets failed
        //use Math.pow(10,9)
        boolean missingNumberFound = false;
        for (int i = 0; i<=Math.pow(10,9); i++) {
            count++;
            if(!missingNumberFindMapper.containsKey(count) && missingNumberFound == false){
                missingNumberFound = true;
                System.out.println(count);
            }
        }

//            6 7 5 9 3 2 8
    }
}
