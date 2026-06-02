class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)-> a[1]-b[1]
        );
        pq.add(new int[]{0,0});

        int edgesUsed= 0;
        int res=0;

        while(edgesUsed < n){
            int[] temp=pq.poll();
            int node= temp[0];
            int nodeDist= temp[1];

            if(visited[node]) continue;

            visited[node]=true;
            res+=nodeDist;

            for(int next=0;next<n;next++){
                if(!visited[next]){
                    // my x - coordinates are node=>points[node] x1,y1
                    int x1 = points[node][0];
                    int y1 = points[node][1];

                    // my y-coordinates are next=>points[next]
                    int x2 = points[next][0];
                    int y2 = points[next][1];

                    int cost = Math.abs(x1-x2)+ Math.abs(y1-y2);

                    pq.add(new int[]{next,cost});
                }
            }
            edgesUsed++;
        }
        return res;
    }
}