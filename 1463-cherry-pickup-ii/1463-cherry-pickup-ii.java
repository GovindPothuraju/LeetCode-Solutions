// using recursion

/*class Solution {
    int n,m;
    public int cherryPickup(int[][] grid) {
        // Your code goes here
        this.n = grid.length;
        this.m = grid[0].length;

        return backtrack(0,0,m-1,grid);
    }
    private int backtrack(int row,int c1,int c2,int[][] grid){
        // base condition for columns
        if(c1<0 || c1>=m || c2<0 || c2>=m){
            return -(int)1e9;
        }
        // base condition for rows
        if(row == n-1){
            // both columns at same 
            if(c1==c2){
                return grid[row][c1];
            }else{
                return grid[row][c1]+grid[row][c2];
            }
        }

        // current value
        int current;
        if(c1==c2){
            current = grid[row][c1];
        }else{
            current = grid[row][c1]+grid[row][c2];
        }
        int best = -(int)1e9;
        // check for all 9 possibilites
        for(int val1=-1 ; val1<=1; val1++){
            for(int val2=-1; val2<=1 ; val2++){
                int newCol1 = c1+val1;
                int newCol2 = c2+val2;

                int newRow = row+1;
                //maximize best amonog 9
                best = Math.max(best, current + backtrack(newRow,newCol1,newCol2,grid));
            }
        }
        return best;
    }
}*/

class Solution {
    int n,m;
    public int cherryPickup(int[][] grid) {
        // Your code goes here
        this.n = grid.length;
        this.m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return backtrack(0,0,m-1,grid,dp);
        
    }
    private int backtrack(int row,int c1,int c2,int[][] grid,int[][][] dp){
        // base condition for columns
        if(c1<0 || c1>=m || c2<0 || c2>=m){
            return -(int)1e9;
        }
        // base condition for rows
        if(row == n-1){
            // both columns at same 
            if(c1==c2){
                return grid[row][c1];
            }else{
                return grid[row][c1]+grid[row][c2];
            }
        }
        if(dp[row][c1][c2] != -1)return dp[row][c1][c2];
        // current value
        int current;
        if(c1==c2){
            current = grid[row][c1];
        }else{
            current = grid[row][c1]+grid[row][c2];
        }
        int best = -(int)1e9;
        // check for all 9 possibilites
        for(int val1=-1 ; val1<=1; val1++){
            for(int val2=-1; val2<=1 ; val2++){
                int newCol1 = c1+val1;
                int newCol2 = c2+val2;

                int newRow = row+1;
                //maximize best amonog 9
                best = Math.max(best, current + backtrack(newRow,newCol1,newCol2,grid,dp));
            }
        }
        return dp[row][c1][c2] = best;
    }
}