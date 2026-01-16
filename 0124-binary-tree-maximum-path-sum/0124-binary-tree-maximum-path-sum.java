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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return res;
        if(root.left==null && root.right==null) return root.val;
        traversal(root);
        return res;
    }
    private int traversal(TreeNode curr){
        if(curr==null) return 0;
        int leftSum = traversal(curr.left);
        int rightSum = traversal(curr.right);

        int temp1=curr.val+rightSum;
        int temp2=curr.val+rightSum;
        int temp3=curr.val+leftSum+rightSum;

        int max = Math.max(curr.val , Math.max(Math.max(temp1, temp2), temp3));

        res=Math.max(res,max);
        return max;
    }
}