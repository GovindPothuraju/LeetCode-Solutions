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
    static class Pair{
        TreeNode node;
        long index;
        Pair(TreeNode n,long i){
            this.node=n;
            this.index=i;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));

        int maxWidth=0;

        while(!q.isEmpty()){
            int n=q.size();

            long left=q.peekFirst().index;
            long right=q.peekLast().index;
            maxWidth = Math.max(maxWidth ,(int)(right-left+1));
            
            for(int i=0;i<n;i++){
                Pair temp=q.poll();
                long idx=temp.index-left;
                if(temp.node.left != null) q.offer(new Pair(temp.node.left,2*idx));
                if(temp.node.right != null)q.offer(new Pair(temp.node.right,2*idx+1));
            }
        }
        return maxWidth;
    }
   
}