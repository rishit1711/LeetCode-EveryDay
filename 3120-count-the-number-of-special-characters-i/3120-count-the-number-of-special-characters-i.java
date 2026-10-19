class Solution {
    public int numberOfSpecialChars(String s) {
        HashSet<Character> set= new HashSet<>();
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++){
            char ch =s.charAt(i);
            if(Character.isUpperCase(ch)){
                set.add(ch);
            }
            else continue;
            
        }
        // duplicate check lagale
        HashSet<Character> set1=new HashSet<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isLowerCase(ch)&&set.contains(Character.toUpperCase(ch))&& !set1.contains(ch)){
                count++;
                set1.add(ch);
            }
        }
        return count;
    }
}