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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root.left ==null && root.right==null) return 0;
        getHeight(root);
        return diameter;
    }
    private int getHeight(TreeNode curr){
        if(curr==null) return 0;
        int left=getHeight(curr.left);
        int right=getHeight(curr.right);
        diameter = Math.max(diameter,left+right);
        return 1+Math.max(left,right);
    }
}