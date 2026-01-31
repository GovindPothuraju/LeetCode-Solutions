/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode res=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root,p,q);
        return res;
    }
    private int traversal(TreeNode curr,TreeNode p,TreeNode q){
        int count=0;
        if(curr==null) return 0;
        int left=traversal(curr.left,p,q);
        int right=traversal(curr.right,p,q);

        if(curr.val==p.val || curr.val==q.val){
            count++;
        }
        int temp=left+right+count;
        if(temp==2 && res==null){
            res=curr;
        }
        return temp;
    }
}