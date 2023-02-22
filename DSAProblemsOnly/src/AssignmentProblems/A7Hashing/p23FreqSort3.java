package AssignmentProblems.A7Hashing;

import java.util.*;
/*
5
2 3 3 2 1


11
2 3 2 4 5 12 2 3 3 3 12

5
5 4 3 2 1

5
1 2 3 4 5

6
200 130 120 100 100 1

gfg code with good comments
https://www.geeksforgeeks.org/sort-elements-by-frequency-set-5-using-java-map/
*/
public class p23FreqSort3 {
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(scn.nextInt());

        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : list) {
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        SortComparator comp = new SortComparator(map, list);  //SortComparator method object initiate
        //passing current map to that comp
        System.out.println(list);
        Collections.sort(list, comp);
        System.out.println(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}

class SortComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> freqMap;
    private final List<Integer> inputlist;

    //constructor
    SortComparator(Map<Integer, Integer> map, List<Integer> list) {
        this.freqMap = map;
        this.inputlist = list;
        System.out.println("frequency of map this is " + this.freqMap);
    }

    //map is like key,value pair. Now first we compare based on value or frequency
    //if two values of map or frequency of two numbers are equal that time we compare their keys
    //compare the values
    @Override
    public int compare(Integer x, Integer y) {
        //comparae the value by frequency of map
        System.out.println("x is " + x + " y is " + y);
        int frequencyCompare = freqMap.get(y).compareTo(freqMap.get(x));
        System.out.println("freqMap.get(y).compareTo(freqMap.get(x) is " + frequencyCompare);
        System.out.println("frequency of " + x + " is " + freqMap.get(x));
        System.out.println("frequency of " + y + " is " + freqMap.get(y));
        //while comparing if frequencies of two numbers are equal in map then compare their keys
        //x and y which are passed are like keys of freqMap
        int valueOfMap = x.compareTo(y);
        System.out.println("x.commpareTo y is " + valueOfMap);

        if (frequencyCompare == 0) {
            System.out.println("when frequencyCompare is 0  then we print valueofMap" + valueOfMap);
            System.out.println("frequency sorted list " + inputlist);
            System.out.println("new iteration next");
            System.out.println();
            return valueOfMap;
        }
        else{
            System.out.println("when frequencyCompare is not 0 that time print  frequencyCompare " + frequencyCompare);
            System.out.println("frequency sorted list " + inputlist);
            System.out.println("new iteration next");
            System.out.println();
            return frequencyCompare;
        }

    }
}
