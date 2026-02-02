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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode res = bildTree(preorder,0,preorder.length-1);
        return res;
    }
    private TreeNode bildTree(int[] arr,int st,int end){
        if(st==end){
            return new TreeNode(arr[st]);
        }
        if(st>end)return null;

        TreeNode root=new TreeNode(arr[st]);
        int temp=st;
        for(int i=st+1;i<=end;i++){
            if(arr[i]>arr[st]){
                break;
            }
            temp=i;
        }
        root.left=bildTree(arr,st+1,temp);
        root.right=bildTree(arr,temp+1,end);
        return root;
    }
}