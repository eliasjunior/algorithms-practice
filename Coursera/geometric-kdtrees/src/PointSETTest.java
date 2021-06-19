import edu.princeton.cs.algs4.Point2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointSETTest {


    @Test
    public void insertNode() {
        PointSET pointSET = new PointSET();
        Point2D point1 = new Point2D(0.1, 0.3);
        pointSET.insert(point1);
        assertEquals(1,  pointSET.size());

        pointSET.insert(new Point2D(0.2, 0.3));
        assertEquals(2,  pointSET.size());

        assertTrue(pointSET.contains(point1));
    }
}