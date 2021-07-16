public class NumberOfIsland {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        String sindent = print(row);
        //base case
        if ( row < 0 || col < 0 || row > grid.length - 1 || col > grid.length - 1 || grid[row][col] != '1') {
            return;
        }
        System.out.println(sindent + " DFS grid["+row+"]["+col+"] ==> "+grid[row][col] );
        // choose

        grid[row][col] = '.';

        dfs(grid, row + 1, col );
        dfs(grid, row - 1, col );
        dfs(grid, row, col + 1 );
        dfs(grid, row, col - 1 );
    }


    public static void main(String[] args) {
        System.out.println(new NumberOfIsland().numIslands(new char[][]{{'0', '0', '1'}, {'0', '1', '0'}, {'0', '0', '0'}}));
    }

    private String print(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += "----";
        }
        return s;
    }
}