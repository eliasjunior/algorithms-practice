import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] segments;
    private int count = 0;
    private int countCollinear = 2;
    private Point[] iPoints = new Point[5];
    private Point[] ePoints = new Point[5];
    private Point end;
    private Point init;
    private Point  [] points;

    public FastCollinearPoints(Point[] points) {
        validateInput(points);
        // just for print
        this.points = points;
        segments = new LineSegment[points.length];

        Point[] aux = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            aux[i] = points[i];
        }

        Point next = null;
        for (int i = 0; i < aux.length; i++) {
            Point origin = aux[i];
            printHelper(" =============== ORIGIN", origin, 0);
            Arrays.sort(points, origin.slopeOrder());
            for (int j = 1; j < points.length; j++) {
                countCollinear = 2;
                Point q1 = points[j];
                double slopeQ1 = origin.slopeTo(q1);
                printHelper("q1", q1, slopeQ1);
                if (j == points.length - 1) break;
                Point q2 = points[++j];
                double slopeQ2 = origin.slopeTo(q2);
                printHelper("q2", q2, slopeQ2);
                if (j == points.length - 1) break;
                Point q3 = points[++j];
                double slopeQ3 = origin.slopeTo(q3);

                printHelper("q3", q3, slopeQ3);
                if (slopeQ1 == slopeQ2 &&  slopeQ1 == slopeQ3) {
                    checkRange(origin);
                    checkRange(q1);
                    checkRange(q2);
                    checkRange(q3);
                    //increment
                    countCollinear++;
                    if (j == points.length - 1) break;
                    next = points[++j];
                    double slopeNext = next.slopeTo(q3);
                    // every next increment the jump and indexSearch
                    while (slopeQ3 == slopeNext) {
                        checkRange(next);
                        printHelper("next", next, slopeNext);
                        countCollinear++;
                        if (j == points.length - 1) break;
                        next = points[++j];
                        slopeNext = next.slopeTo(q3);
                    }
                } else {
//                    if (j == points.length - 1) break;
//                    next = points[j + 1];
//                    if (next.slopeTo(q3) == slopeQ3) {
//                        --j;
//                    }
                }
                if (countCollinear > 3) {
                    // i have a collinear
                    addLine();
                }
            }
        }
    }    // finds all line segments containing 4 or more points

    private void checkRange(Point p) {
        if (init == null) {
            init = p;
            end = p;
        } else {
            if (p.compareTo(init) == -1) {
                init = p;
            } else if (p.compareTo(end) == 1) {
                end = p;
            }
        }

    }

    private void addLine() {
        boolean found = false;
        for (int k = 0; k < iPoints.length; k++) {
            if (iPoints[k] != null &&
                    iPoints[k].compareTo(init) == 0 &&
                    ePoints[k].compareTo(end) == 0) {
                found = true;
                break;
            }
        }
        if (!found) {
            printHelper("line");
            if(init.compareTo(end) != 0) {
                LineSegment lineSegment = new LineSegment(init, end);
                //this condition shows that something is wrong, count should never be greats that the number of segments
                // they should be created at same time
                if (count < segments.length - 1) {
                    segments[count] = lineSegment;
                    count++;
                    // temp
                    if (count < iPoints.length - 1) {
                        iPoints[count] = init;
                        ePoints[count] = end;
                    }
                    UtilCoursera.print(points, segments());
                }
            }
        }

    }

    private void printHelper(String label) {
        System.out.println(label + " ======================== init" + init + " end " + end);
    }

    private void printHelper(String label, Point q, double slope) {
        System.out.println("    ======================== " + q + " " + label + " =>" + slope);
    }

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
