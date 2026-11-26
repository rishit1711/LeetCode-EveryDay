class Solution {
    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        inorder(root1, ans1);
        inorder(root2, ans2);

        int i = 0, j = 0;
        while (i < ans1.size() && j < ans2.size()) {
            if (ans1.get(i) <= ans2.get(j)) {
                ans.add(ans1.get(i));
                i++;
            } else {
                ans.add(ans2.get(j));
                j++;
            }
        }

        while (i < ans1.size()) {
            ans.add(ans1.get(i));
            i++;
        }

        while (j < ans2.size()) {
            ans.add(ans2.get(j));
            j++;
        }

        return ans;
    }
}
