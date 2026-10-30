/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void helper(Node root, List<List<Integer>> ans){
        if(root==null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){

            List<Integer> list=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                Node node=q.poll();
                list.add(node.val);
                for(Node child : node.children){
                    q.add(child);
                }
            }
            
            ans.add(list);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(root,ans);
        return ans;
    }
}