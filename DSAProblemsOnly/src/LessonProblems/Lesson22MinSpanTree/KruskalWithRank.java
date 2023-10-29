package LessonProblems.Lesson22MinSpanTree;

import java.io.*;
import java.util.*;

public class KruskalWithRank {

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

        public int Root(int toNode) {
            if (parent[toNode] < 0)
                return toNode;
            else
                return parent[toNode] = Root(parent[toNode]);
        }

        public void Merge(int x, int y) {
            x = Root(x);
            y = Root(y);

            if (x != y){
                if (rank[x] < rank[y]) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
            }
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

        Kruskal(nodes, edgesArrayList);
    }

    public static void Kruskal(int nodes, List<Node> edgesArrayList) {
        int ans = 0;
        DisjointUnionSet disjointUnionSet = new DisjointUnionSet(nodes);
        Collections.sort(edgesArrayList);

        for(int i= 0; i <edgesArrayList.size();i++) {
            if (disjointUnionSet.Root(edgesArrayList.get(i).fromNode) != disjointUnionSet.Root(edgesArrayList.get(i).toNode)) {
                disjointUnionSet.Merge(edgesArrayList.get(i).fromNode, edgesArrayList.get(i).toNode);
                ans += edgesArrayList.get(i).weight;
            }
        }

        HashSet<Integer> noOfComponents = new HashSet<>();
        for(int i = 0; i<= nodes;i++)
            noOfComponents.add(disjointUnionSet.Root(i));

        if (noOfComponents.size() > 1)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(ans);
    }


}
