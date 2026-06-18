/*class Solution {
    // i used backtracking but the time compleity is crossed that's why i used a simple formula
    // int m;
    // int n;
    // int count;
    // public int uniquePaths(int m, int n) {
    //     this.m=m;
    //     this.n=n;
    //     backtrack(0,0);
    //     return count;
    // }
    // private void backtrack(int x,int y){
    //     if(x==m-1 && y==n-1){
    //         count++;
    //         return;
    //     }
    //     //bottm
    //     if(x<m-1){
    //         backtrack(x+1,y);
    //     }
    //     //right
    //     if(y<n-1){
    //         backtrack(x,y+1);
    //     }
    // }
    //  public int uniquePaths(int m, int n) {
    //     int total = m + n - 2;
    //     int r = Math.min(m - 1, n - 1);

    //     long result = 1;

    //     for (int i = 1; i <= r; i++) {
    //         result = result * (total - r + i) / i;
    //     }

    //     return (int) result;
    // }

    

}*/

class Solution {
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0){
                    dp[i][j]+=dp[i-1][j];
                }
                if(j>0){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}