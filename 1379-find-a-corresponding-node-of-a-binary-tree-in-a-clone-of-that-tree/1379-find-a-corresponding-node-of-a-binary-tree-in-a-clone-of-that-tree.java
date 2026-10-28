class Solution {
    public final TreeNode findTarget( final TreeNode original,final TreeNode cloned, final TreeNode target){
        if(original==null){
            return null;
        }
        if(original==target){
            return cloned;
        }
        TreeNode left = findTarget(original.left,cloned.left,target);
        if(left!=null){
            return left;
        }
        return findTarget(original.right,cloned.right,target);
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        return findTarget(original,cloned, target);

        
    }
}