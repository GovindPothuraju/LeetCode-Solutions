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
    TreeNode res = null;;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postOrder(root,p,q);
        return res;
    }
    private int postOrder(TreeNode curr, TreeNode p, TreeNode q){
        int count=0;
        if(curr==null) return 0;
        int ansOnLeft = postOrder(curr.left,p,q);
        int ansOnRight = postOrder(curr.right,p,q);

        if(curr.val==p.val || curr.val==q.val){
            count++;
        }

        count=count+ansOnLeft+ansOnRight;
        if(count == 2 && res==null){
            res=curr;
        }
        return count;
    }
}