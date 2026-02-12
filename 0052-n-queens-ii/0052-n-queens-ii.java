
class Solution {
    int n;
    int count=0;
    public int totalNQueens(int n) {
        this.n=n;
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }

        backtrack(board,0,new HashSet<>(),new HashSet<>(),new HashSet<>());
        
        return count;
    }
    private void backtrack(char[][] board,int row,HashSet<Integer> colSet,HashSet<Integer> diagSet,HashSet<Integer> antidiagSet){
        if(row==n){
            count++;
            return; 
        }
        for(int col=0;col<n;col++){
            if(colSet.contains(col)|| diagSet.contains(row-col)|| antidiagSet.contains(row+col)){
                continue;
            }
            board[row][col]='Q';
            colSet.add(col);
            diagSet.add(row-col);
            antidiagSet.add(row+col);

            backtrack(board,row+1,colSet,diagSet,antidiagSet);

            board[row][col]='.';
            colSet.remove(col);
            diagSet.remove(row-col);
            antidiagSet.remove(row+col);


        }
    }
}