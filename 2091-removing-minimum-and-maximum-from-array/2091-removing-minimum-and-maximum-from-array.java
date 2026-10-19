class Solution {
    public int minimumDeletions(int[] nums) {
        int mindx = -1;
        int maxdx = -1;
        int maxele = Integer.MIN_VALUE;
        int minele = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxele) {
                maxele = nums[i];
                maxdx = i;
            }
            if (nums[i] < minele) {
                minele = nums[i];
                mindx = i;
            }
        }
        // Case 1: Remove both from front
        int case1 = Math.max(mindx, maxdx) + 1;
        // Case 2: Remove both from back
        int case2 = n - Math.min(mindx, maxdx);
        // Case 3: Remove one from front and one from back
        int case3 = Math.min(mindx, maxdx) + 1
                    + n - Math.max(mindx, maxdx);

        return Math.min(case1, Math.min(case2, case3));
    }
}