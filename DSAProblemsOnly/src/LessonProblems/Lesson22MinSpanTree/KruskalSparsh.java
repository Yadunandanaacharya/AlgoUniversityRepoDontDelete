package LessonProblems.Lesson22MinSpanTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
5 6
1 2 3
2 3 5
2 4 2
3 4 8
5 1 7
5 4 4

ans =14

4 5
0 1 1
0 2 1
0 3 5
1 3 1
2 3 2
ans=3

check this java code try it
https://www.scaler.com/topics/data-structures/kruskal-algorithm/

http://graphonline.ru/en/?graph=aDmMfevHZpRUTTJc
 */
public class KruskalSparsh {

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
            parent = new int[nComponents];
            rank = new int[nComponents];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 0);
        }

        public boolean AddEdge(int fromNode, int toNode) {
            fromNode = FindParent(fromNode);
            toNode = FindParent(toNode);
            if (fromNode == toNode) return false;

            if (rank[fromNode] < rank[toNode]) {
                //swap start
                int temp = parent[fromNode];
                parent[fromNode] = parent[toNode];
                parent[toNode] = temp;
                //swap end

                rank[fromNode] += rank[toNode];
                parent[toNode] = fromNode;
                return true;
            }
            return false;
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
            int weight = Integer.parseInt(s[2]);

            edgesArrayList.add(new Node(fromNode, toNode, weight));
        }

        Collections.sort(edgesArrayList);
        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(nodes);
        int ans = 0;
        int noOfConnections = 0;
        for (int i = 0; i < edgesArrayList.size(); i++) {
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
