package A0WarmupBunch1;
/*
Use two external array of size 100 to mark speed at each point for both ideal speed limit & actual speed,
road length is only 100.
You can now compare  the arrays & look for your answer.

https://stackoverflow.com/questions/43925430/insert-array-into-another-array

 3
40 75
50 35
10 45
these segments I guess I  have to store in 2d array
[[40,75],[50,35],[10,45]]

========input from question======
3 3
40 75
50 35
10 45
40 76
20 30
40 40
==================================

IN THIS FILE LOT OF IMPORTANT INFORMATION IS THERE THAT'S WHY KEPT LIKE THIS


 by using below code inside 1d arraylist we can put 1d array
 List<int[]> list = new ArrayList<>();
 list.add(new int[]{1, 2, 3});

or else we need to create a double 2d array inside that we need to put
1d doubt array
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class UnholyConsult1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String[] nMSegmentsArray = br.readLine().split(" ");
        int nSegments = Integer.parseInt(nMSegmentsArray[0]); //11
        int mSegments = Integer.parseInt(nMSegmentsArray[1]);    //8

        Map<Integer,Integer> nMap = new LinkedHashMap<>();
        Map<Integer,Integer> mMap = new LinkedHashMap<>();
//        there is difference b/w just HashMap and LinkedHashMap
//        In HashMap elements won't be in inserted order
//        but in LinkedHashMap elements will be inserted order only
//        https://docs.oracle.com/javase/7/docs/api/java/util/LinkedHashMap.html

        Dictionary dict1 = new Hashtable();
        Dictionary dict2 = new Hashtable();
        double[][] nSegmentsDistSpeedArray = new double[nSegments][nSegments];
        double[][] mSegmentsDistSpeedArray = new double[mSegments][mSegments];
        for (int i = 0; i < nSegments + mSegments; i++) {
            String[] segmentAndKmPerHourN = br.readLine().split(" ");
            int segment = Integer.parseInt(segmentAndKmPerHourN[0]);
            int kmPerHour = Integer.parseInt(segmentAndKmPerHourN[1]);
            double[] newArray = new double[2];
            newArray[0] = segment;
            newArray[1] = kmPerHour;
            nSegmentsDistSpeedArray[i] = newArray;
            nMap.put(segment,kmPerHour);
            dict1.put(segment,kmPerHour);
        }

        //YOU CAN'T USE 2 BUFFERREADER LIKE BELOW FOR LOOP WE USE BR.READLINE 2ND TIME
//        WHICH IS WRONG, WITH THIS WHAT HAPPENS IS BELOW BR.READLINE RUNS ONLY TWICE BUT YOU NEED
        //3 INPUTS FOR M SEGMENTS  SO YOU CAN'T USE TWO BR.READLINE ONE AFTER OHTER
//        for (int j = 0; j  < mSegments; j ++) {
//            String[] segmentAndKmPerHourM = br2.readLine().split(" ");
//            int segment = Integer.parseInt(segmentAndKmPerHourM[0]);
//            int kmPerHour = Integer.parseInt(segmentAndKmPerHourM[1]);
//            double[] newArray = new double[2];
//            newArray[0] = segment;
//            newArray[1] = kmPerHour;
//            mSegmentsDistSpeedArray[j ] = newArray;
//            mMap.put(segment,kmPerHour);
//            dict2.put(segment,kmPerHour);
//        }

//        int[] nSegmentsTravelledArray = new int[100];
//        int[] mSegmentsTravelledArray = new int[100];

//        for (int i = 0; i < nSegmentsDistSpeedArray.length; i++) { //this equals to the row in our matrix.
//            for (int j = 0; j < nSegmentsDistSpeedArray[i].length; j++) { //this equals to the column in each row.
//                System.out.print(nSegmentsDistSpeedArray[i][j] + " ");
//            }
//            System.out.println(); //change line on console as row comes to end in the matrix.
//        }

//        for (int i = 0; i < nSegmentsDistSpeedArray.length; i++) { //this equals to the row in our matrix.
//            for (int j = 0; j < nSegmentsDistSpeedArray[i].length; j++) { //this equals to the column in each row.
////                for(int k = 0; k<100;k++) {
//                    String s = String.valueOf(nSegmentsDistSpeedArray[i][j]);
//                    System.out.print(s + " ");
////                }
//            }
//            System.out.println(); //change line on console as row comes to end in the matrix.
//        }

//         below is possible answer
        int[] nSegmentsTravelledArray = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i<40)
                nSegmentsTravelledArray[i] = 75;
            else if (i>=40 && i<40+50)
                nSegmentsTravelledArray[i] = 35;
            else if (i>=40+50 && i<100)
                nSegmentsTravelledArray[i] = 45;
        }
        int[] mSegmentsTravelledArray = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i<40)
                mSegmentsTravelledArray[i] = 76;
            else if (i>=40 && i<40+20)
                mSegmentsTravelledArray[i] = 30;
            else if (i>=40+20 && i<100)
                mSegmentsTravelledArray[i] = 40;
        }
        int[] ansArray = new int[100];
        for (int i = 0; i < 100; i++) {
            ansArray[i] = Math.abs(nSegmentsTravelledArray[i] - mSegmentsTravelledArray[i]);
        }

        System.out.println("hi");
    }
}
