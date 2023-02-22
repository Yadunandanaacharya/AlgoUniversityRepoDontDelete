package AssignmentProblems.A4SearchSort1;

/*
18
4.2426406871

1000000000000000


note down below points without long and scn.nextlong your code won't get
accepted you might get N as 10^15 which is 10000000000000 your int can't handle it
notedown in doc
 */

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

public class p19SqrtOfN2 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        long inputInt = scn.nextLong();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int inputInt = Integer.parseInt(input[0]);

        double left = 0;
//        double ebsilon = 10E-8;
        double right = 10e15;
        int steps = 150;

        while (steps >= 0) {
            double middle = left + ((right - left) / 2);
            if (Predicate(middle, inputInt) == 1)
                right = middle;
            else
                left = middle;

            steps--;
        }

        System.out.println(left);
    }

    public static int Predicate(double middle, long inputInt) {
        if((middle * middle) > inputInt)
            return 1;
        else
            return 0;
    }
}
