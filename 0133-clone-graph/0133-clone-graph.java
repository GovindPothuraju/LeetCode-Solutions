/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {
        if(root==null)return root;

        Queue<Node> q=new LinkedList<>();
        HashMap<Node,Node> hm=new HashMap<>();

        Node cloneRoot = new Node(root.val);
        hm.put(root,cloneRoot);

        q.add(root);

        while(!q.isEmpty()){
            Node curr=q.poll();
            // visit all neighbours
            for(Node nei:curr.neighbors){
                if(!hm.containsKey(nei)){
                    q.add(nei);
                    hm.put(nei,new Node(nei.val));
                }
                // get current clone value
                Node cloneCurr=hm.get(curr);
                // add neighbous to current clone 
                cloneCurr.neighbors.add(hm.get(nei));
            }
        }
        return cloneRoot;
    }
}