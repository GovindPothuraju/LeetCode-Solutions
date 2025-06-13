class Solution {
    public void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        HashSet<Integer> rowset= new HashSet<>();
        HashSet<Integer> colset= new HashSet<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }

        for(int i:rowset){
            for(int j=0;j<col;j++){
                matrix[i][j]=0;
            }
        }

        for(int j:colset){
            for(int i=0;i<row;i++){
                matrix[i][j]=0;
            }
        }
    }
}