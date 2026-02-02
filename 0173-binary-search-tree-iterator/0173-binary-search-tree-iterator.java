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
    int idx=0;
    ArrayList<Integer> arr=new ArrayList<>();
    public BSTIterator(TreeNode root) {
        traversal(root);
    }
    private void traversal(TreeNode curr){
        if(curr==null)return;
        traversal(curr.left);
        arr.add(curr.val);
        traversal(curr.right);
    }
    
    public int next() {
        return arr.get(idx++);
    }
    
    public boolean hasNext() {
        return idx<arr.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */