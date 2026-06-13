/*class Solution {
    int max = Integer.MIN_VALUE;
    int sum=0;
    public int rob(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            backtrack(i,nums);
        }
        return max;
    }
    private void backtrack(int st,int[] nums){
        sum+=nums[st];
        max=Math.max(max,sum);
        for(int i=st+2;i<nums.length;i++){
            backtrack(i,nums);
        }
        sum-=nums[st];
    }
}*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp =new int[n];
        Arrays.fill(dp,-1);

        for(int i=n-1;i>=0;i--){
            backtrackDP(i,nums,dp);
        }
        return dp[n-1];
    }
    private int backtrackDP(int n,int[] nums,int[] dp){
        if(n<=1){
            if(n==1){
                dp[n]=Math.max(nums[0],nums[1]);
            }else if(n==0){
                dp[n] = nums[0];
            }
            return dp[n];
        }
        if(dp[n] != -1) return dp[n];
        dp[n] = Math.max(nums[n]+backtrackDP(n-2,nums,dp) , backtrackDP(n-1,nums,dp));
        return dp[n];
    }
}