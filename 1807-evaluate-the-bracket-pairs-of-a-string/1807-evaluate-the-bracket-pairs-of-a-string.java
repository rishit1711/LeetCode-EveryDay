class Solution {
    public String evaluate(String s, List<List<String>> list) {
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            map.put(list.get(i).get(0),list.get(i).get(1));  // "name" -> "bob"
        
        }

        int n=s.length();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!='('){
                result.append(s.charAt(i));
            }
            else {
                i++; // skip '('

                StringBuilder curr = new StringBuilder();

                while (i < n && s.charAt(i) != ')') {
                    curr.append(s.charAt(i));
                    i++;
                }

                String rep = map.getOrDefault(curr.toString(), "?");
                result.append(rep);
            }

        }

        return result.toString();




    }
}