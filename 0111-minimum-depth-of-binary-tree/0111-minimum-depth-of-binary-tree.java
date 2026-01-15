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
    int res=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        traversal(root,1);
        return res;
    }
    private void traversal(TreeNode curr,int dept){
        if(curr==null) return ;
        if(curr.left==null && curr.right==null){
            res=Math.min(res,dept);
            return;
        }
        traversal(curr.left,dept+1);
        traversal(curr.right,dept+1);
    }
}