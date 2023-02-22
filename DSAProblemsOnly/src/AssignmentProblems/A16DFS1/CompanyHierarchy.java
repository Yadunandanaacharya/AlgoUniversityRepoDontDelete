package AssignmentProblems.A16DFS1;

import java.io.*;
import java.util.*;

/*
5 when N=5 we'll have no of employees like 1 2 3 4 5 but 1 is boss
so won't have any thing
2 3 4 5
1 1 2 3
like above i have to create input also like above only i can handle input
using for loop

5
1 1 2 3
 */

public class CompanyHierarchy {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfEmployees = Integer.parseInt(br.readLine());
        GraphList g = new GraphList(noOfEmployees);
        int input[] = new int[noOfEmployees - 1];
        String[] inputString = br.readLine().split(" "); // 1 1 2 3
        for (int i = 0; i < noOfEmployees - 1; i++) {
                input[i] = Integer.parseInt(inputString[i]);
        }

        int[] employeeArr = new int[noOfEmployees - 1];
        int count = 2;
        for(int i = 0; i < noOfEmployees+1; i++) {
            if (count < noOfEmployees+1)
                employeeArr[i] = count;

            count++;
        }

        for (int i = 0; i < employeeArr.length;i++) {
                g.AddEdge(input[i], employeeArr[i]);
        }

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

        for (int i = 1; i < noOfChildren.length; i++)
            System.out.print(noOfChildren[i] - 1 + " ");
    }
}