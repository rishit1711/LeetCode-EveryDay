class Solution {
    public int solve(int idx,int[] prices,int canbuy,Integer[][] dp){

        if(idx>=prices.length) return 0;
        if(dp[idx][canbuy]!=null) return dp[idx][canbuy];
        if(canbuy==1){
            int buy=-prices[idx]+solve(idx+1,prices,0,dp);
            int not_buy=solve(idx+1,prices,1,dp);


            return dp[idx][canbuy]=Math.max(buy,not_buy);
        }
        else{
            int sell=prices[idx]+solve(idx+1,prices,1,dp);
            int not_sell=solve(idx+1,prices,0,dp);

            return dp[idx][canbuy]= Math.max(sell,not_sell);
        }


    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp=new Integer[n][2];
        return solve(0,prices,1,dp);
    }
}