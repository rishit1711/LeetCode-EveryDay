class Solution {
    public int solve(int i, int[] arr, int k,Integer[] dp) {
        int n = arr.length;
        if (i >= n) return 0;
        if(dp[i]!=null) return dp[i];
        int maxele = -1;
        int result = 0;

        for (int j = i; j < n && j - i + 1 <= k; j++) {
            maxele = Math.max(maxele, arr[j]);

            result = Math.max(
                result,
                maxele * (j - i + 1) + solve(j + 1, arr, k,dp)
            );
        }

        return dp[i]=result;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] dp=new Integer[arr.length];
        return solve(0, arr, k,dp);
    }
}