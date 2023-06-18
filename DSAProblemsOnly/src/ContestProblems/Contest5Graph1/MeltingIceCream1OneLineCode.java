package ContestProblems.Contest5Graph1;

import java.io.*;
import java.util.*;

public class MeltingIceCream1OneLineCode {
    public static class PairOfInt
    {
        int i = 0;
        int j = 0;

        public PairOfInt(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpStr = br.readLine().split(" ");
        int n = Integer.parseInt(inpStr[0]);
        int m = Integer.parseInt(inpStr[1]);
        int k = Integer.parseInt(inpStr[2]);

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        PairOfInt shop;
        PairOfInt home;

        //we are interested only on i and h that is i-shop, h-home
        for (int i = 0; i <n;i++) {
            String s = br.readLine();
            for (int j = 0 ; j<m;j++){
                if (s.charAt(j) == 'i'){
                    shop = new PairOfInt(i, j);
                }
                if (s.charAt(j) == 'j'){
                    home = new PairOfInt(i, j);
                }
            }
        }


    }


}
