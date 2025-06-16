class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key=nums[i];
            hm.put(key,hm.getOrDefault(key,0)+1);
        }
        int res=0;
        for(int num:hm.keySet()){
            if(hm.get(num) == 1){
                res+=num;
            }
        }
        return res;
    }
}