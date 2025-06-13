class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max=0;
        int row=mat.length;
        int col=mat[0].length;
        int[] res=new int[2];
        for(int i=0;i<row;i++){
            int count=0;
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count>max){
                res[0]=i;
                res[1]=count;
                max=count;
            }
        }
        return res;
    }
}