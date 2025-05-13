class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                count++;
            }
        }
        if(count == 2){
            return "equilateral";
        }else if(count == 1){
            return "isosceles";
        }else{
            return "scalene";
        }
    }
}