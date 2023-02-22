package LessonProblems.A13GraphBasics;

import java.util.*;

/*
https://github.com/SparshAlgo/AlgoUniversity/blob/main/Graphs/class1/AdjacencyMatrix_class.java
it's always better to use adjacency list because matrix will take more time

    https://www.quora.com/Which-graph-representation-is-better-for-competitive-programming-in-C++-adjacency-list-or-adjacency-matrix
    you can read this blog once

    With matrix you'll understand implementations of graph in better way but while using in
    oas you have to use adjacency list only
 */


class Graph_Matrix {
    int[][] adjMatrix;
    int vertices;
    public Graph_Matrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }
    public void addEdge(int i, int j) {
        //undirected and unweighted graph
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
        //undirected and weighted graph (w)
        // adjMatrix[i][j] = w;
        // adjMatrix[j][i] = w;
        //directed and weighted graph (w)
        // adjMatrix[i][j] = w;
    }
    public void removeEdge(int i, int j) {
        // Undirected
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
        // Directed
        adjMatrix[i][j] = 0;
    }
    public boolean isEdge(int i, int j) {
        // if(adjMatrix[i][j] != 0){
        //     return true;
        // }
        // return false;
        return adjMatrix[i][j] != 0;
    }
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < vertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}


public class AdjaceMatrix{
    public static void main(String args[]){
        Graph_Matrix g;
        try (Scanner sc = new Scanner(System.in)) {
            int vertices = sc.nextInt();
            g = new Graph_Matrix(vertices);
            int edges = sc.nextInt();
            for (int i = 0; i < edges; i++) {
                g.addEdge(sc.nextInt(), sc.nextInt());
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
