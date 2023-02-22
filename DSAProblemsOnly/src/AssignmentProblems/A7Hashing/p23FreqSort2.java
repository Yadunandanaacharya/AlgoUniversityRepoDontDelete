package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

/*
5
2 3 3 2 1

2 2 3 3 1

 */

//https://www.geeksforgeeks.org/sort-elements-by-frequency/
public class p23FreqSort2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arrayLength = Integer.parseInt(br.readLine());

        List<Integer> inputList = new ArrayList();
        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i < arrayLength;i++){
            inputList.add(Integer.parseInt(inputArrayString[i]));
        }

        SortBasedOnFrequencyAndValue(inputList);
    }

    public static void SortBasedOnFrequencyAndValue(List<Integer> list) {
        HashMap<Integer,Integer> mapCount = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> mapIndex = new HashMap<Integer,Integer>();

        for(int i = 0; i<list.size();i++){
            if(mapCount.containsKey(list.get(i)))
                mapCount.put(list.get(i),mapCount.get(list.get(i)) + 1);
            else{
                mapCount.put(list.get(i),1);
                mapIndex.put(list.get(i), i); //put index of first occurence of arry item to map
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                int freq1 =  mapCount.get(n1); //get count of array item from map
                int freq2 =  mapCount.get(n2); //get count of array item from map

                if (freq1 != freq2)
                    return freq2 - freq1; //print whichever greater
                else
                    return mapIndex.get(n1) - mapIndex.get(n2); //element with less index gets hig
                //priority
            }
        });

        for (int i = 0; i< list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
