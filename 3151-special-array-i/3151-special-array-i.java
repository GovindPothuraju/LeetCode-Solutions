class Solution {
    public boolean isArraySpecial(int[] nums) {
        Boolean res=false;
        if(nums.length==1){
            res=true;
        }else{
             for(int i=0;i<nums.length-1;i++){
                if((nums[i]%2==0 && nums[i+1]%2!=0)||(nums[i]%2!=0 && nums[i+1]%2==0)){
                    res=true;
                }else{
                    res=false;
                    break;
                }
            }
        }
        return res;
    }
}