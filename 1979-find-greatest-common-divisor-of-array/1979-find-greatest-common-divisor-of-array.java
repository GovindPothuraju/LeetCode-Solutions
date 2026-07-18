class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        for(int num : nums){
            small = Math.min(small,num);
            large = Math.max(large,num);
        }
        return getGCD(small,large);
    }
    private int getGCD(int a,int b){
        if(b==0)return a;
        return getGCD(b,a%b);
    }
}