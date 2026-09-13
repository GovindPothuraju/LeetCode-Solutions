class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;

        int total = 0;
        for(int num:nums){
            total+=num;
        }
        if(Math.abs(target) > total) return 0;
        if(total-target < 0)return 0;
        if((total-target)%2 != 0)return 0;

        int s2 = (total-target)/2;
        int[][] dp = new int[n][s2+1];
        
 
        // base case - 1 (fill all first column 1)
        if(nums[0]==0){
            dp[0][0]=2;
        }else {
            dp[0][0]=1;
        }
        // base case -2 (if first element is 0)
        if(nums[0] == 0){
            dp[0][0] = 2;
        }

        // base case - 3 (arr[st]==target)retur 1
        if(nums[0]!=0 && nums[0]<= s2){
            dp[0][nums[0]]=1;
        }

        for(int st=1;st<n;st++){
            for(int tar=0;tar<=s2;tar++){
                int notTake = dp[st-1][tar];
                int take = 0;
                if(tar>=nums[st]){
                    take = dp[st-1][tar-nums[st]];
                }
                dp[st][tar] = (take+notTake)%mod;
            }
        }
        return dp[n-1][s2]%mod;
    }
}