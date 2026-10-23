class Solution {
    public int countPeaks(String s){
        int n=s.length();
        int count=0;
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)>s.charAt(i-1)&&s.charAt(i)>s.charAt(i+1)){
                count++;
            }
        }
        return count;
    }

    public int countValley(String s){
        int n=s.length();
        int count=0;
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)<s.charAt(i-1)&&s.charAt(i)<s.charAt(i+1)){
                count++;
            }
        }
        return count;

    }
    public int totalWaviness(int num1, int num2) {
        int waviness=0;
        for(int i=num1;i<=num2;i++){
            int peaks=countPeaks(String.valueOf(i));
            int valley=countValley(String.valueOf(i));
            waviness+=peaks+valley;

        }
        return waviness;
    }
}