package AssignmentProblems.A0WarmupBunch1;
//https://www.geeksforgeeks.org/total-area-two-overlapping-rectangles/
public class WhiteLuckWarriorProblem {
        static class Point {
            int x, y;

            public Point(int x, int y)
            {
                this.x = x;
                this.y = y;
            }
        };

        // Returns Total Area of two overlap
        // rectangles
        static int overlappingArea(Point l1, Point r1,
                                   Point l2, Point r2)
        {
            // Area of 1st Rectangle
            int area1  = Math.abs(l1.x - r1.x) * Math.abs(l1.y - r1.y);

            // Area of 2nd Rectangle
            int area2 = Math.abs(l2.x - r2.x)* Math.abs(l2.y - r2.y);

            // Length of intersecting part i.e
            // start from max(l1.x, l2.x) of
            // x-coordinate and end at min(r1.x,
            // r2.x) x-coordinate by subtracting
            // start from end we get required
            // lengths

            int x_dist = (Math.min(r1.x, r2.x) - Math.max(l1.x, l2.x));
            int y_dist = (Math.min(r1.y, r2.y)- Math.max(l1.y, l2.y));
            int areaI = 0;
            if( x_dist > 0 && y_dist > 0 )
            {
                areaI = x_dist * y_dist;
            }

            return (area1 + area2 - areaI);
        }

        // Driver Code
        public static void main(String[] args)
        {
            Point l1 = new Point(6, 6), r1 = new Point(8, 8);
            Point l2 = new Point(1, 8), r2 = new Point(4, 9);

            // Function Call
            System.out.println(overlappingArea(l1, r1, l2, r2));
        }
}
