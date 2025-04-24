class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                continue;
            }else{
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != 1){
                continue;
            }else{
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != 2){
                continue;
            }else{
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }
}