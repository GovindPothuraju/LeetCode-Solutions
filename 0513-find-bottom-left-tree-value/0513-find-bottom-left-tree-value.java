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
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        dfs(root,res,0);
        return res.get(res.size()-1);
    }
    private void dfs(TreeNode curr,ArrayList res,int level){
        if(curr==null) return;
        if(res.size() == level){
            res.add(curr.val);
        }
        dfs(curr.left,res,level+1);
        dfs(curr.right,res,level+1);
    }
}