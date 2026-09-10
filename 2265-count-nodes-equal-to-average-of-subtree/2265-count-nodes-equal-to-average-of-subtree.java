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
    int count = 0;
    HashMap<TreeNode,Integer> hm = new HashMap<>();
    public int averageOfSubtree(TreeNode root) {
        countNodes(root);
        traversal(root);
        System.out.println(hm);
        return count;
    }
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        hm.put(root,leftCount + rightCount + 1);
        return leftCount + rightCount + 1;
    }
    private int traversal(TreeNode root){
        if(root == null)return 0;
        int leftSum = traversal(root.left);
        int rightSum =traversal(root.right);
        int value = root.val+leftSum+rightSum;
        if(Math.floor(value/hm.get(root)) == root.val){
            count++;
        }
        return value; 
    }
}