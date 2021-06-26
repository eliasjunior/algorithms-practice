import java.util.HashMap;
import java.util.Map;

/**
 *
 */
class ValidSudoku {
    Map<String, Boolean> visited = new HashMap();

    public boolean isValidSudoku(char[][] board) {
        boolean isSubValid = subBox(board, 0, 0, 3, 3);
        boolean isColumnValid = subBox(board, 0, 0, 1, 9);
        boolean isRowValid = subBox(board, 0, 0, 9, 1);
        return isSubValid && isColumnValid && isRowValid;
    }

    private boolean subBox(char[][] board, int row, int col, int rowEnd, int colEnd) {
        visited = new HashMap();
        if (row >= board.length) {
            return true;
        }
        // base when row == 9
        for (int i = row; i < row + rowEnd; i++) {
            int j = col;
            while (j < col + colEnd) {
                boolean result = isValidCell(board, i, j);
                if (!result) {
                    return false;
                }
                j++;
            }
        }

        // go next sub square here[. 7 .]
        col += colEnd;
        if (col >= board.length) {
            // second sub square [8 . . ]
            row += rowEnd;
            col = 0;
        }
        return subBox(board, row, col, rowEnd, colEnd);
    }

    private boolean isValidCell(char[][] board, int row, int col) {
        char ele = board[row][col];
        if (ele == '.') {
            return true;
        }
        // to avoid extra hashMap
        Boolean isVisited = visited.get(String.valueOf(ele));
        if (isVisited == null) {
            visited.put(String.valueOf(ele), true);
        } else if (isVisited) {
            //already visited
            return false;
        }

        int n = ele;

        if (n >= 49 && n <= 57) {
            visited.put(String.valueOf(ele), true);
            return true;
        }
        return false;
    }
}
/*
[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 */

