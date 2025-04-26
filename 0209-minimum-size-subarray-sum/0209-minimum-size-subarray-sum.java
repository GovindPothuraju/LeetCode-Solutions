class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int l=0;
        int temp=0;
        int f=0;
        int ans=Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            temp+=nums[r];
            while(temp>=target){
                ans=Math.min(ans,r-l+1);
                temp-=nums[l];
                l++;
            }
            
        }
        return ans==Integer.MAX_VALUE?0:ans;
        
    }
}