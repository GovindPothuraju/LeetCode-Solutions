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
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traversal(root,root.val,"");
        return res;
    }
    private void traversal(TreeNode curr, int data,String str){
        if(curr == null)return ;
        str+=String.valueOf(curr.val);
        if(curr.left==null && curr.right==null){
            res.add(str);   
            return;
        }
        str+="->";
        traversal(curr.left,curr.val,str);
        traversal(curr.right,curr.val,str);
    }
}