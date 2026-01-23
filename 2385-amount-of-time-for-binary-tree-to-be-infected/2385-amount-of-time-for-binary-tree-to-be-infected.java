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
    HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    TreeNode startNode;
    public int amountOfTime(TreeNode root, int start) {
        // build parent nodes
        buildParent(root,null,start);

        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet();
        //find the starting node
        // getStart(root, start);

        q.add(startNode);
        visited.add(startNode);
        int time=-1;

        while(!q.isEmpty()){
            int n=q.size();
            
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                //left
                if(temp.left != null && !visited.contains(temp.left)){
                    q.offer(temp.left);
                    visited.add(temp.left);
                }
                //right
                if(temp.right != null && !visited.contains(temp.right)){
                    q.offer(temp.right);
                    visited.add(temp.right);
                }
                //parent
                TreeNode par=parent.get(temp);
                if(par != null && !visited.contains(par)){
                    q.offer(par);
                    visited.add(par);
                }
            }
            time++;
        }
        return time;
    }
    // private void buildParent(TreeNode curr,TreeNode par){
    //     if(curr==null) return;
    //     parent.put(curr,par);
    //     buildParent(curr.left,curr);
    //     buildParent(curr.right,curr);
    // }
    // private void getStart(TreeNode curr,int data){
    //     if(curr==null) return ;
    //     if(curr.val==data){
    //         startNode=curr;
    //         return;
    //     }
    //     getStart(curr.left,data);
    //     getStart(curr.right,data);
    // }
    private void buildParent(TreeNode curr,TreeNode par,int data){
        if(curr==null) return;
        parent.put(curr,par);
        if(curr.val==data){
            startNode=curr;
        }
        buildParent(curr.left,curr,data);
        buildParent(curr.right,curr,data);
    }
}