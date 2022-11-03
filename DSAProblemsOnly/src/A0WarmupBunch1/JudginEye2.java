package A0WarmupBunch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.*;

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

//input  3 10 8 2

public class JudginEye2 {
    public static void main(String[] args)  throws Exception  {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferReader.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int a = Integer.parseInt(str[2]);
        int b = Integer.parseInt(str[3]);

        int potentialAns1 = Math.abs(x - y);
        int smallerDistToTeleporterFromX = Math.abs(x - a) < Math.abs(x - b) ? Math.abs(x - a) : Math.abs(x - b);
        int smallerDistToTeleporterFromY = Math.abs(y - a) < Math.abs(y - b) ? Math.abs(y - a) : Math.abs(y - b);
        int potentialAns2 = smallerDistToTeleporterFromX + smallerDistToTeleporterFromY;
        int finalAns = 0;

        if (potentialAns1 < potentialAns2)
            finalAns = potentialAns1;
        else if (potentialAns2 < potentialAns1)
            finalAns = potentialAns2;

        System.out.println(finalAns);
    }
}
