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

public class SizeSubTree {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMJumps = br.readLine().split(" ");
        int noOfBuilding = Integer.parseInt(nAndMJumps[0]);
        int noOfPairs = Integer.parseInt(nAndMJumps[1]);
        GraphList1 g = new GraphList1(noOfBuilding);
        for (int i = 0; i < noOfPairs; i++) {
            String[] node1And2 = br.readLine().split(" ");
            g.AddEdge(Integer.parseInt(node1And2[0]), Integer.parseInt(node1And2[1]));
        }

        g.DFS(1);
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

    public int DFSUtil(int src, int visited[], int noOfChildren[]){
        visited[src] = 1;
        noOfChildren[src] = 1;

        for (int child : adjList.get(src)) {
            if (visited[child] == 0) {
                noOfChildren[src] += DFSUtil(child, visited, noOfChildren);
            }
        }

        return noOfChildren[src];
    }

    public void DFS(int src) {
        int visited[] = new int[vertices + 1];
        int noOfChildren[] = new int[vertices + 1];
        DFSUtil(src, visited, noOfChildren);

        for (int i = 0; i < noOfChildren.length; i++)
            System.out.println(i + " : " + noOfChildren[i] );
    }
}