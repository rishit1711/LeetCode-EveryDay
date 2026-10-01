class Solution {
    public boolean isOpen(char ch){
        if(ch=='[' || ch=='{' || ch=='('){
            return true;
        }
        return false;
    }
    public boolean isClose(char ch){
        if(ch==']' || ch=='}' || ch==')'){
            return true;
        }
        return false;
    }
    public boolean isIdentical(char a,char b){
        if(a=='[' && b==']') return true;
        if(a=='{' && b=='}') return true;
        if(a=='(' && b==')') return true;

        return false;
    }
    public boolean isValid(String s) {
        int n= s.length();
        if(s.charAt(0)==']' || s.charAt(0)==')' || s.charAt(0)=='}')
    return false;

        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(isOpen(ch)){
                st.push(ch);
            }
            else if(isClose(ch)){
                if(st.isEmpty()){
                    return false;
                }
                char ch1 = st.pop();
                if(isIdentical(ch1,ch)){
                    continue;
                }
                else return false;
            }

        }
        if(!st.isEmpty()) return false;
        return true;
    }
}