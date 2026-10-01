class Solution {
    public String removeKdigits(String s, int k) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - '0';
            while (!st.isEmpty() && st.peek() > a && k > 0) {
                st.pop();
                k--;
            }

            st.push(a);
        }
        while (k > 0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

       
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        if (i == sb.length()) {
            return "0";
        }

        return sb.substring(i);
    }
}