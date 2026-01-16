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
        int leftSum = Math.max(0,traversal(curr.left));
        int rightSum = Math.max(0,traversal(curr.right));

        int maxVal=curr.val+leftSum+rightSum;
        int returnMax= Math.max((leftSum+curr.val),(rightSum+curr.val));
        
        res=Math.max(res,maxVal);
        
        return returnMax;
    }
}