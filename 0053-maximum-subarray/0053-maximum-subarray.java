class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int l=0;
        int temp=0;
        int ans=nums[0];
        for(int r=0;r<n;r++){
            temp+=nums[r];
            ans=Math.max(ans,temp);
            if(temp<0){
                temp=0;
            }  
        }
        return ans;
    }
}