class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap <Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        for(int i=0 ;i<n ; i++){
            int key=nums[i];
            if(hm.containsKey(key)){
                int prev=hm.get(key);
                if(i-prev <= k){
                    return true;
                }
            }
            hm.put(key,i);
        }
        return false;
    }
}