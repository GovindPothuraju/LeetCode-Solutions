class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    continue;
                }
                int top = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0){
                    top = grid[i-1][j];
                }
                if(j>0){
                    left = grid[i][j-1];
                }
                grid[i][j] = grid[i][j]+Math.min(top,left);
            }
        }
        return grid[n-1][m-1];
    }
}