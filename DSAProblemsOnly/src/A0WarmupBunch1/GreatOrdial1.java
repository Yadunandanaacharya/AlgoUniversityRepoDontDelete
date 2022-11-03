package A0WarmupBunch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*4 7 9
Whenever you'll be given some problem first google out properly you didn't even know
meaning of consecutive after sereny in discard told i got 1% idea
later arun explained it poperly

if I move once then I move 4 to 8th position so that number
will be 7 8 9
with min 1 move it's in consecutive position

only 4 or 9 i can move
now if i try to move 9 then
9 i move to 6th position so count=1
4 6 7       still not in consecutive as there is one gap b/w 4 and 6
you move 7 to 5th position so count=2 so maximum no of moves now is 2
and ans is 4 5 6 which is in consecutive position

Logic:
#1 first condition if gap b/w x & y, b/w y & z, b/w x and z is 0 then 0 moves required
example: 4 5 6
#2 second: 4 7 9: gap b/w 4 and 7 is 3
gap b/w 7 and 9 is 2
when you move 4 to 8th position so increase count to 1 now check are 7 8 9 are consecutive
yes so minmovecount 1

#3 next i have to also check max move count: so only 4 and 9 i can move
9 if i move to 6th position so count 1 and numbers 4 6 7 still not consecutive
now if i either move 4 to 5th position or if i move 7 to 5th position both will work
if i move 4 to 5th position then 5 6 7 so count 1 total count=2
or else instead of 4 if I move 7 to 5th position in 4 6 7 then numbers: 4 5 6 now consecutive
with

*/

//below is wrong code
public class GreatOrdial1 {
    public static void main(String[] args)  throws Exception  {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = bufferReader.readLine().split(" ");

        int x = Integer.parseInt(str1[0]);
        int y = Integer.parseInt(str1[1]);
        int z = Integer.parseInt(str1[2]);
//4,5,6
        int maxNum = Math.max(x, Math.max(y, z)); //6
        int minNum = Math.min(x, Math.min(y, z)); //4
        int middleNum = x+y+z - maxNum - minNum; //15-6-4= 5
        boolean consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
        int minMoveCount = 0;
        int maxMoveCount = 0;
        int overallCount = 0;
        //6-5==1 true and 5-4==1 true
//need to check for negative numbers check for 0's also


        if (consecutive) {
            System.out.println(minMoveCount);
            System.out.println(maxMoveCount);
        }
        else {
            // 4 7 9
            //10 15 19

//            int  = gapOfMaxNum > gapOfMinNum ? maxNum : minNum; //10

            while (!consecutive) {
                int gapOfMaxNum = Math.abs(maxNum - middleNum); //19-15=4
                int gapOfMinNum = Math.abs(minNum - middleNum);  //10-15=5
                int maxGapNum = 0;
                if (gapOfMaxNum > gapOfMinNum)
                    maxGapNum = maxNum;
                else if (gapOfMinNum > gapOfMaxNum)
                    maxGapNum = minNum;
                else if (gapOfMaxNum == gapOfMinNum)
                    maxGapNum = minNum;

                if (Math.abs(minNum - middleNum) == 1 && !consecutive) {
                    maxNum = middleNum + 1;
                    overallCount += 1;
                    minMoveCount = overallCount;
                    maxMoveCount = overallCount;
                    consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
                }
                if (Math.abs(middleNum - maxNum) == 1 && !consecutive) {
                    minNum = middleNum - 1;
                    overallCount += 1;
                    minMoveCount = overallCount;
                    maxMoveCount = overallCount;
                    consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
                }
                if (maxGapNum == minNum && !consecutive) {
                    minNum = middleNum;
                    middleNum = middleNum + 1;
                    overallCount += 1;
                    minMoveCount = overallCount;
                    maxMoveCount = overallCount;
                    consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
                }
                if (maxGapNum == maxNum && !consecutive) {
                    maxNum = middleNum;
                    middleNum = middleNum - 1;
                    overallCount += 1;
                    minMoveCount = overallCount;
                    maxMoveCount = overallCount;
                    consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
                }

                consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
            }

            System.out.println(minMoveCount);
            System.out.println(maxMoveCount);
        }
    }
}
