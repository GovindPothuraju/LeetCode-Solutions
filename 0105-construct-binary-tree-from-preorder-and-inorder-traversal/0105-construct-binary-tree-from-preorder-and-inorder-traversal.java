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
    
    int preRoot=0;
    HashMap<Integer ,Integer> inOrdermap =new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;

        // put inorder in hashmap
        for(int i=0;i<n;i++){
            inOrdermap.put(inorder[i],i);
        }
        //build actuval tree
        return construct(preorder,0,inorder.length-1);
    }
    private TreeNode construct(int[] preOrder , int prestart , int preEnd){

        if(prestart > preEnd) return null;
        // take the start value in preorder and construct tree
        int rootVal=preOrder[preRoot++];
        TreeNode root=new TreeNode(rootVal);

        // find index of left and right form preorder
        int idx=inOrdermap.get(rootVal);

        root.left=construct(preOrder,prestart,idx-1);
        root.right=construct(preOrder,idx+1,preEnd);
        return root;
    }
}