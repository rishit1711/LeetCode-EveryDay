class Solution {
    public class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs(int[][] image, int sr, int sc, int color, boolean[][] visited) {

        Queue<Pair> q = new LinkedList<>();

        int m = image.length;
        int n = image[0].length;

        int oldColor = image[sr][sc];

        visited[sr][sc] = true;
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!q.isEmpty()) {

            Pair p = q.poll();

            int row = p.x;
            int col = p.y;

            // Up
            if (row > 0) {
                if (image[row - 1][col] == oldColor && !visited[row - 1][col]) {
                    visited[row - 1][col] = true;
                    image[row - 1][col] = color;
                    q.add(new Pair(row - 1, col));
                }
            }

            // Down
            if (row + 1 < m) {
                if (image[row + 1][col] == oldColor && !visited[row + 1][col]) {
                    visited[row + 1][col] = true;
                    image[row + 1][col] = color;
                    q.add(new Pair(row + 1, col));
                }
            }

            // Left
            if (col > 0) {
                if (image[row][col - 1] == oldColor && !visited[row][col - 1]) {
                    visited[row][col - 1] = true;
                    image[row][col - 1] = color;
                    q.add(new Pair(row, col - 1));
                }
            }

            // Right
            if (col + 1 < n) {
                if (image[row][col + 1] == oldColor && !visited[row][col + 1]) {
                    visited[row][col + 1] = true;
                    image[row][col + 1] = color;
                    q.add(new Pair(row, col + 1));
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color)
            return image;

        int m = image.length;
        int n = image[0].length;

        boolean[][] visited = new boolean[m][n];

        bfs(image, sr, sc, color, visited);

        return image;
    }
}