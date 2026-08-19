class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[1]-b[1]
        );

        int[] next = new int[n];
        Arrays.fill(next,-1);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(rains[i] != 0){
                if(hm.containsKey(rains[i])){
                    next[i] = hm.get(rains[i]);
                }
                hm.put(rains[i],i);
            }
            
        }
        int[] res = new int[n];
        HashSet<Integer> full = new HashSet<>();
        for(int i=0;i<n;i++){
            if(rains[i] == 0){
                if(pq.isEmpty()){
                    res[i]=1;
                }else{
                    int[] curr = pq.poll();
                    int lake = curr[0];
                    res[i] = lake;
                    full.remove(lake);
                }
            }else{
                int lake = rains[i];
                if (full.contains(lake)) {
                    return new int[]{};
                }
                full.add(lake);
                if (next[i] != -1) {
                    pq.add(new int[]{lake, next[i]});
                }

                res[i] = -1;
            }
        }
        return res;
    }
}