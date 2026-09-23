class Solution {
    public int minOperations(int[] arr, int x) {

        int n = arr.length;
        int actualsum = 0;

        for(int i = 0; i < n; i++){
            actualsum += arr[i];
        }

        int target = actualsum - x;
        if(target<0) return -1;
        int left = 0;
        int maxlen = Integer.MIN_VALUE;
        int sum = 0;

        for(int right = 0; right < n; right++){

            sum += arr[right];
            while(sum > target){
                sum -= arr[left];
                left++;
            }

            if(sum == target){
                maxlen = Math.max(maxlen, right - left + 1);
            }
        }

        if(maxlen == Integer.MIN_VALUE)
            return -1;

        return n - maxlen;
    }
}