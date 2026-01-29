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
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return res;
        traversal(root,targetSum,0,new ArrayList<>());
        return res;
    }
    private void traversal(TreeNode curr,int target,int sum,List<Integer> arr){
        if(curr==null){
            return;
        }

        sum+=curr.val;
        arr.add(curr.val);
        if(isLeaf(curr)){
            if(sum==target){
                System.out.println(arr);
                res.add(new ArrayList<>(arr));
            }
        }

        traversal(curr.left,target,sum,arr);
        traversal(curr.right,target,sum,arr);
        // remove value when backtracking
        if(arr.size()>0)arr.remove(arr.size()-1);
    }
    private boolean isLeaf(TreeNode curr){
        return curr.left==null && curr.right==null;
    }
}