import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    public String[][] matrix;
    public WeightedQuickUnionUF wqu;
    private final String BLOCKED = "blocked";
    private final String OPEN = "open";
    private final int TOP_ROW = 1;
    private final int VIRTUAL_TOP = 0;
    private final int VIRTUAL_BOTTOM;
    private int n;
    private int numberOpenSites;


    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        matrix = new String[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = BLOCKED;
            }
        }
        wqu = new WeightedQuickUnionUF(n * n + 2);

        VIRTUAL_BOTTOM = n * n + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        verifyValidCorner(row, col);
        if (!OPEN.equals(matrix[row][col])) {
            numberOpenSites++;
        }
        matrix[row][col] = OPEN;

        int currentPos = wqu.find(link2DTo1D(row, col));

        if (row == TOP_ROW) {
            wqu.union(VIRTUAL_TOP, currentPos);
        } else if (row == n) {
//            StdOut.println("root = " + wqu.find(VIRTUAL_BOTTOM));
//            StdOut.println("root currentPos = " + wqu.find(currentPos));
            wqu.union(VIRTUAL_BOTTOM, currentPos);
        }

        // check neighbours
        //variant col right
        int neighborColRight = col + 1;
        if (isSiteValid(row, neighborColRight) && matrix[row][neighborColRight] == OPEN) {
            int negIn1D = link2DTo1D(row, neighborColRight);
            // connect
            wqu.union(currentPos, negIn1D);
        }
        //variant col left
        int neighborColLeft = col - 1;
        if (isSiteValid(row, neighborColLeft) && matrix[row][neighborColLeft] == OPEN) {
            int negIn1D = link2DTo1D(row, neighborColLeft);
            // connect
            wqu.union(negIn1D, currentPos);
        }
        //variant row up
        int neighborRowUp = row - 1;
        if (isSiteValid(neighborRowUp, col) && matrix[neighborRowUp][col] == OPEN) {
            int negIn1D = link2DTo1D(neighborRowUp, col);
            // connect
            wqu.union(negIn1D, currentPos);
        }
        //variant row down
        int neighborRowDown = row + 1;
        if (isSiteValid(neighborRowDown, col) && matrix[neighborRowDown][col] == OPEN) {
            int negIn1D = link2DTo1D(neighborRowDown, col);
            // connect
            wqu.union(currentPos, negIn1D);
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        verifyValidCorner(row, col);
        return OPEN.equals(matrix[row][col]);
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        verifyValidCorner(row, col);
        boolean isFull = false;
        int rootCurrent = wqu.find(link2DTo1D(row, col));

        if (!isOpen(row, col)) {
            return false;
        }

        // and its in the top or is connected to the top via neighbours
        if (row == TOP_ROW) {
            isFull = true;
        } else {
            int top = wqu.find(0);
            if (rootCurrent == top) {
                isFull = true;
            }
        }
        return isFull;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        if (n == 1 && numberOfOpenSites() == 1) {
            return true;
        }
        return wqu.find(VIRTUAL_TOP) == wqu.find(VIRTUAL_BOTTOM);
    }

    // test client (optional)
    public static void main(String[] args) {
       // StdOut.println("Enter the N:");
        WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(10);

        wqu.union(0, 1);
    }

    private void verifyValidCorner(int row, int col) {
        if (row < 1 || col < 1 || row > matrix.length || col > matrix.length) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isSiteValid(int row, int col) {
        if (row < 1 || col < 1 || row > matrix.length - 1 || col > matrix.length - 1) {
            return false;
        }
        return true;
    }

    private int link2DTo1D(int row, int col) {
        return (n * row) - (n - (col - 1));
    }
}
