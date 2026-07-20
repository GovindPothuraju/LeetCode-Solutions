class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans.get(i).add(0);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val =((i*m+j)+k)%(n*m);
                int tempRow = val/m;
                int tempCol = val%m;
                ans.get(tempRow).set(tempCol,grid[i][j]);
            }
        }
        return ans;
    }
}