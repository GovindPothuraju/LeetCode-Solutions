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
    List<Integer> ans= new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        traversal(root);
        return ans;
    }
    private void traversal(TreeNode curr){
        if (curr==null) return;
        ans.add(curr.val);
        traversal(curr.left);
        traversal(curr.right);
    }
}