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
    // using Recursion
    // public boolean isSymmetric(TreeNode root) {
    //     if(root==null) return true;
    //     return isMirror(root.left, root.right);
    // }
    // private boolean isMirror(TreeNode curr1,TreeNode curr2){
    //     // ✅ Both null → symmetric
    //     if (curr1 == null && curr2 == null) return true;

    //     // ✅ Only one null → not symmetric
    //     if (curr1 == null || curr2 == null) return false;
 
    //     return (curr1.val == curr2.val)  && 
    //             isMirror(curr1.left, curr2.right) && 
    //             isMirror(curr1.right, curr2.left);
    // }


    // using iteration by using BFS and queue
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(!q.isEmpty()){
            TreeNode p1=q.poll();
            TreeNode p2=q.poll();

            if(p1==null && p2==null)  continue;
            if(p1==null || p2==null || p1.val != p2.val) return false;

            q.offer(p1.left);
            q.offer(p2.right);
            q.offer(p1.right);
            q.offer(p2.left);
        }
        return true;
    }
}