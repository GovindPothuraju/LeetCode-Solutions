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
    ArrayList<Integer> res=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        traversal(root);
        for(int i=1;i<res.size();i++){
            if(res.get(i-1)>=res.get(i)){
                return false;
            }
        }
        return true;
    }
    private void traversal(TreeNode curr){
        if(curr==null)return;
        traversal(curr.left);
        res.add(curr.val);
        traversal(curr.right);
    }
}