package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

public class p21UniqueWindow {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndKStringArray = br.readLine().split(" ");
        int N = Integer.parseInt(nAndKStringArray[0]);
        int K = Integer.parseInt(nAndKStringArray[0]);

        List<Integer> inputList = new ArrayList();
        String[] inputArrayString = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inputList.add(Integer.parseInt(inputArrayString[i]));
        }

        int[] outputArray = new int[N];
        int ptr1=0;int ptr2=0;
        int windowSize=1;
        for (int i = 0; i < N; i++) {

        }
    }
}
