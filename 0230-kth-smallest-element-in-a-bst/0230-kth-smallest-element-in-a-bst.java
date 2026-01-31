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
    // 1. inorder
    // ArrayList<Integer> arr=new ArrayList<>();
    // public int kthSmallest(TreeNode root, int k) {
    //     inorder(root);
    //     return arr.get(k-1);
    // }
    // private void inorder(TreeNode curr){
    //     if(curr==null) return;
    //     inorder(curr.left);
    //     arr.add(curr.val);
    //     inorder(curr.right);
    // }

    // 2. bottom up approach
    int res=-1;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root,k);
        return res;
    }
    private int traversal(TreeNode curr,int k){
        if(curr==null) return 0;
        int left=traversal(curr.left,k);
        
        left++;
        right++;
        if(left+right == k && res==-1){
            res=curr.val;
        }
        
        return left+right;
    }
}