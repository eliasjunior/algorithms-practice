import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    private int count = 0;
    int countCollinear = 0;
    private Point[] groups;
    Point[] copy;
    Point origin;
    Point q2;
    Point prev;
    public BruteCollinearPoints(Point[] points) {
        validateInput(points);
        copy = copyPoints(points);
        segments = new LineSegment[points.length];
        if(copy.length < 4) {
            return;
        }
        Arrays.sort(copy);
        for (int k = 0; k < copy.length; k++) {
            origin = copy[k];
            if(k > 0)
                prev = copy[k - 1];
            ++countCollinear;
            // find all the slopes and group then
          //  Arrays.sort(copy, Collections.reverseOrder());
            for (int m = 0; m < copy.length; m++) {
                q2 = copy[m];

                if (q2.compareTo(origin) != 0) {
                    for (int i = 0; i < copy.length; i++) {
                        Point q3 = copy[i];
                        i = exaust4Option(q3, i);
                    }
                }
            }
        }
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

    public static void main(String[] args) {
    }

    private int exaust4Option(Point q3, int i) {
        double q2Slope = origin.slopeTo(q2);
        double q3Slope = origin.slopeTo(q3);

        if ((q3.compareTo(origin) != 0 && q3.compareTo(q2) != 0) && (q3Slope == q2Slope)) {
            // more then 3
            if (i == copy.length - 1) {
                return i;
            };
            Point nextGroup = copy[i + 1];
            double nextSlope = origin.slopeTo(nextGroup);

            if (nextSlope == q2Slope) {
                // only if it has 4 or more add to the groups
                groups = new Point[copy.length];
                groups[0] = q2;
                ++countCollinear;
                groups[1] = q3;
                ++countCollinear;
                //start from last match
                i = i + 1;
                //at least 4
                while (nextSlope == q2Slope) {
                    i++;
                    ++countCollinear;
                    groups[countCollinear - 1] = nextGroup;
                    // need to incr
                    if (i >= copy.length) break;
                    nextGroup = copy[i];
                    nextSlope = origin.slopeTo(nextGroup);
                }

                if (countCollinear > 3) {
                    if (origin.compareTo(q2) < 0 &&  q2.compareTo(q3) < 0) {
                        if(prev == null || prev.slopeTo(origin) != q3Slope ) {
                            LineSegment lineSegment = new LineSegment(origin, groups[countCollinear - 1]);
                            if (count == segments.length) {
                                resize(count);
                            }
                            segments[count] = lineSegment;
                            count++;
                        }
                        //  UtilCoursera.print(points, segments());
                    }
                }
                countCollinear = 0;
            } else {
                exaust4Option(q3, i + 1);
            }
        }
        return i;
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

    private Point[] copyPoints(Point[] points) {
        Point[] copy = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            copy[i] = points[i];
        }
        return copy;
    }

    private void resize(int capacity) {
        LineSegment[] copy = new LineSegment[capacity * 2];
        for (int i = 0; i < count; i++) {
            copy[i] = segments[i];
        }
        segments = copy;
    }
}
