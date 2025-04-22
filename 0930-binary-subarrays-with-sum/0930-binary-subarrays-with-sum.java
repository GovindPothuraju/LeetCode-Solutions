class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    private int atmost(int[] nums, int goal){
        int n=nums.length;
        int l=0;
        int temp=0;
        int ans=0;
        for(int r=0;r<n;r++){
            temp+=nums[r];
            while(temp>goal && l<=r){
                temp-=nums[l];
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}