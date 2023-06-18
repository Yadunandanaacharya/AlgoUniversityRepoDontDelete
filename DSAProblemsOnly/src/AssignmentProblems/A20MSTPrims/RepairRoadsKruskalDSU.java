package AssignmentProblems.A20MSTPrims;

import LessonProblems.Lesson22MinSpanTree.KruskalSparshWorking;

import java.io.*;
import java.util.*;

/*
5 6
1 2 100000000000000
2 3 100000000000000
2 4 100000000000000
3 4 100000000000000
5 1 100000000000000
5 4 100000000000000
 */

public class RepairRoadsKruskalDSU {
    public static class Node implements Comparable<Node> {
        public int fromNode;
        public int toNode;
        public long weight;

        public Node(int fromNode,int toNode, long weight) {
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.weight = weight;
        }

        //when long is there below doesn't work
//        public int compareTo(Node node) {
//            return (this.weight - node.weight);
//        }

        //changed code
        //https://stackoverflow.com/questions/57345800/sorting-list-of-objects-by-long-property
        public int compareTo(Node node) {
            return (this.weight < node.weight) ? -1 : ((this.weight == node.weight) ? 0 : 1);
        }
    }

    public static  class DisjointUnionSet {
        int[] parent;
        int[] rank;

        DisjointUnionSet(int nComponents) {
            //0 based indexing
//            parent = new int[nComponents];
//            rank = new int[nComponents];

            //1 based indexing
            parent = new int[nComponents + 1];
            rank = new int[nComponents + 1];

            Arrays.fill(parent, -1);
            Arrays.fill(rank, 0);
        }

        public boolean AddEdge(int fromNode, int toNode) {
            fromNode = FindParent(fromNode);
            toNode = FindParent(toNode);
            if (fromNode == toNode) return false;

            if (rank[fromNode] < rank[toNode]) {
                //swap start
                int temp = fromNode;
                fromNode = toNode;
                toNode = temp;
                //swap end
            }

            rank[fromNode] += rank[toNode];
            parent[toNode] = fromNode;
            return true;
        }

        public int FindParent(int toNode) {
            if (parent[toNode] < 0)
                return toNode;
            else
                return parent[toNode] = FindParent(parent[toNode]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[1]);

        List<Node> edgesArrayList = new ArrayList<Node>();
        for (int i = 0; i < edges; i++) {
            s = br.readLine().split(" ");
            int fromNode = Integer.parseInt(s[0]);
            int toNode = Integer.parseInt(s[1]);
            long weight = Long.parseLong(s[2]);

            edgesArrayList.add(new Node(fromNode, toNode, weight));
        }

        Collections.sort(edgesArrayList);
        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(nodes);
        long ans = 0;
        int noOfConnections = 0;
//        for (int i = 0; i < edgesArrayList.size(); i++) { //0 based indexing
        for (int i = 0; i < edgesArrayList.size(); i++) { //1 based indexing
            if(disjointUnionSet.AddEdge(edgesArrayList.get(i).fromNode, edgesArrayList.get(i).toNode)){
                ans += edgesArrayList.get(i).weight;
                noOfConnections++;
            }
        }

        if (noOfConnections == nodes - 1)
            System.out.println(ans);
        else
            System.out.println("IMPOSSIBLE");
    }

}
