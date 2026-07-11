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
    Boolean[][] dp ;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int i=0;i<n;i++)  sum+=nums[i];
        if(sum%2!=0) return false;

        int target = sum/2;
        dp = new Boolean[n][target+1];
        for(int i=0;i<n;i++){
            if(backtrack(i,target-nums[i],nums)){
                return true;
            }
        }
        return false;
    }
    private boolean backtrack(int st,int sum,int[] nums){
        if(sum == 0)return true;
        if(sum<0)return false;

        if(dp[st][sum] != null) return dp[st][sum];

        for(int i=st+1;i<nums.length;i++){
            if(backtrack(i,sum-nums[i],nums)){
                return dp[st][sum] = true;
            }
        }
        return dp[st][sum] = false;
    }
}