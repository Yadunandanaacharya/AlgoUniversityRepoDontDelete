package LessonProblems.Lesson22MinSpanTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
https://www.scaler.com/topics/data-structures/disjoint-set/

5 6
1 2 3
2 3 5
2 4 2
3 4 8
5 1 7
5 4 4

weight sorted list: 2 3 4 5 7 8
ans =14
http://graphonline.ru/en/?graph=woBxkFZuNLaWWoKX


6 7
1 2 5
2 1 2
2 4 4
4 3 3
3 1 2
2 6 5
6 5 2


5 4
1 2 3
2 3 5
3 2 2
5 4 7

ans = IMPOSSIBLE
http://graphonline.ru/en/?graph=GZmPjZixnLgJidFA


5 3
1 2 3
2 3 5
5 4 7
http://graphonline.ru/en/?graph=GKQPeuoprlMxwUJD

4 5
0 1 1
0 2 1
0 3 5
1 3 1
2 3 2

ans=3
http://graphonline.ru/en/?graph=aDmMfevHZpRUTTJc


check this java code try it
https://www.scaler.com/topics/data-structures/kruskal-algorithm/



 */
public class KruskalSparshWorking {

    public static class Node implements Comparable<Node> {
        public int fromNode;
        public int toNode;
        public int weight;

        public Node(int fromNode,int toNode, int weight) {
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.weight = weight;
        }

        public int compareTo(Node node) {
            return (this.weight - node.weight);
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

        public int FindParent(int node) {
            if (parent[node] < 0)
                return node;
            else
                return parent[node] = FindParent(parent[node]);
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
            int weight = Integer.parseInt(s[2]);

            edgesArrayList.add(new Node(fromNode, toNode, weight));
        }

        Collections.sort(edgesArrayList);
        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(nodes);
        int ans = 0;
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
