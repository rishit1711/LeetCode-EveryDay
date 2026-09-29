class Solution {
    public boolean helper(char[][] grid,int row,int col,int balance,Boolean[][][] dp){
        int m = grid.length;
        int n= grid[0].length;
        if(row>=m||col>=n) return false;
         if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }
        if(balance<0) return false;
        if(row==m-1&&col==n-1&&balance==0) return true;
        if(dp[row][col][balance]!=null) return dp[row][col][balance];
    
        boolean down = helper(grid,row+1,col,balance,dp);
        boolean right=helper(grid,row,col+1,balance,dp);


        return dp[row][col][balance]= right||down;
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        Boolean[][][] dp = new Boolean[m][n][m+n];
        return helper(grid,0,0,0,dp);
        
    }
}