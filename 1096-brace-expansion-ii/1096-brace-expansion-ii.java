class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> ans = getUnit(expression);
        List<String> res = new ArrayList<>(ans);
        Collections.sort(res);
        return res;
    }

    // UNION: {a,b} -> a,b
    Set<String> performUnion(Set<String> a, Set<String> b) {
        Set<String> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }

    // CONCATENATION: {a,b} + {c,d}
    // -> ac, ad, bc, bd
    Set<String> performConcatenation(Set<String> a, Set<String> b) {
        Set<String> res = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                res.add(x + y);
            }
        }

        return res;
    }

    // Parse complete expression
    Set<String> getUnit(String s) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == ',') {
                result = performUnion(result, current);
                current = new HashSet<>();
                current.add("");
                i++;
            }

            else {
                Set<String> unit = new HashSet<>();

                // Normal character
                if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    unit.add(String.valueOf(s.charAt(i)));
                    i++;
                }

                
                else {
                    int start = i + 1;
                    int count = 1;
                    i++;

                    while (count != 0) {
                        if (s.charAt(i) == '{') count++;
                        else if (s.charAt(i) == '}') count--;
                        i++;
                    }

                    int end = i - 1;

                    unit = getUnit(s.substring(start, end));
                }

                current = performConcatenation(current, unit);
            }
        }

        result = performUnion(result, current);

        return result;
    }
}