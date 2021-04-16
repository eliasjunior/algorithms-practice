import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class UtilCoursera {
    public static Point[] getPoints(String path) {
        String basePath = "/Users/eliasjunior/Projects/algorithms-practice/Coursera/collinear-points/src/collinear/";
        In file = new In(basePath + path);
        int n = file.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = file.readInt();
            int y = file.readInt();
            points[i] = new Point(x, y);
        }
        return points;
    }


    public static void print(Point[] points, LineSegment[] segments) {
        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();
        for (LineSegment segment : segments) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show(10000);
    }
}
