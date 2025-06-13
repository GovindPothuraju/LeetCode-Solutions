class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][]=new int[n][n];
        int count=1;
        int strow=0;
        int stcol=0;
        int endcol=n-1;
        int endrow=n-1;
        while(strow<=endrow && stcol<=endcol){
            //top
            for(int i=stcol;i<=endcol;i++){
                mat[strow][i]=count++;
            }//right
            for(int i=strow+1;i<=endrow;i++){
                mat[i][endcol]=count++;
            }
            //bottom
            for(int i=endcol-1;i>=stcol;i--){
                mat[endrow][i]=count++;
            }
            //left
            for(int i=endrow-1;i>stcol;i--){
                mat[i][stcol]=count++;
            }
            strow++;
            stcol++;
            endrow--;
            endcol--;
        }
        return mat;
    }
}