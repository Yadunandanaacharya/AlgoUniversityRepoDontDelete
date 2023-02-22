package AssignmentProblems.A0WarmupBunch1;
    import java.io.BufferedReader;
import java.io.InputStreamReader;
    import java.util.*;
    import java.lang.*;
    import java.util.ArrayList;

/*
A connected component of a graph is called a snowflake if it contains exactly one node that has a degree
        not equal to 1.
not equal to 1 means if degree is 0 then you have to increase count in below problem youu'll get 3 times 0
so ans is 3
===================================
================hint=================
Although the problem at first seems it is of graphs, but actually it can be solved without any concept of graphs or
its traversals, by using first principles.

If you carefully notice, all information that is required is the degree of each node (how many nodes is one node
connected to) - that's it.

Now its clear that what we are interested in is nodes with degree != 1.
So all we need to do is process such nodes & check whether they are snowflakes (how do we do that? you can try
this out, ping in the already running discussion on discord if needed).

Once the snowflakes are identified , we just need to make sure that if same type of snowflakes arise, they are
not counted at all in answer.

For ex: lets say there are 4 snowflakes of 1 node each (ie singular nodes) -> the answer is 0. [because we need
only the unique snowflakes]
===================================
================hint=================

With my code in 2 ways I'm checking whether it's a snowflake or not:
#1 degree is not 1 suppose node's degree is 0 then also it can be snowflake
#2 if degree of some nodes are same then they are not snowflake
#3 if there is one node with degree 3 and if there is no other nodes with degree 3 then it's snowflake
so I return count 1 as I found only one node which is unique wiht degree 3

11 9
0 1
2 3
3 4
2 4
5 6
6 7
7 8
8 9
8 10

above node 8 has degree 3 and node 8 is connected to node 7 where node 7 has degree 2 so you need to avoid node 8 also.

#1 degree is not 1 suppose node's degree is 0 then also it can be snowflake. So for given example's input and output 3 nodes
have degrees 0,2,6 so they're snow flakes.

#2 if degree of some nodes are same then they are not snowflake. Example: Suppose if I get degree 2 for four nodes.
Then I won't consider 2's count as snowflake. I guess because example 2 graph of question there is oone node with degree 3
that is connected to node with degree 2. That one also not snowflake

#3 if there is one node with degree 3 and if there is no other nodes with degree 3 then it's snowflake
so I return count 1 as I found only one node which is unique with degree 3.


Hello yadunandana ,,, you are going ahead with correct approach but for point number 2 we also need to make sure that ifany
1 node is connected to other node and they both have degree let's say 2 it is also an invalid case so you are missing
on this test case. The snowflake should exist as an independent entity

 */
public class SnowFlake1 {

    public static class Graph {
        int vertex, edge;
        int[][] direction;

        Graph(int vertex, int edge) {
            this.vertex = vertex;
            this.edge = edge;
            direction = new int[vertex][];
            for (int i = 0; i < vertex; i++)
                direction[i] = new int[vertex];
        }
    }

    static Map<Integer, Integer> degreeNot1Map = new HashMap<>();
    public static void  FindDegree(Graph graph, int vertex) {
        int degree = 0;
        for (int i = 0; i < graph.vertex; i++) {
            if (graph.direction[vertex][i] == 1)
                degree++;
        }

        if (graph.direction[vertex][vertex] == 1)
            degree++;

        if (degree != 1)
            degreeNot1Map.put(degree, vertex);
    }

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] verticesEdges = br.readLine().split(" ");
        int vertices = Integer.parseInt(verticesEdges[0]); //11
        int edges = Integer.parseInt(verticesEdges[1]);    //8
        int countDegreeNot1 = 0;
        int[] countDegreeNot1List;
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> uniqueList = new ArrayList<Integer>();
        List<Integer> uniqueList1 = new ArrayList<Integer>();
        List<Integer> independentEntityChecker = new ArrayList<Integer>();

        Graph graph = new Graph(vertices, edges);
        for (int i = 0; i < edges; i++) {
            String[] graphParts = br.readLine().split(" ");
            int v1 = Integer.parseInt(graphParts[0]);
            int v2 = Integer.parseInt(graphParts[1]);
            graph.direction[v1][v2] = 1;
            graph.direction[v2][v1] = 1;
        }

        for (int i = 0; i < vertices; i++) {
            FindDegree(graph, i);
//            if (degree != 1)
//                list.add(degree);
        }

        Map<Integer, Integer> mp = new HashMap<>();
        int count_dis=0;
        for (int i = 0; i < list.size(); i++)
        {
            if (mp.containsKey(list.get(i)))
            {
                mp.put(list.get(i), mp.get(list.get(i)) + 1);
            }
            else
            {
                mp.put(list.get(i), 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
        {    if(entry.getValue()==1)
            uniqueList.add(entry.getKey());
        }

        System.out.println(uniqueList.size());
    }
}
