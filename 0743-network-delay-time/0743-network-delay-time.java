class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build adjacency list
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp:times){
            int u=temp[0];
            int v=temp[1];
            int time=temp[2];
            adj.get(u).add(new int[]{v,time});
        }
        //take a dist array 
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{k,0});

        while(!q.isEmpty()){
            int[] temp=q.poll();
            int node=temp[0];
            int time=temp[1];

            for(int[] nei:adj.get(node)){
                int adjNode=nei[0];
                int adjTime=nei[1];
                if(dist[adjNode] > time+adjTime){
                    dist[adjNode]=time+adjTime;
                    q.offer(new int[]{adjNode,time+adjTime });
                }
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            else res=Math.max(res,dist[i]);
        }
        return res;
    }
}