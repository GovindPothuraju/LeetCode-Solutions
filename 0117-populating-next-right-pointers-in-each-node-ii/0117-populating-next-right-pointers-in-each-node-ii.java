/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    // public Node connect(Node root) {
    //     if(root==null)return root;
    //     traversal(root);
    //     return root;
    // }
    // private void traversal(Node curr){
    //     if(curr==null) return;
    //     if(curr.left != null && curr.right !=null){
    //         curr.left.next=curr.right;
    //     }
    //     if(curr.right != null){
    //         curr.right.next=getNextChild(curr.next);
    //     }else if(curr.left !=null ){
    //         curr.left.next=getNextChild(curr.next);
    //     }
        
    //     traversal(curr.right);
    //     traversal(curr.left);
    // }
    // private Node getNextChild(Node curr){
    //     while(curr !=null){
    //         if(curr.left!=null)return curr.left;
    //         if(curr.right!=null)return curr.right;
    //         curr=curr.next;
    //     }
    //     return null;
    // }
    public Node connect(Node root) {
        if(root==null)return root;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node temp=q.poll();
                if(i<n-1) temp.next=q.peek();
                if(temp.left !=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
        }
        return root;
    }
}