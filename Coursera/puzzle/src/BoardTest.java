import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void testToString() {
        Board board = new Board(getBoard("puzzle01.txt"));
        String expected = "2\n" +
                " 1  0 \n" +
                " 3  2 \n";

        assertEquals( expected, board.toString());

        expected = "3\n" +
                " 1  2  3 \n" +
                " 4  5  6 \n" +
                " 7  8  0 \n";

        Board board2 = new Board(getBoard("puzzle3x3-00.txt"));
        assertEquals( expected, board2.toString());
    }
    @Test
    public void test_hamming_3x3and2x2() {
        Board board1 = new Board(getBoard("puzzle2x2-00.txt"));
        assertEquals(0, board1.hamming());

        Board board22 = new Board(getBoard("puzzle2x2-03.txt"));
        assertEquals(3, board22.hamming());

        Board board2 = new Board(getBoard("puzzle3x3-00.txt"));
        assertEquals(0, board2.hamming());

        Board board3 = new Board(getBoard("puzzle3x3-01.txt"));
        assertEquals(1, board3.hamming());

        Board board4 = new Board(getBoard("puzzle3x3-02.txt"));
        assertEquals(2, board4.hamming());

        Board board5 = new Board(getBoard("puzzle3x3-03.txt"));
        assertEquals(3, board5.hamming());

        Board board6 = new Board(getBoard("puzzle3x3-04.txt"));
        assertEquals(4, board6.hamming());

        Board board7 = new Board(getBoard("puzzle3x3-05.txt"));
        assertEquals(5, board7.hamming());

        Board board9 = new Board(getBoard("puzzle3x3-06.txt"));
        assertEquals(4, board9.hamming());

        Board board10 = new Board(getBoard("puzzle3x3-07.txt"));
        assertEquals(4, board10.hamming());

    }
    @Test
    public void test_hamming4x4() {
        Board board2 = new Board(getBoard("puzzle4x4-00.txt"));
        assertEquals(0, board2.hamming());

        Board board3 = new Board(getBoard("puzzle4x4-01.txt"));
        assertEquals(1, board3.hamming());

        Board board4 = new Board(getBoard("puzzle4x4-02.txt"));
        assertEquals(2, board4.hamming());

        Board board5 = new Board(getBoard("puzzle4x4-03.txt"));
        assertEquals(3, board5.hamming());

        Board board6 = new Board(getBoard("puzzle4x4-04.txt"));
        assertEquals(4, board6.hamming());

        Board board7 = new Board(getBoard("puzzle4x4-05.txt"));
        assertEquals(5, board7.hamming());

        Board board9 = new Board(getBoard("puzzle4x4-06.txt"));
        assertEquals(6, board9.hamming());

        Board board10 = new Board(getBoard("puzzle4x4-07.txt"));
        assertEquals(7, board10.hamming());

        Board board11 = new Board(getBoard("puzzle4x4-24.txt"));
        assertEquals(13, board11.hamming());
    }
    @Test
    public void test_manhattan() {
        Board board = new Board(getBoard("puzzle07.txt"));
        assertEquals(7, board.manhattan());
    }
    @Test
    public void test_manhattan_2x2() {
        Board board0 = new Board(getBoard("puzzle2x2-00.txt"));
        assertEquals(0, board0.manhattan());
        Board board1 = new Board(getBoard("puzzle2x2-01.txt"));
        assertEquals(1, board1.manhattan());
        Board board2 = new Board(getBoard("puzzle2x2-02.txt"));
        assertEquals(2, board2.manhattan());
        Board board3 = new Board(getBoard("puzzle2x2-03.txt"));
        assertEquals(3, board3.manhattan());
        Board board5 = new Board(getBoard("puzzle2x2-05.txt"));
        assertEquals(5, board5.manhattan());
    }
    @Test
    public void test_manhattan_3x3() {
        Board board0 = new Board(getBoard("puzzle3x3-00.txt"));
        assertEquals(0, board0.manhattan());
        Board board1 = new Board(getBoard("puzzle3x3-01.txt"));
        assertEquals(1, board1.manhattan());
        Board board2 = new Board(getBoard("puzzle3x3-02.txt"));
        assertEquals(2, board2.manhattan());
        Board board3 = new Board(getBoard("puzzle3x3-03.txt"));
        assertEquals(3, board3.manhattan());
        Board board5 = new Board(getBoard("puzzle3x3-05.txt"));
        assertEquals(5, board5.manhattan());
        Board board6 = new Board(getBoard("puzzle3x3-06.txt"));
        assertEquals(6, board6.manhattan());
        Board board7 = new Board(getBoard("puzzle3x3-07.txt"));
        assertEquals(7, board7.manhattan());
        Board board8 = new Board(getBoard("puzzle3x3-08.txt"));
        assertEquals(8, board8.manhattan());
        Board board9 = new Board(getBoard("puzzle3x3-09.txt"));
        assertEquals(9, board9.manhattan());
        Board board16 = new Board(getBoard("puzzle3x3-16.txt"));
        assertEquals(8, board16.manhattan());
    }
    @Test
    public void test_manhattan_4x4() {
        Board board0 = new Board(getBoard("puzzle4x4-00.txt"));
        assertEquals(0, board0.manhattan());
        Board board1 = new Board(getBoard("puzzle4x4-01.txt"));
        assertEquals(1, board1.manhattan());
        Board board2 = new Board(getBoard("puzzle4x4-02.txt"));
        assertEquals(2, board2.manhattan());
        Board board3 = new Board(getBoard("puzzle4x4-03.txt"));
        assertEquals(3, board3.manhattan());
        Board board5 = new Board(getBoard("puzzle4x4-05.txt"));
        assertEquals(5, board5.manhattan());
        Board board6 = new Board(getBoard("puzzle4x4-06.txt"));
        assertEquals(6, board6.manhattan());
        Board board7 = new Board(getBoard("puzzle4x4-07.txt"));
        assertEquals(7, board7.manhattan());
        Board board8 = new Board(getBoard("puzzle4x4-08.txt"));
        assertEquals(8, board8.manhattan());
        Board board9 = new Board(getBoard("puzzle4x4-09.txt"));
        assertEquals(9, board9.manhattan());
        Board board10 = new Board(getBoard("puzzle4x4-10.txt"));
        assertEquals(10, board10.manhattan());
    }
    @Test
    public void testEqual() {
        Board board0 = new Board(getBoard("puzzle3x3-00.txt"));
        Board board00 = new Board(getBoard("puzzle3x3-00.txt"));

        assertTrue(board0.equals(board00));

        Board board1 = new Board(getBoard("puzzle3x3-01.txt"));
        Board board2 = new Board(getBoard("puzzle3x3-02.txt"));

        assertFalse(board1.equals(board2));
    }
//    @Test
//    public void testConvert() {
//        Board board2 = new Board(getBoard("puzzle3x3-00.txt"));
//        assertEquals(3, board2.convert2dTo1d(1, 2));
//        assertEquals(2, board2.convert2dTo1d(1, 1));
//
//        assertEquals(4, board2.convert2dTo1d(2, 0));
//        assertEquals(5, board2.convert2dTo1d(2, 1));
//
//        assertEquals(9, board2.convert2dTo1d(3, 2));
//        assertEquals(8, board2.convert2dTo1d(3, 1));
//
//        Board board3 = new Board(getBoard("puzzle4x4-00.txt"));
//
//        assertEquals(1, board3.convert2dTo1d(1, 0));
//        assertEquals(4, board3.convert2dTo1d(1, 3));
//
//        assertEquals(9, board3.convert2dTo1d(3, 0));
//        assertEquals(12, board3.convert2dTo1d(3, 3));
//
//        assertEquals(5, board3.convert2dTo1d(2, 0));
//        assertEquals(6, board3.convert2dTo1d(2, 1));
//        assertEquals(7, board3.convert2dTo1d(2, 2));
//        assertEquals(8, board3.convert2dTo1d(2, 3));
//
//
//        assertEquals(13, board3.convert2dTo1d(4, 0));
//        assertEquals(14, board3.convert2dTo1d(4, 1));
//        assertEquals(15, board3.convert2dTo1d(4, 2));
//        assertEquals(16, board3.convert2dTo1d(4, 3));
//    }
    @Test
    public void testNeighbours() {
        Board board = new Board(getBoard("puzzle01.txt"));
        String neighbours = "";
        for (Board n : board.neighbors()) {
            neighbours += n.toString();
        }
        String s1 = "2\n" +
                " 0  1 \n" +
                " 3  2 \n";
        String s2 = "2\n" +
                " 1  2 \n" +
                " 3  0 \n";

        assertEquals(s1 + s2, neighbours);

        Board board2 = new Board(getBoard("puzzle00.txt"));
        String expected00 = "10\n" +
                " 1  2  3  4  5  6  7  8  9 10 \n" +
                "11 12 13 14 15 16 17 18 19 20 \n" +
                "21 22 23 24 25 26 27 28 29 30 \n" +
                "31 32 33 34 35 36 37 38 39 40 \n" +
                "41 42 43 44 45 46 47 48 49 50 \n" +
                "51 52 53 54 55 56 57 58 59 60 \n" +
                "61 62 63 64 65 66 67 68 69 70 \n" +
                "71 72 73 74 75 76 77 78 79 80 \n" +
                "81 82 83 84 85 86 87 88 89 90 \n" +
                "91 92 93 94 95 96 97 98  0 99 \n" +
                "10\n" +
                " 1  2  3  4  5  6  7  8  9 10 \n" +
                "11 12 13 14 15 16 17 18 19 20 \n" +
                "21 22 23 24 25 26 27 28 29 30 \n" +
                "31 32 33 34 35 36 37 38 39 40 \n" +
                "41 42 43 44 45 46 47 48 49 50 \n" +
                "51 52 53 54 55 56 57 58 59 60 \n" +
                "61 62 63 64 65 66 67 68 69 70 \n" +
                "71 72 73 74 75 76 77 78 79 80 \n" +
                "81 82 83 84 85 86 87 88 89  0 \n" +
                "91 92 93 94 95 96 97 98 99 90 \n";

        String neighbours2 = "";
        for (Board n : board2.neighbors()) {
            neighbours2 += n.toString();
        }

        assertEquals(expected00, neighbours2);
    }
    @Test
    public void testNeighbours04() {
        Board board = new Board(getBoard("puzzle04.txt"));
        String b1 = "3\n" +
                " 1  0  3 \n" +
                " 4  2  5 \n" +
                " 7  8  6 \n";
        String b2 = "3\n" +
                " 4  1  3 \n" +
                " 0  2  5 \n" +
                " 7  8  6 \n";
        String neighboursExpected = b2 + b1;
        int counter = 0;
        String neighbours = "";
        for (Board n : board.neighbors()) {
            counter++;
            neighbours += n.toString();
        }
        assertEquals(2, counter);
        assertEquals(neighboursExpected, neighbours);
    }
    @Test
    public void testNeighbours08() {
        Board board = new Board(getBoard("puzzle08.txt"));
        String b1 = "3\n" +
                " 2  0  5 \n" +
                " 1  3  4 \n" +
                " 7  8  6 \n";
        String b2 = "3\n" +
                " 2  3  5 \n" +
                " 1  4  0 \n" +
                " 7  8  6 \n";
        String b3 = "3\n" +
                " 2  3  5 \n" +
                " 1  8  4 \n" +
                " 7  0  6 \n";
        String b4 = "3\n" +
                " 2  3  5 \n" +
                " 0  1  4 \n" +
                " 7  8  6 \n";
        String neighboursExpected = b4 + b3 + b2 + b1;
        int counter = 0;
        String neighbours = "";
        for (Board n : board.neighbors()) {
            counter++;
            neighbours += n.toString();
        }
        assertEquals(4, counter);
        assertEquals(neighboursExpected, neighbours);
    }
    @Test
    public void testTwin() {
        String twinExpected = "3\n" +
                " 1  0  2 \n" +
                " 5  7  4 \n" +
                " 8  6  3 \n";

        Board board = new Board(getBoard("puzzle11.txt"));
        assertEquals(twinExpected, board.twin().toString());
    }
    @Test
    public void testIsGoal() {
        Board board = new Board(getBoard("puzzle3x3-00.txt"));
        assertEquals(3, board.dimension());
        assertTrue(board.isGoal());
        Board board1 = new Board(getBoard("puzzle3x3-01.txt"));
        assertFalse(board1.isGoal());
        Board board4x = new Board(getBoard("puzzle4x4-00.txt"));
        assertTrue(board4x.isGoal());
        Board board4x1 = new Board(getBoard("puzzle4x4-01.txt"));
        assertFalse(board4x1.isGoal());
        Board board6 = new Board(getBoard("puzzle3x3-06.txt"));
        assertFalse(board6.isGoal());
    }

    private int[][] getBoard(String fileName) {
        return UtilCoursera.getBoard(fileName);
    }
}