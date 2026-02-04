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
    int i=0;
    ArrayList<Integer> arr=new ArrayList<>();
    public void recoverTree(TreeNode root) {
        // build preorder
        traversal(root);
        //sort arr
        Collections.sort(arr);
        // again check with inorder
        traversalSwap(root);
    }
    public void traversal(TreeNode curr){
        if(curr==null) return;
        traversal(curr.left);
        arr.add(curr.val);
        traversal(curr.right);
    }
    public void traversalSwap(TreeNode curr){
        if(curr==null) return;
        traversalSwap(curr.left);
        curr.val=arr.get(i++);
        traversalSwap(curr.right);
    }
    
}