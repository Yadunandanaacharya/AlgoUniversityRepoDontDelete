package LessonProblems.Lesson17BFS1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

/*
5 7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
 */

public class BFS2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMJumps = br.readLine().split(" ");
        int vertices = Integer.parseInt(nAndMJumps[0]);
        int edges = Integer.parseInt(nAndMJumps[1]);
        Graph2 g = new Graph2(vertices);
        for (int i = 0; i < edges; i++) {
            String[] node1And2 = br.readLine().split(" ");
            g.AddEdge(Integer.parseInt(node1And2[0]), Integer.parseInt(node1And2[1]));
        }
//        String[] srcAndDest = br.readLine().split(" ");
//        int number = Integer.parseInt(br.readLine());
        g.BFS(0);
    }
}

class Graph2{
    int vertices;
    LinkedList<Integer> adjacencyList[];

    public Graph2 (int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adjacencyList[i] = new LinkedList();
        }
    }

    public void AddEdge(int i, int j){
        adjacencyList[i].add(j);
    }

    public void BFS(int src){
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[src] = true;
        queue.add(src);

        while (queue.size() != 0){
            src = queue.poll();
            System.out.println(src);
            Iterator<Integer> iterator = adjacencyList[src].listIterator();
            while (iterator.hasNext()){
                int num = iterator.next();
                if (!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }
}

//region gfg code

//class Graph2 {
//    private int vertices; // No. of vertices
//    private LinkedList<Integer> adj[]; // Adjacency Lists
//
//    // Constructor
//    Graph2(int vertices)
//    {
//        vertices = vertices;
//        adj = new LinkedList[vertices];
//        for (int i = 0; i < vertices; ++i)
//            adj[i] = new LinkedList();
//    }
//
//    // Function to add an edge into the graph
//    void addEdge(int v, int w) { adj[v].add(w); }
//
//    // prints BFS traversal from a given source s
//    void BFS(int s)
//    {
//        // Mark all the vertices as not visited(By default
//        // set as false)
//        boolean visited[] = new boolean[V];
//
//        // Create a queue for BFS
//        LinkedList<Integer> queue
//                = new LinkedList<Integer>();
//
//        // Mark the current node as visited and enqueue it
//        visited[s] = true;
//        queue.add(s);
//
//        while (queue.size() != 0) {
//            // Dequeue a vertex from queue and print it
//            s = queue.poll();
//            System.out.print(s + " ");
//
//            // Get all adjacent vertices of the dequeued
//            // vertex s If a adjacent has not been visited,
//            // then mark it visited and enqueue it
//            Iterator<Integer> i = adj[s].listIterator();
//            while (i.hasNext()) {
//                int n = i.next();
//                if (!visited[n]) {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
//        }
//    }
//}

//endregion