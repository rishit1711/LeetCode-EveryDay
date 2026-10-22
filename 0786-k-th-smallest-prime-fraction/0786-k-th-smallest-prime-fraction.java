class Solution {
    public class Pair {
        List<Integer> frac;
        double val;

        Pair(List<Integer> frac, double val) {
            this.frac = frac;
            this.val = val;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(a.val, b.val)
        );

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double val = (double) arr[i] / arr[j];

                pq.add(new Pair(
                    Arrays.asList(arr[i], arr[j]),
                    val
                ));
            }
        }

        while (k > 1) {
            pq.poll();
            k--;
        }

        Pair p = pq.poll();
        return new int[] {
            p.frac.get(0),
            p.frac.get(1)
        };
    }
}
