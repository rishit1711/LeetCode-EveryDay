class Solution {
    public long maxTotalValue(int[] nums, int k) {
        // val == max[l..r]-min[l...r];
        int n=nums.length;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        return k*(max-min);


    }
}