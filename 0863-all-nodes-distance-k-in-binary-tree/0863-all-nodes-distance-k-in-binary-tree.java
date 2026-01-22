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
    // using DFS & BFS
    // HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    // public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    //     // build parent tree
    //     buildParent(root,null);

    //     //create q and visited
    //     Queue<TreeNode> q=new LinkedList<>();
    //     HashSet<TreeNode> visited=new HashSet<>();

    //     int distance=0;
    //     // initially insert target
    //     q.offer(target);
    //     visited.add(target);
    //     while(!q.isEmpty()){
    //         int n=q.size();

    //         if(distance==k){
    //             List<Integer> res=new ArrayList<>();
    //             for(TreeNode t:q){
    //                 res.add(t.val);
    //             }
    //             return res;
    //         }

    //         for(int i=0;i<n;i++){
    //             TreeNode temp=q.poll();
    //             //left
    //             if(temp.left != null && !visited.contains(temp.left)){
    //                 q.offer(temp.left);
    //                 visited.add(temp.left);
    //             }
    //             //right
    //             if(temp.right != null && !visited.contains(temp.right)){
    //                 q.offer(temp.right);
    //                 visited.add(temp.right);
    //             }
    //             //parent
    //             TreeNode par=parent.get(temp);
    //             if(par!= null && !visited.contains(par)){
    //                 q.offer(par);
    //                 visited.add(par);
    //             }
    //         }
    //         distance++;
    //     }
    //     return new ArrayList<>();
    // }

    // private void buildParent(TreeNode curr,TreeNode par){
    //     if(curr==null) return ;
    //     parent.put(curr,par);
    //     buildParent(curr.left,curr);
    //     buildParent(curr.right,curr);
    // }


    // Using recursion 
    List<Integer> res=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            traversal(root,target,k);
            return res;
    }
    private int traversal(TreeNode curr, TreeNode target, int k){
        if(curr==null) return -1;

        if(curr==target){
            collectDown(curr,k);
            return 0;
        }
        int leftDist=traversal(curr.left,target,k);
        if(leftDist != -1){
            int currDist=leftDist+1;

            if(currDist==k){
                res.add(curr.val);
            }else{
                collectDown(curr.right,k-currDist-1);
            }
            return currDist;
        }
        int rightDist = traversal(curr.right,target,k);
        if(rightDist != -1){
            int currDist=rightDist+1;

            if(currDist==k){
                res.add(curr.val);
            }else{
                collectDown(curr.left,k-currDist-1);
            }
            return currDist;
        }
        return -1;
    }
    private void collectDown(TreeNode curr,int dist){
        if(curr==null || dist<0)return;
        if(dist==0){
            res.add(curr.val);
            return;
        }
        collectDown(curr.left,dist-1);
        collectDown(curr.right,dist-1);
    }
}