import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;

import java.util.TreeSet;

public class PointSET {
    private SET<Point2D> points;
    private Node root;
    private int count = 0;

    public PointSET() {
        this.points = new SET<>();
    }                             // construct an empty set of points

    public boolean isEmpty() {
        return count == 0;
    }                    // is the set empty?

    public int size() {
        return count;
    }                       // number of points in the set

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        root = insert(root, p);
    }
    private Node insert(Node node, Point2D p) {
        count++;
        if(node == null) {
            return new Node(p);
        }
        return null;
    }

    public boolean contains(Point2D p) {
        Node current = root;

        while(current != null) {
            // how I compare this, should use the coordinates to compare, how to compare coordinates ?
            //current.p.y()
        }

        return this.points.contains(p);
    }         // does the set contain point p?

    public void draw() {
    }                   // draw all points to standard draw

    public Iterable<Point2D> range(RectHV rect) {
        return null;
    }             // all points that are inside the rectangle (or on the boundary)

    public Point2D nearest(Point2D p) {
        return null;
    }           // a nearest neighbor in the set to point p; null if the set is empty

    public static void main(String[] args) {
        test1();
    }                  // unit testing of the methods (optional)

    private static void test1() {
        PointSET pointSET = new PointSET();
        pointSET.insert(new Point2D(0.1, 0.3));
        pointSET.insert(new Point2D(0.4, 0.3));
        pointSET.insert(new Point2D(0.6, 0.6));
        pointSET.insert(new Point2D(0.8, 0.6));

    }
    private static class Node {
        private Point2D p;      // the point
        private RectHV rect;    // the axis-aligned rectangle corresponding to this node
        private Node lb;        // the left/bottom subtree
        private Node rt;        // the right/top subtree
        public Node(Point2D p) {
            this.p = p;
        }
    }
}
