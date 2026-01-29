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
    public int sumNumbers(TreeNode root) {
        traversal(root,0);
        return res;
    }
    private void traversal(TreeNode curr,int sum){
        if(curr==null) return;
        sum=sum*10+curr.val;
        if(curr.left==null && curr.right==null){
            res+=sum;
        }
        traversal(curr.left,sum);
        traversal(curr.right,sum);
    }
}