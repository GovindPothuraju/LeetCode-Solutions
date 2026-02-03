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
    boolean res=false;
    HashSet<Integer> hs=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        traversal(root,k);
        return res;
    }
    private void traversal(TreeNode curr,int k){
       
        if(res || curr==null)return;
        if(hs.contains(k-curr.val)){
            res=true;
        }
        hs.add(curr.val);
        traversal(curr.left,k);
        traversal(curr.right,k);
    }
}