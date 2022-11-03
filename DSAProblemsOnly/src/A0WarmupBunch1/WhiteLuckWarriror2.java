package A0WarmupBunch1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* hint given */
/*Lets say we wanted to create a minimum rectangle instead of a minimum square.

        In our pictorial representation below, lets say the orignal rectangles are as shown below.

        What we would have simply done is chosen a rectangle such that :
        * min_x = min(x1, x3);
        * max_x = max(x2, x4);
        * min_y = min(y1, y3);
        * max_y = max(y2, y4);
        * area of the min encompassing rectangle (dotted rectangle in the picture) would have been
        (max_x - min_x) * (max_y - min_y)

        How can we now do it for a minimum square ?
inputs:
6 6 8 8
1 8 4 9

 */

public class WhiteLuckWarriror2 {
    public static void main(String[] args)  throws Exception  {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = bufferReader.readLine().split(" ");
        String[] str2 = bufferReader.readLine().split(" ");

        int x1 = Integer.parseInt(str1[0]);
        int y1 = Integer.parseInt(str1[1]);
        int x2 = Integer.parseInt(str1[2]);
        int y2 = Integer.parseInt(str1[3]);

        int x3 = Integer.parseInt(str2[0]);
        int y3 = Integer.parseInt(str2[1]);
        int x4 = Integer.parseInt(str2[2]);
        int y4 = Integer.parseInt(str2[3]);

        int minX = Math.min(x1, x3);
        int maxX = Math.max(x2, x4);
        int minY = Math.min(y1, y3);
        int maxY = Math.max(y2, y4);

        int minAreaOfRectangle = Math.abs(maxX - minX) * Math.abs(maxY - minY);
        /*mistakes done while submitting code is below line previously I was finding larger length of rectangle
        only for that particular problem with inputs below
        inputs:
        6 6 8 8
        1 8 4 9
        With this what happens I did like this
        int minAreaOfRectangle = Math.abs(maxX - minX) * Math.abs(maxY - minY);
        int minAreaHelper1 = (maxX - minX);
        int minAreaOfSquare = minAreaHelper1 * minAreaHelper1;
        System.out.println(minAreaOfSquare);
        With above code suppose other end of rectangle that is maxY-minY if it's larger that time
        this code fails in submission

        so this code
        int minAreaHelper1 = (maxX - minX) > (maxY - minY) ? (maxX - minX) : (maxY - minY);
        works for all cases I check if ((maxX - minX) greater than (maxY - minY) then update
        minAreaHelper1 as (maxX - minX) else
        if (maxY - minY) is greater than (maxX - minX) then update
        minAreaHelper1 as (maxY - minY)
        this code accepted
        */
        int minAreaHelper1 = (maxX - minX) > (maxY - minY) ? (maxX - minX) : (maxY - minY);
        int minAreaOfSquare = minAreaHelper1 * minAreaHelper1;

        System.out.println(minAreaOfSquare);
    }
}
