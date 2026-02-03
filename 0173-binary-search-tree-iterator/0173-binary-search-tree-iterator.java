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
class BSTIterator {
    // 1. using inorder traversal
    // int idx=0;
    // ArrayList<Integer> arr=new ArrayList<>();
    // public BSTIterator(TreeNode root) {
    //     traversal(root);
    // }
    // private void traversal(TreeNode curr){
    //     if(curr==null)return;
    //     traversal(curr.left);
    //     arr.add(curr.val);
    //     traversal(curr.right);
    // }
    
    // public int next() {
    //     return arr.get(idx++);
    // }
    
    // public boolean hasNext() {
    //     return idx<arr.size();
    // }
    // 2.using stack o(h)
    Stack<TreeNode> st=new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode curr=root;
        while(curr != null){
            st.push(curr);
            curr=curr.left;
        }
    }
    
    public int next() {
        TreeNode top=st.pop();
        if(top.right!=null){
            TreeNode temp=top.right;
            while(temp != null){
                st.push(temp);
                temp=temp.left;
            }
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */