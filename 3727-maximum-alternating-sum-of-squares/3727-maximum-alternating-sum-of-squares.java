class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(arr);
        long sum = 0;
        int n = arr.length;
        //  alternating sum
        for(int i=0;i<n;i++){
            if(i<n/2){
                sum-=arr[i];
            }
            else sum+=arr[i];
        }
        return sum;
    }
}