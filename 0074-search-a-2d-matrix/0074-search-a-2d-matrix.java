class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m=mat.length;
        int n=mat[0].length;
        int l=0;
        int r=n*m-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int row=mid/n;
            int col=mid%n;
            int midvalue=mat[row][col];
            if(midvalue == target) return true;
            else if(midvalue<target) l=mid+1;
            else r=mid-1; 
        }
        return false;
    }
}