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
    TreeNode res=null;
    public TreeNode searchBST(TreeNode root, int val) {
        traversal(root,val);
        return res;
    }
    private void traversal(TreeNode curr,int val){
        if(curr==null) return;
        if(curr.val==val && res==null){
            res=curr;
        }
        if(curr.val > val){
            traversal(curr.left,val);
        }else{
            traversal(curr.right,val);
        }
    }
}