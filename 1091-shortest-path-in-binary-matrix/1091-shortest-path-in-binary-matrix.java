class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0)return -1;

        Queue<int[]> q=new LinkedList<>();
        int n=grid.length;

        q.offer(new int[]{0,0,1});

        while(q.size()>0){
            int[] temp=q.poll();
            int row=temp[0];
            int col=temp[1];
            int weight=temp[2];


            if(row==n-1 && col==n-1)return weight;
            
            // left
            if(col>0 && grid[row][col-1]==0){
                grid[row][col-1]=1;
                q.offer(new int[]{row,col-1,weight+1});
            }
            //right
            if(col<n-1 && grid[row][col+1]==0){
                grid[row][col+1]=1;
                q.offer(new int[]{row,col+1,weight+1});
            }
            //bottom
            if(row<n-1 && grid[row+1][col]==0){
                grid[row+1][col]=1;
                q.offer(new int[]{row+1,col,weight+1});
            }
            // top
            if(row>0 && grid[row-1][col]==0){
                grid[row-1][col]=1;
                q.offer(new int[]{row-1,col,weight+1});
            }
            // top left
            if(row>0 && col>0 && grid[row-1][col-1]==0){
                grid[row-1][col-1]=1;
                q.offer(new int[]{row-1,col-1,weight+1});
            }
            // top right
            if(row>0 && col<n-1 && grid[row-1][col+1]==0){
                grid[row-1][col+1]=1;
                q.offer(new int[]{row-1,col+1,weight+1});
            }
            // bottom left
            if(row<n-1 && col>0 && grid[row+1][col-1]==0){
                grid[row+1][col-1]=1;
                q.offer(new int[]{row+1,col-1,weight+1});
            }
            // bottom right
            if(row<n-1 && col<n-1 && grid[row+1][col+1]==0){
                grid[row+1][col+1]=1;
                q.offer(new int[]{row+1,col+1,weight+1});
            }
        }
        return -1;
    }
}