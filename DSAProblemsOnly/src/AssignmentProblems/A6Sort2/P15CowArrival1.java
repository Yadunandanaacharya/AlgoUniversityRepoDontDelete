package AssignmentProblems.A6Sort2;

//below best thing searching like ""java compareto passing object""
//https://www.happycoders.eu/java/comparator-comparable-compareto/
import java.util.*;
public class P15CowArrival1 {
    public static void main(String[] args) {
        ArrayList<Integer> ss = new ArrayList<Integer>();
        ss.add(7695);
        ss.add(12498);
        ss.add(13559);
        ss.add(14372);
        ss.add(429);
        ss.add(4);
        ss.add(2546);
        ss.add(1319);
        ss.add(651);
        ss.add(9705);
        Collections.sort(ss);
        System.out.println(ss);
    }
}
