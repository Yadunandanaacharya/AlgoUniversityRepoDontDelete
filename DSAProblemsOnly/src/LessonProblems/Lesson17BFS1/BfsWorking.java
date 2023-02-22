package LessonProblems.Lesson17BFS1;

import java.io.*;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

//when you run if you paste inputs it works but while debug don't paste all inputs directly some time
//it doesn't work'
//IMPORTANT THERE IS PROBLEM WITH INTELLIJ buffreader taking inputs as it's pasted
//below input if you paste in console it won't take it'll give error of index so first manually type
//8 7 after that paste all edges after that type manually src and dest
//but same will work properly in ideone

/*
this below input not working
don't directly paste below inputs in console you get error instead first type 8 7 manually
after that paste 7 edges after that type src vertex again
8 7
1 2
1 3
2 6
3 4
3 5
4 7
6 8
1 2
below is workin
don't directly paste below inputs in console you get error instead first type 8 7 manually
after that paste 7 edges after that type src vertex again
http://graphonline.ru/en/?graph=QpphqTnAnHFksFsl
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
0 4

don't directly paste below inputs in console you get error instead first type 5 and 7 manually
after that paste 7 edges after that type src vertex again
5
7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
0 4
 */


public class BfsWorking {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vertexEdges = br.readLine().split(" ");
        int vertices = Integer.parseInt(vertexEdges[0]);
        int edges = Integer.parseInt(vertexEdges[1]);
        GraphList g = new GraphList(vertices);
        for (int i = 0; i < edges; i++) {
            String[] node1And2 = br.readLine().split(" ");
            int n1 = Integer.parseInt(node1And2[0]);
            int n2 = Integer.parseInt(node1And2[1]);
            g.AddEdge(n1, n2);
        }
//        String[] srcAndDest = br.readLine().split(" ");
//        g.BFS(Integer.parseInt(srcAndDest[0]));
        g.BFS(1);
    }
}


//ctrl+alt+t for folding with region first select code to fold
//region GraphList

class GraphList {
    ArrayList<ArrayList<Integer>> adjList;
    int vertices;

    public GraphList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void AddEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void BFS(int src) {
        int visited[] = new int[vertices];
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        visited[src] = 1;
        queue.push(src);

        while (queue.size() != 0) {
            int current = queue.poll(); //poll removes first item from queue
            visited[current] = 1;
            System.out.println(current );
            for (int child : adjList.get(current)) {
                if (visited[child] == 0) {
                    queue.offerLast(child);
                    visited[child] = 1;
                }
            }
        }
    }

    public void FindPath(int i, int j) {

    }
}

//endregion

//region GFG code for bfs above mine is not working
class Graph {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue
                = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued
            // vertex s If a adjacent has not been visited,
            // then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
//                System.out.println(queue);
            }
        }
    }
}
//endregion