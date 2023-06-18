package ContestProblems.Contest5Graph1;

import java.io.*;
import java.util.*;

/*
Sample 1 INPUT:
6 7
1 2
1 3
2 4
4 5
5 6
3 6
2 6
Sample 1 OUTPUT:
1 2 3 6


2 1
1 2
 */
public class ImportantNodes {
    public static ArrayList<ArrayList<Integer>> adjList;
    public static int n;
    public static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nM = br.readLine().split(" ");
        n = Integer.parseInt(nM[0]);
        m = Integer.parseInt(nM[1]);

        adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            nM = br.readLine().split(" ");
            adjList.get(Integer.parseInt(nM[0])).add(Integer.parseInt(nM[1]));
            adjList.get(Integer.parseInt(nM[1])).add(Integer.parseInt(nM[0]));
        }

        int[] srcDest = BFS(1); //goes from src to dest
        int[] destSrc = BFS(n);     //goes from dest to src
        int min = Integer.MAX_VALUE;
        for (int i= 1; i < srcDest.length; i++) {
            if (srcDest[i] + destSrc[i] < min){
                min = srcDest[i] + destSrc[i];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i= 1; i < srcDest.length; i++) {
            if (srcDest[i] + destSrc[i] == min){
                System.out.print(i + " ");
            }
        }
    }

    public static int[] BFS(int src) {
        int[] visited = new int[n + 1];
        int[] parent = new int[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(parent, -1);
        visited[src] = 1;
        Queue<Integer> queue = new LinkedList();
        queue.add(src);
        while(!queue.isEmpty()) {
            int remNod = queue.poll();

            visited[remNod] = 1;
            for (int newNod : adjList.get(remNod)) {
                if (visited[newNod] != 1) {
                    parent[newNod] = remNod;
                    dist[newNod] = dist[remNod] + 1;
                    queue.add(newNod);
                }
            }
        }

        return dist;
    }
}
