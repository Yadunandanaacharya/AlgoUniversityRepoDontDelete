package AssignmentProblems.A13GraphAssignment;

import java.util.*;
import java.io.*;

/*
11 8
1 2
2 3
4 5
6 5
7 5
8 5
9 5
10 5
 */
public class BeautifulSnowFlakes {
    public static void main(String[] args) throws Exception {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] verticeEdgeList = br.readLine().split(" ");
            int vertices = Integer.parseInt(verticeEdgeList[0]);
            int edges = Integer.parseInt(verticeEdgeList[1]);
            GraphList1 graphList1 = new GraphList1(vertices);
            for(int i = 0; i < edges; i++){
                String[] edge1Edge2 = br.readLine().split(" ");
                graphList1.AddEdge(Integer.parseInt(edge1Edge2[0]), Integer.parseInt(edge1Edge2[1]));
            }
            graphList1.CountBeautifulSnowFlakes();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

class GraphList1{
    int vertices;
    ArrayList<ArrayList<Integer>> adjList;
    public GraphList1(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < vertices; i++){
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void AddEdge(int i, int j){
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void CountBeautifulSnowFlakes(){
        int count = 0;
        List<Integer> beautifulSnowFlakeList = new ArrayList<Integer>();
        for (int i = 0; i < vertices; i++){
            count = 0;
            for(int j = 0; j < adjList.get(i).size(); j++){
                count++;
            }
            if (count != 1 && !beautifulSnowFlakeList.contains(count))
                beautifulSnowFlakeList.add(count);
        }
        System.out.println(beautifulSnowFlakeList.size());
    }
}
