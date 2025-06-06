class Solution {
    public int majorityElement(int[] nums) {
        // solution
       /* Arrays.sort(nums);
        int n=nums.length/2;
        return nums[n];*/
        int freq=0;
        int ans=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(freq==0){
                ans=nums[i];
            }
            if(ans==nums[i]){
                freq++;
            }else{
                freq--;
            }
        }
        return ans;
    }
}