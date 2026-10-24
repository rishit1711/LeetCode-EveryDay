
class Solution {
    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' ||
            ch == 'o' || ch == 'u' || ch == 'A' ||
            ch == 'E' || ch == 'I' || ch == 'O' ||
            ch == 'U') {
            return true;
        }
        return false;
    }

    public String reverseVowels(String s) {
        int n = s.length();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                list.add(ch);
            }
        }
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            char temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }

        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (!isVowel(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else {
                sb.append(list.get(idx++));
            }
        }
        return sb.toString();
    }
}
