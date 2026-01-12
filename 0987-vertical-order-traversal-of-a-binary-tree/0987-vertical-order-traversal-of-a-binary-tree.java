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
     static class NodeInfo {
        TreeNode node;
        int row, col;

        NodeInfo(TreeNode n, int c, int r) {
            node = n;
            col = c;
            row = r;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm=new TreeMap<>();

        Queue<NodeInfo> q=new LinkedList<>();
        q.offer(new NodeInfo(root,0,0));

        while(!q.isEmpty()){
            NodeInfo curr=q.poll();

            if(!tm.containsKey(curr.col)){
                tm.put(curr.col,new TreeMap<>());
            }
            TreeMap<Integer,PriorityQueue<Integer>> rowMap = tm.get(curr.col);
            if(!rowMap.containsKey(curr.row)){
                rowMap.put(curr.row,new PriorityQueue<Integer>());
            }
            rowMap.get(curr.row).add(curr.node.val);
            
            if(curr.node.left != null){
                q.offer(new NodeInfo(curr.node.left , curr.col-1, curr.row+1));
            }
            if(curr.node.right != null){
                q.offer(new NodeInfo(curr.node.right , curr.col+1, curr.row+1));
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> rows : tm.values()){
            List<Integer> temp=new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            res.add(temp);
        }
        return res;
    }
}