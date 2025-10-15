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
    //using top-down approach
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traversal(root,0,targetSum);
    }
    private boolean traversal(TreeNode curr , int sum, int targetSum ){
        if(curr == null ) return false;
        sum+=curr.val;
        if(curr.left == null && curr.right == null){
            return sum==targetSum;
        }
        
        return traversal(curr.left,sum,targetSum) ||traversal(curr.right,sum,targetSum);
    }
    //  using bottom up approach
    // public boolean hasPathSum(TreeNode root, int targetSum) {
    //     if(curr == null) return false;
    //     targetsum-=curr.val;
    //     return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    // }
}