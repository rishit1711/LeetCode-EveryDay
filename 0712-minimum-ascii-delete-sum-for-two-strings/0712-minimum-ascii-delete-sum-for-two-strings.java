class Solution {

    public int solve(int i, int j, String s1, String s2, Integer[][] dp) {

        // dono strings khatam
        if (i == s1.length() && j == s2.length()) {
            return 0;
        }

        
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // s1 khatam -> s2 ke saare characters delete
        if (i == s1.length()) {
            return dp[i][j] =
                    s2.charAt(j) + solve(i, j + 1, s1, s2, dp);
        }

        // s2 khatam -> s1 ke saare characters delete
        if (j == s2.length()) {
            return dp[i][j] =
                    s1.charAt(i) + solve(i + 1, j, s1, s2, dp);
        }

        // characters same -> kuch delete nahi karna
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] =
                    solve(i + 1, j + 1, s1, s2, dp);
        }

        // s1 ka character delete karo
        int delete1 = s1.charAt(i)
                + solve(i + 1, j, s1, s2, dp);

        // s2 ka character delete karo
        int delete2 = s2.charAt(j)
                + solve(i, j + 1, s1, s2, dp);

        return dp[i][j] = Math.min(delete1, delete2);
    }

    public int minimumDeleteSum(String s1, String s2) {

        Integer[][] dp = new Integer[s1.length() + 1][s2.length() + 1];

        return solve(0, 0, s1, s2, dp);
    }
}