class Solution {
    public int maxProduct(int[] nums) {
        int result=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int mul=1;
            for(int j=i;j<n;j++){
                mul*=nums[j];
                result=Math.max(result,mul);
            }

        }
        return result;
    }
}