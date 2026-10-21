class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<300;i++){
            if(i%k==0&&!set.contains(i)){
                min=Math.min(min,i);   
            }
        }

        return min;
    }
}