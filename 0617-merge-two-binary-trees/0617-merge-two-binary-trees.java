class Solution {
    public TreeNode dfs(TreeNode root, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 != null && root2 != null) {
            root = new TreeNode(root1.val + root2.val);

            root.left = dfs(null, root1.left, root2.left);
            root.right = dfs(null, root1.right, root2.right);
        }
        else if (root1 == null && root2 != null) {
            root = new TreeNode(root2.val);

            root.left = dfs(null, null, root2.left);
            root.right = dfs(null, null, root2.right);
        }
        else {
            root = new TreeNode(root1.val);

            root.left = dfs(null, root1.left, null);
            root.right = dfs(null, root1.right, null);
        }

        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode();
        return dfs(root, root1, root2);
    }
}