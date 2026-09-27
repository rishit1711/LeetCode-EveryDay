class Solution {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(current.toString());
                current.setLength(0);

            } else if (ch == ')') {
                current.reverse();
                current.insert(0, stack.pop());

            } else {

                // Normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}