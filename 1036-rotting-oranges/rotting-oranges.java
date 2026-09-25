import java.util.*;

class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();
        int fresh = 0;

        // Find rotten oranges and count fresh oranges
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {
                    queue.offer(r * cols + c);
                }
                else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0)
            return 0;

        int minutes = 0;

        // Up, Down, Left, Right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Multi-source BFS
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int cell = queue.poll();

                int row = cell / cols;
                int col = cell % cols;

                // Check four directions
                for (int[] direction : directions) {

                    int nr = row + direction[0];
                    int nc = col + direction[1];

                    if (nr >= 0 && nr < rows &&
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {

                        // Fresh -> Rotten
                        grid[nr][nc] = 2;

                        fresh--;

                        // Add newly rotten orange
                        queue.offer(nr * cols + nc);
                    }
                }
            }

            // One BFS level = one minute
            if (!queue.isEmpty())
                minutes++;
        }

        // If fresh oranges remain, impossible
        return fresh == 0 ? minutes : -1;
    }
}