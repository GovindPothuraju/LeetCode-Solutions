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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root.left==null && root.right==null)return 1;
        dfs(root, root.val);
        return count;
    }
    private void dfs(TreeNode curr,int data){
        if(curr==null)return;

        if(curr.val>=data){
            data=curr.val;
            count++;
        }
        dfs(curr.left,data);
        dfs(curr.right,data);
    }
}