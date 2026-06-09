class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Long max = Long.MIN_VALUE;
        Long min = Long.MAX_VALUE;
        int n = nums.length;

        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }

        long ans = (max-min)*k;
        return ans;
    }
}