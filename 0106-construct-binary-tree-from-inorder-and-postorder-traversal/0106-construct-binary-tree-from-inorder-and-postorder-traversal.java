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
    int postRoot;
    HashMap<Integer,Integer> inMap=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        postRoot=postorder.length-1;

        return construct(postorder,0,postorder.length-1);
    }
    private TreeNode construct(int[] postorder,int stPost , int endPost){
        if(stPost>endPost) return null;

        int rootVal=postorder[postRoot--];
        TreeNode root=new TreeNode(rootVal);
        int idx=inMap.get(rootVal);
        
        root.right=construct(postorder,idx+1,endPost);
        root.left=construct(postorder,stPost,idx-1);
        return root;
    }
}