class Solution {
    public boolean solve(String s, String t, int i, int j) {
        if (s.length() == 0 && t.length() > 0) return true;
        if (s.length() == 0 && t.length() == 0) return true;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;

            if (i == s.length()) return true;
        }
        return false;
    }

    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        return solve(s, t, 0, 0);
    }

    public int appendCharacters(String s, String t) {
        int i = 0; // t
        int j = 0; // s

        while (i < t.length() && j < s.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }

        return t.length() - i;
    }
}