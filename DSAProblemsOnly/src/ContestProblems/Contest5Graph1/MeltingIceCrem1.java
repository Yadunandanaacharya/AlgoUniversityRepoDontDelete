package ContestProblems.Contest5Graph1;

import java.io.*;
import java.util.*;

/*
imp: always write main method in java as public all other outside method you've write them as
private method if you want check in gfg:
https://www.geeksforgeeks.org/shortest-distance-two-cells-matrix-grid/

IMPORTANT: next time when you revise don't just look at these codes solve it again, try to
write code by yourself, just seeing code won't work you can't remember
Pepcoding codes i've done but i don't remember single code now
 */


/*
Sample 1 INPUT:
4 4 5
i***
****
****
***h
Sample 1 OUTPUT:
NO

Sample 2 INPUT:
4 4 6
i***
****
****
***h
Sample 2 OUTPUT:
YES
 */
public class MeltingIceCrem1 {

    private static class PairOfInt
    {
        int row = 0;
        int col = 0;
        int dist = 0;

        public PairOfInt(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inpStr = br.readLine().split(" ");
        int n = Integer.parseInt(inpStr[0]);
        int m = Integer.parseInt(inpStr[1]);
        int k = Integer.parseInt(inpStr[2]);
        char[][] grid = new char[n][m];

        PairOfInt shop = new PairOfInt(0,0,0);
        PairOfInt home = new PairOfInt(0,0,0);

        //we are interested only on i and h that is i-shop, h-home
        for (int i = 0; i <n;i++) {
            String s = br.readLine();
            for (int j = 0 ; j<m;j++){
                grid[i][j] = s.charAt(j);

                if (s.charAt(j) == 'i'){
                    shop.row=i;
                    shop.col=j;
                }
            }
        }

        int ans = BFS(shop, n, m, k, grid);
        if (ans > -1 && ans <= k){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    private static boolean IsValid(int x, int y, int[][] visited, int n, int m) {
        if (x >= 0 && y >= 0 && x<n && y < m && visited[x][y] == 0) {
            return true;
        }
        return false;
    }

    private static int BFS(PairOfInt shop, int n, int m, int k, char[][] grid) {
        int[][] visit = new int[n][m];
        Queue<PairOfInt> queue = new LinkedList<PairOfInt>();
        queue.add(shop);
        visit[shop.row][shop.col] = 1;

        while (!queue.isEmpty()) {
            PairOfInt curnt = queue.poll();

            //if 1
            if(grid[curnt.row][curnt.col] == 'h'){
                return curnt.dist;
            }

            // if 2  moving up
            if (IsValid(curnt.row - 1, curnt.col, visit, n, m)) {
                queue.add(new PairOfInt(curnt.row -1, curnt.col, curnt.dist + 1));
                visit[curnt.row - 1][curnt.col] = 1;
            }

            //if 3 moving down
            if (IsValid(curnt.row + 1, curnt.col, visit,  n, m)) {
                queue.add(new PairOfInt(curnt.row + 1, curnt.col, curnt.dist + 1));
                visit[curnt.row + 1][curnt.col] = 1;
            }

            //if 4 moving left
            if (IsValid(curnt.row, curnt.col - 1, visit,  n, m)) {
                queue.add(new PairOfInt(curnt.row, curnt.col - 1, curnt.dist + 1));
                visit[curnt.row][curnt.col - 1] = 1;
            }

            //if 5 moving right
            if (IsValid(curnt.row, curnt.col + 1, visit,  n, m)) {
                queue.add(new PairOfInt(curnt.row, curnt.col + 1, curnt.dist + 1));
                visit[curnt.row][curnt.col + 1] = 1;
            }
        }

        return -1;
    }

}
