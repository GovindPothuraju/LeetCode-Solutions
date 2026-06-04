class Solution {
    int[] parent;
    int[] size;
    private int find(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    private void findUnion(int u,int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv)return ;
        
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    public int largestIsland(int[][] grid) {
        int max=Integer.MIN_VALUE;
        int n=grid.length;
        int length= n*n;
        parent = new int[length];
        size = new int[length];

        for(int i=0;i<length;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                
                if(grid[row][col] == 0) continue; 

                int curr = (row * n) + col;
                // top
                if(row>0 && grid[row-1][col] == 1){
                    int top = ((row-1) * n) + col ;
                    findUnion(top ,curr);
                }
                // left
                if(col>0 && grid[row][col-1] == 1){
                    int left = (row * n) + (col-1);
                    findUnion(left ,curr);
                }
                // right
                if(col < n-1 && grid[row][col+1] == 1){
                    int right = (row * n) + (col+1);
                    findUnion(right,curr);
                }
                // bottom
                if(row<n-1 && grid[row+1][col] == 1){
                    int bottom = ((row+1) * n) + col;
                    findUnion(bottom ,curr);
                }
            }
        }
        System.out.println(Arrays.toString(size));
        System.out.println(Arrays.toString(parent));

        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    // take hasset and add all unique neighbours and take all unique neighbous and add all sizes 
                    HashSet<Integer> hs=new HashSet<>();
                    //top
                    if(row>0 && grid[row-1][col]==1){
                        int currNum = ((row-1)*n)+col;
                        hs.add(find(currNum));
                    }
                    //left
                    if(col>0 && grid[row][col-1]==1){
                        int currNum = (row*n)+col-1;
                        hs.add(find(currNum));
                    }
                    //bottom
                    if(row<n-1 && grid[row+1][col]==1){
                        int currNum = ((row+1)*n)+col;
                        hs.add(find(currNum));
                    }
                    //right
                    if(col<n-1 && grid[row][col+1]==1){
                        int currNum = (row*n)+col+1;
                        hs.add(find(currNum));
                    }

                    int sum = 1;
                    for(int num:hs){
                        sum+=size[num];
                    }
                    max=Math.max(max,sum);
                }
            }
        }

        // it gets tle
        /*for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                int[] temp1 = parent.clone();
                int[] temp2 = size.clone();
                if(grid[row][col] == 0){
                    grid[row][col]=1;
                    int curr = (row * n) + col;
                    // top
                    if(row>0 && grid[row-1][col] == 1){
                        int top = ((row-1) * n) + col ;
                        findUnion(top ,curr);
                    }
                    // left
                    if(col>0 && grid[row][col-1] == 1){
                        int left = (row * n) + (col-1);
                        findUnion(left ,curr);
                    }
                    // right
                    if(col < n-1 && grid[row][col+1] == 1){
                        int right = (row * n) + (col+1);
                        findUnion(right,curr);
                    }
                    // bottom
                    if(row<n-1 && grid[row+1][col] == 1){
                        int bottom = ((row+1) * n) + col;
                        findUnion(bottom ,curr);
                    }
                    grid[row][col]=0;
                }
                for(int i=0;i<length;i++){
                    max=Math.max(max,size[i]);
                }
                parent = temp1;
                size = temp2;
            }
        }*/
        return max==Integer.MIN_VALUE ? length : max;
    }
}