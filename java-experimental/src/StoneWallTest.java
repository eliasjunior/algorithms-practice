import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StoneWallTest {

    @Test
    void solution1() {
        int [] height = new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8};
        StoneWall stoneWall = new StoneWall();

        assertEquals( 7, stoneWall.solution(height, 9));
    }

    @Test
    void solution2() {
        int [] height = new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        StoneWall stoneWall = new StoneWall();

        assertEquals( 9, stoneWall.solution(height, 11));
    }

    @Test
    void solution3() {
        int [] height = new int[]{5, 8};
        StoneWall stoneWall = new StoneWall();

        assertEquals( 8, stoneWall.solution(height, 2));
    }

    @Test
    void solution4() {
        int [] height = new int[]{1, 1, 1, 1};
        StoneWall stoneWall = new StoneWall();

        assertEquals( 1, stoneWall.solution(height, 1));
    }
}