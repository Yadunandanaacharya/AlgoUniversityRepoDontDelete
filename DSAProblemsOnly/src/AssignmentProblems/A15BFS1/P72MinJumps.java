package AssignmentProblems.A15BFS1;

import java.util.*;
import java.io.*;
/*

some links might help adding vertex as 1 based indexing
https://www.scaler.com/topics/data-structures/0-1-bfs-shortest-path-binary-graph/
https://medium.com/codex/solving-graph-problems-number-of-islands-e15cbaa3b8dc

best one below
https://pencilprogrammer.com/algorithms/shortest-path-in-unweighted-graph-using-bfs/

http://graphonline.ru/en/?graph=gaKowPsBFskbXDVi

5 5
1 3
2 3
1 2
3 5
4 5
1 4

 */
public class P72MinJumps {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndMJumps = br.readLine().split(" ");
        int noOfBuilding = Integer.parseInt(nAndMJumps[0]);
        int noOfPairs = Integer.parseInt(nAndMJumps[1]);
        GraphList g = new GraphList(noOfBuilding);
        for (int i = 0; i < noOfPairs; i++) {
            String[] node1And2 = br.readLine().split(" ");
            g.AddEdge(Integer.parseInt(node1And2[0]), Integer.parseInt(node1And2[1]));
        }
        String[] srcAndDest = br.readLine().split(" ");
        g.BFS(Integer.parseInt(srcAndDest[0]),Integer.parseInt(srcAndDest[1]));
    }

    public ArrayList<Integer> FindPath(){
        ArrayList<Integer> visitedList = new ArrayList<>();

        return visitedList;
    }
}

class GraphList {
    ArrayList<ArrayList<Integer>> adjList;

    int vertices;

    public GraphList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < vertices + 1; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public void AddEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
    }

    public void BFS(int src, int destination) {
        int visited[] = new int[vertices + 1];
        //either use ArrayDeque or else LinkedList
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        int[] distanceChild = new int[vertices + 1];
        int[] parent = new int[vertices + 1];
        Arrays.fill(parent, -1);
        visited[src] = 1;
        queue.push(src);

        while (queue.size() != 0) {
            int current = queue.poll(); //poll removes first item from queue
            visited[current] = 1;
//            System.out.println(current );
            for (int child : adjList.get(current)) {
                if (visited[child] == 0) {
                    queue.offerLast(child);
                    parent[child] = current; //for main parent that if for 1 val is -1
                    //parent array we store parent of that particular child node
                    //for root node it'll be -1
                    visited[child] = 1;
//                    distanceChild[child] = distanceChild[current] + 1;
                }
            }
        }

        List<Integer> answerList = new ArrayList<>();
        while (parent[destination] != -1) {
            answerList.add(destination);
            destination = parent[destination];
        }
        answerList.add(src);
        System.out.println(answerList.size()-1);
    }
}
