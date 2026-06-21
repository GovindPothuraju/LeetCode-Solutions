class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n==1)return matrix[0][0];
        int res = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                //top
                int top = i>0 ? matrix[i-1][j] : Integer.MAX_VALUE;
                // left diag
                int leftDiag = i>0 && j>0 ? matrix[i-1][j-1] : Integer.MAX_VALUE;
                //right diag
                int rightDiag = i>0 && j<n-1 ? matrix[i-1][j+1] : Integer.MAX_VALUE;

                int min = Math.min(top,Math.min(leftDiag,rightDiag));
                matrix[i][j] += min;

                if(i==n-1){
                    res = Math.min(res,matrix[n-1][j]);
                }
            }
        }
        return res;
    }
}