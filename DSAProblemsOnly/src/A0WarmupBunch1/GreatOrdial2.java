package A0WarmupBunch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* in interview also we have to aask lot of question until you understand like for this proble
i didn't understand anything clearly after asking with rounak arun i could able to come
to thhis approach

 */

public class GreatOrdial2 {

    public static void main(String[] args) throws Exception {
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

 /*
 if any where x-y or y-z gap is 2 then min move is 2
  */
        if (consecutive) {
            System.out.println(minMoveCount);
            System.out.println(maxMoveCount);
        }
        else {
            int gapOfMaxNum = Math.abs(maxNum - middleNum); //19-15=4
            int gapOfMinNum = Math.abs(minNum - middleNum);  //10-15=5
            maxMoveCount = Math.max(gapOfMinNum,gapOfMaxNum) - 1;

            if (gapOfMaxNum == 2 || gapOfMinNum == 2) {
                minMoveCount = 1;
                System.out.println(minMoveCount);
                System.out.println(maxMoveCount);
            }
            else if (gapOfMaxNum != 2 && gapOfMinNum != 2) {
                minMoveCount = 2;
                System.out.println(minMoveCount);
                System.out.println(maxMoveCount);
            }
        }


        if (!consecutive) {
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

                boolean isConsecutive = MinMoveCountFinderWith1Move(maxNum, minNum, middleNum, maxGapNum
    , consecutive, overallCount, minMoveCount);

                consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;

            }

        }
    }

    public static boolean MinMoveCountFinderWith1Move(int maxNum, int minNum, int middleNum, int maxGapNum
    ,boolean consecutive, int overallCount, int minMoveCount) {
        if (Math.abs(minNum - middleNum) == 1 && !consecutive) {
            minNum = middleNum;
            middleNum = middleNum + 1;
            overallCount += 1;
            minMoveCount = overallCount;
            consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
        }
        if (Math.abs(middleNum - maxNum) == 1 && !consecutive) {
            minNum = middleNum - 1;
            overallCount += 1;
            minMoveCount = overallCount;
            consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
        }
        if (maxGapNum == minNum && !consecutive) {
            minNum = middleNum;
            middleNum = middleNum + 1;
            overallCount += 1;
            minMoveCount = overallCount;
            consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
        }
        if (maxGapNum == maxNum && !consecutive) {
            maxNum = middleNum;
            middleNum = middleNum - 1;
            overallCount += 1;
            minMoveCount = overallCount;
            consecutive = Math.abs(maxNum - middleNum) == 1 && Math.abs(middleNum - minNum) == 1;
        }
        return consecutive;
    }

    public static int MinMoveCountFinder() {

        return 0;
    }


}
