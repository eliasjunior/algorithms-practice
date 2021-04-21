import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FastCollinearPointsTest {
    @Test
    public void experimental() {

        Point[] points = UtilCoursera.getPoints("equidistant.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
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
    public void testFastIndexes() {
        Point[] points = UtilCoursera.getPoints("input9.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(1, fast.numberOfSegments());
    }

    @Test
    public void testFastInput10() {
        Point[] points = UtilCoursera.getPoints("input10.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(2, fast.numberOfSegments());
    }

    @Test
    public void testFastIndex20() {
        Point[] points = UtilCoursera.getPoints("input20.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(5, fast.numberOfSegments());
    }

    @Test
    public void testFastIndex40() {
        Point[] points = UtilCoursera.getPoints("input40.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(4, fast.numberOfSegments());
    }

    @Test
    public void testFastIndex200() {
        Point[] points = UtilCoursera.getPoints("input200.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(4, fast.numberOfSegments());
    }

    @Test
    public void testFastInputHorinzontal() {
        // Point[] points = UtilCoursera.getPoints("horizontal5.txt");
        Point[] points = UtilCoursera.getPoints("draft.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(5, fast.numberOfSegments());

    }

    @Test
    public void testFastEquidistant() {
        Point[] points = UtilCoursera.getPoints("equidistant.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        assertEquals(4, fast.numberOfSegments());
    }

    @Test
    public void testFastGrids() {
        //Point[] points = UtilCoursera.getPoints("input10000.txt");
        Point[] points = UtilCoursera.getPoints("grid6x6.txt");
        FastCollinearPoints fast = new FastCollinearPoints(points);
        //assertEquals(4, fast.numberOfSegments());
    }

}