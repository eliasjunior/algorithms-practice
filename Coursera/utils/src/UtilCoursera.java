import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class UtilCoursera {
    private static String basePath = "/Users/eliasjunior/Projects/algorithms-practice/Coursera";
    private static String module_path_collinear = "/collinear-points/src/collinear/";
    private static String module_path_puzzle = "/puzzle/";
    public static Point[] getPoints(String path) {

        In file = new In(basePath + module_path_collinear + path);
        int n = file.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = file.readInt();
            int y = file.readInt();
            points[i] = new Point(x, y);
        }
        return points;
    }

    public static int[][] getBoard(String path) {
        In file = new In(basePath + module_path_puzzle + path);
        int n = file.readInt();
        int [][] tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = file.readInt();
                tiles[i][j] = num;
            }
        }
        return tiles;
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
