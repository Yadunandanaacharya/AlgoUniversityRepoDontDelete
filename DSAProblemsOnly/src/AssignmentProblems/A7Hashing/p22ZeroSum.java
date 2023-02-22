package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

public class p22ZeroSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arrayLength = Long.parseLong(br.readLine());

        List<Long> inputList = new ArrayList();
        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i < arrayLength;i++){
            inputList.add(Long.parseLong(inputArrayString[i]));
        }

        //bruteforce
        long sum = 0;
        boolean ansFound = false;
        for (int i = 0; i < inputList.size() - 1; i++) {
            sum = 0;
            sum = sum + inputList.get(i);
            for (int j=i+1; j<inputList.size(); j++) {
                sum = sum  + inputList.get(j);
                if (sum == 0 && ansFound == false) {
                    System.out.println("Yes");
                    ansFound = true;
                }
            }
        }
    }
}
