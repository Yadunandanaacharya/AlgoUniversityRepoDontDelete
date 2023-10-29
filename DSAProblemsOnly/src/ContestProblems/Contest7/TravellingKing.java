package ContestProblems.Contest7;

import java.io.*;
import java.util.*;

/*
4 4 3 2
1 2 10
2 3 10
3 4 10
1 4 15
3
4
1


ans:
10
20
10

6 5 3 2
1 2 10
2 3 10
3 4 10
1 4 15
5 6 10
6
4
5


ans:
-1
20
-1


6 4 3 2
1 2 10
3 4 10
1 4 15
5 6 10
3
5
6


ans:
35
-1
-1

 */

public class TravellingKing {
    public static HashMap<Integer, ArrayList<Node>> adjList = new HashMap<>();
    public static long totalWeight1 = 0;
    public static long[] distance;

    public static class Node {
        int toNode;
        long weight;

        public Node(int toNode,  long weight){
            this.toNode = toNode;
            this.weight = weight;
        }

        public long getWeight() {
            return this.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int nodes = Integer.parseInt(s[0]);
        int edges = Integer.parseInt(s[1]);
        int warInDays = Integer.parseInt(s[2]);
        int srcCity = Integer.parseInt(s[3]);
        distance = new long[nodes + 1];

        for (int i = 1; i <= nodes; i++) {
            adjList.put(i, new ArrayList<Node>());
        }

        for (int i = 0; i < edges; i++) {
            s = br.readLine().split(" "); //same variable used above, allowed
            int fromNode = Integer.parseInt(s[0]);
            int toNode = Integer.parseInt(s[1]);
            long weight = Long.parseLong(s[2]);
            adjList.get(fromNode).add(new Node(toNode, weight));
            adjList.get(toNode).add(new Node(fromNode, weight));
        }

        int[] inputArra = new int[warInDays];
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i< warInDays; i++) {
            inputArra[i] = Integer.parseInt(br.readLine());
        }

        for (int i :inputArra) {
            Arrays.fill(distance, Integer.MAX_VALUE);
            Dijkstra1(nodes, i, srcCity);
            if (distance[srcCity] > 0 && distance[srcCity] != Integer.MAX_VALUE){
                System.out.println(distance[srcCity]);
            }else{
                System.out.println(-1);
            }
        }
    }

    public static void   Dijkstra1(int nodes, int srcCity, int destinationCity) {
        boolean[] visited = new boolean[nodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Comparator<Node> nodeComparator = Comparator.comparingLong(Node:: getWeight);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nodeComparator);
        priorityQueue.add(new Node(srcCity, 0));
        distance[srcCity] = 0;
        totalWeight1 = 0;
        int node = Integer.MAX_VALUE;

        while (!priorityQueue.isEmpty()) {
            Node removedNode = priorityQueue.remove(); //removes high priority nodes from pq

            if (removedNode.weight != distance[removedNode.toNode])
                continue;
 
            totalWeight1 += removedNode.weight;
            visited[removedNode.toNode] = true;
            distance[removedNode.toNode] = removedNode.getWeight();

            for (Node neighbour : adjList.get(removedNode.toNode)) {
                node = neighbour.toNode;
                long weightIs = neighbour.weight;

                //checking other edge weight is less than current weight
                if (distance[removedNode.toNode] + weightIs < distance[node] && visited[node] == false) {
                    distance[node] = distance[removedNode.toNode] + weightIs;
                    priorityQueue.add(new Node(node, distance[node]));

                    if(node == destinationCity) {
                        return ;
                    }
                }
            }
        }
    }
}
