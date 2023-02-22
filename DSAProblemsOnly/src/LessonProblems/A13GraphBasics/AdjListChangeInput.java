package LessonProblems.A13GraphBasics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

//IMPORTANT THERE IS PROBLEM WITH INTELLIJ buffreader taking inputs as it's pasted
//below input if you paste in console it won't take it'll give error of index so first manually type
//8 7 after that paste all edges after that type manually src and dest
//but same will work properly in ideone

/*
IMPORTANT:
https://github.com/SparshAlgo/AlgoUniversity/tree/main/Graphs/class1

if you simply give input it won't work for below code
https://www.geeksforgeeks.org/graph-representation-using-java-arraylist/
from this link I got inputs so check it's graph how it looks
give input like below below is space separated input
start
5
7
0 1
0 4
1 2
1 3
1 4
2 3
3 4
end
above is in form of
vertices =5
edges =7 runs inside for loop
edge1 edge2
 */


public class  AdjListChangeInput{
    public static void main(String[] args) {
        GraphList1 graphList;
//        try(Scanner sc = new Scanner(System.in)){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int vertices = Integer.parseInt(br.readLine());
            graphList = new GraphList1(vertices);
            int edges = Integer.parseInt(br.readLine());
            for (int i = 0; i < edges; i++){
                String[] input = br.readLine().split(" ");
                int v1 = Integer.parseInt(input[0]);
                int v2 = Integer.parseInt(input[1]);
                graphList.AddEdge(v1, v2);
            }
//            graphList.AddEdge(1, 0);
//            graphList.PrintGraph();
//            System.out.println("deleting");
//            graphList.RemoveEdge(1,0);
//            System.out.println("after delete");
//            graphList.PrintGraph();
            graphList.BFS();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}

class GraphList1 {
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;

    public GraphList1(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < vertices; i++){
            adjList.add(new ArrayList<Integer>());
        }
    }

    public  void AddEdge(int i, int j){
        //add an edge from i to j here unweighted and undirected
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void RemoveEdge(int i, int j){
        //remove an edge from i to j
        int index = -1;
        //removing the connection b/w i->j
        for (int children : adjList.get(i)){
            index++;
            if (children == j){
                adjList.get(i).remove(index);
                break;
            }
        }
        index = -1;
        //removing the connection b/w j->i
        for (int children: adjList.get(j)){
            index++;
            if (children == i){
                adjList.get(j).remove(index);
                break;
            }
        }
    }

    public boolean isEdge(int i, int j){
        //check if an edge exists from i to j
        for (int children : adjList.get(i)){
            if (children == j){
                return true;
            }
        }
        return false;
    }

    public void PrintGraph(){
        for(int i = 0; i < vertices;i++){
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j < adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void BFS() {
        int visited[] = new int[vertices];
//        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
//        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        visited[0] = 1;
        queue.push(0);

        while (queue.size() != 0) {
            int current = queue.poll();
            visited[current] = 1;
            System.out.println(current );
            for (int child : adjList.get(current)) {
                if (visited[child] == 0) {
//                    System.out.print(child + " ");
//                    queue.push(child);
//                    queue.addFirst(child);
                    //issue not pushing at front
                    queue.offerFirst(child);
                    visited[child] = 1;
                }
            }
//            System.out.println();
        }

//        System.out.println(queue);
    }
}
