class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        int absent = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'A') {
                absent++;
            }
        }

        if (absent >= 2) {
            return false;
        }

        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) == 'L' &&
                s.charAt(i + 1) == 'L' &&
                s.charAt(i + 2) == 'L' 
                ) {
                return false;
            }
        }

        return true;
    }
}
