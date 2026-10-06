class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st =new Stack<>();
        int n=s.length();
        int extraclose=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                if(st.isEmpty()){
                    extraclose++;
                }
                else st.pop();
            }
        }
    int ans=0;
        while(!st.isEmpty()){
            ans++;
            st.pop();
        }
        return ans+extraclose;
    }
}