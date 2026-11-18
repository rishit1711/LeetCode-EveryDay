class Solution {
    public int solve(int idx,int canBuy,int[]prices,int k, Integer[][][] dp){
        
        if(idx==prices.length||k==0) return 0;
     

        if(dp[idx][canBuy][k]!=null) return dp[idx][canBuy][k];
        if(canBuy==1){
            int buy = -prices[idx] + solve(idx+1,0,prices,k,dp);
            int notbuy = solve(idx+1,1,prices,k,dp);

            dp[idx][canBuy][k]=Math.max(buy,notbuy);
        }
        else {

            int sell = prices[idx] + solve(idx+1,1,prices,k-1,dp);
            int notsell = solve(idx+1,0,prices, k,dp);
            dp[idx][canBuy][k]=Math.max(sell,notsell);
        }
        return dp[idx][canBuy][k];

        
    }
    public int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length][2][k+1];
        return solve(0,1,prices,k,dp);
        
    }
}