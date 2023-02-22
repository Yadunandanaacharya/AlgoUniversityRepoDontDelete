package AssignmentProblems.A11StacksQueues.AssignmentProblems;

import  java.util.*;
import java.io.*;

public class p60NGELeft {
    public  static  void  main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInput = Integer.parseInt(br.readLine());
        String[] inputArray = br.readLine().split(" ");

        int[] array = new int[numberOfInput];
        for(int i = 0; i<numberOfInput;i++){
            array[i] = Integer.parseInt(inputArray[i]);
        }

        int leftMax = -1;
        int[] outputArray = new int[numberOfInput];
        outputArray[0] = -1;
        for(int i = 1; i< numberOfInput;i++){
            if (array[i] > leftMax){

            }

        }
    }
}
