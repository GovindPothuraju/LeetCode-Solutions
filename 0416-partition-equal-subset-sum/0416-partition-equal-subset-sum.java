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
        int[][] dp = new int[n][target + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return backtrack(n - 1, nums, target, dp);
    }

    private boolean backtrack(int st, int[] arr, int target, int[][] dp) {
        if (target == 0)
            return false;
        if (st == 0)
            return arr[st] == target;

        if (dp[st][target] != -1)
            return dp[st][target] == 1 ? true : false;
        boolean notTake = backtrack(st - 1, arr, target, dp);
        boolean take = false;
        if (target >= arr[st]) {
            take = backtrack(st - 1, arr, target - arr[st], dp);
        }
        dp[st][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}