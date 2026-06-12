class Solution {
    int top ;
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
    }
}