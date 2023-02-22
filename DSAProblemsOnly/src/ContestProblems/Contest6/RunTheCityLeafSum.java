package ContestProblems.Contest6;

import java.io.*;
import java.util.*;

/*
8 22
1 2
2 3
1 4
2 5
4 6
4 7
7 8
 */

public class RunTheCityLeafSum {
    public static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    public static int visited[];
    public static int answer = 0;
    public static List<Integer> childrenList = new ArrayList<>();
    public static int sum = 0;
    public static int vertices = 0;
    public static int childCount = 0;
    public static int root = 1;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] verticesAndSum = br.readLine().split(" ");
        vertices = Integer.parseInt(verticesAndSum[0]);
        sum = Integer.parseInt(verticesAndSum[1]);

        visited = new int[vertices + 1];

        //if 1 based indexing then do vertices+1
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < vertices - 1; i++) {
            String[] node1And2 = br.readLine().split(" ");
            adjList.get(Integer.parseInt(node1And2[0])).add(Integer.parseInt(node1And2[1]));
            adjList.get(Integer.parseInt(node1And2[1])).add(Integer.parseInt(node1And2[0]));
        }

        DFS(root,0);

        for(int child : childrenList)
            answer+=child;

        if (answer >= sum)
            System.out.println("YES");
        else
            System.out.println("NO");
    }


    public static boolean BFS(int src, int parent) {
        int visited[] = new int[vertices];
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
//        visited[src] = 1;
        queue.push(src);
        int sizeIs = adjList.get(src).size();

        while (queue.size() != 0) {
            int current = queue.poll(); //poll removes first item from queue
//            visited[current] = 1;
            if (current != root) {
                for (int child : adjList.get(current)) {
                    if (sizeIs == 1 && child == parent)
                        return true;
                }
            }
        }

        return false;
    }

    public static void DFS(int node, int parent) {
        visited[node] = 1;

        boolean leafNode = BFS(node, parent);
        if (leafNode){
            childrenList.add(node);
        }

        for (int child : adjList.get(node)) {
            if (visited[child] == 0) {
                DFS(child, node);
            }
        }

        return;
    }
}
