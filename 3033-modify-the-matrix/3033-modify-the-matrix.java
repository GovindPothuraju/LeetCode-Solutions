class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] col=new int[m];
        for(int j=0;j<m;j++){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<n;i++){
                max=Math.max(max,matrix[i][j]);
            }
            for(int i=0;i<n;i++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=max;
                }
            }
        }
        return matrix;
    }
}