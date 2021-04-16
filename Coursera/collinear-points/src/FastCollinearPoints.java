import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] segments;
    private int count = 0;
    private int countCollinear = 4;
    private Point[] points;

    public FastCollinearPoints(Point[] points) {
        validateInput(points);
        this.points = points;
        segments = new LineSegment[points.length];

        Point[] aux = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            aux[i] = points[i];
        }

        for (int i = 0; i < points.length; i++) {
            Point origin = aux[i];
            Arrays.sort(points, origin.slopeOrder());
            Point q1 = points[1];
            double slopeWithQ1 = origin.slopeTo(q1);

            Point q2 = points[2];
            Point q3 = points[3];
            Point end = q3;

            double slope2 = q2.slopeTo(q3);

            if (slopeWithQ1 == slope2) {
                i = i + 3;
                Point adjacent = points[4];

                double slopeAdjacent = adjacent.slopeTo(origin);

                while (slopeWithQ1 == slopeAdjacent && i < points.length - 1) {
                    end = adjacent;
                    adjacent = points[i + 1];
                    slopeAdjacent = adjacent.slopeTo(origin);
                    countCollinear++;
                    i++;
                }
                addLine(origin, end);
            }

//            if (countCollinear > 4) {
//                boolean isAlreadyIn = false;
////                for (LineSegment inSegment : segments()
////                ) {
////                    if (inSegment != null) {
////                        // it has to be ascending order to work
////                        Point[] inPoints = getPointFromStr(inSegment.toString());
////                        Point inFirst = inPoints[0];
////                        Point inLast = inPoints[1];
////
////                        if (inFirst.slopeTo(origin) == slopeWithQ1) {
////                            isAlreadyIn = true;
////                        }
////                    }
////                }
//                // if(!isAlreadyIn) {
//                addLine(origin, end);
//                  UtilCoursera.print(points, segments());
//                // }
//            }
            countCollinear = 2;
        }
    }    // finds all line segments containing 4 or more points

    private void addLine(Point init, Point end) {
        LineSegment lineSegment = new LineSegment(init, end);
        segments[count++] = lineSegment;
        //  UtilCoursera.print(points, segments());
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

    private Point[] getPointFromStr(String str) {
        String[] stillStr = str.split("->");
        Point p = getPoint(stillStr[0].trim().split(","));
        Point q = getPoint(stillStr[1].trim().split(","));
        return new Point[]{p, q};
    }

    private Point getPoint(String[] coor) {
        String x = coor[0].trim().replaceAll("[()]", "");
        String y = coor[1].trim().replaceAll("[()]", "");
        return new Point(Integer.parseInt(x), Integer.parseInt(y));
    }

}
