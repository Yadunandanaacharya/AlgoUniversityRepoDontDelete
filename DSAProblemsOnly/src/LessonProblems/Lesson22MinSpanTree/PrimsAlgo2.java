package LessonProblems.Lesson22MinSpanTree;

import java.io.*;
import java.util.*;


//https://www.algotree.org/algorithms/minimum_spanning_tree/prims_java/

/*
6 6
0 1 2
1 2 3
2 3 4
1 3 6
0 5 3
5 3 6
ans=12


5 6
1 2 3
2 3 5
2 4 2
3 4 8
5 1 7
5 4 4
ans=14

 */

public class PrimsAlgo2 {
    public static HashMap<Integer, ArrayList<Node>> adjList = new HashMap<>();
    public static long totalWeight = 0;

    public static class Node {
        public int toNode;
        public long weight;

        public Node(int toNode, long weight) {
            this.toNode = toNode;
            this.weight = weight;
        }

        public long GetWeight() {
            return this.weight;
        }
    }

    public static class Edge {
        public int toNode = -1;
        public long weight1 = Integer.MAX_VALUE;

        public Edge(int weight1, int toNode) {
            this.weight1 = weight1;
            this.toNode = toNode;
        }

        public long getWeight() {return this.weight1;}

        public int compare(Edge edge) {
            if(this.weight1 < edge.weight1)
                return -1;
            else if (this.weight1 > edge.weight1)
                return  1;
            else
                return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[1]);

        //we used put here for map since we just insert key value pair into map
//        for (int i = 0; i<= nodes; i++) {
        for (int i = 1; i<= nodes; i++) { //1 based indexing
            adjList.put(i, new ArrayList<Node>());
        }

        //here we don't use put since first we get key inside that key we have arrayList
        //so for adding to arrayList we use add
        for (int i = 0; i < edges; i++) {
            s = br.readLine().split(" ");
            int fromNode = Integer.parseInt(s[0]);
            int toNode = Integer.parseInt(s[1]);
            long weight = Long.parseLong(s[2]);
            adjList.get(fromNode).add(new Node(toNode, weight));
        }

        PrimsMST(adjList, 1, nodes);
        System.out.println(totalWeight);
    }

    public static void PrimsMST(HashMap<Integer, ArrayList<Node>> adjList, int src, int nodes){
        boolean[] visited = new boolean[nodes + 1];
        long[] distance = new long[nodes + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Comparator<Node> nodeComparator = Comparator.comparingLong(Node:: GetWeight);
        Comparator<Edge> edgeComparator = Comparator.comparingLong(Edge:: getWeight);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nodeComparator);
        priorityQueue.add(new Node(src, 0));

        while (!priorityQueue.isEmpty()) {
            Node removedNode = priorityQueue.remove();

            if (!visited[removedNode.toNode]) {
                visited[removedNode.toNode] = true;
                totalWeight += removedNode.weight;

                for (Node neighbour : adjList.get(removedNode.toNode)) {
                    if (!visited[neighbour.toNode])
                        priorityQueue.add(new Node(neighbour.toNode, neighbour.weight));
                }
            }
        }
    }
}
