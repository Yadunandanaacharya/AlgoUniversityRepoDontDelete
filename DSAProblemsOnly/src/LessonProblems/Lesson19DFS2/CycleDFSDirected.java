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

7 7
0 1
2 3
1 4
3 4
3 5
4 5
4 6
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

            //very very imp: for directed edge graph you'll use adjList to add only once since
            //it's directed single edge will be there
            //but in the case of undirected edge there won't be any direction so you'll add to
            //adjlist twice u to v and v to u
//            adjList.get(Integer.parseInt(node1And2[1])).add(Integer.parseInt(node1And2[0]));
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

    //here returning 1,2,0 are important if you return 1 then only it means that cycle is there
    //we return 1 or 2 based on coloring you can read notes for this
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
