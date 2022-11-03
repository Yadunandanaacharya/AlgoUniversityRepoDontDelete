package A0WarmupBunch1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SnowFlakeWithInputs {

    public static class Edge {
        int src;
        int nbr;
        int wegt;

        Edge(int src, int nbr,int wegt) {
            this.src = src;
            this.nbr = nbr;
            this.wegt = wegt;
        }
    }

//    static int findDegree(ArrayList<Edge>[] graph, int ver)
//    {
//        for (ArrayList<Edge> edge:graph[])
//
//        int degree = 0;
//        for (int i = 0; i < graph.v; i++) {
//            if (graph.dir[ver][i] == 1)
//                degree++;
//        }
//
//        // below line is to account for self loop in graph
//        // check sum of degrees in graph theorem
//        if(graph.dir[ver][ver] == 1) degree++;
//        return degree;
//    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] stringArray = br.readLine().split(" ");
//        int vertices = Integer.parseInt(stringArray[0]);
//        int edges = Integer.parseInt(stringArray[1]);

        int vertices = 11; int edges= 8;
        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++)
            graph[i] = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < edges; i++) {
            String[] graphParts = br.readLine().split(" ");
            int v1 = Integer.parseInt(graphParts[0]);
            int v2 = Integer.parseInt(graphParts[1]);
            int weight = Integer.parseInt(graphParts[2]);
            graph[v1].add(new Edge(v1, v2, weight));
            graph[v2].add(new Edge(v2, v1, weight));
        }

        int g = 0;
//        for (int i = 0; i < vertices; i++) {
//            if (visited[i] == false) {
//                ArrayList< Integer> comp = new ArrayList< >();
//                dfs(graph, i, visited, comp);
//                comps.add(comp);
//            }
//        }
//
//        System.out.println(comps);
    }
}
