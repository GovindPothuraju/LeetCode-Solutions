class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        // if i take 0
        int a=nums[0];
        int b=Math.max(nums[0],nums[1]);
        int temp1 = maxRob(2,n-2,nums,a,b);
        if(n<3) return temp1;
        // if i take 1
        a=nums[1];
        b=Math.max(nums[1],nums[2]);
        int temp2 = maxRob(3,n-1,nums,a,b);
        return Math.max(temp1,temp2);
    }
    private int maxRob(int st,int end,int[] nums,int a,int b){
        int c= Math.max(a,b);
        for(int i=st;i<=end;i++){
            c=Math.max(nums[i]+a , b);
            a=b;
            b=c;
        }
        return c;
    }
}