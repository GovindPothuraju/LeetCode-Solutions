class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxi=Integer.MIN_VALUE;
        for(int num:nums){
            if(num > maxi){
                maxi=num;
            }
        }
        int n=nums.length;
        int l=0;
        int temp=0;
        long ans=0;
        for(int r=0;r<n;r++){
            if(nums[r]==maxi){
                temp++;
            }
            while(temp >= k){
                if(nums[l] == maxi){
                    temp--;
                }
                l++;
                ans+=n-r;
            }
        }
        return ans;
    }
}