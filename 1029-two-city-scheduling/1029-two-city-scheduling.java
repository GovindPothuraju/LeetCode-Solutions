class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(
            (b[1]-b[0])-
            (a[1]-a[0])
        ));
        int n=costs.length/2;
        int res=0;
        for(int i=0;i<n;i++){
            res+=costs[i][0];
            res+=costs[i+n][1];
        }
        return res;
    }
}