package AssignmentProblems.A15BFS1;

/*
use this: https://csacademy.com/app/graph_editor/

1)
5 5
0 2
0 1 0 0 0
0 1
1 2
0 3
3 4
4 2

ans=3

2)
below no obstacles
5 5
0 2
0 0 0 0 0
0 1
1 2
0 3
3 4
4 2

ans=2

3)
5 5
0 2
1 1 1 0 0
0 1
1 2
0 3
3 4
4 2

ans=-1

4)
5 5
0 2
0 1 1 0 0
0 1
1 2
0 3
3 4
4 2

ans=-1

5)
5 5
0 2
0 1 0 0 1
0 1
1 2
0 3
3 4
4 2

ans=-1

6)
5 3
0 4
0 1 0 0 0
0 3
3 4
1 2

ans=2

7)
6 4
0 5
0 0 0 0 0 0
0 3
3 4
1 2
2 5

ans=-1

only 1 one node with 0 edge
src=dest=0
cursed array has one item 0
8)
1 0
0 0
0

9)
1 0
0 0
1
 */

import java.io.*;
import java.util.*;

public class AvoidingCities {
    public static ArrayList<ArrayList<Integer>> adjList;
    public static int vertices;
    public static int[] visited;
    public static int[] distance;
    public static int[] cursedCityArray;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] noOfCitiesAndRoadsArray = br.readLine().split(" ");
        String[] srcAndDestArray = br.readLine().split(" ");
        String[] cursedCityArrayString = br.readLine().split(" ");

        int noOfCities = Integer.parseInt(noOfCitiesAndRoadsArray[0]);
        int noOfRoads = Integer.parseInt(noOfCitiesAndRoadsArray[1]);
        int src = Integer.parseInt(srcAndDestArray[0]);
        int destination = Integer.parseInt(srcAndDestArray[1]);

        cursedCityArray = new int[noOfCities]; //int[] cursedCityArray both type of initializing is same
        for (int i = 0; i < cursedCityArray.length; i++)
            cursedCityArray[i] = Integer.parseInt(cursedCityArrayString[i]);

        if(src == destination) {
            if (cursedCityArray[src] == 0) {
                System.out.println(1);
            }
            else {
                System.out.println(-1);
            }
            return;
        }

        vertices = noOfCities;
        adjList = new ArrayList<>();
        visited = new int[noOfCities];
        distance = new int[noOfCities];
        for (int i = 0; i < noOfCities; i++)
            adjList.add(new ArrayList<Integer>());

        for (int i = 0; i < noOfRoads; i++){
            String[] uAndV = br.readLine().split(" ");
            int edge1 = cursedCityArray[Integer.parseInt(uAndV[0])];
            int edge2 = cursedCityArray[Integer.parseInt(uAndV[1])];
            if (edge1 == 1 || edge2 == 1) {
                continue;
            }
            else{
                adjList.get(Integer.parseInt(uAndV[0])).add(Integer.parseInt(uAndV[1]));
                adjList.get(Integer.parseInt(uAndV[1])).add(Integer.parseInt(uAndV[0]));
            }
        }

        BFS(0,src,destination);
    }

    public static void  BFS(int parentNode, int src, int destination) {
        ArrayDeque queue = new ArrayDeque();
        int[] distanceChildArray = new int[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        visited[parentNode] = 1;

        int current = 0;
        visited[parentNode] = 1;
        queue.push(parentNode);

        while (queue.size() != 0) {
            current = (int)queue.poll(); //poll removes first item from queue
            visited[current] = 1;
            for (int child : adjList.get(current)) {
                if (visited[child] == 0) {
                    queue.offerLast(child);
                    parent[child] = current; //for main parent that if for 1 val is -1
                    visited[child] = 1;
                    distance[child] = distance[current] + 1; //distance from root node
                }
            }
        }

//        List<Integer> ansList = new ArrayList<>();
//        while(parent[destination] != -1) {
//            ansList.add(parent[destination]);
//            destination = parent[destination];
//        }
//        ansList.add(src);

//        if (ansList.size() == 1) {
//            System.out.println(ansList.size() - 1);
//        } else {
//            System.out.println(-1);
//        }

        if (distance[destination] + distance[src] > 0) {
            System.out.println(distance[destination] + distance[src]);
        } else {
            System.out.println(-1);
        }
    }
}
