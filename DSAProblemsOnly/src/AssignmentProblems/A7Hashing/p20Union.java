package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

/*
5 5
7 6 9 7 2
7 2 9 7 2
 */

public class p20Union {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrayLengthStr = br.readLine().split(" ");

        int arrayLength1 = Integer.parseInt(arrayLengthStr[0]);
        int arrayLength2 = Integer.parseInt(arrayLengthStr[1]);

        HashSet<Long> unionHashSet = new HashSet();

        String[] array1String = br.readLine().split(" ");
        for (int i = 0; i < arrayLength1;i++)
            unionHashSet.add(Long.parseLong(array1String[i]));

        String[] array2String = br.readLine().split(" ");
        for (int i = 0; i < arrayLength2;i++)
            unionHashSet.add(Long.parseLong(array2String[i]));

        List<Long> outputList = new ArrayList<Long>(unionHashSet);
        Collections.sort(outputList);

        for(int i = 0; i<outputList.size();i++)
            System.out.print(outputList.get(i) + " ");
    }
}
