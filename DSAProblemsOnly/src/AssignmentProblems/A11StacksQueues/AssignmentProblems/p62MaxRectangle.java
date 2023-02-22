package AssignmentProblems.A11StacksQueues.AssignmentProblems;

import java.util.*;
import java.io.*;

/*
6
2 1 5 6 2 3
 */
public class p62MaxRectangle {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();;

        int[] input = new int[n];
        for(int i = 0; i < n;i++){
            input[i]  = scn.nextInt();
        }

        LargestAreaRectangle(input);
    }

    private static void  LargestAreaRectangle(int[] heightsArr){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);

        for(int i = 0; i<heightsArr.length;i++){
            int val = i == heightsArr.length ? 0 : heightsArr[i];

            while (stack.peek() != -1 && heightsArr[stack.peek()] >= val){
                int rightMin = i;
                int height = heightsArr[stack.pop()];
                int leftMin = stack.peek();
                maxArea = Math.max(maxArea, height * (rightMin - leftMin - 1));
            }
            stack.push(i);
        }

        System.out.println(maxArea);
    }
}
