public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int x = 0; x < 9; x++) {
            if (board[x][col] == num || board[row][x] == num) {
                return false;
            }
            int r = 3 * (row / 3) + x / 3;
            int c = 3 * (col / 3) + x % 3;
            if (board[r][c] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
