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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums,0,nums.length-1);
    }
    private TreeNode traversal(int[] arr,int st,int ed){
        if(ed<0 || st>ed)return null;

        int max=st;
        for(int i=st;i<=ed;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        TreeNode curr=new TreeNode(arr[max]);
        curr.left=traversal(arr,st,max-1);
        curr.right=traversal(arr,max+1,ed);
        return curr;
    }
}