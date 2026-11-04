class Solution {
    public int minMoves2(int[] nums) {
        int n =nums.length;
        Arrays.sort(nums);
        int median=nums[n/2];
        int moves=0;
        for(int i=0;i<n;i++){
            moves+=Math.abs(nums[i]-median);
        }
        return moves;
    }
}