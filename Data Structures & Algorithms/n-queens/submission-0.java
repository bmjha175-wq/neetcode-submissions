class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, result, n);

        return result;
    }

    private void solve(int currentQueen, char[][] board, List<List<String>> result, int n) {
        // Base case: all rows have a queen
        if (currentQueen == n) {
            result.add(construct(board));
            return;
        }

        // Try every column in the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(currentQueen, col, board, n)) {
                // Choose: place queen
                board[currentQueen][col] = 'Q';

                // Explore: move to the next row
                solve(currentQueen + 1, board, result, n);

                // Backtrack: remove queen
                board[currentQueen][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // Check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    // Convert char[][] board into List<String>
    private List<String> construct(char[][] board) {
        List<String> arrangement = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            arrangement.add(new String(board[i]));
        }

        return arrangement;
    }
}
