class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res=Integer.MAX_VALUE;
        int n=nums.length;
        int l=0;
        for(int r=0;r<n;r++){
            if(r-l == k){
                l++;
            }
            if(r-l+1 == k){
            int temp=nums[r]-nums[l];
            res=Math.min(res,temp);}
        }
        return res;
    }
}