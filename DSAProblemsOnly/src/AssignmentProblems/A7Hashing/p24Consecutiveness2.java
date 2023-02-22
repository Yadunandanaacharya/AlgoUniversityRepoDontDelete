package AssignmentProblems.A7Hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
7
2 6 1 9 4 5 3

5
1 2 3 4 5
ans 5

5
9 10 11 12 15
ans=4

5
1 5 6 7 8
ans=4

thinking what if duplicates will be there
8
1 1 1 2 3 3 4 5

5
1 1 1 1 1

5
1 2 3 8 15
above case told by aman kumar

5
1 9 15 25 35

 */

//below is not handling so many test cases giving wrong ans on test case 2

//https://www.geeksforgeeks.org/maximum-consecutive-numbers-present-array/
//second approach
public class p24Consecutiveness2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arrayLength = Integer.parseInt(br.readLine());

        List<Long> inputList = new ArrayList();
        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i < arrayLength; i++) {
            inputList.add(Long.parseLong(inputArrayString[i]));
        }

        System.out.println(ConsecutiveNumbers(inputList));
    }

    public static int ConsecutiveNumbers(List<Long> inputList) {
        if (inputList.size() == 0)
            return 0;

        int ans = 1;
        int count = 1;

        Collections.sort(inputList);
        for(int i =1;i<inputList.size();i++){
            if (inputList.get(i) != inputList.get(i-1)){
//                if (inputList.get(i) - inputList.get(i-1) == 1)
                if (inputList.get(i) == 1 + inputList.get(i-1))
                    count++;
                else {
                    ans = Math.max(ans,count);
                    count = 1;
                }
            }
        }

        return Math.max(ans,count);
    }
}
