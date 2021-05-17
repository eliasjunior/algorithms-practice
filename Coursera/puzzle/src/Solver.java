import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

import java.util.Comparator;

public class Solver {
    private int finalMoves;
    private Stack<Board> queue = new Stack<>();
    private boolean isSolvable = true;

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }
        helper(initial);
    }

    private void helper(Board initial) {
        MinPQ<SearchNode> pq = new MinPQ<>(new ByManhattanMoves());
        pq.insert(new SearchNode(initial, null, 0));
        //TWIN
        MinPQ<SearchNode> pqTwin = new MinPQ<>(new ByManhattanMoves());
        pqTwin.insert(new SearchNode(initial.twin(), null, 0));

        while (!pq.isEmpty() && isSolvable) {
            SearchNode current = pq.delMin();
            SearchNode parallel = pqTwin.delMin();

            if (current.board.isGoal()) {
                finalMoves = current.moves;
                backTracking(current);
                break;
            }

            if (parallel.board.isGoal()) {
                isSolvable = false;
                finalMoves = -1;
                queue = null;
            }
            neighbours(current, pq);
            neighbours(parallel, pqTwin);
        }
    }

    private void backTracking(SearchNode current) {
        while (current.previous != null) {
            queue.push(current.board);
            current = current.previous;
        }
        queue.push(current.board);
    }

    private void neighbours(SearchNode searchNode, MinPQ<SearchNode> pq) {
        searchNode.moves = searchNode.moves + 1;
        for (Board neighbour : searchNode.board.neighbors()) {
            if (searchNode.previous == null || !neighbour.equals(searchNode.previous.board)) {
                SearchNode newSN = new SearchNode(neighbour, searchNode, searchNode.moves);
                pq.insert(newSN);
            }
        }
    }

    public boolean isSolvable() {
        return isSolvable;
    }

    public int moves() {
        return finalMoves;
    }

    public Iterable<Board> solution() {
        return queue;
    }

    private class ByManhattanMoves implements Comparator<SearchNode> {

        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            int movesO1 = o1.priority + o1.moves;
            int movesO2 = o2.priority + o2.moves;
            if (movesO1 == movesO2) {
                int thor1 = o1.board.hamming();
                int thor2 = o2.board.hamming();
                return Integer.compare(thor1, thor2);
            } else if (movesO1 < movesO2) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private class SearchNode {
        private int moves;
        private Board board;
        private SearchNode previous;
        private int priority;

        public SearchNode(Board board, SearchNode previous, int moves) {
            this.board = board;
            this.previous = previous;
            this.moves = moves;
            this.priority = board.manhattan();
        }
    }
}
