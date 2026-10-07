class Solution {

    public void helper(int idx, String s, StringBuilder sb,
                       int count, HashSet<String> set) {

        if (count < 0) return;
        if (idx == s.length()) {
            if (count == 0) {
                set.add(sb.toString());
            }
            return;
        }
        char ch = s.charAt(idx);
        sb.append(ch);
        if (ch == '(') {
            helper(idx + 1, s, sb, count + 1, set);
        } 
        else if (ch == ')') {
            helper(idx + 1, s, sb, count - 1, set);
        } 
        else {
            helper(idx + 1, s, sb, count, set);
        }
        sb.deleteCharAt(sb.length() - 1);
        if (ch == '(' || ch == ')') {
            helper(idx + 1, s, sb, count, set);
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        helper(0, s, sb, 0, set);
        int maxLen = 0;
        for (String str : set) {
            maxLen = Math.max(maxLen, str.length());
        }
        List<String> ans = new ArrayList<>();
        for (String str : set) {
            if (str.length() == maxLen) {
                ans.add(str);
            }
        }
        return ans;
    }
}