class Solution {
    public int countElements(int[] nums) {
        int n=nums.length;
        int count=0;
        if(n==1) return 0;
        for(int i=0;i<n;i++){
            boolean max=false;
            boolean min=false;
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(nums[j]>nums[i]){
                        max=true;
                    }
                    if(nums[j]<nums[i]){
                        min=true;
                    }
                }
            }

            if(min==true&&max==true){
                count++;
            }
        }
        return count;
    }
}