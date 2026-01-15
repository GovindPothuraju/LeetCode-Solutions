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
    boolean res=true;
    public boolean isUnivalTree(TreeNode root) {
        traversal(root,root.val);
        return res;
    }
    private void traversal(TreeNode root,int value){
        if(root==null) return;
        if(root.val!=value){
            res=false;
            return;
        }
        traversal(root.left,value);
        traversal(root.right,value);
    }
}