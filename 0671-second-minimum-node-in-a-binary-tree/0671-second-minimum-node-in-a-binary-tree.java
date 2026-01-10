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
    int min;
    long smin=Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        min=root.val;
        bfs(root);
        return smin==Long.MAX_VALUE ? -1:(int)smin;
    }
    private void bfs(TreeNode curr){
        if(curr == null) return ;
        if(curr.val > min && curr.val<smin){
            smin=curr.val;
        }
        bfs(curr.left);
        bfs(curr.right);
    }
}