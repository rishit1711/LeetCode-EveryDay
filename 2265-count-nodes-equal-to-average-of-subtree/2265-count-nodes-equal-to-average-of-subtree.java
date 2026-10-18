class Solution {
    public int sum(TreeNode root){
        if(root==null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }

    public int count(TreeNode root){
        if(root==null) return 0;
        return 1+ count(root.left)+count(root.right);

    }
    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        int sumNodes = sum(root);
        int countNodes = count(root);
        if (sumNodes / countNodes == root.val) {
            ans++;
        }
        ans += averageOfSubtree(root.left);
        ans += averageOfSubtree(root.right);

        return ans;
       
    }
}