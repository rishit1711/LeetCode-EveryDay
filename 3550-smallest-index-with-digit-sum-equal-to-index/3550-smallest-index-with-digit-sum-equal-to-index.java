class Solution {
    public int sumofdigits(int sum,int a){
        while(a!=0){
            sum+=a%10;
            a=a/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=sumofdigits(0,nums[i]);
            if(sum==i){
                min=Math.min(i,min);
            }
        }

        if(min==Integer.MAX_VALUE) return -1;
        return min;

    }
}