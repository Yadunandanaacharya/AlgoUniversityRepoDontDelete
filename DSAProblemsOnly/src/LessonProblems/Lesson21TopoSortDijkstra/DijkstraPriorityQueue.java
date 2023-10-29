package LessonProblems.Lesson21TopoSortDijkstra;

import java.io.*;
import java.util.*;

/*
3 4
1 2 3
2 3 1
1 3 7
2 1 5

8 8
1 2 10
2 4 1
4 6 1
6 8 1
1 3 2
3 5 4
5 7 4
7 8 4

ans=14

6 6
1 2 2
2 3 3
3 4 4
2 4 6
1 6 3
6 4 6

6 10
0 1 2
0 2 1
1 5 4
1 4 8
2 5 3
2 3 7
5 4 5
5 3 4
4 3 8
 */

public class DijkstraPriorityQueue {
    public static HashMap<Integer, ArrayList<Node>> adjList = new HashMap<>();
    public static long totalWeight = 0;
    
    public static class Node {
        public int toNode;
        public long weight;

        public Node(int toNode, long weight) {
            this.toNode = toNode;
            this.weight = weight;
        }

        public long getWeight()
        {
            return this.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().trim().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[1]);

        for (int i = 1; i <= nodes; i++) {
            adjList.put(i, new ArrayList<Node>());
        }

        for (int i = 0; i < edges; i++) {
            s = br.readLine().split(" "); //same variable used above, allowed
            int fromNode = Integer.parseInt(s[0]);
            int toNode = Integer.parseInt(s[1]);
            long weight = Long.parseLong(s[2]);
            adjList.get(fromNode).add(new Node(toNode, weight));
        }

        Dijkstra(adjList, 1, nodes);

//        bw.write(sourceDijkstra[sourceDijkstra.length - 1] + "");
//        bw.flush();
    }

    public static void Dijkstra(HashMap<Integer, ArrayList<Node>> adjList, int src, int nodes) {
        boolean[] visited = new boolean[nodes + 1];
        long[] distance = new long[nodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<Integer> shortestPathNodes = new ArrayList<>();
        Comparator<Node> nodeComparator = Comparator.comparingLong(Node :: getWeight);
        //for pq below you must pass nodeComparator, or else pq can't give high priority for some node
        //with weight with passing comparator we tell give high priority for weights of node like that

        //https://www.algotree.org/algorithms/minimum_spanning_tree/prims_java/
        //below is lambda function for that nodecomparator
        Comparator<Node> NodeCostComparator = (obj1, obj2) -> {
            return (int) (obj1.weight - obj2.weight);
        };

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nodeComparator);
        priorityQueue.add(new Node(src, 0));
        distance[src] = 0;

        shortestPathNodes.add(src);

        while (!priorityQueue.isEmpty()) {
            Node removedNode = priorityQueue.remove(); //removes high priority nodes from pq
            //means node with smaller weight will be removed

            //you can either use visited or use not equal to code below both will give same answer
            //since main logic is based on pq
//            if (visited[removedNode.toNode])
//                continue;

            if (removedNode.weight != distance[removedNode.toNode])
                continue;

            shortestPathNodes.add(removedNode.toNode);
            totalWeight += removedNode.weight;
            visited[removedNode.toNode] = true;
            distance[removedNode.toNode] = removedNode.getWeight();

            for (Node neighbour : adjList.get(removedNode.toNode)) {
                int node = neighbour.toNode;
                long weightIs = neighbour.weight;
                if (distance[removedNode.toNode] + weightIs < distance[node]) {
                    distance[node] = distance[removedNode.toNode] + weightIs;

                    priorityQueue.add(new Node(node, distance[node]));
                }
            }
        }
        System.out.println(totalWeight);

        for (long i : distance){
            System.out.print(i + " ");
        }
    }
}
//2147483647 0 10 2 11 6 12 10 13
//2147483647 0 10 2 11 6 12 10 13