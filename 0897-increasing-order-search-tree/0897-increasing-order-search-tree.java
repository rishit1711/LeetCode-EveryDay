class Solution {
    public void inorder(TreeNode root, List<TreeNode> ans) {
        if (root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root);
        inorder(root.right, ans);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        inorder(root, ans);

        if (ans.isEmpty()) {
            return null;
        }
        TreeNode root1 = ans.get(0);
        for (int i = 0; i < ans.size(); i++) {
            TreeNode a = ans.get(i);
            a.left = null;

            if (i < ans.size() - 1) {
                a.right = ans.get(i + 1);
            } else {
                a.right = null;
            }
        }

        return root1;
    }
}