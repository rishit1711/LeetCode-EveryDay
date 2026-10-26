class Solution {
    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public long bfs(int i, int j, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        visited[i][j] = true;
        long count = 0;

        while (q.size() > 0) {
            Pair p = q.poll();

            int row = p.x;
            int col = p.y;

            count += grid[row][col];

            // top
            if (row > 0) {
                if (grid[row - 1][col] > 0 && !visited[row - 1][col]) {
                    q.add(new Pair(row - 1, col));
                    visited[row - 1][col] = true;
                }
            }

            // bottom
            if ((row + 1) < m) {
                if (grid[row + 1][col] > 0 && !visited[row + 1][col]) {
                    q.add(new Pair(row + 1, col));
                    visited[row + 1][col] = true;
                }
            }

            // left
            if (col > 0) {
                if (grid[row][col - 1] > 0 && !visited[row][col - 1]) {
                    q.add(new Pair(row, col - 1));
                    visited[row][col - 1] = true;
                }
            }

            // right
            if ((col + 1) < n) {
                if (grid[row][col + 1] > 0 && !visited[row][col + 1]) {
                    q.add(new Pair(row, col + 1));
                    visited[row][col + 1] = true;
                }
            }
        }

        return count;
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] > 0 && !visited[i][j]) {

                    long sum = bfs(i, j, grid, visited);

                    if (sum % k == 0) {
                        ans++;
                    }
                }
            }
        }

        return (int)ans;
    }
}