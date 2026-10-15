class Solution {
    public boolean isPossible(int[]arr,int days,int mid){
        int totaldays=1;
        int sum=0;
        for(int i = 0;i<arr.length;i++){
            if(sum+arr[i]>mid){
                totaldays++;
                sum=arr[i];

            }
            else{
                sum+=arr[i];
            }


        }
        return totaldays<=days;
    }
    public int shipWithinDays(int[] arr, int days) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
            max=Math.max(max,arr[i]);

        }
        int lo =max;
        int hi=sum;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(arr,days,mid)){
                hi=mid-1;
            }
            else lo =mid+1;
        }
        return lo;
        
    }
}