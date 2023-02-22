package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

//different cases
/*
1 2 3 4 5 ans 5
9 10 11 12 15 ans=4
1 5 6 7 8 ans=4

thinking what if duplicates will be there
1 1 1 2 3 3 4 5
I think if youu sort list it should handle duplicates also
 */

public class p24Consecutiveness {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arrayLength = Integer.parseInt(br.readLine());

        List<Long> inputList = new ArrayList();
        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i < arrayLength; i++) {
            inputList.add(Long.parseLong(inputArrayString[i]));
        }

        Collections.sort(inputList);

        HashMap<Long,Boolean> consecutiveMap = new HashMap();
        for (int i = 0; i < arrayLength; i++)
            consecutiveMap.put(inputList.get(i),false);

        int count = 0;
        int sum=0;
        for (int i = 0; i < arrayLength; i++) {
            sum = i + 1;
            if (consecutiveMap.containsKey(sum))
                count++;
            else
                count = 0;
        }

    }
}
