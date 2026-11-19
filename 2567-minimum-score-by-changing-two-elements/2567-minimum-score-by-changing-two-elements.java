class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int opt1 = nums[n - 3] - nums[0];
        int opt2 = nums[n - 1] - nums[2];
        int opt3 = nums[n - 2] - nums[1];
        return Math.min(opt1, Math.min(opt2, opt3));
    }
}