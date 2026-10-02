class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtrack("",0,0,n,ans);

        return ans;
    }

    public void backtrack(String s,int open,int close,int n,List<String> ans){

        // base case
        if(open==n&&close==n){
            ans.add(s);
            return;

        }
        if(open<n){
            backtrack(s+'(',open+1,close,n,ans);
        }
        if(close<open){
            backtrack(s+')',open,close+1,n,ans);
        }
    }
}