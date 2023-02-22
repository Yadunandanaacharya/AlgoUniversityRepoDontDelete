package AssignmentProblems.A5PrefixSumRangeQuery;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
9
4 4 3 1 5 4 5 4 2
6
1 1
1 6
2 8
1 3
4 8
5 8

ans:
21
26
11
19
18
 */

public class p7SphinxRangeSums1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputArrayString = br.readLine().split(" ");

        int[] inputArray = new int[N];
        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(inputArrayString[i]);
        }

        if (N > 10e6)
            throw new ArithmeticException("Overflow");

        int[] prefixSum = new int[N];
        prefixSum[0] = inputArray[0];
        HashMap<Integer,Integer> preFixSumMap = new HashMap<>();
        for (int i = 1; i < N; i++) {
            int currSum = prefixSum[i - 1] + inputArray[i];
            if (currSum > 10e6)
                throw new ArithmeticException("Overflow");
            prefixSum[i] = currSum;
        }

        for (int i = 0; i<N;i++)
            preFixSumMap.put(i+1, prefixSum[i]);

        int Q = Integer.parseInt(br.readLine());
        if (Q > 10e6)
            throw new ArithmeticException("Overflow");

        List<String[]> userInputs = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            String[] rangeArrayLAndR = br.readLine().split(" ");
            userInputs.add(rangeArrayLAndR);
        }

        for(int i = 0; i<userInputs.size(); i++) {
            String[] array = userInputs.get(i);
            int left = Integer.parseInt(array[0]);
            int right = Integer.parseInt(array[1]);

            if(left ==1)
                System.out.println(preFixSumMap.get(right));
            else
                System.out.println(preFixSumMap.get(right) - preFixSumMap.get(left - 1));
        }
    }
}
