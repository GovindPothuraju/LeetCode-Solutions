class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->a[2]-b[2]
        );

        int n=grid.length;
        boolean[][] visited = new boolean[n][n];
        int max = Integer.MIN_VALUE;
        
        pq.add(new int[]{0,0,grid[0][0]});
        while(!pq.isEmpty()){
            int[] temp = pq.poll();

            int row=temp[0];
            int col=temp[1];
            int wt=grid[row][col];

            if(visited[row][col])continue;
            visited[row][col]=true;
            max= Math.max(max,wt);

            if(row==n-1 && col==n-1) return max;

            // top 
            if(row >0 && !visited[row-1][col]){
                pq.add(new int[]{row-1,col,grid[row-1][col]});
            }
            //left
            if(col >0 && !visited[row][col-1]){
                pq.add(new int[]{row,col-1,grid[row][col-1]});
            }
            //bottom
            if(row < n-1 && !visited[row+1][col]){
                pq.add(new int[]{row+1,col,grid[row+1][col]});
            }
            //right
            if(col < n-1 && !visited[row][col+1]){
                pq.add(new int[]{row,col+1,grid[row][col+1]});
            }
        }
        return max;
    }
}