class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        //take a maximum matrix
        int[][] res= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j]=Integer.MAX_VALUE;
            }
        }
        res[0][0]=0;
        // take priority Queue and push initial 0,0,0 row,col,maxdiff
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->a[2]-b[2]
        );

        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int row=temp[0];
            int col=temp[1];
            int maxDiff=temp[2];

            if(row==n-1 && col==m-1)return maxDiff;

            // check all 4 directions and if any two values diff is less that the maxDiff then update with maxDiff and push to q

            // top
            if(row>0){
                //everytime caluculate new efforst which max of diff of two elemnts and popped maxdiff
                int newEffort=Math.max(Math.abs(heights[row][col]-heights[row-1][col]),maxDiff);
                if(res[row-1][col] > newEffort){
                    res[row-1][col]=newEffort;
                    pq.add(new int[]{row-1,col,newEffort});
                }
            }
            // left
            if(col>0){
                //everytime caluculate new efforst which max of diff of two elemnts and popped maxdiff
                int newEffort=Math.max(Math.abs(heights[row][col]-heights[row][col-1]),maxDiff);
                if(res[row][col-1] > newEffort){
                    res[row][col-1]=newEffort;
                    pq.add(new int[]{row,col-1,newEffort});
                }
            }
            // right
            if(col<m-1){
                //everytime caluculate new efforst which max of diff of two elemnts and popped maxdiff
                int newEffort=Math.max(Math.abs(heights[row][col]-heights[row][col+1]),maxDiff);
                if(res[row][col+1] > newEffort){
                    res[row][col+1]=newEffort;
                    pq.add(new int[]{row,col+1,newEffort});
                }
            }
            // bottom
            if(row<n-1){
                //everytime caluculate new efforst which max of diff of two elemnts and popped maxdiff
                int newEffort=Math.max(Math.abs(heights[row][col]-heights[row+1][col]),maxDiff);
                if(res[row+1][col] > newEffort){
                    res[row+1][col]=newEffort;
                    pq.add(new int[]{row+1,col,newEffort});
                }
            }
        }
        return 0;
    }
}