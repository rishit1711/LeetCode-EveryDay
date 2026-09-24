class Solution {
    public boolean helper(int idx1, int idx2, String s, String p, Boolean[][] dp) {

        if (idx1 < 0 && idx2 < 0) return true;  // dono string consumed
        if (idx1 >= 0 && idx2 < 0) return false;  // string2 consumed but string1 consumed nhi hua to koi chance nhi hai match ka
        // because benefits to string2 me the isliye wo khatam to bat khatam
        if (idx1 < 0 && idx2 >= 0) {  // string 1 khatam but string 2 hai to
        // agar mujhe match chahiye to baki sab char string2 me ya * ya ? hone chahiye
            for (int k = 0; k <= idx2; k++) {
                if (p.charAt(k) != '*' || p.charAt(k)=='?') {
                    return false;
                }
            }
            return true;
        }

        if (dp[idx1][idx2] != null) return dp[idx1][idx2];
        // dono match ya string2 is '?' so indirectly match
        if (s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?') {
            return dp[idx1][idx2] =
                    helper(idx1 - 1, idx2 - 1, s, p, dp);
        }
        // if * hai to 2 cases ekbar replace with empty string(i,j-1)
        // or replace it with actual ith char so (i-1,j)
        
        else if (p.charAt(idx2) == '*') {

            boolean case1 = helper(idx1 - 1, idx2, s, p, dp);

            boolean case2 = helper(idx1, idx2 - 1, s, p, dp);

            return dp[idx1][idx2] = case1 || case2;
        }

        else { // no match
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