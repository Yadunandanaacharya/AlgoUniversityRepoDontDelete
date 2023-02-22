package LessonProblems.Lesson19DFS2;

import java.io.*;
import java.util.*;

/*
now working below code

4 3
0 1
1 2
2 3

5
1 2
1 3
3 4
3 5

 */

public class Diameter {
    public static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
    public static int visited[];
    public static int diameter = 0;
    public static List<Integer> childSubTreeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());

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

        diameter = Math.max(diameter, DFS(1));
        System.out.println(diameter - 2);
    }

    public static int DFS(int node) {
        visited[node] = 1;

        for (int child : adjList.get(node)) {
            if (visited[child] == 0) {
                childSubTreeList.add(DFS(child));
            }
        }
        //above we have recursion call, once recursion call ends after that only we
        //come down. Recursively above we're adding children to childSubTreeList

        if (childSubTreeList.size() == 0)
            return 1;

        Collections.sort(childSubTreeList, Collections.reverseOrder());

        if (childSubTreeList.size() >= 2){
            diameter = Math.max(diameter, childSubTreeList.get(0) + childSubTreeList.get(1) + 1);
        }
        else if (childSubTreeList.size() == 1){
            diameter = Math.max(diameter, childSubTreeList.get(0) + 1);
        }

        return childSubTreeList.get(0) + 1;
    }

}
