package AssignmentProblems.A12Recursion;

import java.io.*;
import java.util.*;

public class p68Fibonacci {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(FibonacciNumber(n));
    }

    public static int FibonacciNumber(int num) {
        if (num == 1 || num == 2) return 1;

        return FibonacciNumber(num -1 ) + FibonacciNumber(num - 2);
    }
}
