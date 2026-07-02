class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int toatlHealth) {
        // initilaize
        int n = grid.size();
        int m = grid.get(0).size();
        // take min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->b[2]-a[2]
        );
        int[][] best = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(best[i],-1);
        }
        int start = toatlHealth - grid.get(0).get(0);
        pq.add(new int[]{0, 0, start});
        best[0][0] = start;
        //traverse until pq.is not empty;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int row = temp[0];
            int col = temp[1];
            int health = temp[2];
            System.out.println(row+" "+col+" "+health);

            //base condition is
            if(health <= 0) continue;
            if(row==n-1 && col==m-1 )return true;
            if (health < best[row][col]) continue;
             // top
            if (row > 0) {
                int tempHealth = health - grid.get(row - 1).get(col);
                if (tempHealth > best[row - 1][col]) {
                    best[row - 1][col] = tempHealth;
                    pq.add(new int[]{row - 1, col, tempHealth});
                }
            }

            // left
            if (col > 0) {
                int tempHealth = health - grid.get(row).get(col - 1);
                if (tempHealth > best[row][col - 1]) {
                    best[row][col - 1] = tempHealth;
                    pq.add(new int[]{row, col - 1, tempHealth});
                }
            }

            // bottom
            if (row < n - 1) {
                int tempHealth = health - grid.get(row + 1).get(col);
                if (tempHealth > best[row + 1][col]) {
                    best[row + 1][col] = tempHealth;
                    pq.add(new int[]{row + 1, col, tempHealth});
                }
            }

            // right
            if (col < m - 1) {
                int tempHealth = health - grid.get(row).get(col + 1);
                if (tempHealth > best[row][col + 1]) {
                    best[row][col + 1] = tempHealth;
                    pq.add(new int[]{row, col + 1, tempHealth});
                }
            }
        }
        return false;
    }
}