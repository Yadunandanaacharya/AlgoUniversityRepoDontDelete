package LessonProblems.Lesson21TopoSortDijkstra;

import java.io.*;
import java.util.*;

/*
7 7
0 1
2 3
1 4
3 4
3 5
4 5
4 6

2 3 0 1 4 6 5

7 7
0 1
1 2
2 0
3 4
3 5
4 5
4 6

cycle is there b/w 0 1 2 so IMPOSSIBLE

4 3
0 1
0 2
1 2

 */

public class TopoSort {
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

        for (int i = 0; i < vertices; i++) {
            if (visited[i] == 0 && DFSFindCycle(i, 0) == 1) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        //topo sort start
        Arrays.fill(visited, 0);
        for(int i = 0; i < vertices; i++) {
            if (visited[i] == 0)
                DFS(i);
        }

        Collections.reverse(answer);

        for (int item : answer){
            System.out.print(item + " ");
        }
    }

    //this
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

    public static void DFS(int node) {
        visited[node] = 1;
        for (int child : adjList.get(node)){
            if (visited[child] == 0)
                DFS(child);
        }
        answer.add(node);
    }
}
