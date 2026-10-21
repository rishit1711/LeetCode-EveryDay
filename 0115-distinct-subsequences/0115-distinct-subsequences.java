class Solution {
    int[][] dp;
    public int solve(int i, int j, String s, String t) {

        //  i iterates on s and j itertes on t
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = solve(i + 1, j + 1, s, t);
        }

        int skip = solve(i + 1, j, s, t);

        return dp[i][j] = take + skip;
    }

    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s, t);
    }
}