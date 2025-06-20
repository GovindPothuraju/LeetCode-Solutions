class Solution {
    public int ispossible(int[] nums,int k){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=k){
                count++;
            }
        }
        return count;
    }
    public int specialArray(int[] nums) {
        int l=0;
        int r=nums.length;
        while(l<=r){
            int mid=l+(r-l)/2;
            int count=ispossible(nums,mid);
            if(count==mid){
                return mid;
            }
            else if(count<=mid){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}