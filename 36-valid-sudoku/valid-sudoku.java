import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {

            HashMap<Character, Integer> rows = new HashMap<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                char ch = board[i][j];

                if (rows.containsKey(ch)) {
                    return false;
                }

                rows.put(ch, 1);
            }
        }

        for (int j = 0; j < 9; j++) {

            HashMap<Character, Integer> cols = new HashMap<>();

            for (int i = 0; i < 9; i++) {

                if (board[i][j] == '.') {
                    continue;
                }

                char ch = board[i][j];

                if (cols.containsKey(ch)) {
                    return false;
                }

                cols.put(ch, 1);
            }
        }

        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {

                HashMap<Character, Integer> box = new HashMap<>();

                for (int i = row; i < row + 3; i++) {

                    for (int j = col; j < col + 3; j++) {

                        if (board[i][j] == '.') {
                            continue;
                        }

                        char ch = board[i][j];

                        if (box.containsKey(ch)) {
                            return false;
                        }

                        box.put(ch, 1);
                    }
                }
            }
        }

        return true;
    }
}