import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FastCollinearPointsTest {
    @Test
    public void experimental() {

        System.out.println(9.0/7.0 );
        System.out.println( 45.0/35.0);

//        Point[] points = UtilCoursera.getPoints("draft.txt");
//        // Arrays.sort(points, origin.slopeOrder());
//        StdOut.println(points[0] +" ====  "+points[1] + " slope="+points[0].slopeTo(points[1]) + " <->" + points[1].slopeTo(points[0]) );
//        //  StdOut.println(points[2] +" ====  "+points[3] + " slope="+points[2].slopeTo(points[3]) + " <->" + points[3].slopeTo(points[2]));
//
//        StdOut.println("x2, x0 "+points[0].slopeTo(points[2]));
//        StdOut.println("x3, x0 "+points[0].slopeTo(points[3]));
//
////        (3, 1) ====  (5, 2) slope=0.5 <->0.5
////        (4, 2) ====  (-3, 16) slope=-2.0 <->-2.0
////        x2, x0 1.0
////        x3, x0 -2.5
//
//        Arrays.sort(points, points[0].slopeOrder());
//
//        for (int i = 0; i < points.length; i++) {
//            StdOut.println(points[i]);
//        }
    }
    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point[] points = {new Point(4, 4), new Point(2, 2), new Point(2, 2)};
            new FastCollinearPoints(points);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new FastCollinearPoints(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point[] points = {new Point(4, 4), null, new Point(2, 2)};
            new FastCollinearPoints(points);
        });
    }

    @Test
    public void testIndex6() {
        Point[] points = UtilCoursera.getPoints("input6.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        for (LineSegment segment : fast.segments()) {
            StdOut.println(segment);
        }
        assertEquals(1, fast.numberOfSegments());
        assertEquals(1, fast.segments().length);
    }

    @Test
    public void testIndex8() {
        Point[] points = UtilCoursera.getPoints("input8.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(2, fast.numberOfSegments());
        assertEquals(2, fast.segments().length);
    }

    @Test
    public void testBruteIndexes() {
//        {
//            Point[] points = UtilCoursera.getPoints("input9.txt");
//            FastCollinearPoints fast = new FastCollinearPoints(points);
//            assertEquals(1, fast.numberOfSegments());
//        }

        {
            Point[] points = UtilCoursera.getPoints("input10.txt");
            FastCollinearPoints fast = new FastCollinearPoints(points);
            assertEquals(1, fast.numberOfSegments());
        }
    }

    @Test
    public void testBruteIndex20() {
        {
            Point[] points = UtilCoursera.getPoints("input20.txt");
            FastCollinearPoints fast = new FastCollinearPoints(points);
            assertEquals(5, fast.numberOfSegments());
        }
    }

    @Test
    public void testBruteIndex40() {
        {
            Point[] points = UtilCoursera.getPoints("input40.txt");
            FastCollinearPoints fast = new FastCollinearPoints(points);
            assertEquals(4, fast.numberOfSegments());
        }
    }

}