package LessonProblems.A13GraphBasics;
import java.util.Scanner;

/*
IMPORTANT:
GraphList CLASS you can see it's in same package but it's a different class or file that
we import here without any code
https://github.com/SparshAlgo/AlgoUniversity/tree/main/Graphs/class1
 */
public class BasicGraph {
    public static  void main(String[] args) throws Exception{

        try(Scanner sc  = new Scanner(System.in)){
            int vertices = sc.nextInt();
            GraphList graphList = new GraphList(vertices);
        }
    }

}


