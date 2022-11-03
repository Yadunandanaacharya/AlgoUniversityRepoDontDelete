package A2Arrays;
import java.util.*;

public class p9TreasureRoom2 {
    public static void main(String[] args)
    {
//        int A[] = { 1, 4, 45, 6, 10, 8 };
        int A[] = { 4, 9 ,12, 20, 14, 2 ,1, 12 ,11 ,6, 4 ,3 ,4 };
        int sum = 7;
        int arr_size = A.length;

        find3Numbers(A, arr_size, sum);
    }
    static boolean find3Numbers(int A[],
                                int arr_size, int sum)
    {
        // Fix the first element as A[i]
        for (int i = 0; i < arr_size - 2; i++) {

            // Find pair in subarray A[i+1..n-1]
            // with sum equal to sum - A[i]
            HashSet<Integer> s = new HashSet<Integer>();
            int curr_sum = sum - A[i];
            for (int j = i + 1; j < arr_size; j++)
            {
                if (s.contains(curr_sum - A[j]))
                {
                    System.out.printf("Triplet is %d,%d, %d", A[i],A[j], curr_sum - A[j]);
                    return true;
                }
                s.add(A[j]);
            }
        }

        // If we reach here, then no triplet was found
        return false;
    }
}
