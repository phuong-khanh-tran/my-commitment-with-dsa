package Graph;

public class MaxAreaOfIsland {
    int rows;
    int cols;
    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }

        return res;
    }

    private int dfs(int row, int col, int[][] grid) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) {
            return 0;
        }

        int res = 1;
        grid[row][col] = 0;

        res += dfs(row + 1, col, grid);
        res += dfs(row - 1, col, grid);
        res += dfs(row, col + 1, grid);
        res += dfs(row, col - 1, grid);

        return res;
    }
}
