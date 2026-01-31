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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res=traversal(root,p,q);
        return res;
    }
    private TreeNode traversal(TreeNode curr,TreeNode p,TreeNode q){
        if(p.val < curr.val && q.val<curr.val){
            return traversal(curr.left,p,q);
        }else if(p.val > curr.val && q.val > curr.val){
            return traversal(curr.right,p,q);
        }
        return curr;
        
    }
}