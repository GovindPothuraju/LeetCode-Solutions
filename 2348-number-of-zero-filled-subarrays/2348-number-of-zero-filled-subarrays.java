class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n=nums.length;
        int l=0;
        long ans=0;
        for(int r=0;r<n;r++){
            if(nums[r] != 0){
                l=r+1;
            }else{
                ans+=r-l+1;
            }
        }
        return ans;
    }
}