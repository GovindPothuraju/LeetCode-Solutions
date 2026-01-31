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
    ArrayList<Integer> arr=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return arr.get(k-1);
    }
    private void inorder(TreeNode curr){
        if(curr==null) return;
        inorder(curr.left);
        arr.add(curr.val);
        inorder(curr.right);
    }
}