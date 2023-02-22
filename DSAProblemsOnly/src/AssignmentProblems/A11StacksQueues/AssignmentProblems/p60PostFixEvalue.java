package AssignmentProblems.A11StacksQueues.AssignmentProblems;

import java.util.*;
import java.io.*;

/*
1 2 + 4 + 2 /

output:3

1 2 + 3 - 4 + 5 6 * 7 / 8 * - 9 -

output:-37

 */

public class p60PostFixEvalue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n;i++){
            if (input.charAt(i) != ' '){ //remeber this space denoted like this java: ' '
                if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){
                    //taking y first after that x since in input ""1 2 + 4 + 2 /""
                    //finally we get x=2 y=7 if we divide this we get ans as 0 which is wrong
                    //in C++ it works fine I guess but in java we have to do like take y first
                    //take x next

                    int y = stack.peek();
                    stack.pop();
                    int x = stack.peek();
                    stack.pop();
                    if(input.charAt(i) == '+') stack.push(x + y);
                    else if(input.charAt(i) == '-') stack.push(x - y);
                    else if(input.charAt(i) == '*') stack.push(x * y);
                    else if(input.charAt(i) == '/') stack.push(x / y);
                }
                else{
                    stack.push(input.charAt(i) - '0');
                }
            }
        }

        System.out.println(stack.peek());
    }
}

