import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    private int count = 0;

    public BruteCollinearPoints(Point[] points) {
        validateInput(points);
        segments = new LineSegment[points.length];
        int countCollinear = 2;

        for (int k = 0; k < points.length - 2; k++) {
            Point initPoint = points[k];
            Point endPoint = points[k + 1];

            if (initPoint.compareTo(endPoint) == 1) {
                Point temp = endPoint;
                endPoint = initPoint;
                initPoint = temp;
            }

            double slope1 = initPoint.slopeTo(endPoint);

            int j = k + 2;
            Point current = points[j];
            double slope2 = initPoint.slopeTo(current);
            if (slope1 == slope2) {
                while (slope1 == slope2 && j < points.length - 1) {
                    if (current.compareTo(endPoint) == 1) {
                        endPoint = current;
                    } else if (current.compareTo(initPoint) == -1) {
                        initPoint = current;
                    }
                    //get next
                    current = points[++j];
                    // next slope
                    slope2 = current.slopeTo(initPoint);
                    countCollinear++;
                    k = j - 1;

                }
            }
            if (countCollinear > 3) {
                LineSegment lineSegment = new LineSegment(initPoint, endPoint);
                segments[count] = lineSegment;
                count++;
                // UtilCoursera.print(points, segments());
            }
            countCollinear = 3;
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
