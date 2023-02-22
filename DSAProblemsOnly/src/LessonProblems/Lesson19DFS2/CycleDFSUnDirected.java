package LessonProblems.Lesson19DFS2;

import java.io.*;
import java.util.*;

/*
Here this is little bit different type of method here we don't create separate
class for graph inside main method only writing findCycle method
Since here we need global visited array and adjlist array

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
above output: NO CYCLE
 */

public class CycleDFSUnDirected {

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

        //#region why do we loop through all the vertices:
        /*
        if there are multiple componenents present like
        0 1 one component
        2 3 another component

        below is component of graph with cycle 4->5 5->6 6->4 cycle
        4 5
        5 6
        6 4
         */

        //#endregion
        for (int i = 0; i < vertices; i++) {
            if (visited[i] == 0) { //this checking important don't check visited edge again
                //that's why checking only unvisited not marked edge
                boolean ans = FindCycle(i, -1);
                if (ans == true) {
                    System.out.println("CYCLE");
                    return; //this also imp: if you use break it just break from for loop
                    //and go outside and again print NO CYCLE but if you use return it directly
                    //returns out of main method
                }
            }
        }

        System.out.println("NO CYCLE");
    }

    public static boolean FindCycle(int node, int parent) {
        visited[node] = 1;
        for (int child : adjList.get(node)){
            if (visited[child] == 1 && child != parent) return  true;
            if (visited[child] == 0 && FindCycle(child, node)) return  true;
        }

        return  false;
    }
}

//# region graph class not needed without that we find cycle
//
//class GraphList1 {
//    ArrayList<ArrayList<Integer>> adjList;
//    int vertices;
//
//    public GraphList1(int vertices) {
//        this.vertices = vertices;
//        adjList = new ArrayList<ArrayList<Integer>>();
//        for (int i = 0; i < vertices + 1; i++) {
//            adjList.add(new ArrayList<Integer>());
//        }
//    }
//
//    public void AddEdge(int i, int j) {
//        adjList.get(i).add(j);
//        adjList.get(j).add(i);
//    }
//
//    public void DFSUtil(int src, int visited[]){
//        visited[src] = 1;
//        System.out.println(src);
//
//        for (int child : adjList.get(src)) {
//            if (visited[child] == 0) {
//                DFSUtil(child, visited);
//            }
//        }
//    }
//
//    boolean FindCycle(int node, int parent) {
//        visited[node] = 1;
//        for (int child : adjList.get(node)){
//            if (visited[node] == 1 && child != parent) return  true;
//            if (visited[node] == 1 && FindCycle(child, node)) return  true;
//        }
//
//        return  false;
//    }
//
////    public void DFS(int src) {
//////        DFSUtil(src, visited);
////
////    }
//
//}

//#endregion
