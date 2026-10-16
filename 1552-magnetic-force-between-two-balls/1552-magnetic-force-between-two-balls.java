class Solution {
    public boolean isPossible(int[]arr,int mid,int m){
        int n =arr.length;
        int prev = arr[0];
        int totalBalls=1;
        for(int i=1;i<n;i++){

            int curr = arr[i];
            if(curr-prev>=mid) {
                totalBalls++;
                prev=curr;
            }
        }
        return totalBalls>=m;
    }
    public int maxDistance(int[] arr, int m) {
        int n =arr.length;
        Arrays.sort(arr);
        int lo=0;
        int hi= arr[n-1]-arr[0];
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(arr,mid,m)){
                ans=mid;
                lo=mid+1;
            }
            else hi=mid-1;
        }
        return ans;
    }
}