class Solution {
    public int majorityElement(int[] nums) {
        // solution
        Arrays.sort(nums);
        int n=nums.length/2;
        return nums[n];
    }
}