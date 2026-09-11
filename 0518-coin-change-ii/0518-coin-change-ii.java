class Solution {
    int mod = (int)1e9;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return backtrack(n-1,coins,amount,dp);
    }
    private int backtrack(int st,int[] coins,int target,int[][] dp){
        if(target==0){
            return dp[st][target]= 1;
        }
        if(st==0){
            if(target%coins[st] == 0){
                return  dp[st][target]=1;
            }
            return  dp[st][target]=0;
        }
        if( dp[st][target] != -1){
            return dp[st][target];
        }
        int notTake = backtrack(st-1,coins,target,dp);
        int take = 0;
        if(target>=coins[st]){
            take = backtrack(st,coins,target-coins[st],dp);
        }
        return dp[st][target]=(take+notTake);
    }
}