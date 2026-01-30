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
    int res=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        traversal(root,low,high);
        return res;
    }
    private void traversal(TreeNode curr,int low,int high){
        if(curr==null)return;
        if(curr.val>=low && curr.val<=high){
            res+=curr.val;
        }
        traversal(curr.left,low,high);
        traversal(curr.right,low,high);
    }
}