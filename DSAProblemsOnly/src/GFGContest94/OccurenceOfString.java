package GFGContest94;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/*
10101
10101
10101
10101
 */

public class OccurenceOfString {

    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        String binary = BinaryNo(n);
        String hundred1 = "101";

        HashSet<ArrayList<Integer>> setIs = new HashSet<>();
        for (int i = 0; i < binary.length(); i++){
            for(int j = i; j < binary.length(); j++){
                for(int k = j; k <binary.length(); k++){
                    String formed = String.valueOf(binary.charAt(i))   + String.valueOf(binary.charAt(j)) + String.valueOf(binary.charAt(k));
                    if (formed.equals(hundred1)){
                        ArrayList<Integer> indeXarr = new ArrayList<Integer>();
                        indeXarr.add(i);
                        indeXarr.add(j);
                        indeXarr.add(k);
                        setIs.add(indeXarr);
                    }
                }
            }
        }

        System.out.println(setIs.size());
    }
    
    public static String BinaryNo(long n){
        long num = n;
        long newNum = n;
        long remainder = 0;
        String out = "";
        String out1 = "";

        while(newNum/2 != 0){
            remainder = newNum % 2;
            out += String.valueOf(remainder);
            newNum = newNum/2;
        }

        if (newNum != 0) {
            remainder = newNum % 2;
            out += String.valueOf(remainder);
            newNum = newNum/2;
        }

        for (int i = out.length() -1; i >=0 ;i--){
            out1 += out.charAt(i);
        }

        return out1;
    }
}
