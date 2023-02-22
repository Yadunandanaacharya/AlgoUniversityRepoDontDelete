package LessonProblems.Lesson19DFS2;

import java.io.*;
import java.util.*;

/*
5 4
0 1
1 2
2 3
0 3

above output: CYCLE

4 3
0 1
1 2
2 3

above NO CYCEL

 */

public class CycleDFSDirected {
    public static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    public static int visited[];

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
            adjList.get(Integer.parseInt(node1And2[0])).add(Integer.parseInt(node1And2[1]));
            adjList.get(Integer.parseInt(node1And2[1])).add(Integer.parseInt(node1And2[0]));
        }

        visited = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == 0) {
                if (DFSFindCycle(i, 0) == 1) {
                    System.out.println("CYCLE");
                    return;
                }
            }
        }
        System.out.println("NO CYCLE");
    }

    public static int DFSFindCycle(int node, int parent) {
        visited[node] = 1;
        for(int child : adjList.get(node)) {
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
