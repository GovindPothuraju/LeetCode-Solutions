/*class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans=Integer.MAX_VALUE;
        // build adjacency list
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] temp:flights){
            int from=temp[0];
            int to=temp[1];
            int price=temp[2];
            adj.get(from).add(new int[]{to,price});
        }

        // take a res array initally all are infinity
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(i==src)res[i]=0;
            else res[i]=Integer.MAX_VALUE;
        }


        // Take priorityQueue with node,dist,stops
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->a[1]-b[1]
        );
        pq.add(new int[]{src,0,0});

        while(!pq.isEmpty()){
            // pq contains node,distance,stops
            // from node to all neighbours
            int temp[]=pq.poll();
            int node=temp[0];
            int fromDist=temp[1];
            int stops=temp[2];
            
            if(stops>k)continue; 

            for(int[] nei:adj.get(node)){
                // each neightbour to,dist
                int to=nei[0];
                int toDist=nei[1];

                // if my to ==des then the stops must be equals to k 
                if(to==dst){
                    ans=Math.min(ans,fromDist+toDist);
                }

                // check dijakstras condition
                if(res[to] > fromDist+toDist){
                    res[to]=fromDist+toDist;
                    pq.add(new int[]{to,fromDist+toDist,stops+1});
                }
            }
        }
        return ans;
    }
}*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // build adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] temp : flights) {
            int from = temp[0];
            int to = temp[1];
            int price = temp[2];
            adj.get(from).add(new int[]{to, price});
        }

        // dist[node] = minimum cost to reach node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // {node , cost , stops}
        // use level order traversal because at each level my stops increse one by one when i go beyond k then stop the process
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int node = temp[0];
            int cost = temp[1];
            int stops = temp[2];

            // cannot go beyond k stops
            if (stops > k) continue;

            for (int[] nei : adj.get(node)) {
                int to = nei[0];
                int price = nei[1];
                if (dist[to] > cost + price ) {
                    dist[to] = cost + price;
                    q.add(new int[]{to, cost + price, stops + 1});
                }
            }
        }
        // if i can't reach the destination
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }

        return dist[dst];
    }
}