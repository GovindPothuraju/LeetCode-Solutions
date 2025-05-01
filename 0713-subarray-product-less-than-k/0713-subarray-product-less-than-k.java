class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n=nums.length;
        int l=0,p=1;
        int count=0;
            for(int r=0;r<n;r++){
                p*=nums[r];
                while(p>=k && l<=r){
                    p/=nums[l];
                    l++;
                }
                count+=r-l+1;
            }
        return count;
    }
}