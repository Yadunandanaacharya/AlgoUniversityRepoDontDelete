package AssignmentProblems.A5PrefixSumRangeQuery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
9
4 4 3 1 5 4 5 4 2
5
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

//WRONG CODE

public class p7SphinxRangeSum0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputArrayString = br.readLine().split(" ");

        int[] inputArray = new int[N];
        for (int i = 0; i < N; i++) {
            inputArray[i] = Integer.parseInt(inputArrayString[i]);
        }

        int[] prefixSum = new int[N];
        prefixSum[0] = inputArray[0];
        for (int i = 1; i < N; i++)
            prefixSum[i] = prefixSum[i - 1] + inputArray[i];

        int Q = Integer.parseInt(br.readLine());
        List<String[]> userInputs = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            String[] rangeArrayLAndR = br.readLine().split(" ");
            userInputs.add(rangeArrayLAndR);
        }

        for(int i = 0; i<userInputs.size(); i++) {
            String[] array = userInputs.get(i);
            int left = Integer.parseInt(array[0]);
            int right = Integer.parseInt(array[1]);

            if(left != 1)
                System.out.println(prefixSum[right] - prefixSum[left - 1]);
            else
                System.out.println(prefixSum[right]);
        }
    }
}
