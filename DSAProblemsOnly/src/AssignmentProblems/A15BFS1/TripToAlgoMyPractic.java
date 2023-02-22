package AssignmentProblems.A15BFS1;
import java.io.*;
import java.util.*;

public class TripToAlgoMyPractic {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMStringArr = br.readLine().split(" ");
        int n = Integer.parseInt(nAndMStringArr[0]);
        int m = Integer.parseInt(nAndMStringArr[1]);

        HashMap<List<String>,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] uAndVAndPath = br.readLine().split(" ");
            String u = uAndVAndPath[0];
            String v = uAndVAndPath[1];
            String path = uAndVAndPath[2];
//            map.
        }
    }
}
