class Solution {
    public int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp, (a, b) -> {
            int diff = digitSum(a) - digitSum(b);
            if (diff != 0) return diff;
            return a - b;
        });

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = temp[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == ans[i]) {
                continue;
            }

            int currVal = nums[i];
            int expectedVal = ans[i];

            int j = map.get(expectedVal);

            // Swap elements
            nums[i] = expectedVal;
            nums[j] = currVal;

            // Update their indices
            map.put(expectedVal, i);
            map.put(currVal, j);

            swaps++;
        }

        return swaps;
    }
}
