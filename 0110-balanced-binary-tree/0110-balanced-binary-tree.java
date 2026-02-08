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
    boolean ans=true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return ans;
    }
    private int getHeight(TreeNode curr){
        if(ans==false)return 0;
        if(curr == null) return -1;
        int left=getHeight(curr.left);
        int right=getHeight(curr.right);
        if(Math.abs(left-right)>1){
            ans=false;
        }
        return 1+Math.max(left,right);
    }
}