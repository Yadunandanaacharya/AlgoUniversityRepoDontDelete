package AssignmentProblems.A12Recursion;

import java.util.*;
import java.io.*;

/*
abc

aabc
 */
public class p70PermutString {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String n = scn.next();
        int[] freqArr = new int[26];
        List<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i<n.length();i++)
            freqArr[n.charAt(i) - 'a']++; //
        //n.charAt(0)='a'-'a' = 97-97=0 at 0th index we fill 1
        //n.charAt(1)='b'-'a' = 98-97=1 at 1th index we fill 1
        //n.charAt(2)='c'-'a' = 99-97=2 at 2th index we fill 1

        String temp = "";
        PermutationOfString(temp, freqArr);
    }

    public static void PermutationOfString(String temp, int[] freq) {
        int sum = 0; //line1

        for (int i = 0; i < 26; i++) {  //line1
            sum += freq[i]; //line1
            if (freq[i] > 0){ //line2
                freq[i]--; //line3
                 int val3 = (i + 'a'); //line4
                char asciiToChar = (char) val3; //line5 //converting ascii value to it's original char
                //exaple i+'a' gives us like 97 we convert it to 'a'
                temp += asciiToChar; //line6
                PermutationOfString(temp, freq); //line7
                freq[i]++; //line8
                temp = temp.substring(0, temp.length() - 1);  ; //line9
            } //line10
        } //line11

        if (sum == 0){ //line12
            System.out.println(temp); //line13
        } //line14
        return; //line15
    }
}

