class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int depth=0;
        int maxdepth=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                depth++;
                maxdepth=Math.max(maxdepth,depth);
            }
            else{
                if(s.charAt(i)==')'){
                    depth--;
                }
            }
        }
        return maxdepth;
    }
}