package AssignmentProblems.A20MSTPrims;

import LessonProblems.Lesson22MinSpanTree.PrimsAlgo;

import java.io.*;
import java.util.*;

/*
actually in prim's algo you don't need comparator for edge, since youo're
going based on min weight nodes
but in kruskal it's needed because i guess we're sorting based on edge weight first

5 6
1 2 3
2 3 5
2 4 2
3 4 8
5 1 7
5 4 4
ans=14

5 3
1 2 3
2 3 5
5 4 4

1 0
1 1 1

2 1
1 2 2

1 0

1 1
1 1 1

2 2
1 2 1
2 1 2
 */

public class RepairRoads {
    public static HashMap<Integer, ArrayList<Node>> adjList = new HashMap<>();
    public static long totalWeight = 0;

    public static class Node {
        public int weight;
        public int toNode;

        public Node(int weight,int toNode) {
            this.weight = weight;
            this.toNode = toNode;
        }

        public long GetWeight() {
            return this.weight;
        }
    }

//    https://github.com/cormacpayne/algorithms/blob/master/PrimsAlgorithmMST.java
//    creating class with comparable interface

//    public static class Edge1 implements Comparable<Edge1> {
//        int  weight1 = Integer.MAX_VALUE;
//        int toNode;
//
//        public Edge1(int weight1, int toNode) {
//            this.weight1 = weight1;
//            this.toNode = toNode;
//        }
//
//        public int compareTo(Edge1 e) {
//            return this.weight1 - e.weight1;
//        }
//    }

    public static class Edge1 {
        int  weight1 = Integer.MAX_VALUE;
        int toNode;

        public Edge1(int weight1, int toNode) {
            this.weight1 = weight1;
            this.toNode = toNode;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[1]);

        if (edges == 1) {
            System.out.println(edges);
            return;
        }

        //we used put here for map since we just insert key value pair into map
        for (int i = 1; i <= nodes; i++) { //0 based inde
            adjList.put(i, new ArrayList<Node>());
        }

        //here we don't use put since first we get key inside that key we have arrayList
        //so for adding to arrayList we use add
        for (int i = 0; i < edges; i++) {
            s = br.readLine().split(" ");
            int fromNode = Integer.parseInt(s[0]);
            int toNode = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            adjList.get(fromNode).add(new Node(weight,toNode));
            adjList.get(toNode).add(new Node(weight,fromNode));
        }

        PrimsMST(adjList, 1, nodes);
    }

    public static void PrimsMST(HashMap<Integer, ArrayList<Node>> adjList, int src, int nodes) {
        boolean[] visited = new boolean[nodes + 1];
        long[] distance = new long[nodes + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Comparator<Node> nodeComparator = Comparator.comparingLong(Node::GetWeight);
//        Comparator<Edge1> edgeComparator = Comparator.comparingLong(Edge1 :: getWeight);
        List<Edge1> minEdges = new ArrayList<Edge1>();
        Edge1[] minEdges1 = new Edge1[nodes + 1];
//        Arrays.fill(minEdges1,0);

        for (int i=1; i<=nodes+1 ;i++) {
            minEdges.add(new Edge1(Integer.MAX_VALUE,i));
        }
        minEdges.get(src).weight1 = 0;
//        minEdges.add(new Edge1(src, 0));

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nodeComparator);
        priorityQueue.add(new Node(0,src));

        for (int i = 0; i < nodes; i++) {
            if (priorityQueue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            Node removedNode = priorityQueue.remove();
            visited[removedNode.toNode] = true;
            totalWeight += removedNode.weight;

//            if (minEdges.get(removedNode.toNode).toNode != -1)
//            if (minEdges.get(removedNode.toNode).toNode != -1)
//                System.out.println("node " + minEdges.get(removedNode.toNode).toNode);

            for (Node neighbour : adjList.get(removedNode.toNode)) {
                if (!visited[neighbour.toNode] && neighbour.weight < minEdges.get(neighbour.toNode).weight1) {
                    Node nodeToRemove = new Node(minEdges.get(neighbour.toNode).weight1, neighbour.toNode);
                    priorityQueue.remove(nodeToRemove);
                    minEdges.get(neighbour.toNode).toNode = removedNode.toNode;
                    minEdges.get(neighbour.toNode).weight1 = neighbour.weight;
                    priorityQueue.add(new Node(neighbour.weight,neighbour.toNode));
                }
            }
        }

        System.out.println(totalWeight);
    }

}
