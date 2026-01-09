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
    // public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    //     if(subRoot==null) return true;
    //     if(root==null) return false;
    //     if(sameTree(root,subRoot)){
    //         return true;
    //     }
    //     return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    // }
    // public boolean sameTree(TreeNode p,TreeNode q){
    //     if(p==null && q==null) return true;
    //     if(p==null || q==null) return false;
    //     return p.val==q.val && sameTree(p.left,q.left) && sameTree(p.right,q.right);
    // }
    String hash="";
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String hashroot = serialize(root);
        String hashsubroot = serialize(subRoot);
        return hashroot.contains(hashsubroot);
    }
    public String serialize(TreeNode curr){
        StringBuilder sb=new StringBuilder();
        traversal(curr,sb);
        return sb.toString();
    }
    public void traversal(TreeNode curr,StringBuilder sb){
        if(curr==null){
            sb.append("-#");
            return;
        }
        sb.append("-").append(curr.val);
        traversal(curr.left,sb);
        traversal(curr.right,sb);
    }
}