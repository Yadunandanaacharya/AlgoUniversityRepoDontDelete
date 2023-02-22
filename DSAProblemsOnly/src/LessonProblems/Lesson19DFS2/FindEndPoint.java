package LessonProblems.Lesson19DFS2;

import java.io.*;
import java.util.*;

/*
now working below code

another edge from 5

14 13
0 1
1 2
2 3
2 4
4 5
5 6
6 7
7 8
5 9
9 10
10 11
11 12
11 13
 */


public class FindEndPoint {
    public static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    public static int visited[];
    public static int distance[];
    public static int diameter = 0;
    public static int maxDistance = 0;
    public static int endPoint = 0;
    public static int n = 0;
    public static List<Integer> childSubTreeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] verticesAndEdges = br.readLine().split(" ");
        int vertices = Integer.parseInt(verticesAndEdges[0]);
        int edges = Integer.parseInt(verticesAndEdges[1]);

        visited = new int[vertices];
        distance = new int[vertices];
        endPoint = 0;

        //if 1 based indexing then do vertices+1
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges; i++) {
            String[] node1And2 = br.readLine().split(" ");
            adjList.get(Integer.parseInt(node1And2[0])).add(Integer.parseInt(node1And2[1]));
            adjList.get(Integer.parseInt(node1And2[1])).add(Integer.parseInt(node1And2[0]));
        }

        findEndPoint(0, 0, 0);
        int endPoint1 = endPoint;
        maxDistance = 0;
        findEndPoint(endPoint1, 0, 0);
        System.out.println("maxDistance " + maxDistance);

        int endPoint2 = endPoint;
        DFS(endPoint1, 0, 0);
        DFS(endPoint2, 0, 0);
        for (int x: distance){
            System.out.println("path is " + x);
        }
    }

    public static void findEndPoint(int index, int parent, int depth) {
        distance[index] = Math.max(distance[index], depth);
        if (maxDistance < depth) {
            maxDistance = depth;
            endPoint = index;
        }
        for (int child: adjList.get(index)) {
            if (child != parent )
                findEndPoint(child, index, depth + 1);
        }
    }

    public static void DFS(int index, int parent, int depth) {
        distance[index] = Math.max(distance[index],depth);
        for(int child : adjList.get(index)) {
            if (child != parent)
                DFS(child, index, depth + 1);
        }
    }
}
