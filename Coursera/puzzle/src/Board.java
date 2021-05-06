import edu.princeton.cs.algs4.Stack;

public final class Board {
    private int[][] tilesCopy;
    private int n;
    private int drManhattan = -1;
    private int thor = -1;


    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(final int[][] tiles) {
        if (tiles.length < 2 && tiles.length < 128 && tiles != null) {
            throw new IllegalArgumentException();
        }
        this.tilesCopy = new int[tiles.length + 1][tiles.length];
        for (int i = 1; i <= tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tilesCopy[i][j] = tiles[i - 1][j];
            }
        }
        this.n = tiles.length;
        this.drManhattan = manhattan();
    }

    // string representation of this board
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n + "\n");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                s.append(String.format("%2d ", tilesCopy[i][j]));
            }
            s.append("\n");
        }
        return s.toString();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        if(thor == -1) {
            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < n; j++) {
                    int value = tilesCopy[i][j];
                    int converted = convert2dTo1d(i, j);
                    if (value != 0 && converted != value) {
                        count++;
                    }
                }
            }
            thor = count;
        }
        return thor;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        if(drManhattan == -1) {
            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 0; j < n; j++) {
                    int value = tilesCopy[i][j];
                    int oneDimensionValue = convert2dTo1d(i, j);
                    if (value != 0 && oneDimensionValue != value) {
                        int[] cord = convert1dTo2d(value);
                        int row = cord[0];
                        int col = cord[1];
                        int rowRemainder = Math.abs(row - i);
                        int colRemainder = Math.abs(col - j);
                        count += rowRemainder + colRemainder;
                    }
                }
            }
            drManhattan = count;
        }
        return drManhattan;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return manhattan() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board other = (Board) y;
        int[][] otherTiles = other.tilesCopy;
        if (other.n != this.n) {
            return false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                int value = tilesCopy[i][j];
                int otherValue = otherTiles[i][j];

                if (value != otherValue) {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Stack<Board> stack = new Stack<>();
        int [][] original = copyOriginal();
        boolean isStop = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = original[i][j];
                if (value == 0) {
                    isStop = true;
                    // check isNeighbours i, j,
                    // yes,
                    // swap
                    // add the neighbour to the stack
                    // next neigh
                    if (isThereNeighbours(i - 1, j)) {
                        int num = original[i - 1][j];
                        original[i - 1][j] = 0;
                        original[i][j] = num;
                        Board neighbour = new Board(original);
                        stack.push(neighbour);
                        original[i - 1][j] = num;
                        original[i][j] = 0;
                    }
                    if (isThereNeighbours(i, j + 1)) {
                        int num = original[i][j + 1];
                        original[i][j] = num;
                        original[i][j + 1] = 0;
                        Board neighbour = new Board(original);
                        stack.push(neighbour);
                        original[i][j + 1] = num;
                        original[i][j] = 0;
                    }
                    if (isThereNeighbours(i + 1, j)) {
                        int num = original[i + 1][j];
                        original[i][j] = num;
                        original[i + 1][j] = 0;
                        Board neighbour = new Board(original);
                        stack.push(neighbour);
                        original[i][j] = 0;
                        original[i + 1][j] = num;
                    }
                    if (isThereNeighbours(i, j - 1)) {
                        int num = original[i][j - 1];
                        original[i][j] = num;
                        original[i][j - 1] = 0;
                        Board neighbour = new Board(original);
                        stack.push(neighbour);
                        original[i][j - 1] = num;
                        original[i][j] = 0;
                    }
                    break;
                }
            }
            if (isStop) {
                break;
            }
        }
        return stack;
    }

    private boolean isThereNeighbours(int i, int j) {
        return !( i < 0 || i > n - 1 || j < 0 || j > n - 1);
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int [][] original = copyOriginal();

        int i = 0;
        boolean found = false;
        Board board = null;
        while ( i < n && !found) {
            int j = 0;
            while ( j < n && !found) {
                int value = original[i][j];
                if (value != 0 && isThereNeighbours(i, j + 1)) {
                    int nextValue = original[i][j + 1];
                    if (nextValue != 0) {
                        original[i][j] = nextValue;
                        original[i][j + 1] = value;
                        board = new Board(original);
                        found = true;
                    }
                }
                j++;
            }
            i++;
        }
        return board;
    }

    private int convert2dTo1d(int i, int j) {
        // n is the leaps, math sequence and series
        return 1 + n * (i - 1) + j;
    }

    private int[] convert1dTo2d(int num) {
        int mod = num % n;
        // + 1 because row starts from 1
        int i = mod == 0 ? (num / n) : (num / n) + 1;
        // mod - 1 because col starts from 0
        int j = mod == 0 ? (n - 1) : mod - 1;
        // System.out.println(("when i=" +i +", row="+(((double) i / (double)n))) +" rounded="+(i/n) + " --- " +  i + "/"+n+", "+ "col is " + ((i % n)));
        return new int[]{i, j};
    }

    private int [][] copyOriginal() {
        int[][] original = new int[n][n];
        for (int row = 1; row < n + 1; row++) {
            for (int col = 0; col < n; col++) {
                original[row - 1][col] = tilesCopy[row][col];
            }
        }
        return original;
    }
}