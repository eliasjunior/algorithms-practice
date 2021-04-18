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
        int count = 0;
        int countCollinear = 2;
       // String file = UtilCoursera.readFile(basePath + "input6.txt");
        Point [] points = UtilCoursera.getPoints( "draft.txt");
        Point[] aux = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            aux[i] = points[i];
        }
        double [] slopes = new double[5];
        Point end;
        Point init;
        Point next = null;
        for (int i = 0; i < aux.length; i++) {
            Point origin  = aux[i];
            init = origin;
            System.out.println("ORIGIN ======================== " + origin);
            Arrays.sort(points, origin.slopeOrder());
            for (int j = 1; j < points.length; j++) {
                Point q1 = points[j];
                end = q1;
                double slopeQ1 = origin.slopeTo(q1);
                System.out.println("    ======================== " + q1 + " q1 slope " +slopeQ1);
                if(j == points.length - 1) break;
                Point q2 = points[++j];
                double slopeQ2 = origin.slopeTo(q2);
                if(slopeQ1 == slopeQ2) {
                    //increment
                    countCollinear++;
                }
                System.out.println("    ======================== " + q2 + " q2 slope " +slopeQ2);
                if(j == points.length - 1) break;
                Point q3 = points[++j];
                double slopeQ3 = origin.slopeTo(q3);
                System.out.println("    ======================== " + q3 + " q3 slope " +slopeQ3);
                if(slopeQ2 == slopeQ3) {
                    //increment
                    countCollinear++;
                    if(j == points.length - 1) break;
                    next = points[++j];
                    double slopeNext = next.slopeTo(q3);
                    // every next increment the jump and indexSearch
                    while(slopeQ3 == slopeNext) {
                        if(next.compareTo(init) == -1) {
                            init = next;
                        } else if (next.compareTo(end) == 1) {
                            end = next;
                        }
                        System.out.println("    ======================== " + next + " slopeNext " +slopeNext);
                        countCollinear++;
                        if(j == points.length - 1) break;
                        next = points[++j];
                        slopeNext = next.slopeTo(q3);
                    }
                    Point[] extra = {origin, q1, q2, q3, next, init, end};
                    Arrays.sort(extra);
                    init = extra[0];
                    end = extra[extra.length -1];
                }
                if(countCollinear > 3){
                    // i have a colinear
                    //addLine(init, end)
                    boolean found = false;
                    for (int k = 0; k < slopes.length; k++) {
                        if(slopes[k] == slopeQ3) {
                            found = true;
                        }
                    }
                    if(!found) {
                        slopes[count] = slopeQ3;
                        System.out.println("  LINE  ======================== init" + init + " end "+end );
                    }

                }
                countCollinear = 2;
            }

        }

    }

}