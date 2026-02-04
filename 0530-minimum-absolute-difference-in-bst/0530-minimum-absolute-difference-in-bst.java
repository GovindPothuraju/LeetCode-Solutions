/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode prev=null;
    int res=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return res;
    }
    private void traversal(TreeNode curr){
        if(curr==null) return;
        traversal(curr.left);
        if(prev!=null && Math.abs(prev.val-curr.val)<res){
            res=Math.abs(prev.val-curr.val);
        }
        prev=curr;
        traversal(curr.right);
    }
}