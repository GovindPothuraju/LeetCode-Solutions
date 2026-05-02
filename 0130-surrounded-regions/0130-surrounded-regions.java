class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        // ckeck first row  and last row
        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                backtrack(0,j,n,m,board);
            }
            if(board[n-1][j]=='O'){
                backtrack(n-1,j,n,m,board);
            }
        }
        //check first col and last col instead of 2 times
        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                backtrack(i,0,n,m,board);
            }
            if(board[i][m-1]=='O'){
                backtrack(i,m-1,n,m,board);
            }
        }
        // convert 'O'->'X' and 'T'->'O'
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void backtrack(int row,int col,int n,int m,char[][] board){
        board[row][col]='T';
        // top
        if(row>0 && board[row-1][col]=='O'){
            backtrack(row-1,col,n,m,board);
        }
        // left
        if(col>0 && board[row][col-1]=='O'){
            backtrack(row,col-1,n,m,board);
        }
        // bottom
        if(row<n-1 && board[row+1][col]=='O'){
            backtrack(row+1,col,n,m,board);
        }
        // right
        if(col<m-1 && board[row][col+1]=='O'){
            backtrack(row,col+1,n,m,board);
        }
    }
}