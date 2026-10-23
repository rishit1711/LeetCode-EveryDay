class Solution {
    public int maximumGap(int[] arr) {
        int n=arr.length;
        if(n<2) return 0;
        Arrays.sort(arr);
        int diff=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            diff=Math.max(diff,Math.abs(arr[i+1]-arr[i]));
        }
        return diff;
    }
}