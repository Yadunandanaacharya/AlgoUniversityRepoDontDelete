package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

/*
5
4 2 -3 1 6
 */

public class p22ZeroSum2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arrayLength = Long.parseLong(br.readLine());

        List<Long> inputList = new ArrayList();
        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i < arrayLength;i++){
            inputList.add(Long.parseLong(inputArrayString[i]));
        }

        String ans = SubArrayWithZeroSum(inputList);
        System.out.println(ans);
    }

    public static String SubArrayWithZeroSum(List<Long> inputList) {
        String ans = "NO";

        long sum = 0;
        HashSet<Long> hashSet = new HashSet();
        for (int i = 0; i < inputList.size();i++){
            sum += inputList.get(i);

            if(inputList.get(i) == 0 || sum == 0 || hashSet.contains(sum)){
                return "YES";
            }

            hashSet.add(sum);
        }

        return ans;
    }
}
