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

preSum= 4 8 11 12 17 21 26 30 32
ans:
21
26
11
19
18
 */
//getting memory limit exceeded because of map I guess at test case 7
public class p7SphinxUsedLong3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputArrayString = br.readLine().split(" ");
        HashMap<Integer,Long> inputArrayMap = new HashMap<>();
        for (int i = 0; i < N; i++)
            inputArrayMap.put(i, Long.parseLong(inputArrayString[i]));

        HashMap<Integer,Long> prefixSumMap = new HashMap<>();
        prefixSumMap.put(1,inputArrayMap.get(0));
        for (int i = 2; i < N; i++)
            prefixSumMap.put(i, prefixSumMap.get(i - 1) + inputArrayMap.get(i -1));

        prefixSumMap.put(N, prefixSumMap.get(N- 1) + inputArrayMap.get(N -1));

        int Q = Integer.parseInt(br.readLine());
        List<String[]> userInputs = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            String[] rangeArrayLAndR = br.readLine().split(" ");
            userInputs.add(rangeArrayLAndR);
        }

        for (int i = 0; i < userInputs.size(); i++) {
            String[] array = userInputs.get(i);
            int left = Integer.parseInt(array[0]);
            int right = Integer.parseInt(array[1]);

            if (left != 1) {
                long ans = prefixSumMap.get(right) - prefixSumMap.get(left - 1);
                System.out.println(ans);
            }
            else {
                long ans = prefixSumMap.get(right);
                System.out.println(ans);
            }
        }
    }
}
