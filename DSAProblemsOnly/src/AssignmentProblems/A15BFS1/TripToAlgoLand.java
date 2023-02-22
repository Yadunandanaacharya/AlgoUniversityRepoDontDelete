package AssignmentProblems.A15BFS1;

import java.io.*;
import java.util.*;

/*
4 4
xor-city list-city kunal-road
matrix-city xor-city agni-path
list-city matrix-city pallav-maarg
matrix-city graph-city manvendra-road
xor-city graph-city

output:
kunal-road
pallav-maarg
manvendra-road

BELOW IS LITTLE CHANGED INPUT FROM PROBLEM GIVEN IN ALGO WEBSITE
7 5
A B a
B C b
C D c
E F d
D G e
A G

output:
4

a
b
c
e

example below for understanding easily

3 2
C D e
D E f
C E
 */

public class TripToAlgoLand {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Map<String, Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new HashMap<>());
        }

        int count = 0;
        HashMap<String, Integer> denoteStringNodesAsNumber = new HashMap<>();
        for (int j = 0; j < m; j++) {
            String node1 = sc.next();
            String node2 = sc.next();
            String path = sc.next();
            int a = 0;
            int b = 0;

            if (denoteStringNodesAsNumber.containsKey(node1)) {
                a = denoteStringNodesAsNumber.get(node1);
            }
            else {
                a = count++;
                denoteStringNodesAsNumber.put(node1, a);
            }

            if (denoteStringNodesAsNumber.containsKey(node2)) {
                b = denoteStringNodesAsNumber.get(node2);
            }
            else {
                b = count++;
                denoteStringNodesAsNumber.put(node2, b);
            }
            adjacencyList.get(a).put(path, b);
        }

        String src = sc.next();
        String dest = sc.next();
        int source = denoteStringNodesAsNumber.get(src);
        int destination = denoteStringNodesAsNumber.get(dest);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        String[] visited = new String[n];
        int[] visited2 = new int[n];

        visited[source] = "";
        visited2[source] = 0;

        while (queue.size() != 0) {
            int current = queue.remove();

            for (Map.Entry<String, Integer> entry : adjacencyList.get(current).entrySet()) {
                if (visited[entry.getValue()] == null) {
                    queue.add(entry.getValue());
                    visited[entry.getValue()] = visited[current] + "\n" + entry.getKey();
                    visited2[entry.getValue()] = visited2[current] + 1;
                }
            }
        }

        if (visited[destination] == null) {
            System.out.println("Impossible");
        } else {
            System.out.println(visited2[destination] + "\n" + visited[destination]);
        }
    }
}
