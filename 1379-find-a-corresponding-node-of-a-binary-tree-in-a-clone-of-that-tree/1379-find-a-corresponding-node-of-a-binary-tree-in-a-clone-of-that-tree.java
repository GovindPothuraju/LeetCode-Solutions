/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(cloned,target);
        return res;
    }
    private void dfs(TreeNode curr,TreeNode target){
        if(curr==null){
            return ;
        }
        if(curr.val==target.val){
            res=curr;
        }
        dfs(curr.left,target);
        dfs(curr.right,target);
    }
}