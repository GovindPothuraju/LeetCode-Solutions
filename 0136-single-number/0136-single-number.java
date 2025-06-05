class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int key=nums[i];
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        for(int num:hm.keySet()){
            if(hm.get(num) == 1){
                ans=num;
                break;
            }
        }
        return ans;
    }
}