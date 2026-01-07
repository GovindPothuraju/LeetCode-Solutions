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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        q.addLast(root);
        boolean ltr=true;
        while(!q.isEmpty()){
            List<Integer> arr=new ArrayList<>();
            int n=q.size();
            for(int i=0;i<n;i++){
                if(ltr){
                    TreeNode temp=q.pollFirst();
                    if(temp.left!=null)q.addLast(temp.left);
                    if(temp.right!=null)q.addLast(temp.right);
                    arr.add(temp.val);
                } else{     
                    TreeNode temp=q.pollLast();
                    if(temp.left!=null)q.addFirst(temp.right);
                    if(temp.right!=null)q.addFirst(temp.left);
                    arr.add(temp.val);
                }
            }
            ans.add(arr);
            ltr=!ltr;
        }
        

        return ans;
    }
}