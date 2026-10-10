
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        // Maximum possible reduction
        long total = 0;
        for (int d : diff) {
            total += d;
        }

        if (k >= total) return 0;

        // Count differences using frequency
        long[] freq = new long[max + 1];

        for (int d : diff) {
            freq[d]++;
        }

        // Reduce maximum differences together
        for (int d = max; d > 0 && k > 0; d--) {
            long count = freq[d];
            long reduce = Math.min(k, count);

            freq[d] -= reduce;
            freq[d - 1] += reduce;
            k -= reduce;
        }

        long ans = 0;

        for (int d = 0; d <= max; d++) {
            ans += freq[d] * d * d;
        }

        return ans;
    }
}
