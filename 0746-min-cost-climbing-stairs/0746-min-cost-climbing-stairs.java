class Solution {
    // top down
    /*int top ;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        top = n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n,dp,cost);
    }
    private int climb(int n,int[] dp,int[] cost){
        if(n<=1) return cost[n];
        if(dp[n] != -1)return dp[n];
        dp[n] = ((n==top)?0:cost[n])+ Math.min(climb(n-1,dp,cost) , climb(n-2,dp,cost));
        return dp[n];
    }*/
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=n;i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1] , dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}