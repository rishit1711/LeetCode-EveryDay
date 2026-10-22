class Solution {
    static final int MOD = 1_000_000_007;
    public int solve(int idx,int absent,int late,int n,Integer[][][] dp){

        // base cases   
        if(absent>=2||late>=3){
            return 0;
        }
        if(idx==n) return 1;
        if(dp[idx][absent][late]!=null) return dp[idx][absent][late];

        long count=0;
        // present
        count+=solve(idx+1,absent,0,n,dp);
        // absent
        count+=solve(idx+1,absent+1,0,n,dp);
        // late - >>> matlab consecutive lates hai
        count+=solve(idx+1,absent,late+1,n,dp);

        return dp[idx][absent][late]= (int)(count%MOD);

    }

    public int checkRecord(int n) {
        Integer[][][] dp=new Integer[n][2][3];

        return solve(0,0,0,n,dp);
    }
}