package AssignmentProblems.A0WarmupBunch1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UnholyConsult3_whileLoopUsed {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nMSegmentsArray = br.readLine().split(" ");
        int nSegments = Integer.parseInt(nMSegmentsArray[0]); //11
        int mSegments = Integer.parseInt(nMSegmentsArray[1]);    //8
        int[] nSpeedValArray = new int[100];
        int[] mSpeedValArray = new int[100];

        boolean stopper=false;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nSegments; i++) {
            String[] segmentAndKmPerHourN = br.readLine().split(" ");
            int segment = Integer.parseInt(segmentAndKmPerHourN[0]);
            int kmPerHour = Integer.parseInt(segmentAndKmPerHourN[1]);

            if(stopper) {
                stopper = false;
            }

            end += segment;
            while (start <= 99 && stopper==false) {
                nSpeedValArray[start] = kmPerHour;
                start++;

                if(start == end -1 && start != 99) {
                    nSpeedValArray[start] = kmPerHour;
                    stopper = true;
                    start++;
                }

                if (start == 99)
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

            if(stopper) {
                stopper = false;
            }

            end += segment;

            while (start <= 99 && stopper==false) {
                mSpeedValArray[start] = kmPerHour;
                start++;

                if(start == end -1 && start != 99) {
                    mSpeedValArray[start] = kmPerHour;
                    stopper = true;
                    start++;
                }

                if (start == 99)
                    stopper = true;
            }
        }

        int maxDifference = 0;
        int oldMaxDifference = 0;
        for (int k=0;k<100;k++) {
            if(mSpeedValArray[k] >nSpeedValArray[k]) {
                oldMaxDifference = mSpeedValArray[k] - nSpeedValArray[k];
                if (oldMaxDifference > maxDifference)
                    maxDifference =oldMaxDifference;
            }
        }

        System.out.println(maxDifference);
    }
}
