/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // build parent tree
        buildParent(root,null);

        //create q and visited
        Queue<TreeNode> q=new LinkedList<>();
        HashSet<TreeNode> visited=new HashSet<>();

        int distance=0;
        // initially insert target
        q.offer(target);
        visited.add(target);
        while(!q.isEmpty()){
            int n=q.size();

            if(distance==k){
                List<Integer> res=new ArrayList<>();
                for(TreeNode t:q){
                    res.add(t.val);
                }
                return res;
            }

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
                if(par!= null && !visited.contains(par)){
                    q.offer(par);
                    visited.add(par);
                }
            }
            distance++;
        }
        return new ArrayList<>();
    }

    private void buildParent(TreeNode curr,TreeNode par){
        if(curr==null) return ;
        parent.put(curr,par);
        buildParent(curr.left,curr);
        buildParent(curr.right,curr);
    }
}