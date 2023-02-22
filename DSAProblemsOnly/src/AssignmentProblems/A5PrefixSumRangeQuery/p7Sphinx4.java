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

preSum=
4 8 11 12 17 21 26 30 32
0 1 2   3  4  5  6  7  8
1 2 3   4  5  6  7  8  9

1 6 -> 0 5
2 8 -> 1 7
1 3 -> 0 2
4 8 -> 3 7
5 8 -> 4 7

ans:
21
26
11
19
18
 */

//one big disadvantage of intellij it does not print

public class p7Sphinx4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputArrayString = br.readLine().split(" ");

        long[] inputArray = new long[N];
        for (int i = 0; i < N; i++)
            inputArray[i] = Long.parseLong(inputArrayString[i]);

        long[] prefixSum = new long[N];
        prefixSum[0] = inputArray[0];
        for (int i = 1; i < N; i++)
            prefixSum[i] = prefixSum[i-1] + inputArray[i];

        int Q = Integer.parseInt(br.readLine());
        List<String[]> userInputs = new ArrayList<>();
        for (int i = 0; i < Q; i++)
            userInputs.add(br.readLine().split(" "));

        for (int i = 0; i < userInputs.size(); i++) {
            if (Integer.parseInt(userInputs.get(i)[0]) -1 != 0)
                System.out.println(prefixSum[Integer.parseInt(userInputs.get(i)[1])-1] - prefixSum[Integer.parseInt(userInputs.get(i)[0]) -1 - 1]);
            else
                System.out.println(prefixSum[Integer.parseInt(userInputs.get(i)[1])-1]);
        }
    }
}
