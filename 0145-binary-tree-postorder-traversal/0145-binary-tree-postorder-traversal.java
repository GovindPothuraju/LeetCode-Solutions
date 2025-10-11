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
    /*   using recursion
     public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        traversal(root,ans);
        return ans;
    }
    private void traversal(TreeNode curr,List<Integer> ans){
        // left->right->root
        if (curr == null) return;
        traversal(curr.left,ans);
        traversal(curr.right,ans);
        ans.add(curr.val);
    }*/
    

    // using two stacks
    /*public List<Integer> postorderTraversal(TreeNode root){
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();

        st1.push(root);
        TreeNode curr;
        while(!st1.isEmpty()){
            curr=st1.pop();
            st2.push(curr);

            if(curr.left != null) st1.push(curr.left);
            if(curr.right != null) st1.push(curr.right);

        }
        
        while(!st2.isEmpty()){
            ans.add(st2.pop().val);
        }
        return ans;
    }*/

    // using one stack
    public List<Integer> postorderTraversal(TreeNode root){
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        TreeNode lastVisited = null;
        while(!st.isEmpty() || curr != null){
            // push all values to stack until i reach the leftmost element
            while(curr != null){
                st.push(curr);
                curr=curr.left;
            }

            TreeNode peekNode=st.peek();
            if(peekNode.right != null && lastVisited !=peekNode.right){
                curr=peekNode.right;
            }else{
                ans.add(peekNode.val);
                lastVisited= st.pop();
            }
        }
        return ans;
    }
}