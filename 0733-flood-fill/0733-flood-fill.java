class Solution {
    int n;
    int m;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n=image.length;
        m=image[0].length;
        backtrack(image,sr,sc,color);
        return image;
    }
    private void backtrack(int[][] image,int x,int y,int color){

        int temp=image[x][y];
        image[x][y]=-1;
        //top
        if(x>0 && image[x-1][y]==temp){
            backtrack(image,x-1,y,color);
        }
        //bottom
        if(x<n-1 && image[x+1][y]==temp){
            backtrack(image,x+1,y,color);
        }//left
        if(y>0 && image[x][y-1]==temp){
            backtrack(image,x,y-1,color);
        }
        //right
        if(y<m-1 && image[x][y+1]==temp){
            backtrack(image,x,y+1,color);
        }
        image[x][y]=color;
    }
}