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
    // 1. using inorder traversal
    // ArrayList<Integer> res=new ArrayList<>();
    // public boolean isValidBST(TreeNode root) {
    //     traversal(root);
    //     for(int i=1;i<res.size();i++){
    //         if(res.get(i-1)>=res.get(i)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // private void traversal(TreeNode curr){
    //     if(curr==null)return;
    //     traversal(curr.left);
    //     res.add(curr.val);
    //     traversal(curr.right);
    // }

    // 2. using recursion
    
    // public boolean isValidBST(TreeNode root) {
    //     boolean res=traversal(root,Long.MIN_VALUE,Long.MAX_VALUE);
    //     return res;
    // }
    // private boolean traversal(TreeNode curr,long lo,long hi){
    //     if(curr==null)return true;
    //     if(curr.val<=lo || curr.val>=hi){
    //        return false;
    //     } 
    //     boolean left=traversal(curr.left,lo,curr.val);
    //     boolean right=traversal(curr.right,curr.val,hi);
    //     return left && right;
    // }

    // 3 . using morris traversal
    public boolean isValidBST(TreeNode root) {
        TreeNode curr=root;
        long preValue = Long.MIN_VALUE;

        while(curr != null){
            if(curr.left==null){
                if(preValue >= curr.val){
                    return false;
                }
                preValue=curr.val;
                curr=curr.right;
            }else{
                TreeNode ip=curr.left;
                while(ip.right!=null && ip.right !=curr){
                    ip=ip.right;
                }

                if(ip.right == null){
                    ip.right=curr;
                    curr=curr.left;
                }else{
                    ip.right=null;
                    if(preValue >= curr.val){
                        return false;
                    }
                    preValue=curr.val;
                    curr=curr.right;
                }
            }
        }
        return true;
    }
}