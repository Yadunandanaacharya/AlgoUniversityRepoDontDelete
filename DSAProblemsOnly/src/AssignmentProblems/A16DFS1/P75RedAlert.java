package AssignmentProblems.A16DFS1;

import java.io.*;
import java.util.*;

/*
7 1
1 0 1 1 0 0 0
1 2
1 3
2 4
2 5
3 6
3 7


4 1
1 1 0 0
1 2
1 3
1 4

 */

public class P75RedAlert {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndCapacity = br.readLine().split(" ");
        int nNodes = Integer.parseInt(nAndCapacity[0]);
        int capacity = Integer.parseInt(nAndCapacity[1]);
        GraphList1 g = new GraphList1(nNodes);

        String[] redAlertArray = br.readLine().split(" ");
        int[] redAlertArrayInput = new int[nNodes + 1];
        int count = 1;
        for (int i = 0; i < redAlertArray.length; i++) {
            if (count < nNodes + 1)
                redAlertArrayInput[count] = Integer.parseInt(redAlertArray[i]);

            count++;
        }

        for (int i = 0; i < nNodes - 1; i++) {
            String[] node1And2 = br.readLine().split(" ");
            g.AddEdge(Integer.parseInt(node1And2[0]), Integer.parseInt(node1And2[1]));
        }

        g.DFS(1, redAlertArrayInput, capacity);
    }
}

class GraphList1 {
    ArrayList<ArrayList<Integer>> adjList;
    int vertices;

    public GraphList1(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void AddEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    int leafByChild = 0;
    public int DFSUtil(int src, int visited[],  int consecutiveFire, int[] redAlertArrayInput, int capacity){
        visited[src] = 1;
        consecutiveFire += redAlertArrayInput[src];

        if (redAlertArrayInput[src] == 0) {
            consecutiveFire = 0;
        }

        if (consecutiveFire > capacity) {
            return 0;
        }

        boolean isLeaf = true;
        for (int child : adjList.get(src)) {
            if (visited[child] == 0) {
                isLeaf = false;
                leafByChild += DFSUtil(child, visited, consecutiveFire, redAlertArrayInput, capacity);
            }
        }

        if(isLeaf) return 1;
        return leafByChild;
    }

    public void DFS(int src, int[] redAlertArrayInput, int capacity) {
        int visited[] = new int[vertices + 1];
        int consecutiveFire = 0;
        DFSUtil(src, visited, consecutiveFire, redAlertArrayInput, capacity);

            System.out.print(leafByChild);
    }
}