package AssignmentProblems.A7Hashing;

import java.io.*;
import java.util.*;

public class p21UniquWindow2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] nums = new int[n];
        s = br.readLine().trim().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(s[i]);
        }


        Map<Integer, Integer> freq = new HashMap<>();
        int i=0, j=0;
        while(j<n){
            if(j-i+1<=k){ //including current item into window
                freq.put(nums[j], freq.getOrDefault(nums[j],0)+1);
                if(j-i+1==k) {
                    bw.write(freq.size() + " ");
                }
                j++;
            }else{ //excluding first item from next window
                freq.put(nums[i], freq.getOrDefault(nums[i],0)-1);
                if(freq.get(nums[i])<=0)
                    freq.remove(nums[i]);
                i++;
            }
        }
        bw.write("\n");
        bw.flush();
    }

}


