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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode curr1,TreeNode curr2){
        // ✅ Both null → symmetric
        if (curr1 == null && curr2 == null) return true;

        // ✅ Only one null → not symmetric
        if (curr1 == null || curr2 == null) return false;
 
        return (curr1.val == curr2.val)  && 
                isMirror(curr1.left, curr2.right) && 
                isMirror(curr1.right, curr2.left);
    }
}