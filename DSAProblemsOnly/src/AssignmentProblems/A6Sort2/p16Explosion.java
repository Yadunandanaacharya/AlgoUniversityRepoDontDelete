package AssignmentProblems.A6Sort2;

import java.io.*;
import java.util.*;

public class p16Explosion {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfExplosive = Integer.parseInt(br.readLine());

        String[] explosivesArrayString = br.readLine().split(" ");
        List<Long> inputArrayExplosives = new ArrayList();
        for (int i=0; i <noOfExplosive; i++ ){
            inputArrayExplosives.add(Long.parseLong(explosivesArrayString[i]));
        }

        Collections.sort(inputArrayExplosives);
        /*
        6
        8 5 6 13 3 4
        3 4 5 6 8 13
         */

    }
}
