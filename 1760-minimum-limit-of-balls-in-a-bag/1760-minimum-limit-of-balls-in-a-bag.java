class Solution {
    public boolean isPossible(int[] arr, int k, long mid) {
        long operation = 0;   // int -> long

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= mid) {
                continue;
            } else {
                operation += (arr[i] - 1) / mid;
            }
        }

        return operation <= k;
    }

    public int minimumSize(int[] arr, int k) {
        int n = arr.length;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }

        long lo = 1;
        long hi = max;
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            if (isPossible(arr, k, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return (int) ans;
    }
}