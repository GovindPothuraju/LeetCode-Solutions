class Solution {
    public int maxAscendingSum(int[] nums) {
        int res=nums[0];
        int max=res;
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1] < nums[i]){
                res+=nums[i];
            }else{
                res=nums[i];
            }
            max=Math.max(max,res);
        }
        return max;
    }
}