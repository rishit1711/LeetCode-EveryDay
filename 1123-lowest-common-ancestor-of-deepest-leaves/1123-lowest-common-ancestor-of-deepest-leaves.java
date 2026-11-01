class Solution {
    int maxDepth = 0;

    public void depth(TreeNode root, int d,
                      HashMap<TreeNode, Integer> map) {

        if (root == null) return;

        maxDepth = Math.max(maxDepth, d);

        map.put(root, d);

        depth(root.left, d + 1, map);
        depth(root.right, d + 1, map);
    }

    public boolean exist(TreeNode root, TreeNode node) {

        if (root == null) return false;

        if (root == node) return true;

        boolean left = exist(root.left, node);
        boolean right = exist(root.right, node);

        return left || right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (root == p || root == q) {
            return root;
        }

        boolean pinLst = exist(root.left, p);
        boolean qinlst = exist(root.left, q);

        if (pinLst != qinlst) {
            return root;
        }

        if (pinLst && qinlst) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return lowestCommonAncestor(root.right, p, q);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        depth(root, 0, map);
        ArrayList<TreeNode> deepest = new ArrayList<>();

        for (TreeNode node : map.keySet()) {
            if (map.get(node) == maxDepth) {
                deepest.add(node);
            }
        }

        TreeNode ans = deepest.get(0);

        for (int i = 1; i < deepest.size(); i++) {
            ans = lowestCommonAncestor(root, ans, deepest.get(i));
        }

        return ans;
    }
}
