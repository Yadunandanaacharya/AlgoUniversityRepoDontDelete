package AssignmentProblems.A0WarmupBunch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
        Use two external array of size 100 to mark speed at each point for both ideal speed limit & actual speed,
        road length is only 100.
        You can now compare  the arrays & look for your answer.

        https://stackoverflow.com/questions/43925430/insert-array-into-another-array

========input from question======
3 3
40 75
50 35
10 45
40 76
20 30
40 40

3 3
4 7
5 3
1 4
4 8
2 3
4 4

above input was not working so trying with below
3 3
7 7
6 6
5 5
1 1
2 2
3 3
==================================

        IN THIS FILE UnholyConsult1.java LOT OF IMPORTANT INFORMATION IS check it
        diff b/w LinkedHashmpa and hashmap, why can't we uses 2 br.readline in for loop one after other

        */

public class UnholyConsult2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nMSegmentsArray = br.readLine().split(" ");
        int nSegments = Integer.parseInt(nMSegmentsArray[0]); //11
        int mSegments = Integer.parseInt(nMSegmentsArray[1]);    //8
        int[] nSpeedValArray = new int[100];
        int[] mSpeedValArray = new int[100];


        double[][] nSegmentsDistSpeedArray = new double[nSegments][1];
        double[][] mSegmentsDistSpeedArray = new double[mSegments][1];
        boolean stopper=false;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nSegments; i++) {
            String[] segmentAndKmPerHourN = br.readLine().split(" ");
            int segment = Integer.parseInt(segmentAndKmPerHourN[0]);
            int kmPerHour = Integer.parseInt(segmentAndKmPerHourN[1]);
            double[] newArray = new double[2];
            newArray[0] = segment;
            newArray[1] = kmPerHour;
            nSegmentsDistSpeedArray[i] = newArray;

            if(stopper) {
                stopper = false;
            }
            end += segment;
            while (start <= 100 && stopper==false) {
                nSpeedValArray[start] = kmPerHour;
                start++;
                if(start == end -1 && start != 100) {
                    nSpeedValArray[start] = kmPerHour;
                    stopper = true;
                    start++;
                }
                if (start == 100)
                    stopper = true;
            }
        }

        stopper=false;
        start = 0;
        end = 0;
        for (int j = 0; j  < mSegments; j ++) {
            String[] segmentAndKmPerHourM = br.readLine().split(" ");
            int segment = Integer.parseInt(segmentAndKmPerHourM[0]);
            int kmPerHour = Integer.parseInt(segmentAndKmPerHourM[1]);
            double[] newArray = new double[2];
            newArray[0] = segment;
            newArray[1] = kmPerHour;
            mSegmentsDistSpeedArray[j] = newArray;

            if(stopper) {
                stopper = false;
            }
            end += segment;
            while (start <= 100 && stopper==false) {
                mSpeedValArray[start] = kmPerHour;
                start++;
                if(start == end -1 && start != 100) {
                    mSpeedValArray[start] = kmPerHour;
                    stopper = true;
                    start++;
                }
                if (start == 100)
                    stopper = true;
            }
        }

        int maxDifference = 0;
        for (int k=0;k<100;k++) {
            if(mSpeedValArray[k] >nSpeedValArray[k]) {
                maxDifference = mSpeedValArray[k] - nSpeedValArray[k];
            }
        }
        System.out.println(maxDifference);
//        for (int i=0; i<nSegmentsDistSpeedArray.length;i++){
//            for(int j=0; j<nSegmentsDistSpeedArray[i].length;j++) {
//                System.out.print(nSegmentsDistSpeedArray[i][j]);
//            }
//        }
    }
}
