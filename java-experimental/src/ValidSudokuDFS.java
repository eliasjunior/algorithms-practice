import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//DFS DOES NOT works here, because the ranges are fixed!!!
public class ValidSudokuDFS {
    Map<String, Boolean> visited = new HashMap();

    public boolean isValidSudoku(char[][] board) {
        boolean isSubValid = dfs(board, 0, 0, 3, 3);
        boolean isColumnValid = dfs(board, 0, 0, 1, 9);
        boolean isRowValid = dfs(board, 0, 0, 9, 1);
        return isSubValid && isColumnValid && isRowValid;
    }


    private boolean dfs(char[][] board, int rStart, int cStart, int rEnd, int cEnd) {
        visited = new HashMap();
        LinkedList<Neighbour> linkedList = new LinkedList<>();

        linkedList.push(new Neighbour(rStart, cStart));

        while(!linkedList.isEmpty()) {
            Neighbour current = linkedList.pop();

            for (int i = current.i; i < rEnd; i++) {
                for (int j = current.j; j < cEnd; j++) {
                    System.out.println("explore row[" +  i + " ]" + "col [" + j + " ]" + " => "+ board[i][j]);
                    boolean isValid = isValidCell(board, new Neighbour(i, j));
                    if(!isValid) {
                        return false;
                    }
                    linkedList.push(new Neighbour(i, j));
                }
            }
        }
        return true;
    }

    private void maskVisited(char[][] board, Neighbour neighbour) {
        int n = board[neighbour.i][neighbour.j];
        if (n >= 49 && n <= 57) {
            visited.put(String.valueOf(board[neighbour.i][neighbour.j]), true);
        }
    }

    private boolean isValidCell(char[][] board, Neighbour neighbour) {
        char ele = board[neighbour.i][neighbour.j];
        if (ele == '.') {
            return true;
        }
        // to avoid extra hashMap
        Boolean isVisited = visited.get(String.valueOf(ele));
        if (isVisited == null) {
            maskVisited(board, neighbour);
            return true;
        } else {
            return false;
        }
    }

    class Neighbour {
        public int i;
        public int j;
        public Neighbour(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        ValidSudokuDFS validSudokuDFS = new ValidSudokuDFS();
        char [] [] board = new char[][]{
                {'5', '3', '.',  '.', '7', '.',   '.','.','.'},
                {'6', '.', '.',  '1', '9', '5',   '.','.','.'},
                {'.', '9', '8',  '.', '.', '.',   '.','.','.'},
                {'8', '.', '.',  '.', '6', '.',   '.','.','3'},
                {'4', '.', '.',  '8', '.', '3',   '.','.','1'},
                {'7', '.', '.',  '.', '2', '.',   '.','.','6'},
                {'.', '6', '.',  '.', '.', '.',   '2','8','.'},
                {'.', '.', '.',  '4', '1', '9',   '.','.','5'},
                {'.', '.', '.',  '.', '8', '.',   '.','7','9'},
        };
        validSudokuDFS.isValidSudoku(board);
    }
}
