package AssignmentProblems.A15BFS1;

/*

1
20 10
2
10 7 2
10 4 2

ans= YES
 */


import java.util.*;
import java.io.*;
import java.lang.*;

public class BigDiscs {
    public static long Distance(long x1, long y1, long x2, long y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }

    public static void AddEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            long[][] circlesArray = new long[n][3];

            for(int i = 0; i < n;i++) {
                for (int j= 0; j < 3; j++) {
                    circlesArray[i][j] = sc.nextLong();
                }
            }

            Solve(x, y, n, circlesArray);
        }
    }

    public static void Solve(int x, int y, int n, long[][] circlesArray) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n+4; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < n;i++) {
            int idx = i + 4;
            if (circlesArray[i][0] - circlesArray[i][2] <= 0)
                AddEdge(adjList, 3, idx);
            if (circlesArray[i][0] + circlesArray[i][2] >= x)
                AddEdge(adjList, 1, idx);
            if (circlesArray[i][1] - circlesArray[i][2] <= 0)
                AddEdge(adjList, 2, idx);
            if (circlesArray[i][1] - circlesArray[i][2] >= y)
                AddEdge(adjList, 0, idx);
        }

        for (int i = 0; i < n; i++) {
            int idxi = i + 4;
            for (int j = i + 1; j < n; j++) {
                int idxj = j + 4;

                if (Distance(circlesArray[i][0], circlesArray[i][1], circlesArray[j][0], circlesArray[j][1])
                <= (circlesArray[i][2] + circlesArray[j][2]) + (circlesArray[i][2] + circlesArray[j][2])) {
                    AddEdge(adjList, idxi, idxj);
                }
            }
        }

        //0-T,1-R, 2-B, 3-L
        boolean[] TV = BFS(0, adjList);
        boolean[] RV = BFS(1, adjList);
        boolean ans = !(TV[2] || TV[3] || RV[2] || RV[3]);
        System.out.println(ans ? "YES" : "NO");
    }

    public static boolean[] BFS(int src, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, false);
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int a : adj.get(node)) {
                if (!visited[a]) {
                    visited[a] = true;
                    queue.add(a);
                }
            }
        }

        return visited;
    }
}
