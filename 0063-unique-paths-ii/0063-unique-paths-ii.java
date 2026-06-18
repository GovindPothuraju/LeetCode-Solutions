class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];
        if(obstacleGrid[0][0] != 1){
            dp[0][0] = 1;
        }else{
            dp[0][0] = 0;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0 && obstacleGrid[i][j]!=1 && obstacleGrid[i-1][j]!=1){
                    dp[i][j] += dp[i-1][j];
                }
                if(j>0 && obstacleGrid[i][j]!=1 && obstacleGrid[i][j-1]!=1){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}