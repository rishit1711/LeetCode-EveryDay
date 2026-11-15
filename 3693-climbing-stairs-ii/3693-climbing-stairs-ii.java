class Solution {
    int[] memo;
    public int climbStairs(int n, int[] costs) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return solve(0, n, costs);
    }
    public int solve(int i, int n, int[] costs) {

        if (i == n) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int ans = Integer.MAX_VALUE;

        for (int jump = 1; jump <= 3; jump++) {

            int next = i + jump;

            if (next <= n) {
                int cost = costs[next - 1] + jump * jump;

                ans = Math.min(ans, cost + solve(next, n, costs));
            }
        }
        return memo[i] = ans;
    }
}
