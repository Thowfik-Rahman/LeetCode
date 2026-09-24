class Solution {

    public void solve(char[][] board) {

        if (board == null || board.length == 0 ||
            board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Process top and bottom boundaries
        for (int c = 0; c < cols; c++) {

            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }

            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        // Process left and right boundaries
        for (int r = 0; r < rows; r++) {

            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }

            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        // Surrounded O -> X
        // Safe # -> O
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {

        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length ||
            board[r][c] != 'O') {
            return;
        }

        // Mark boundary-connected O as safe
        board[r][c] = '#';

        // Up
        dfs(board, r - 1, c);

        // Down
        dfs(board, r + 1, c);

        // Left
        dfs(board, r, c - 1);

        // Right
        dfs(board, r, c + 1);
    }
}