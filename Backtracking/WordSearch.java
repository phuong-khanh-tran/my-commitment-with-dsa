package Backtracking;

public class WordSearch {
    char[][] board;
    String word;
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.board = board;
        this.word = word;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != word.charAt(i)
                || board[row][col] == '#') {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean res = dfs(row + 1, col, i + 1) ||
                dfs(row, col + 1, i + 1) ||
                dfs(row - 1, col, i + 1) ||
                dfs(row, col - 1, i + 1);

        board[row][col] = temp;
        return res;

    }
}
