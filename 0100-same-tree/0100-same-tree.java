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
    // using recursion
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if(p==null && q==null){
    //         return true;
    //     }
    //     if(p==null || q==null){
    //         return false;
    //     }
    //     if(p.val != q.val){
    //         return false;
    //     }
    //     return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    // }
   


   // using iteration by using BFS
   public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode curr1=q1.poll();
            TreeNode curr2=q2.poll();

            if(curr1==null && curr2==null) continue;
            if(curr1==null || curr2==null) return false;

            if(curr1.val != curr2.val){
                return false;
            }
            q1.offer(curr1.left);
            q2.offer(curr2.left);
            q1.offer(curr1.right);
            q2.offer(curr2.right);
        }
        return true;
   }
}