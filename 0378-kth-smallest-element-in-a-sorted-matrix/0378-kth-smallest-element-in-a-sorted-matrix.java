class Solution {
    // 1) approach 0 (n^2 log n)
    // public int kthSmallest(int[][] matrix, int k) {
    //     int n=matrix.length;
    //     int m=matrix[0].length;
    //     PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<m;j++){
    //             pq.add(matrix[i][j]);
    //             if(pq.size()>k){
    //                 pq.poll();
    //             }
    //         }
    //     }
    //     System.out.println(pq);
    //     return pq.peek();
    // }
    // 2.optimal and less than n^2
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        //put all my first values in my pq
        int n=matrix.length;
        for(int i=0;i<n;i++){
            pq.add(new int[]{matrix[i][0],i,0});
        }

        // get one by one find the min value in pq and increase count till k
        for(int count=0;count<k-1;count++){
            int[] temp=pq.poll();
            int val=temp[0];
            int row=temp[1];
            int col=temp[2];
            if(col+1 < n){
                pq.add(new int[]{matrix[row][col+1],row,col+1});
            }
        }
        return pq.peek()[0];
    }

}