class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    public int atMost(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int temp=0;
        int ans=0;
        for(int r=0;r<n;r++){
            if(nums[r]%2 != 0){
                temp++;
            }
            while(temp>k){
                if(nums[l]%2 != 0){
                    temp--;
                }
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}