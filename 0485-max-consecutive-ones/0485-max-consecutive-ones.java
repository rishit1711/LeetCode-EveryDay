class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxlen=0;
        int i =0;
        int len=0;
        for(int j =0;j<n;j++){
            if(nums[j]==0){
                i=j+1;
            }
            len = j-i+1;
            maxlen=Math.max(maxlen, len);

               

            
        }
        return maxlen;
    }

  
}