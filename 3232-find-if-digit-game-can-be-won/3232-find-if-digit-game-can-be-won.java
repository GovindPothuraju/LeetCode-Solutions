class Solution {
    public boolean canAliceWin(int[] nums) {
        int n=nums.length;
        int alice=0;
        int bob=0;
        for(int i=0;i<n;i++){
            if(nums[i]<10){
                alice+=nums[i];
            }else{
                bob+=nums[i];
            }
        }
        int alice1=Math.max(alice,bob);
        int bob1=Math.min(alice,bob);
        if(alice1>bob1){
            return true;
        }else{
            return false;
        }
    }
}