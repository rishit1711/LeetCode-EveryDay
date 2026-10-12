class Solution {
    public int dominantIndices(int[] arr) {
        int n =arr.length;
        
        int count=0;
        for(int i=0;i<n-1;i++){
            int sum=0;
            for(int j=i+1;j<n;j++){
                sum+=arr[j];
        
            }
            int elements=n-i-1;
            int avg=sum/elements;
           
            if(arr[i]>avg){
                count++;

            }
        }
        return count;
    }
}