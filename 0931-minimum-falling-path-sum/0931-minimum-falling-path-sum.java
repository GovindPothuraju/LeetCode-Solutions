class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
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
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            min = Math.min(min,matrix[n-1][j]);
        }
        return min;
    }
}