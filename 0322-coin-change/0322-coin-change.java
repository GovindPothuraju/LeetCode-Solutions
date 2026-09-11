class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] temp : dp){
            Arrays.fill(temp,-1);
        }
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int tar=0;tar<=amount;tar++){
            if(tar%coins[0] == 0){
                dp[0][tar] = tar/coins[0];
            }else{
                dp[0][tar] = Integer.MAX_VALUE/2;
            }
        }
        for(int st=1;st<n;st++){
            for(int tar=1;tar<=amount;tar++){
                int notTake = dp[st-1][tar];
                int take = Integer.MAX_VALUE/2;
                if(tar >= coins[st]){
                    take = 1+dp[st][tar-coins[st]];
                }
                dp[st][tar] = Math.min(take,notTake);
            }
        }
        int ans = dp[n-1][amount];
        return ans==Integer.MAX_VALUE/2 ? -1 : ans;
    }
}