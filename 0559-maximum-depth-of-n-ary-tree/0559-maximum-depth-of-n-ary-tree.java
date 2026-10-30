class Solution {
    public int dfs(Node root,int currdepth){
        if(root==null){
            return currdepth;
        }
        int maxdepth=currdepth;
        for(Node child:root.children){
            maxdepth=Math.max(dfs(child,currdepth+1),maxdepth);
        }
        return maxdepth;
    }
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        return dfs(root,1);
    }
}