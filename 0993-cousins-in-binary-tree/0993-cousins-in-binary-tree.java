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
    HashMap<Integer,Integer> parent=new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        
        buildParent(root,null);
        System.out.println(parent);
        if(parent.get(x)==parent.get(y)){
            return false;
        }

        int v1=getDepth(root,x);
        int v2=getDepth(root,y);
        System.out.println(v1+" "+v2);
        return v1==v2;
    }
    private int getDepth(TreeNode curr, int x){
            if(curr==null) return -1;
            if(curr.val==x) return 0;
            int left=getDepth(curr.left,x);
            if(left!=-1) return left+1;
            int right=getDepth(curr.right,x);
            if(right!=-1) return right+1;
            return -1;
    }
    private void buildParent(TreeNode curr,TreeNode par){
        if(curr==null) return;
        parent.put(curr.val, (par==null ? -1 : par.val));
        buildParent(curr.left,curr);
        buildParent(curr.right,curr);
    }
    

}