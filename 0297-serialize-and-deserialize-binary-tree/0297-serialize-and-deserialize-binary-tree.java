/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "#";
        Queue<TreeNode> q=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null) {
                sb.append("#,");
            }
            else{
                sb.append(temp.val).append(",");
                q.offer(temp.left);
                q.offer(temp.right);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")) return null;

        String[] arr=data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        int i=1;

        while(!q.isEmpty()){
            TreeNode curr=q.poll();

            if(!arr[i].equals("#")){
                curr.left=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.left);
            }
            i++;

            if(!arr[i].equals("#")){
                curr.right=new TreeNode(Integer.parseInt(arr[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));