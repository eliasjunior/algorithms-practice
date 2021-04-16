import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    private int count = 0;

    public BruteCollinearPoints(Point[] points) {
        validateInput(points);
        Arrays.sort(points);
        segments = new LineSegment[points.length];
        int countCollinear = 2;
        int maxLiner = 3;
        for (int i = 0; i < points.length; i++) {
            Point initPoint = points[i];
            //   Arrays.sort(points, initPoint.slopeOrder());

            for (int k = i + 1; k < points.length; k++) {
                // Point endPointCandidate = points[k];
                Point endPoint = points[k];
                //j = k + 1
                for (int j = k + 1; j < points.length; j++) {
                    Point current = points[j];

                    double slope1 = initPoint.slopeTo(endPoint);
                    double slope2 = initPoint.slopeTo(current);

                    if (slope1 == slope2) {
                  //  if (initPoint.slopeTo(endPoint) == initPoint.slopeTo(current)) {
                        endPoint = points[j];
                        countCollinear++;
                    }
                }
                if (countCollinear > maxLiner) {
                    LineSegment lineSegment = new LineSegment(initPoint, endPoint);
                    boolean isAlreadyIn = false;
                    for (LineSegment inSegment : segments()
                    ) {
                        if (inSegment != null) {
                            // it has to be ascending order to work
                            Point[] inPoints = getPointFromStr(inSegment.toString());
                            Point inFirst = inPoints[0];
                            Point inLast = inPoints[1];

                            if (inLast.compareTo(endPoint) == 0) {
                                if (initPoint.slopeTo(endPoint) == inFirst.slopeTo(inLast)) {
                                    isAlreadyIn = true;
                                }
                            }
                        }

                    }
                    if (!isAlreadyIn) {
                        segments[count++] = lineSegment;
                        maxLiner = countCollinear;

                      //  UtilCoursera.print(points, segments());
                    }
                } else if (countCollinear == 3) {
                    for (int j = 0; j < segments.length; j++) {

                        LineSegment inSegment = segments[j];
                        if (inSegment != null) {
                            // searching previous same slope as its sorted
                            Point[] inPoints = getPointFromStr(inSegment.toString());
                            Point inFirst = inPoints[0];
                            Point inLast = inPoints[1];

                            Point newInit = initPoint.compareTo(inFirst) == -1 ? initPoint : inFirst;
                            Point newEnd = endPoint.compareTo(inLast) == 1 ? endPoint: inLast;

                            double slope1 = initPoint.compareTo(inFirst) == 1 ?  inFirst.slopeTo(initPoint): initPoint.slopeTo(inFirst);
                            double slope2 = endPoint.compareTo(inLast) == 1 ?  inLast.slopeTo(endPoint): endPoint.slopeTo(inLast);

                            if (slope1 == slope2) {
                                // replace if its same line but larger
                                if (initPoint.compareTo(inFirst) == -1 || endPoint.compareTo(inLast) == 1) {
                                    segments[j] = new LineSegment(newInit, newEnd);
                                   // UtilCoursera.print(points, segments());
                                }
                                break;
                            } else {
                                double slope3 = initPoint.compareTo(endPoint) == 1 ?  endPoint.slopeTo(initPoint): initPoint.slopeTo(endPoint);
                                double slope4 = initPoint.compareTo(inFirst) == 1 ?  inFirst.slopeTo(initPoint): initPoint.slopeTo(inFirst);
                                // same line
                                if (slope3 == slope4 && endPoint.compareTo(inLast) != 0) {
                                    segments[count++] = new LineSegment(newInit, newEnd);
                                   // UtilCoursera.print(points, segments());
                                    break;
                                }
                            }
                        }
                    }
                }
                countCollinear = 2;
            }
            maxLiner = 3;
        }
    } // finds all line segments containing 4 points

    private boolean isSameLine(Point inFirst, Point inLast, Point initPoint, Point endPoint) {
        int[] xyInFirst = getXy(inFirst.toString());
        int[] xyInLast = getXy(inLast.toString());

        int[] initXy = getXy(initPoint.toString());
        int[] endXy = getXy(endPoint.toString());

        return xyInFirst[0] == initXy[0] && xyInLast[1] == endXy[1];
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

    private int[] getXy(String str) {
        String[] stillStr = str.split("->");
        String x = stillStr[0].trim().replaceAll("[()]", "");
        String y = stillStr[1].trim().replaceAll("[()]", "");
        return new int[]{Integer.parseInt(x), Integer.parseInt(y)};
    }
}
