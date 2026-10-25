class Solution {
    int m, n;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int r, int c) {

        // Out of bounds means this island touches the boundary
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return false;
        }

        // Water or already visited
        if (grid[r][c] == 1) {
            return true;
        }

        // Mark land as visited
        grid[r][c] = 1;

        boolean down = dfs(grid, r + 1, c);
        boolean up = dfs(grid, r - 1, c);
        boolean right = dfs(grid, r, c + 1);
        boolean left = dfs(grid, r, c - 1);

        return down && up && right && left;
    }
}
