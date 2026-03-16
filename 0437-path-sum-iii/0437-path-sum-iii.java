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
    int count=0;
    HashMap<Long,Integer> hm=new HashMap<>();
    public int pathSum(TreeNode root, int k) {
        // code here
        //base case to handle
        if(root==null)return count;
        hm.put(0L,1);
        traversal(root,0L,k);
        return count;
    }
    private void traversal(TreeNode root,long sum,int k){
        sum+=root.val;
        long rem=sum-k;
        if(hm.containsKey(rem)){
            count+=hm.get(rem);
        }
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        if(root.left != null)traversal(root.left,sum,k);
        if(root.right != null)traversal(root.right,sum,k);
        hm.put(sum,hm.get(sum)-1);
        if(hm.get(sum)==0){
            hm.remove(sum);
        }
    }
}