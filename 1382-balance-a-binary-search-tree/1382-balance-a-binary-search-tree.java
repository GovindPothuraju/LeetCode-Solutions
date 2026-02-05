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
    ArrayList<Integer> arr=new ArrayList<>();
    int i=0;
    public TreeNode balanceBST(TreeNode root) {
        // preorder of tree
        traversal(root);
        //buildtree
        TreeNode res=buildTree(0,arr.size()-1);
        return res;
    }
    private void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.left);
        arr.add(root.val);
        traversal(root.right);
    }
    private TreeNode buildTree(int st,int end){
        if(st==end){
            return new TreeNode(arr.get(st));
        }
        if(st>end)return null;
        int mid=st+(end-st)/2;
        TreeNode curr=new TreeNode(arr.get(mid));
        curr.left=buildTree(st,mid-1);
        curr.right=buildTree(mid+1,end);
        return curr;
    }

}