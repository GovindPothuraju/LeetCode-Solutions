class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int l=0;
        double max = Integer.MIN_VALUE;
        int sum=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            if(r-l == k){
                sum-=nums[l];
                l++;
            }
            if(r-l+1 == k){
                max = Math.max(max,(double)sum/k);
            }
        }
        return max;
    }
}