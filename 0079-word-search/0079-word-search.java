class Solution {
     boolean res=false;
     int n;
     int m;
    public boolean exist(char[][] board, String word) {

        n=board.length;
        m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    backtrack(i,j,1,word,board);
                }
            }
        }
        return res;
    }
    private void backtrack(int x,int y,int nextIndex,String word,char[][] board){
        if(nextIndex==word.length()){
            res=true;
            return;
        }
        
        char temp= board[x][y];
        board[x][y]='#';
        //top
        if(x>0 && board[x-1][y]==word.charAt(nextIndex)){
            backtrack(x-1,y,nextIndex+1,word,board);
        }
        //bottom
        if(x<n-1 && board[x+1][y]==word.charAt(nextIndex)){
            backtrack(x+1,y,nextIndex+1,word,board);
        }
        //left
        if(y>0 && board[x][y-1]==word.charAt(nextIndex)){
            backtrack(x,y-1,nextIndex+1,word,board);
        }
        //right
        if(y<m-1 && board[x][y+1]==word.charAt(nextIndex)){
            backtrack(x,y+1,nextIndex+1,word,board);
        }
        board[x][y]=temp;
    }
}