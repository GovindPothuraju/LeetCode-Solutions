class Solution {
    // tabulation
    /*public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int top = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
                grid[i][j] += Math.min(top, left);
            }
        }
        return grid[n - 1][m - 1];
    }*/
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp =new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        backtrack(n-1,m-1,grid,dp);
        for(int i=0;i<n;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n-1][m-1];
    }
    private int backtrack(int row,int col,int[][] grid,int[][] dp){
        if(row==0 && col==0){
            return dp[row][col] = grid[row][col];
        }
        if(dp[row][col] != -1) return dp[row][col];
        int top=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;
        if(row>0){
           top =backtrack(row-1,col,grid,dp);
        }
        if(col > 0){
           left= backtrack(row,col-1,grid,dp);
        }
        return dp[row][col]=grid[row][col]+ Math.min(top,left);
    }
}