import edu.princeton.cs.algs4.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    String basePath = "/Users/eliasjunior/Projects/algorithms-practice/Coursera/collinear-points/src/collinear/";

    @Test
    public void testSlopeOrder() {
        Point p3 = new Point(3, 3);
        Point p1 = new Point(1,1);
        Point p2 = new Point(2, 2);

        Point [] points = {p3, p1, p2};

        Arrays.sort(points, p3.slopeOrder());

        for (Point p: points
        ) {
            StdOut.println("===" + p);
        }

        p3.slopeOrder().compare(p1, p2);
        // bySlope.compare(p1, p2);

    }
    @Test
    public void testSlopeTo() {
        Point p1 = new Point(1,1);
        Point q = new Point(1, 2);
        assertTrue( p1.slopeTo(q) == Double.POSITIVE_INFINITY);

        Point p2 = new Point(2, 2);
        double p2r = p1.slopeTo(p2);
        assertTrue( p2r == 1.0);

        Point p3 = new Point(3, 3);
        double p3r = p1.slopeTo(p3);
        assertTrue( p3r == 1.0);

        Point p4 = new Point(4, 4);
        double p4r = p1.slopeTo(p4);
        assertTrue( p4r == 1.0);
    }

    @Test
    public void testMoreSlope() {
        Point p;
        Point q;
        p = new Point(430, 230);
        q = new Point(430, 38);
        assertTrue( p.slopeTo(q) == Double.POSITIVE_INFINITY );

        p = new Point(8522, 24360);
        q = new Point(8522, 23258);
        assertTrue( p.slopeTo(q) == Double.POSITIVE_INFINITY );

        p = new Point(358, 7);
        q = new Point(358, 197);
        assertEquals(  Double.POSITIVE_INFINITY , p.slopeTo(q));

        p = new Point(289, 343);
        q = new Point(237, 343);
        assertEquals(  +0.0 , p.slopeTo(q));

    }

    @Test
    public void testCompareTo() {
        Point p = new Point(1,1);
        Point degen = new Point(1,1);

        Point q = new Point(1, 2);
        Point r = new Point(3, 2);

        assertTrue( p.compareTo(q) == -1);
        assertTrue( q.compareTo(p) == 1);
        assertTrue( q.compareTo(r) == -1);
        assertTrue( r.compareTo(q) == 1);
        assertTrue( p.compareTo(degen) == 0);
    }

    @Test
    public void testSlopeFromFiles() {
       // String file = UtilCoursera.readFile(basePath + "input6.txt");
        Point [] points = UtilCoursera.getPoints( "input6.txt");


    }


}