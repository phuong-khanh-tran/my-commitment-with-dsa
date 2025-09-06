import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class valid_sudoku_solution {
    public boolean isValidSudoku(char[][] board) {

        int SIZE = 9;
        Map<Integer, HashSet<Character>> rows = new HashMap<>();
        Map<Integer, HashSet<Character>> cols = new HashMap<>();
        Map<Integer, HashSet<Character>> squares = new HashMap<>();

        // Rows
        for (int i = 0; i < SIZE; i++) {
            if (!rows.containsKey(i)) {
                rows.put(i, new HashSet<>());
            }

            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.')
                    continue;
                if (rows.get(i).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
            }
        }

        // Cols
        for (int i = 0; i < SIZE; i++) {
            if (!cols.containsKey(i)) {
                cols.put(i, new HashSet<>());
            }

            for (int j = 0; j < SIZE; j++) {
                if (board[j][i] == '.')
                    continue;
                if (cols.get(i).contains(board[j][i])) {
                    return false;
                }
                cols.get(i).add(board[j][i]);
            }
        }

        // Squares
        for (int k = 0; k < SIZE; k++) {
            squares.put(k, new HashSet<>());
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int index = (i / 3) * 3 + (j / 3);

                if (board[i][j] == '.')
                    continue;
                if (squares.get(index).contains(board[i][j])) {
                    return false;
                }
                squares.get(index).add(board[i][j]);
            }
        }

        return true;
    }
}
