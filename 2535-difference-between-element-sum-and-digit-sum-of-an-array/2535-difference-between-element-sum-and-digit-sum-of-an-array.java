class Solution {
    public int differenceOfSum(int[] nums) {
        int n=nums.length;
        int  ele_sum=0;
        int digi_sum=0;
        for(int i=0;i<n;i++){
            ele_sum+=nums[i];
        }
        System.out.println(ele_sum);
        for(int i=0;i<n;i++){
            if(nums[i]<10){
                digi_sum+=nums[i];
            }else{
                int sum=getsum(nums[i]);
                digi_sum+=sum;
            }
        }
        System.out.println(digi_sum);
        if(ele_sum==digi_sum) return 0;
        else if(ele_sum>digi_sum) return ele_sum-digi_sum;
        else return digi_sum-ele_sum;
    }
    private static int getsum(int a){
        int sum=0;
        while(a>0){
            int x=a%10;
            sum+=x;
            a=a/10;
        }
        return sum;
    }
}