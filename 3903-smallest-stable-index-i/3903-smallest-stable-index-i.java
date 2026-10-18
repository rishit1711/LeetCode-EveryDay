class Solution {
    public int firstStableIndex(int[] arr, int k) {
        int mindx=Integer.MAX_VALUE;
        int n=arr.length;
        int[] largest=new int[n];
        largest[0]=arr[0];
        for(int i=1;i<n;i++){
            largest[i]=Math.max(arr[i],largest[i-1]);
        }

        int[] smallest=new int[n];
        smallest[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            smallest[i]=Math.min(arr[i],smallest[i+1]);
        }


        for(int i=0;i<n;i++){
            int diff=largest[i]-smallest[i];
            if(diff<=k){
                mindx=Math.min(mindx,i);
            }
        }
        if(mindx==Integer.MAX_VALUE)return -1;
        return mindx;
    }
}