class Solution {
    public boolean checkValidString(String s) {

        int open = 0;
        int close = 0;
        int star = 0;

        // Left to right
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            }
            else if (ch == ')') {
                close++;
            }
            else {
                star++;
            }
            if (close > open + star) {
                return false;
            }
        }
        // Right to left
        open = 0;
        close = 0;
        star = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (ch == ')') {
                close++;
            }
            else if (ch == '(') {
                open++;
            }
            else {
                star++;
            }

            if (open > close + star) {
                return false;
            }
        }

        return true;
    }
}