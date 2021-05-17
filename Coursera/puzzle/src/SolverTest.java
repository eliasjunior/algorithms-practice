import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    public void testSolver() {
        // solve the slider puzzle
        {
            Board initial = new Board(getBoard("puzzle01.txt"));
            Solver solver = new Solver(initial);
            assertEquals(1 , solver.moves());
        }

        {
            Board initial = new Board(getBoard("puzzle04.txt"));
            Solver solver = new Solver(initial);
            assertEquals(4 , solver.moves());

            for (Board board:
            solver.solution()) {
//                StdOut.println("--------------");
//                StdOut.println(board);

            }
        }
        {
            Board initial = new Board(getBoard("puzzle05.txt"));
            Solver solver = new Solver(initial);
            assertEquals(5 , solver.moves());
        }
        {
            Board initial = new Board(getBoard("puzzle06.txt"));
            Solver solver = new Solver(initial);
            assertEquals(6 , solver.moves());
        }
        {
            Board initial = new Board(getBoard("puzzle09.txt"));
            Solver solver = new Solver(initial);
            assertEquals( 9, solver.moves());
        }
        {
            Board initial = new Board(getBoard("puzzle09.txt"));
            Solver solver = new Solver(initial);
            assertEquals( 9, solver.moves());
        }
        {
            Board board1 = new Board(getBoard("puzzle3x3-01.txt"));
            Solver solver = new Solver(board1);
            assertEquals( 1, solver.moves());

            Board board2 = new Board(getBoard("puzzle3x3-02.txt"));
            solver = new Solver(board2);
            assertEquals( 2, solver.moves());

            Board board3 = new Board(getBoard("puzzle3x3-03.txt"));
            solver = new Solver(board3);
            assertEquals( 3, solver.moves());

            Board board4 = new Board(getBoard("puzzle3x3-04.txt"));
            solver = new Solver(board4);
            assertEquals( 4, solver.moves());

            Board board6 = new Board(getBoard("puzzle3x3-06.txt"));
            solver = new Solver(board6);
            assertEquals( 6, solver.moves());

            Board board7 = new Board(getBoard("puzzle3x3-07.txt"));
            solver = new Solver(board7);
            assertEquals( 7, solver.moves());


//            Board board4 = new Board(getBoard("puzzle3x3-02.txt"));
//
//            Board board5 = new Board(getBoard("puzzle3x3-03.txt"));
//
//            Board board6 = new Board(getBoard("puzzle3x3-04.txt"));
        }

    }

    @Test
    public void testDebug() {
        Board board8 = new Board(getBoard("test.txt"));
       // Board board8 = new Board(getBoard("puzzle20.txt"));
        Solver solver = new Solver(board8);

//        for (Board board : solver.solution()) {
//            StdOut.println("------------------ " + board.manhattan());
//            StdOut.println(board + "Neighbours");
//            for (Board bb: board.neighbors()
//            ) {
//                StdOut.println("manhattan "+bb.manhattan());
//                StdOut.println(bb);
//            }
//        }
        assertEquals( -1, solver.moves());
        assertNull( solver.solution());
        assertFalse(solver.isSolvable());
    }

    @Test
    public void test2() {
        {
            Board initial = new Board(getBoard("puzzle07.txt"));
            Solver solver = new Solver(initial);
//            for (Board board : solver.solution())
//                StdOut.println(board);
            assertEquals( 7, solver.moves());

            Board board8 = new Board(getBoard("puzzle3x3-08.txt"));
            solver = new Solver(board8);
//            for (Board board : solver.solution()) {
//                StdOut.println("------------------ " + board.manhattan());
//                StdOut.println(board + "Neighbours");
//                for (Board bb: board.neighbors()
//                ) {
//                    StdOut.println("manhattan "+bb.manhattan());
//                    StdOut.println(bb);
//                }
//            }

            assertEquals( 8, solver.moves());
        }

//        {
//            Board initial = new Board(getBoard("puzzle08.txt"));
//            Solver solver = new Solver(initial);
//            assertEquals( 8, solver.moves());
//        }
    }

    private int[][] getBoard(String fileName) {
        return UtilCoursera.getBoard(fileName);
    }


}