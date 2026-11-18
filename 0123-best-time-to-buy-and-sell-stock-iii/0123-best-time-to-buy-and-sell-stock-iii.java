class Solution {
    public int solve(int idx,int[] prices,int canbuy,int count, Integer[][][] dp){

        if(idx>=prices.length||count==2) return 0;
        if(dp[idx][canbuy][count]!=null) return dp[idx][canbuy][count];
        // buy ya not buy
        if(canbuy==1){
            int buy=-prices[idx]+solve(idx+1,prices,0,count,dp);
            int not_buy=solve(idx+1,prices,1,count,dp);

            return dp[idx][canbuy][count]= Math.max(buy,not_buy);
        }
        else {
            int sell = prices[idx] +
                solve(idx + 1, prices, 1, count + 1,dp);

            int not_sell =
                solve(idx + 1, prices, 0, count,dp);
            return dp[idx][canbuy][count]=Math.max(sell, not_sell);
    }
            
        
    }
    public int maxProfit(int[] prices) {
        int n =prices.length;
        Integer[][][] dp=new Integer[n][2][2];
        return solve(0,prices,1,0,dp);
    }
}