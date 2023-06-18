package AssignmentProblems.A19ShortPathTopoSort;

import LessonProblems.Lesson21TopoSortDijkstra.DijkstraPriorityQueue;

import java.util.*;
import java.io.*;

/*
3 4
1 2 3
2 3 1
1 3 7
2 1 5
 */

public class FlightCoupon {
    public static HashMap<Integer, ArrayList<Node>> adjListMap1 = new HashMap<>();
    public static HashMap<Integer, ArrayList<Node>> adjListMap2 = new HashMap<>();

    public static class Node {
        public int toNode;
        public long weight;

        public Node(int toNode, long weight) {
            this.toNode = toNode;
            this.weight = weight;
        }

        public long getWeight(){
            return this.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[0]);

        for (int i = 1; i <= edges; i++) {
            adjListMap1.put(i, new ArrayList<Node>());
            adjListMap2.put(i, new ArrayList<Node>());
        }

        for (int i = 0; i < edges; i++) {
            s = br.readLine().split(" ");
            int fromNode = Integer.parseInt(s[0]);
            int toNode = Integer.parseInt(s[1]);
            long weight = Long.parseLong(s[2]);
            adjListMap1.get(fromNode).add(new Node(toNode, weight));
            adjListMap2.get(toNode).add(new Node(fromNode, weight));
        }

        long[] srcDijkstra = Dijkstra(adjListMap1, 1, nodes); //call of dijkstra from 1 to
        long[] destDijkstra = Dijkstra(adjListMap1, nodes, nodes);
        long ans = Long.MAX_VALUE;

        for (int i = 1; i <= nodes; i++) {
            for (Node node : adjListMap1.get(i)) {
                long result = (long) ((srcDijkstra[i] + destDijkstra[node.toNode]) + node.weight/2);
                ans = Math.min(ans, result);
            }
        }

        System.out.println(ans);
    }

    public static long[] Dijkstra(HashMap<Integer, ArrayList<Node>> adjList, int src, int nodes) {
        boolean[] visited = new boolean[nodes + 1];
        long[] distance = new long[nodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        //when long type weight is there that time you can't do obj1-obj2 it returns int type
        //so in stackoverflow i found simple solution
        Comparator<Node> nodeComparator= Comparator.comparingLong(Node::getWeight);
//        Comparator<Node> nodeComparator = (obj1,obj2) -> {
////            return (int) (obj1.weight > obj2.weight ? obj1.weight : obj2.weight);
////            return (int) (obj1.weight < obj2.weight) ? -1 : ((obj1.weight == obj2.weight) ? 0 : 1);
//            return (int) (obj1.weight - obj2.weight);
//        };

        PriorityQueue<Node> priorQueue = new PriorityQueue<>(nodeComparator);
//        distance[src] = 0;
        priorQueue.add(new Node(src, 0));

        while (!priorQueue.isEmpty()) {
            Node removedNode = priorQueue.remove();

            if (visited[removedNode.toNode])
                continue;

            visited[removedNode.toNode] = true;
            distance[removedNode.toNode] = removedNode.getWeight();
            for (Node neighbourNode : adjList.get(removedNode.toNode)) {
                int node = neighbourNode.toNode;
                long weightIs = neighbourNode.weight;
                if (distance[removedNode.toNode] + weightIs < distance[node]) {
                    distance[node] = distance[removedNode.toNode] + weightIs;

                    priorQueue.add(new Node(node, distance[node]));
//                    priorQueue.add(new Node(node, removedNode.getWeight() + neighbourNode.getWeight()));
                }
            }
        }

        return distance;
    }
}
