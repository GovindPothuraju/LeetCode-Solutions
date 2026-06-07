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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        HashSet<Integer> child = new HashSet<>();
        TreeNode root = null;
        for(int[] temp : descriptions){
            int par = temp[0];
            int chi = temp[1];
            hm.putIfAbsent(par,new TreeNode(par));
            hm.putIfAbsent(chi,new TreeNode(chi));
            if(temp[2] == 1){
                hm.get(par).left = hm.get(chi);
            }else{
                hm.get(par).right = hm.get(chi);
            }
            child.add(chi);
        }
        for(int[] temp : descriptions){
            if(!child.contains(temp[0])){
                return hm.get(temp[0]);
            }
        }
        return null;
    }
}