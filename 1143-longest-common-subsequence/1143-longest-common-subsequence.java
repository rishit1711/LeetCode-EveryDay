class Solution {
    public int helper(int idx1,int idx2,String text1,String text2,Integer[][] dp){
        if(idx1<0||idx2<0) return 0;
        if(dp[idx1][idx2]!=null) return dp[idx1][idx2];
        if(text1.charAt(idx1)==(text2.charAt(idx2))){
            return 1+helper(idx1-1,idx2-1,text1,text2,dp);
        }

        return dp[idx1][idx2]=Math.max(helper(idx1-1,idx2,text1,text2,dp),helper(idx1,idx2-1,text1,text2,dp));

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m =text1.length();
        int n=text2.length();
        Integer[][] dp=new Integer[m][n];
        return helper(m-1,n-1,text1,text2,dp);
    }
}