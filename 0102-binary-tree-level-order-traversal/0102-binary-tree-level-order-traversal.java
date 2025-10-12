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
    /* using queue iteration
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root == null) return new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            ArrayList<Integer> arr=new ArrayList<>();
            int levelSize=q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode temp=q.poll();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                arr.add(temp.val);
            }
            ans.add(arr);
        }
        return ans;
    }*/

    // using recursion
    public List<List<Integer>> levelOrder(TreeNode root){
        
        List<List<Integer>> ans=new ArrayList<>();
        traversal(root,0,ans);
        return ans;
    }
    public void traversal (TreeNode curr,int level,List<List<Integer>> ans){
        if(curr == null) return;
        if(ans.size()<=level){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(curr.val);
        traversal(curr.left,level+1,ans);
        traversal(curr.right,level+1,ans);
    }
}