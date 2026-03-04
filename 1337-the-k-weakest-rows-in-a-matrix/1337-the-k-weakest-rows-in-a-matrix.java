class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a[1] == b[1]) return b[0] - a[0]; // larger index stronger
                return b[1] - a[1]; // more soldiers stronger
            }
        );
        for(int i=0;i<mat.length;i++){
            int sum=0;
            for(int j=0;j<mat[0].length;j++){
                sum+=mat[i][j];
            }
            pq.add(new int[]{i,sum});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res=new int[pq.size()];
        int i=pq.size()-1;
        while(!pq.isEmpty()){
            res[i--]=pq.poll()[0];
        }
        return res;
    }
}