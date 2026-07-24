// class Solution {
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) {
//             sum += num;
//         }
//         if (sum % 2 != 0)
//             return false;
//         int target = sum/2;
//         int[][] dp = new int[n][target + 1];
//         for (int[] temp : dp) {
//             Arrays.fill(temp, -1);
//         }
//         return backtrack(n - 1, nums, target, dp);
//     }

//     private boolean backtrack(int st, int[] arr, int target, int[][] dp) {
//         if (target == 0)
//             return false;
//         if (st == 0)
//             return arr[st] == target;

//         if (dp[st][target] != -1)
//             return dp[st][target] == 1 ? true : false;
//         boolean notTake = backtrack(st - 1, arr, target, dp);
//         boolean take = false;
//         if (target >= arr[st]) {
//             take = backtrack(st - 1, arr, target - arr[st], dp);
//         }
//         dp[st][target] = take || notTake ? 1 : 0;
//         return take || notTake;
//     }
// }

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum/2;
        boolean[][] dp = new boolean[n][target + 1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=target)dp[0][nums[0]]=true;
        for(int st=1;st<n;st++){
            for(int tar=1;tar<=target;tar++){
                boolean notTake = dp[st-1][tar];
                boolean take = false;
                if (tar >= nums[st]) {
                    take = dp[st-1][tar-nums[st]];
                }
                dp[st][tar] = take || notTake;
            }
        }
        return dp[n-1][target];
    }
}