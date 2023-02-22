package AssignmentProblems.A4SearchSort1;

import java.util.Scanner;

/*
18
4.2426406871
 */

public class p19SqrtOfN {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int inputInt = scn.nextInt();

        double left = 0;
        double ebsilon = 10E-8;
        double right = 10E15;

        while (left + ebsilon < right) {
            double middle = left + (right - left) / 2;
            if (Predicate(middle, inputInt) == 1)
                right = middle;
            else
                left = middle;
        }

        System.out.println(left);
    }

    public static int Predicate(double middle, int inputInt) {
        if((middle * middle) > inputInt)
            return 1;
        else
            return 0;
    }
}
