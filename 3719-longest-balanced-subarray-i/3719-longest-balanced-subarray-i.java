class Solution {
    public int longestBalanced(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer> even=new HashMap<>();
            HashMap<Integer,Integer> odd=new HashMap<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0){
                    even.put(nums[j],even.getOrDefault(nums[j],0)+1);
                }else{
                    odd.put(nums[j],odd.getOrDefault(nums[j],0)+1);
                }
                if(even.size()==odd.size()){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}