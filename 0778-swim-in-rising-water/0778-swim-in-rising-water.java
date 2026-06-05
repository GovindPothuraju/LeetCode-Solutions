class Solution {
    // using pq+ greedy =>dijkstar's
    /*public int swimInWater(int[][] grid) {
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
    }*/

    public int swimInWater(int[][] grid){
        int n = grid.length;

        int l=0;
        int r=n*n;
        int res=0;
        while(l<=r){
            int mid = l +(r-l)/2;
            if(isPossible(mid,grid,n)){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
    private boolean isPossible(int k,int[][]grid,int n){
        boolean[][] visited = new boolean[n][n];
        return backtrack(0,0,grid,k,visited,n);
    }
    private boolean backtrack(int row,int col,int[][] grid,int k,boolean[][] visited,int n){
        if(grid[row][col] > k || visited[row][col]) return false;
        if(row==n-1 && col ==n-1) return true;
        visited[row][col]=true;
        // top 
        if(row >0 && !visited[row-1][col]){
            if(backtrack(row-1,col,grid,k,visited,n)){
                return true;
            }
        }
        //left
        if(col >0 && !visited[row][col-1]){
            if(backtrack(row,col-1,grid,k,visited,n)){
                return true;
            }
        }
        //bottom
        if(row < n-1 && !visited[row+1][col]){
            if(backtrack(row+1,col,grid,k,visited,n)){
                return true;
            }
        }
        //right
        if(col < n-1 && !visited[row][col+1]){
            if(backtrack(row,col+1,grid,k,visited,n)){
                return true;
            }
        }
        return false;
    }
}