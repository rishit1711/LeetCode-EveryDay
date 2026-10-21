class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        //int max=Integer.MIN_VALUE;
        int n=nums.length;
        int[] max=new int[n];
        max[0]=nums[0];
        for(int i=1;i<n;i++){
            max[i]=Math.max(max[i-1],nums[i]);
        }
        int[] prefixgcd=new int[n];
        for(int i=0;i<n;i++){
            prefixgcd[i]=gcd(nums[i],max[i]);
        }
        Arrays.sort(prefixgcd);
        int i=0;
        int j=n-1;
        long sum=0;
        while(i<j){
            sum+=gcd(prefixgcd[i],prefixgcd[j]);
            i++;
            j--;
        }
        return sum;
    }
}