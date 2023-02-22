package AssignmentProblems.A0WarmupBunch1;
import java.io.*;
import java.util.*;

public class SnowFlake_PepcodingReference {
        public static class Edge {
            int source;
            int neighbour;

            Edge(int source, int neighbour) {
                this.source = source;
                this.neighbour = neighbour;
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter vertices and edges: ");
            String[] input = br.readLine().split(" ");
            int vertices = Integer.parseInt(input[0]);
            int edges = Integer.parseInt(input[1]);
            System.out.println("vertices "+ vertices);
            System.out.println("edges "+ edges);

            ArrayList<Edge>[] graph = new ArrayList[vertices];
            for(int i = 0; i < edges; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < edges; i++) {
                String[] parts = br.readLine().split(" ");
                int v1 = Integer.parseInt(parts[0]);
                int v2 = Integer.parseInt(parts[1]);
                graph[v1].add(new Edge(v1, v2));
                graph[v2].add(new Edge(v2, v1));
            }
        }
}
