class Solution {
    public int findPermutationDifference(String s, String t) {
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map1.put(ch,i);
        }
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map2.put(ch,i);
        }

        int diff=0;
        for(char c : map1.keySet()){
            int a = map1.get(c);
            int b = map2.get(c);

            diff+=Math.abs(a-b);
        }
        return diff;

    }
}