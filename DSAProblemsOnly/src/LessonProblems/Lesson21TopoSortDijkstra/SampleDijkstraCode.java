package LessonProblems.Lesson21TopoSortDijkstra;

import java.io.*;
import java.util.*;

/*
3 4
1 2 3
2 3 1
1 3 7
2 1 5
 */

public class SampleDijkstraCode {

    static HashMap<Integer, ArrayList<Node>> adjList = new HashMap<>();
    static HashMap<Integer, ArrayList<Node>> adjList2 = new HashMap<>();

    static class Node {
        public int to;
        public long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        public long getWeight() {
            return this.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().trim().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[1]);

        for (int i = 1; i <= nodes; i++) {
            adjList.put(i, new ArrayList<Node>());
            adjList2.put(i, new ArrayList<Node>());
        }

        for (int i = 0; i < edges; i++) {
            s = br.readLine().trim().split(" ");
            int fromNode = Integer.parseInt(s[0]);
            int toNode = Integer.parseInt(s[1]);
            long weight = Long.parseLong(s[2]);
            adjList.get(fromNode).add(new Node(toNode, weight));
            adjList2.get(toNode).add(new Node(fromNode, weight));
        }

        long[] sorceDijktra = Dijkstra(adjList, 1, nodes);
        long[] desDijkstra = Dijkstra(adjList2, nodes, nodes);
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= nodes; i++) {
            for (Node it : adjList.get(i)) {
                long res = (long) ((sorceDijktra[i] + desDijkstra[it.to]) + it.weight / 2);
                ans = Math.min(ans, res);
            }
        }

        bw.write(ans + "");
        bw.flush();
    }

    public static long[] Dijkstra(HashMap<Integer, ArrayList<Node>> adjList, int src, int nodes) {
        boolean[] visited = new boolean[nodes + 1];
        long[] distance = new long[nodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Comparator<Node> NodeComparator = Comparator.comparingLong(Node::getWeight);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(NodeComparator);
        priorityQueue.add(new Node(src, 0));

        while (!priorityQueue.isEmpty()) {
            Node fromNode = priorityQueue.remove();

            if (visited[fromNode.to])
                continue;

            visited[fromNode.to] = true;
            distance[fromNode.to] = fromNode.getWeight();

            for (Node neighbour : adjList.get(fromNode.to)) {
                priorityQueue.add(new Node(neighbour.to, fromNode.getWeight() + neighbour.getWeight()));
            }
        }

        return distance;
    }
}

