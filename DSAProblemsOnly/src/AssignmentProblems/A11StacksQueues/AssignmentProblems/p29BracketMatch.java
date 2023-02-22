package AssignmentProblems.A11StacksQueues.AssignmentProblems;

// import java.io.*;
import java.util.*;

/*
Sample 1 INPUT:
(())()
Sample 1 OUTPUT:
3 2 1 0 5 4

)((()
) (  (  (  )
0 1  2  3  4
this case below not handled

ans(())()
-1 -1 -1 4 3
 */

//this ans below does not follow all the test cases failed at first attempt
public class p29BracketMatch {
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        System.out.print("enter input: ");
        String inputString = scn.next();

        Stack<Integer> stack = new Stack();
//        List<Integer> ansList = new ArrayList();
        int[] ansList = new int[inputString.length()];
        for(int i = 0; i<inputString.length();i++) {
            if (inputString.charAt(i) == '('){
                stack.push(i);
            }
            else{
                if (stack.empty()){
                    ansList[i] = -1;
                }
                else {
                    int stackPeek = stack.pop();
                    if (inputString.charAt(stackPeek) == '(') {
                        ansList[stackPeek] = i;
                        ansList[i] = stackPeek;
//                    ansList.add(stackPeek,i);
//                    ansList.add(i,stackPeek);
                    }
                    else {

                    }
                }
            }
        }

        while (!stack.empty()){
            int stackPeek = stack.pop();
            ansList[stackPeek] = -1;
        }
        System.out.println(Arrays.toString(ansList).split(","));

        for (int i = 0; i<ansList.length;i++) {
            System.out.print(ansList[i] + " ");
        }
    }
}
