class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isEmpty() || arr[i].equals(".")) {
                continue;
            }
            else if (arr[i].equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            else {
                st.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : st) {
            sb.append("/").append(dir);
        }

       if(sb.length()==0) return "/";
       return sb.toString();
    }
}