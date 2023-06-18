package ContestProblems.Contest7;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/*
4 5
0 1
1 2
2 3
3 0
3 2

4 5
0 1
2 1
2 3
3 0
3 2

4 4
0 1
2 1
2 3
3 0

6 3
0 1
2 3
4 5
 */

public class Nirvana {
    public static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    public static int visited[];
    public static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] verticesAndEdges = br.readLine().split(" ");
        int vertices = Integer.parseInt(verticesAndEdges[0]);
        int edges = Integer.parseInt(verticesAndEdges[1]);

        //if 1 based indexing then do vertices+1
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges; i++) {
            String[] node1And2 = br.readLine().split(" ");
            //when you have directed graph add to adjList only once
            adjList.get(Integer.parseInt(node1And2[0])).add(Integer.parseInt(node1And2[1]));
        }

        visited = new int[vertices];
        int notCycle = 0;
//        int[] cycleNodes = new int[vertices];
        List<Integer> cycleNodesList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
//            if (visited[i] == 0 && DFSFindCycle(i, 0) == 0) {
            if (DFSFindCycle(i, 0) == 0) {
                notCycle++;
                cycleNodesList.add(i);
            }
        }

        if (cycleNodesList.size() > 0)
            Collections.sort(cycleNodesList);

        if (notCycle == 0)
            System.out.println(0);
        else {
            System.out.print(notCycle + " ");
            for (int i : cycleNodesList)
                System.out.print(i + " ");
        }
    }

    //this cycle method is for undirected, in directed we don't need checking parents and all
    public static int DFSFindCycle(int node, int parent) {
        visited[node] = 1;
        boolean check = false;

        for (int child : adjList.get(node)){
            if (visited[child] == 0){
                if (DFSFindCycle(child, node) == 1){
                    return 1;
                }
            }

            if (visited[child] == 1 && child != parent) {
                return 1;
            }

            if(visited[child] == 2) {
                continue;
            }
        }

        visited[node] = 2;
        return 0;
    }
}
