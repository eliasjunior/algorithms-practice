import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] segments;
    private int count = 0;
    private int countCollinear = 3;
    private Point[] groups;

    public FastCollinearPoints(Point[] points) {
        validateInput(points);
        // just for print
        //this.points = points;
        Point [] copy = copyPoints(points);
        Point [] copy2 = copy;

        segments = new LineSegment[points.length];

        printHelper("================BEGIN====================");

        for (int i = 0; i < copy.length; i++) {
            Arrays.sort(copy);// maybe I can move this up
            Point origin = copy[i];
            printHelper(i + " <<<<<<<< =============== ORIGIN P " + origin);
            Arrays.sort(copy, origin.slopeOrder());

            printHelper("**** END GROUPED BY SLOPE ");

            for (int j = 1; j < copy.length; j++) {
                Point q1 = copy[j];
                double slopeQ1 = origin.slopeTo(q1);
                printHelper("q1 " + q1 + " " + slopeQ1);
                if (j == copy.length - 1) break;
                Point q2 = copy[j + 1];
                double slopeQ2 = origin.slopeTo(q2);
                printHelper("q2 " + q2 + " " + slopeQ2);
                groups = new Point[copy.length];
                groups[0] = q1;
                groups[1] = q2;
                if (slopeQ1 == slopeQ2) {
                    j = j + 1; // incr for the prev
                    if (j >= copy.length - 1) break;
                    Point next = copy[j + 1];
                    double slopeNext = origin.slopeTo(next);
                    while (slopeQ2 == slopeNext) {
                        j++; // after its true incr
                        groups[countCollinear - 1] = next;
                        countCollinear++;
                        if (j >= copy.length - 1) break;
                        next = copy[j + 1];
                        slopeNext = next.slopeTo(q2);
                    }
                    if (slopeQ2 != slopeNext) {
                        j--; // give it back to try with the next
                    }
                }

                if (countCollinear >= 4) {
                    if (origin.compareTo(groups[0]) <= 0) {
                        LineSegment lineSegment = new LineSegment(origin, groups[countCollinear - 2]);
                        printHelper("***** Line *****  " + lineSegment);
                        if(count == segments.length) {
                            resize(count);
                        }
                        segments[count] = lineSegment;
                        count++;
                        //  UtilCoursera.print(points, segments());
                    }
                }
                countCollinear = 3;
            }
        }
    }    // finds all line segments containing 4 or more points

    public int numberOfSegments() {
        return count;
    }    // the number of line segments

    public LineSegment[] segments() {
        LineSegment[] result = new LineSegment[count];
        int j = 0;
        for (int i = 0; i < segments.length; i++) {
            if (segments[i] != null) {
                result[j++] = segments[i];
            }
        }
        return result;
    }             // the line segments

    private void printHelper(String label) {
      //  System.out.println(label);
    }

    private void resize(int capacity) {
        LineSegment [] copy = new LineSegment[capacity * 2];
        for (int i = 0; i < count; i++) {
            copy[i] = segments[i];
        }
        segments = copy;
    }

    private Point[] copyPoints(Point [] points) {
        Point [] copy = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            copy[i] = points[i];
        }
        return copy;
    }

    private void validateInput(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
            Point p = points[i];

            for (int j = 0; j < points.length; j++) {
                if (points[j] == null) {
                    throw new IllegalArgumentException();
                }
                Point next = points[j];
                if (i != j && p.compareTo(next) == 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
