class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int key=nums[i];
            if(!hm.containsKey(key)){
                hm.put(key,hm.getOrDefault(key,0)+1);
            }else{
                return key;
            }
        }
        return 0;
    }
}