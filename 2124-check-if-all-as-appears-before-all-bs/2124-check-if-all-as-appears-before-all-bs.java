class Solution {
    public boolean checkString(String s) {
        HashSet<Integer> set=new HashSet<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='b'){
                set.add(i);   // sare b ke indices set me daldo
            }

        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
              
                for(int ele : set){
                    if(ele<i){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}