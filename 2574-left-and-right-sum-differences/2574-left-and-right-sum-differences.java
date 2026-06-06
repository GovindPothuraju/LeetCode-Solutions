class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++){
            
            if(i==0){
                left[i]=0;
                right[n-i-1]=0;
            }else{
                left[i] = left[i-1]+nums[i-1];
                right[n-i-1] = right[n-i]+nums[n-i];
            }

        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=Math.abs(left[i]-right[i]);
        }
        return res;
    }
}