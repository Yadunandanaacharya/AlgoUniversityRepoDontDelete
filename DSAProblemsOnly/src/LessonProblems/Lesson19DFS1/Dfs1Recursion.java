package LessonProblems.Lesson19DFS1;

import java.io.*;
import java.util.*;

/*

9 8
1 2
2 3
2 4
1 5
5 6
5 7
1 8
8 9

 */

public class Dfs1Recursion {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMJumps = br.readLine().split(" ");
        int noOfBuilding = Integer.parseInt(nAndMJumps[0]);
        int noOfPairs = Integer.parseInt(nAndMJumps[1]);
        GraphList g = new GraphList(noOfBuilding);
        for (int i = 0; i < noOfPairs; i++) {
            String[] node1And2 = br.readLine().split(" ");
            g.AddEdge(Integer.parseInt(node1And2[0]), Integer.parseInt(node1And2[1]));
        }
//        String[] srcAndDest = br.readLine().split(" ");
        g.DFS(1);
    }
}

class GraphList {
    ArrayList<ArrayList<Integer>> adjList;
    int vertices;

    public GraphList(int vertices) {
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

    public void DFSUtil(int src, int visited[]){
        visited[src] = 1;
        System.out.println(src);

        for (int child : adjList.get(src)) {
            if (visited[child] == 0) {
                DFSUtil(child, visited);
            }
        }
    }

    public void DFS(int src) {
        int visited[] = new int[vertices + 1];
        DFSUtil(src, visited);
    }

}
