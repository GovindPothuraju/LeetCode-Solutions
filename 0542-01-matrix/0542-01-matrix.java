class Solution {
    /*public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    boolean[][] visited = new boolean[n][m];
                    res[i][j] = backtrack(i, j, mat, visited, res);
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }
    
    private int backtrack(int row, int col, int[][] mat, boolean[][] visited, int[][] res) {
        // Memoization check
        if (visited[row][col]) return res[row][col];
        
        visited[row][col] = true;
        
        // Base case: found 0
        if (mat[row][col] == 0) {
            res[row][col] = 0;
            return 0;
        }
        
        int top = Integer.MAX_VALUE, bottom = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        
        // Top
        if (row > 0) top = backtrack(row - 1, col, mat, visited, res);
        // Left  
        if (col > 0) left = backtrack(row, col - 1, mat, visited, res);
        // Bottom
        if (row < mat.length - 1) bottom = backtrack(row + 1, col, mat, visited, res);
        // Right
        if (col < mat[0].length - 1) right = backtrack(row, col + 1, mat, visited, res);
        
        int min = Math.min(Math.min(top, left), Math.min(bottom, right));
        res[row][col] = (min == Integer.MAX_VALUE) ? Integer.MAX_VALUE : min + 1;
        return res[row][col];
    }*/

    public int[][] updateMatrix(int[][] mat) {
        // caluculate values m,n
        int n=mat.length;
        int m=mat[0].length;

        boolean[][] visited=new boolean[n][m];
        int[][] res=new int[n][m];
        Queue<int[]> q=new LinkedList<>();

        // initialize res;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visited[i][j]=true;
                    q.add(new int[]{i,j,0});
                    res[i][j]=0;
                }else{
                    res[i][j]=-1;
                }
            }
        }
        while(!q.isEmpty()){
            int N=q.size();
            for(int i=0;i<N;i++){
                int[] temp=q.poll();
                int row=temp[0];
                int col=temp[1];
                int val=temp[2];
                //top
                if(row > 0 && !visited[row-1][col]){
                    visited[row-1][col]=true;
                    res[row-1][col]=val+1;
                    q.add(new int[]{row-1,col,res[row-1][col]});
                }
                // left
                if(col>0 && !visited[row][col-1]){
                    visited[row][col-1]=true;
                    res[row][col-1]=val+1;
                    q.add(new int[]{row,col-1,res[row][col-1]});
                }
                // bottom
                if(row<n-1 && !visited[row+1][col]){
                    visited[row+1][col]=true;
                    res[row+1][col]=val+1;
                    q.add(new int[]{row+1,col,res[row+1][col]});
                }
                //right
                if(col<m-1 && !visited[row][col+1]){
                    visited[row][col+1]=true;
                    res[row][col+1]=val+1;
                    q.add(new int[]{row,col+1,res[row][col+1]});
                }
            }
        }

        return res;
    }
}