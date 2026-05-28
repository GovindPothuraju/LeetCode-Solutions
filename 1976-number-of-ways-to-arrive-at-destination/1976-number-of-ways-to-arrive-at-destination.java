class Solution {
    int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        // adjacency list
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp : roads){
            int u=temp[0];
            int v=temp[1];
            int time= temp[2];
            adj.get(u).add(new int[]{v,time});
            adj.get(v).add(new int[]{u,time});
        }
        // dist array
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        // pathcount
        long[] pathCount=new long[n];
        Arrays.fill(pathCount,0);

        //prority queue
        PriorityQueue<long[]> pq=new PriorityQueue<>(
            (a,b)-> Long.compare(a[1], b[1])
        );

        dist[0]=0;
        pathCount[0]=1;
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] temp=pq.poll();
            int node=(int)temp[0];
            long time=temp[1];

            for(int[] nei :adj.get(node)){
                int adjNode=nei[0];
                int adjTime = nei[1];
                
                long newTime = time+adjTime; 
                // new Shortest path found
                if(newTime < dist[adjNode]){
                    dist[adjNode] = newTime;
                    pq.add(new long[]{adjNode,newTime});
                    pathCount[adjNode] = pathCount[node];
                }
                else if(newTime == dist[adjNode]){
                    pathCount[adjNode] =(pathCount[adjNode] + pathCount[node] ) % MOD;
                }
            }
        }
        return (int)(pathCount[n-1]%MOD);
    }
}