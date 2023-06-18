package AssignmentProblems.A15BFS1;

import java.util.*;
import java.io.*;

/*
Sample 1 INPUT:
properties
5 5
1 3
2 3
1 2
3 5
4 5
1 4
Sample 1 OUTPUT:
text
3
Sample 2 INPUT:
properties
5 3
1 3
1 2
4 5
1 4
Sample 2 OUTPUT:
text
0
 */

public class MinJumpsSimpleBFSNoClass {
    
    public static int n;
    public static int m;
    public static ArrayList<ArrayList<Integer>> adjList;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMJumps = br.readLine().split(" ");
        n = Integer.parseInt(nAndMJumps[0]);
        m = Integer.parseInt(nAndMJumps[1]);
        adjList = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            String[] node1And2 = br.readLine().split(" ");
            int fromNode = Integer.parseInt(node1And2[0]);
            int toNode = Integer.parseInt(node1And2[1]);
            adjList.get(fromNode).add(toNode);
            adjList.get(toNode).add(fromNode);
        }

        String[] srcAndDest = br.readLine().split(" ");
        int src = Integer.parseInt(srcAndDest[0]);
        int dest = Integer.parseInt(srcAndDest[1]);
        BFS(src, dest);
    }

    private static void BFS(int src, int destination) {
        int visited[] = new int[n + 1];
        //either use ArrayDeque or else LinkedList
//        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        int[] distanceChild = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        visited[src] = 1;
        queue.add(src);

        while (queue.size() != 0) {
            int current = queue.poll(); //poll removes first item from queue
            visited[current] = 1;
            for (int child : adjList.get(current)) {
                if (visited[child] == 0) {
                    queue.add(child);
                    parent[child] = current; //for main parent that if for 1 val is -1
                    //parent array we store parent of that particular child node
                    //for root node it'll be -1
                    visited[child] = 1;
//                    distanceChild[child] = distanceChild[current] + 1;
                }
            }
        }

        List<Integer> answerList = new ArrayList<>();
        while (parent[destination] != -1) {
            answerList.add(destination);
            destination = parent[destination];
        }
        answerList.add(src);
        System.out.println(answerList.size()-1);
    }
}
