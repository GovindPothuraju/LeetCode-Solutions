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
    /* Recursive approach
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        traversal(root,ans);
        return ans;
    }
    private void traversal(TreeNode curr,List<Integer> ans){
        if (curr == null) return;
        traversal(curr.left,ans);
        ans.add(curr.val);
        traversal(curr.right,ans);
    }*/

    // Iterative way
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        TreeNode curr=root;
        
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr=curr.left;
            }
            curr = st.pop();   
            ans.add(curr.val);       
            curr=curr.right;
        }
        return ans;
    }
}