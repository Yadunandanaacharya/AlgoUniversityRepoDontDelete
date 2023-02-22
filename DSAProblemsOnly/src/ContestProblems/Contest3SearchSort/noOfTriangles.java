package ContestProblems.Contest3SearchSort;

import java.util.*;
import java.io.*;

public class noOfTriangles {
    public static void main(String[] args) throws Exception{
        int n = 5;
        int count=0;
        HashMap<int[],Integer> trackerMap = new HashMap<>();
        List<Integer> inputArray = new ArrayList(Arrays. asList(10, 6, 8, 6, 4));
        for(int i = 0; i < n-2;i++){
            for(int j=0;j<n-1;j++){
                for(int k=0;k<n;k++){
                    if (inputArray.get(k) < inputArray.get(i) +inputArray.get(k)) {

                    }
//                    else
//                        trackerMap.put(new int[]{})
//                        count++;
                }
            }
        }
        System.out.println(count);
    }
}

////5
//10
//
//        5
//        10 6 8 6 4
//4 6 6 8 10
//
//4 6 6
//4 6 8
//4 6 10 can'// TODO: 26-11-2022  '
//
//
//
//6 6 8
//6 8 10
