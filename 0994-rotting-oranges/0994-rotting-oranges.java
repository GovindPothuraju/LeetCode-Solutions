class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int time=0;
        // first add all rottend oranges to my queue
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }
        //mark adj nodes as rotten and push into q until q is not empty
        while(!q.isEmpty()){
            int N=q.size();
            boolean rotted=false;
            for(int i=0;i<N;i++){
                int[] temp=q.poll();
                int row=temp[0];
                int col=temp[1];
                //top
                if(row>0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    q.offer(new int[]{row-1,col});
                    rotted = true;
                }
                //left
                if(col>0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    q.offer(new int[]{row,col-1});
                    rotted = true;
                }
                //bottom
                if(row<n-1 && grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    q.offer(new int[]{row+1,col});
                    rotted = true;
                }
                //right
                if(col<m-1 && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    q.offer(new int[]{row,col+1});
                    rotted = true;
                }
            }
            if(rotted)time++;
        }
        //finally run over each element in check if anyone is remaining then i return -1 otherwise i        return my time
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }
}
