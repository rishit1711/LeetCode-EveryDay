class Solution {

    public boolean isIncreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)
                    || list.get(i) % 2 == 0) {
                return false;
            }
        }
        return list.get(list.size() - 1) % 2 != 0;
    }

    public boolean isDecreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) <= list.get(i + 1)
                    || list.get(i) % 2 != 0) {
                return false;
            }
        }

        return list.get(list.size() - 1) % 2 == 0;
    }

    public List<List<Integer>> levelOrder(
            TreeNode root, List<List<Integer>> ans) {

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            ans.add(level);
        }

        return ans;
    }

    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> arr = levelOrder(root, ans);

        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) {
                if (!isIncreasing(arr.get(i))) {
                    return false;
                }
            } else {
                if (!isDecreasing(arr.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
