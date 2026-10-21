class Solution {
    
    public int solve(TreeNode root,int flag){
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            if (flag == 0) {
                return root.val;
            } else {
                return 0;
            }
        }
        
        int sum=0;
        sum+=solve(root.left,0);
        sum+=solve(root.right,1);

        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left==null&&root.right==null) return 0;
        return solve(root,-1);
        

    }
}