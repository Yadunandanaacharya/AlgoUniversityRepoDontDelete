package AssignmentProblems.A5PrefixSumRangeQuery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class p7SphinxRangesSum2 {
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
        HashMap<Integer, Integer> preFixSumMap = new HashMap<>();
        for (int i = 1; i < N; i++) {
            int currSum = prefixSum[i - 1] + inputArray[i];
            prefixSum[i] = currSum;
        }

        for (int i = 0; i < N; i++)
            preFixSumMap.put(i + 1, prefixSum[i]);

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

            if (left == 1) {
                long ans = preFixSumMap.get(right);
                System.out.println(ans);
            }
            else {
                long ans = preFixSumMap.get(right) - preFixSumMap.get(left - 1);
                System.out.println(ans);
            }
        }
    }
}
