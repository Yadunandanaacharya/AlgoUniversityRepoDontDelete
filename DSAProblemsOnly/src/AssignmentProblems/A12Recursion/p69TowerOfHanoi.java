package AssignmentProblems.A12Recursion;

import java.util.*;
import java.io.*;

public class p69TowerOfHanoi {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println((int)(Math.pow(2,n) - 1));
        TowerOfHanoi(n,1, 2, 3);
     }

    public static void TowerOfHanoi(int toalRodsMove, int fromRod, int toRod, int helperRod){
        if (toalRodsMove == 0) return;
        TowerOfHanoi(toalRodsMove - 1, fromRod, helperRod, toRod);
        System.out.println(toalRodsMove + " " + fromRod + " " + toRod);
        TowerOfHanoi(toalRodsMove - 1, helperRod, toRod, fromRod);
    }

}
