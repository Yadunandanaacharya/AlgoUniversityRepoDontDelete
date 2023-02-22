package AssignmentProblems.A11StacksQueues.AssignmentProblems;

import java.io.*;
import java.util.*;

/*
5
10 8 6 4 6
 */

public class p60NextGreatLeft2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputArray = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] result = new int[N];
        Arrays.fill(result, -1);

        for(int i = 0; i<inputArray.length;i++)
            arr[i] = Integer.parseInt(inputArray[i]);

        Stack<Integer> stack = new Stack<>();
        for(int i =arr.length - 1;i>=0;i--){
            while(stack.size() != 0 && arr[stack.peek()] < arr[i]){
                int index = stack.pop();
                result[index] = arr[i];
            }
            stack.push(i);
        }

        for(int i=0; i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
}
