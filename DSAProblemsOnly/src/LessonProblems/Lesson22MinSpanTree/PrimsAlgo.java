package LessonProblems.Lesson22MinSpanTree;

import LessonProblems.Lesson21TopoSortDijkstra.DijkstraPriorityQueue;

import javax.swing.plaf.PanelUI;
import java.io.*;
import java.util.*;

/*
below code is only uni-directional while adding into adjList only once I'm
adding fromnode, tonode, weight
if you want to make bi-directional refere Repair roads there while adding into
adjlist

adjList.get(fromNode).add(new Node(weight,toNode));
adjList.get(toNode).add(new Node(weight,fromNode));
if you add like above it becomes bi-directional

actually in prim's algo you don't need comparator for edge, since youo're
going based on min weight nodes
but in kruskal it's needed because i guess we're sorting based on edge weight first


4 5
0 1 1
0 2 1
0 3 5
1 3 1
2 3 2
ans=3


you can also use comparator like below and pass it to priorityqueue while initializing
Comparator<NodeCost> NodeCostComparator = (obj1, obj2) -> {
            return obj1.cost - obj2.cost;
        };
 */

//referring to pepcoding code of prim's
//https://www.pepcoding.com/resources/online-java-foundation/graphs/min_wire_required_to_connect_all_pcs/topic
public class PrimsAlgo {
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

    public static class Edge1 implements Comparable<Edge1> {
        int  weight1 = Integer.MAX_VALUE;
        int toNode;

        public Edge1(int weight1, int toNode) {
            this.weight1 = weight1;
            this.toNode = toNode;
        }

        public int compareTo(Edge1 e) {
            return this.weight1 - e.weight1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[1]);

        //we used put here for map since we just insert key value pair into map
        for (int i = 0; i <= nodes; i++) { //0 based inde
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
        }

        PrimsMST(adjList, 0, nodes);
        System.out.println(totalWeight);
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

        for (int i=0; i<=nodes;i++) {
            minEdges.add(new Edge1(Integer.MAX_VALUE,i));
        }
        minEdges.get(src).weight1 = 0;
//        minEdges.add(new Edge1(src, 0));

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nodeComparator);
        priorityQueue.add(new Node(0, src));

        for (int i = 0; i < nodes; i++) {
            if (priorityQueue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            Node removedNode = priorityQueue.remove();
            visited[removedNode.toNode] = true;
            totalWeight += removedNode.weight;

//            if (minEdges.get(removedNode.toNode).toNode != -1)
            if (minEdges.get(removedNode.toNode).toNode != -1)
                System.out.println("node " + minEdges.get(removedNode.toNode).toNode);

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
    }

}

