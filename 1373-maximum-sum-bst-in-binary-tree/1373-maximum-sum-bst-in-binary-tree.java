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
    public static class BSTNode {
        int maxNode;
        int minNode;
        int sum;

        BSTNode(int s, int min, int max) {
            this.sum = s;
            this.minNode = min;
            this.maxNode = max;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        traversal(root);
        return maxSum;
    }

    public BSTNode traversal(TreeNode curr) {
        if (curr == null) {
            return new BSTNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        BSTNode left = traversal(curr.left);
        BSTNode right = traversal(curr.right);
        if (left.maxNode < curr.val && curr.val < right.minNode) {
            int temp = curr.val + left.sum + right.sum;
            maxSum = Math.max(maxSum, temp);

            int tempMin = Math.min(left.minNode, curr.val);
            int tempMax = Math.max(right.maxNode, curr.val);
            return new BSTNode(temp, tempMin, tempMax);
        }

        return new BSTNode(Math.max(left.sum, right.sum), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}