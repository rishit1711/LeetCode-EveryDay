class Solution {
    public void helper(int idx,String s,HashSet<String> set,StringBuilder sb){
        // two choice 
        // if number aage badho
        // agar chacter hai ek bar jaisa hai waise hi rakho aur second time uppercase me convert krke recursively aage badho
        // base case
        if(idx==s.length()){
            set.add(sb.toString());
            return;
        }
        char ch=s.charAt(idx);
        if(Character.isLowerCase(ch)){
            sb.append(ch);
            helper(idx+1,s,set,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(ch));
            helper(idx+1,s,set,sb);
            sb.deleteCharAt(sb.length()-1);

        }
        else{
            sb.append(ch);
            helper(idx+1,s,set,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toLowerCase(ch));
            helper(idx+1,s,set,sb);
            sb.deleteCharAt(sb.length()-1);
        }
           
        
        
        


    }
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb = new StringBuilder(); 
        HashSet<String> set=new HashSet<>();
        helper(0,s,set,sb);
        for(String key : set){
            ans.add(key);
        }
        return ans;
    }
}