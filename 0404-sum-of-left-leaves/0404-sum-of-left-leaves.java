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
    int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(isLeaf(root)){
            return 0;
        }
        traversalLeft(root,false);
        return sum;
    }
    private boolean isLeaf(TreeNode root){
        return root.left== null && root.right==null;
    }
    private void traversalLeft(TreeNode curr,boolean isLeft){
        if(curr == null )return;
        if(isLeft && isLeaf(curr)){
            sum+=curr.val;
        }
        traversalLeft(curr.left ,true);
        traversalLeft(curr=curr.right,false);
 
    }
}