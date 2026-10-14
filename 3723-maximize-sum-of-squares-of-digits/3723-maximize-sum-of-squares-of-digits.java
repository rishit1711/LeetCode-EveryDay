class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum) return "";
        int[] arr=new int[num];
        for(int i=0;i<num;i++){
            arr[i]=Math.min(9,sum);
            sum-=arr[i];
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}