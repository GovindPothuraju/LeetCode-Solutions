class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        HashMap <Integer,Integer> macha=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key=nums[i];
            macha.put(key,macha.getOrDefault(key,0)+1);
        }
        for(int val:macha.keySet()){
            int x=macha.get(val);
            if(x>1){
                count+=((x*(x-1))/2);
            }
        }
        return count;
    }
}