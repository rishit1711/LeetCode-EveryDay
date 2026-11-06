class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n =nums.length;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }

        // minimum krna hai so minimum ko bada kro maximum km kro

        return Math.max(0, (max - k) - (min + k));
    }
}