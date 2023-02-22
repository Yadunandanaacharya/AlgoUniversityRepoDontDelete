package AssignmentProblems.A5PrefixSumRangeQuery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p7SpinxRangeSum5 {
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

        //below code won't print properly in intellij but it prints correctly in ideone check it
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String[] arr = br.readLine().split(" ");
            int left = Integer.parseInt(br.readLine().split(" ")[0]);
            int right = Integer.parseInt(br.readLine().split(" ")[1]);

            left = left - 1;
            right = right - 1;

            if (left != 0)
                System.out.println(prefixSum[right] - prefixSum[left - 1]);
            else
                System.out.println(prefixSum[right]);
        }
    }
}
