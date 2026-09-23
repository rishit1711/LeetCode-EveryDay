class Solution {
    int moves = 0;

    public int solve(TreeNode root) {
        if (root == null) return 0;

        int left = solve(root.left);
        int right = solve(root.right);

        moves += Math.abs(left)+Math.abs(right);

        return root.val + left + right - 1;
    }

    public int distributeCoins(TreeNode root) {
        int x = solve(root);
        return moves;
    }
}