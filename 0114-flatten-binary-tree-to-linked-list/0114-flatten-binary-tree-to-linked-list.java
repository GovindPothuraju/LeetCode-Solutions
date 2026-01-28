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
    TreeNode nr=null;
    public void flatten(TreeNode root) {
        flat(root);
    }
    private void flat(TreeNode curr){
        if(curr==null) return;
        flat(curr.right);
        flat(curr.left);
        curr.left=null;
        curr.right=nr;
        nr=curr;
    }
}