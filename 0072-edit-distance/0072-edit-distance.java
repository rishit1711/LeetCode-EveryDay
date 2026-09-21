class Solution {
    public int helper(int idx1,int idx2,String word1,String word2,Integer[][] dp){

        // 4 options hai
        // delete
        // replace
        // insert
        // same character mila to jane do
        if(idx1 < 0)return idx2 + 1;

        if(idx2 < 0)return idx1 + 1;

        if(dp[idx1][idx2]!=null) return dp[idx1][idx2];

        if(word1.charAt(idx1)==word2.charAt(idx2)) return dp[idx1][idx2]= 0+helper(idx1-1,idx2-1,word1,word2,dp);
        int delete=Integer.MAX_VALUE;
        int insert=Integer.MAX_VALUE;
        int replace=Integer.MAX_VALUE;


        if(word1.charAt(idx1)!=word2.charAt(idx2)){

            // 3 possibilties..
             delete=1+helper(idx1-1,idx2,word1,word2,dp);
             insert=1+helper(idx1,idx2-1,word1,word2,dp);
             replace=1+helper(idx1-1,idx2-1,word1,word2,dp);

        }

        return dp[idx1][idx2]= Math.min(delete,Math.min(replace,insert));



    }
    public int minDistance(String word1, String word2) {
        int m =word1.length();
        int n=word2.length();
        Integer[][] dp=new Integer[m][n];
        return helper(m-1,n-1,word1,word2,dp);
    }
}