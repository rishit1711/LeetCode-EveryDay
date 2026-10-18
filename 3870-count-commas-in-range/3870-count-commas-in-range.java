class Solution {
    public int countCommas(int n) {
        int count=0;
        for(int i=1000;i<=n;i++){
            int temp=i;
            int digit=0;
            while(temp>0){
                temp=temp/10;
                digit++;
            }
            count+=(digit-1)/3;
        }
        return count;
    }
}