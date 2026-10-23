class Solution {
    public int maximumGap(int[] arr) {
        int n=arr.length;
        if(n<2) return 0;
        Arrays.sort(arr);
        int diff=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            diff=Math.max(diff,Math.abs(arr[i]-arr[i-1]));
        }
        return diff;
    }
}