package AssignmentProblems.A0WarmupBunch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//You are on a number where your position is denoted by x. You want to travel to another point on the number line y. Normally,
//        the distance to y is simply |y−x|. However, you know there is a teleporter on the number line denoted by two positions
//        a and b. You can teleport from a directly to b or from b directly to a. Teleporting counts as travelling 0 distance.
//        What is the minimum distance you must travel to get from x to y.
//
//        Input
//        3 10 8 2
//        Output
//        3
/* go from 3 to telporter 2 distance 1km from telporter 2 to teleporter 8 0km distance
from 8 to 10 distance 2km so total 3km*/

//One path is obviously travelling from x to y.
//
//        What are the other two paths possible ?
//
//        One out of the two paths is travelling from x to a , teleporting from a to b, and then travelling from b to y.
//
//        PS: Have seen some of the implementations for this problem go complex. One simple trick to reduce implementation is
//        use predefined libraries like abs to code |y-x|

public class JudgingEye {
    public static void main(String[] args)  throws Exception  {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferReader.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int a = Integer.parseInt(str[2]);
        int b = Integer.parseInt(str[3]);
//        int x = 3;
//        int y = 10;
//        int a = 8;
//        int b = 2;

        int minimumTeleportedDistance = 0;
        int subtraction = y - x;
        int larger = a > b ? a : b;
        int smaller = a < b ? a : b;

//        int minDistFromXtoAorY
//        System.out.println(ans);
    }
}
