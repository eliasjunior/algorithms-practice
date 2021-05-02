import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

import java.util.Comparator;

public class Solver {
    private int moves;
    private Queue<Board> queue = new Queue<>();
    private boolean isSolvable = true;
    MinPQ<Board> pqTwin = new MinPQ<>(new ByManhattanMoves());

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        moves = helper(initial);
    }

    private int helper(Board initial) {
        MinPQ<Board> pq = new MinPQ<>(new ByManhattanMoves());
        pq.insert(initial);
        int moves = 0;
        Board previous = null;

        //TWIN
        pqTwin.insert(initial.twin());
        Board prevTwin = null;

        while (!pq.isEmpty() && isSolvable) {
            Board current = pq.delMin();
            queue.enqueue(current);
            if (current.isGoal()) {
                break;
            }
            moves++;
            System.out.println("moves " + moves);
            for (Board b : current.neighbors()) {
                if (!b.equals(previous)) {
                    pq.insert(b);
                }
            }
            previous = current;

            //TODO maybe here
            prevTwin = simulate(prevTwin);
            if(prevTwin == null) {
                // base case found
                isSolvable = false;
            }
        }
        return moves;
    }

    private Board simulate(Board previous) {
        Board current = pqTwin.delMin();
        if (current.isGoal()) {
            return null;
        }
        for (Board b : current.neighbors()) {
            if (!b.equals(previous)) {
                pqTwin.insert(b);
            }
        }
        return current;
    }

    public boolean isSolvable() {
        return isSolvable;
    }

    public int moves() {
        return moves;
    }

    public Iterable<Board> solution() {
        return queue;
    }

    private class ByManhattanMoves implements Comparator<Board> {
        @Override
        public int compare(Board o1, Board o2) {
            if (o1.manhattan() == o2.manhattan()) {
                if(o1.hamming() < o1.hamming()) {
                    return -1;
                } else if(o1.hamming() > o1.hamming()) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (o1.manhattan() < o2.manhattan()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    private class SearchNode {
        private int moves = 0;
        private Board initialBoard;
        private Board previous;
    }
}
