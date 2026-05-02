class Solution {
    public int numEnclaves(int[][] board) {
        int n=board.length;
        int m=board[0].length;

        Queue<int[]> q=new LinkedList<>();

        // ckeck first row  and last row
        for(int j=0;j<m;j++){
            if(board[0][j]==1){
                q.offer(new int[]{0,j});
                board[0][j]=0;
            }
            if(board[n-1][j]==1){
                q.offer(new int[]{n-1,j});
                board[n-1][j]=0;
            }
        }
        //check first col and last col instead of 2 times
        for(int i=0;i<n;i++){
            if(board[i][0]==1){
                q.offer(new int[]{i,0});
                board[i][0]=0;
            }
            if(board[i][m-1]==1){
                q.offer(new int[]{i,m-1});
                board[i][m-1]=0;
            }
        }
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int row=temp[0];
            int col= temp[1];

            if(row>0 && board[row-1][col]==1){
                q.offer(new int[]{row-1,col});
                board[row-1][col]=0;
            }
            // left
            if(col>0 && board[row][col-1]==1){
                q.offer(new int[]{row,col-1});
                board[row][col-1]=0;
            }
            // bottom
            if(row<n-1 && board[row+1][col]==1){
                q.offer(new int[]{row+1,col});
                board[row+1][col]=0;
            }
            // right
            if(col<m-1 && board[row][col+1]==1){
                q.offer(new int[]{row,col+1});
                board[row][col+1]=0;
            }
        }
        int count=0;
        // after convert all 1 to 0 which are visited then count no.of 1's remaining
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}