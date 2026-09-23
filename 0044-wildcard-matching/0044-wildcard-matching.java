class Solution {
    public boolean helper(int idx1, int idx2, String s, String p, Boolean[][] dp) {

        if (idx1 < 0 && idx2 < 0) return true;

        if (idx1 >= 0 && idx2 < 0) return false;

        if (idx1 < 0 && idx2 >= 0) {
            for (int k = 0; k <= idx2; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[idx1][idx2] != null) return dp[idx1][idx2];

        if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?') {
            return dp[idx1][idx2] =
                    helper(idx1 - 1, idx2 - 1, s, p, dp);
        }

        else if (p.charAt(idx2) == '*') {

            boolean case1 = helper(idx1 - 1, idx2, s, p, dp);

            boolean case2 = helper(idx1, idx2 - 1, s, p, dp);

            return dp[idx1][idx2] = case1 || case2;
        }

        else {
            return dp[idx1][idx2] = false;
        }
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        Boolean[][] dp = new Boolean[m][n];

        return helper(m - 1, n - 1, s, p, dp);
    }
}