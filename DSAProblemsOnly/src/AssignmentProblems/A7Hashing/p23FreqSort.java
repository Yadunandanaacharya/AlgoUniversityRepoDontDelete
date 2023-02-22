package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

public class p23FreqSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arrayLength = Integer.parseInt(br.readLine());

        List<Integer> inputList = new ArrayList();
        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i < arrayLength;i++){
            inputList.add(Integer.parseInt(inputArrayString[i]));
        }

        Collections.sort(inputList,Collections.reverseOrder());
        HashMap<Integer, Integer> freqSortMap = new HashMap();

        for (int i = 0; i < arrayLength;i++) {
            if (freqSortMap.containsKey(inputList.get(i)))
                freqSortMap.put(inputList.get(i), freqSortMap.get(inputList.get(i)) + 1);
            else
                freqSortMap.put(inputList.get(i), 1);
        }

        //you can't create 2d array with below 2 for loops time becomes o(n^2) you should
//        solve in o(nlogn)
//        int[][] convertMapTo2DArray = new int[freqSortMap.size()][2];
//        for (int i = 0; i < convertMapTo2DArray.length; i++){
//            for (int j=0; j<convertMapTo2DArray[i].length;j++)
//        }

        //I should convert map to 2d array with o(n) time only
        long[][] convertMapTo2DArray = new long[freqSortMap.size()][2];
        int count = 0;
        for(Map.Entry<Integer,Integer> mapEntry : freqSortMap.entrySet()) {
            convertMapTo2DArray[count][0] = mapEntry.getKey();
            convertMapTo2DArray[count][1] = mapEntry.getValue();
            count++;
        }

        //now apply custom sorting
//        Collections.sort(convertMapTo2DArray, new Comparator(){
//            public int[] compare(int i, int j ) {
//                if ()
//            }
//        })

        System.out.println("out");
    }

}
