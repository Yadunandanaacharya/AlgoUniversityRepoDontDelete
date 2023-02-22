package AssignmentProblems.A13GraphAssignment;

import java.util.*;
import java.io.*;

/*
4
0 1 0 1
1 0 1 0
0 1 1 1
1 0 1 1

1: 2 4
2: 1 3
3: 2 3 4
4: 1 3 4
 */

public class p73AdjacencyMatrixToList {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] inputArray = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] matrixRows = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                inputArray[i][j] = Integer.parseInt(matrixRows[j]);
            }
        }

        GraphList graphList = new GraphList(n);

//        for(int i =0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                System.out.print(inputArray[i][j]+" ");
//            }
//            System.out.println();
//        }
        for(int i =0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (inputArray[i][j] > 0) {
                    graphList.AddEdge(i, j);
                }
            }
        }

        graphList.PrintAllEdges();
    }
}

class GraphList{
    ArrayList<ArrayList<Integer>> adjList;
    int vertices;

    public GraphList(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<Integer>());
    }

    public void AddEdge(int i, int j){
        adjList.get(i).add(j);
//        adjList.get(j).add(i);
    }

    public void PrintAllEdges(){
        for(int i = 0; i < vertices; i++){
            System.out.print(i+1 + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j)+1 + " ");
            }
            System.out.println();
        }
    }
}