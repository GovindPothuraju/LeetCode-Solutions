/*class Solution {
    boolean res = false;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int half = sum/2;
        if(sum%2!=0){
            return false;
        }
        for(int i=0;i<n;i++){
            if(backtrack(i,half-nums[i],nums)){
                return true;
            }
        }
        return false;
    }
    private boolean backtrack(int st,int sum,int[] nums){
        if(sum == 0)return true;
        if(sum<0)return false;

        for(int i=st+1;i<nums.length;i++){
            if(backtrack(i,sum-nums[i],nums)){
                return true;
            }
        }
        return false;
    }
}*/

// uisng dp
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i=0;i<n;i++)  sum+=nums[i];
        if(sum%2!=0) return false;

        int target = sum/2;

        int[][] dp = new int[n][target+1];
        for(int[] temp : dp){
            Arrays.fill(temp,-1);
        }
        return backtrack(n-1,target,nums,dp);
    }
    private boolean backtrack(int st,int target,int[] nums,int[][] dp){
        if(target == 0)return true;
        if(st == 0)return nums[0]==target;

        if(dp[st][target] != -1) return dp[st][target]==0?false:true;

        boolean notTaken = backtrack(st-1,target,nums,dp);
        boolean taken = false;
        if(target >= nums[st]){
            taken = backtrack(st-1,target-nums[st],nums,dp);
        }
        dp[st][target] = taken || notTaken ? 1 : 0;
         return dp[st][target]==0?false:true;
    }
}