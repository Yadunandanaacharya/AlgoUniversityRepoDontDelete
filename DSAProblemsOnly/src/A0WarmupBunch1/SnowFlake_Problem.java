package A0WarmupBunch1;

//A connected component of a graph is called a snowflake if it contains exactly one node that has a degree
//        not equal to 1.
//not equal to 1 means if degree is 0 then you have to increase count in below problem youu'll get 3 times 0
//so ans is 3

public class SnowFlake_Problem {
    public  static  class  Graph{
        int v,e;
        int[][] dir;

        Graph(int v,int e){
            this.v = v;
            this.e = e;
            dir = new int[v][];
            for (int i = 0; i < v; i++)
                dir[i] = new int[v];
        }
    }

    static Graph createGraph(int v, int e)
    {
        Graph G = new Graph(v, e);
//        Graph G = new Graph(v, e);

     /* 0-----1
        | \   |
        |  \  |
        |   \ |
        2-----3 */

        //direction from 0
//        G.dir[0][1] = 1;
//        G.dir[0][2] = 1;
//        G.dir[0][3] = 1;
//
//        //direction from 1
//        G.dir[1][0] = 1;
//        G.dir[1][3] = 1;
//
//        //direction from 2
//        G.dir[2][0] = 1;
//        G.dir[2][3] = 1;
//
//        //direction from 3
//        G.dir[3][0] = 1;
//        G.dir[3][1] = 1;
//        G.dir[3][2] = 1;

        //direction from 1
        G.dir[1][2] = 1;
        G.dir[2][3] = 1;

        //direction from 1
        G.dir[4][5] = 1;
        G.dir[6][5] = 1;
        G.dir[7][5] = 1;
        G.dir[8][5] = 1;
        G.dir[9][5] = 1;
        G.dir[10][5] = 1;

        return G;
    }

    static int findDegreeWhichIsNot1(Graph G, int ver)
    {
        int degree = 0;
        int degreeCountNot1 = 0;
        for (int i = 0; i < G.v; i++) {
            if (G.dir[ver][i] == 1)
                degree++;
        }

        // below line is to account for self loop in graph
        // check sum of degrees in graph theorem
        if(G.dir[ver][ver] == 1) degree++;
        return degree;
    }

    public static void main(String[] args) {
        int vertices = 11;
        int edges = 8;

        Graph G = createGraph(vertices, edges);

        int ver = 0;

        // Function calling
        for (int i = 0; i < vertices; i++) {
            int degree = findDegreeWhichIsNot1(G, i);
            System.out.println("vertex is " + i + " degree " + degree);
        }

    }
}
