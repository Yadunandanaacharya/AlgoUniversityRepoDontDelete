package AssignmentProblems.A2Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p10ClosestRefuge2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        int integerN  = Integer.parseInt(bufferReader.readLine());

        String[] inputArrayString = bufferReader.readLine().split(" ");

        boolean ansFound = false;
        int[] inputArray = new int[integerN];
        for (int i = 0; i < integerN; i++) {
            inputArray[i] = Integer.parseInt(inputArrayString[i]);
        }

        Map<Integer,Integer> missingNumberFindMapper = new HashMap<>();
        for(int i = 0; i < inputArray.length; i++) {
            if(!missingNumberFindMapper.containsKey(inputArray[i]))
                missingNumberFindMapper.put(inputArray[i],i);
        }

        //this will not work takes more space time exceeded error you get
        //submission gets failed
        //use Math.pow(10,9)
        int missingNumber = 1;
        if (inputArray.length == 0)
            missingNumber = 1;


        boolean missingNumberFound = false;
        for (int i = 1; i<=inputArray.length; i++) {
            if(!missingNumberFindMapper.containsKey(i) && missingNumberFound == false){
                missingNumberFound = true;
                missingNumber = i;
            }
        }

        if (missingNumber != 1 && missingNumberFound)
            System.out.println(missingNumber);
        else {
            if (missingNumberFound == false && inputArray.length > 0)
                System.out.println(inputArray.length + 1);
            else
                System.out.println(missingNumber);
        }
    }
}
