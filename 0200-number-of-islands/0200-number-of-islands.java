class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    backtrack(i,j,n,m,grid);
                }
            }
        }
        return count;
    }
    private void backtrack(int row,int col,int n,int m,char[][] grid){
        grid[row][col]='0';
        //top
        if(row>0 && grid[row-1][col]=='1'){
            backtrack(row-1,col,n,m,grid);
        }
        // left
        if(col>0 && grid[row][col-1]=='1'){
            backtrack(row,col-1,n,m,grid);
        }
        // bottom
        if(row<n-1 && grid[row+1][col]=='1'){
            backtrack(row+1,col,n,m,grid);
        }
        // right
        if(col<m-1 && grid[row][col+1]=='1'){
            backtrack(row,col+1,n,m,grid);
        }
    }
}