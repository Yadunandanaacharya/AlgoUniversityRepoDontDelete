package Contest1Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
7
3
5
1
6
2
14
10
 */
public class MaxDivideByK {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inpputArray = new int[n];
        for(int i = 0; i <inpputArray.length;i++){
            inpputArray[i] = Integer.parseInt(br.readLine());
        }

        int maxSum = Integer.MIN_VALUE;

        int maxCount = 0;
        int count = 0;
        for(int i = 0; i < n;i++) {
            maxSum = 0;
            count = 0;
            int currSum = 0;
            for(int j=i; j<n;j++) {
                currSum = currSum + inpputArray[j];
                if (currSum> 0) {
                    count +=1;
                    if (currSum % n == 0) {
                        maxSum = Math.max(currSum, maxSum);
                        maxCount = Math.max(count,maxCount);
                    }
                }
            }
        }

        System.out.println(maxCount);
    }
}
