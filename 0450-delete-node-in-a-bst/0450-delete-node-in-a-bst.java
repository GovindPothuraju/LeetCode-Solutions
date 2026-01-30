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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode res=delete(root,key);
        return res;
    }
    private TreeNode delete(TreeNode curr,int key){
        if(curr==null) return null;
        if(curr.val>key){
            curr.left=delete(curr.left,key);
        }else if(curr.val<key){
            curr.right=delete(curr.right,key);
        }else{
            // 0 children
            if(curr.left==null && curr.right==null) return null;
            // 1 children
            if(curr.left==null){
                return curr.right;
            }else if(curr.right==null){
                return curr.left;
            }
            // 2 children
            TreeNode ip=getInorderSucessor(curr.right);
            curr.val=ip.val;
            //after repcaing the value with ip the remove ip it definitly leaf node
            curr.right=delete(curr.right,ip.val);
        }

        return curr;
    }
    private TreeNode getInorderSucessor(TreeNode temp){
        while(temp.left != null){
            temp=temp.left;
        }
        return temp;
    }
}