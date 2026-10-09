class Solution {
    public int minInsertions(String s) {
        int open=0;
        int need=0;

        for(int i =0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='('){
                open++;
            }
            else {
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    i++;
                }
                else {
                    need++;
                }
                if(open==0) need++;
                else open--;
            }
        }

        need+=open * 2;
        return need;
    }
}