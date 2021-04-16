import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BruteCollinearPointsTest {

    @Test
    public void testConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point[] points = {new Point(4, 4), new Point(2, 2), new Point(2, 2)};
            new BruteCollinearPoints(points);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BruteCollinearPoints(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point[] points = {new Point(4, 4), null, new Point(2, 2)};
            new BruteCollinearPoints(points);
        });
    }

    @Test
    public void testBrute0() {
        Point[] points = {new Point(4, 4), new Point(2, 2),
                new Point(3, 3), new Point(1, 1), new Point(1, 2)};

        BruteCollinearPoints brute = new BruteCollinearPoints(points);

        assertEquals(1, brute.segments().length);
        assertEquals(1, brute.numberOfSegments());
    }

    @Test
    public void testBruteIndexes() {
        {
            Point[] points = UtilCoursera.getPoints("input1.txt");
            BruteCollinearPoints brute = new BruteCollinearPoints(points);
            for (LineSegment segment : brute.segments()) {
                StdOut.println(segment);
            }
            assertEquals(0, brute.numberOfSegments());
        }

        {
            Point[] points = UtilCoursera.getPoints("input2.txt");
            BruteCollinearPoints brute = new BruteCollinearPoints(points);
            for (LineSegment segment : brute.segments()) {
                StdOut.println(segment);
            }
            assertEquals(0, brute.numberOfSegments());
        }

        {
            Point[] points = UtilCoursera.getPoints("input3.txt");
            BruteCollinearPoints brute = new BruteCollinearPoints(points);
            for (LineSegment segment : brute.segments()) {
                StdOut.println(segment);
            }
            assertEquals(0, brute.numberOfSegments());
        }
    }

    @Test
    public void testBruteIndexFiles() {
        Point[] points = UtilCoursera.getPoints("input6.txt");
        BruteCollinearPoints brute = new BruteCollinearPoints(points);
       // UtilCoursera.print(points, brute.segments());
        assertEquals(1, brute.numberOfSegments());
    }

    @Test
    public void testBruteIndex8() {
        Point[] points = UtilCoursera.getPoints("input8.txt");
        BruteCollinearPoints brute = new BruteCollinearPoints(points);
        for (LineSegment segment : brute.segments()) {
            StdOut.println(segment);
        }
        assertEquals(2, brute.numberOfSegments());
    }

    @Test
    public void testBruteIndex() {
        {
            Point[] points = UtilCoursera.getPoints("input9.txt");
            BruteCollinearPoints brute = new BruteCollinearPoints(points);
            assertEquals(1, brute.numberOfSegments());
        }

        {
            Point[] points = UtilCoursera.getPoints("input10.txt");
            BruteCollinearPoints brute = new BruteCollinearPoints(points);
           // print(points, brute.segments());
            assertEquals(2, brute.numberOfSegments());
        }
    }

    @Test
    public void testBruteIndex20() {
        {
            Point[] points = UtilCoursera.getPoints("input20.txt");
            BruteCollinearPoints brute = new BruteCollinearPoints(points);
         //   UtilCoursera.print(points, brute.segments());
            assertEquals(5, brute.numberOfSegments());
        }
    }

    @Test
    public void testBruteIndex40() {
        {
            Point[] points = UtilCoursera.getPoints("input40.txt");
            BruteCollinearPoints brute = new BruteCollinearPoints(points);
            //   UtilCoursera.print(points, brute.segments());
            assertEquals(4, brute.numberOfSegments());
        }
    }

}