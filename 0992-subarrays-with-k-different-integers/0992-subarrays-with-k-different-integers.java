class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return ispossible(nums,k)-ispossible(nums,k-1);
    }
    private int ispossible(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int ans=0,l=0;
        for(int r=0;r<n;r++){
            int key = nums[r];
            hm.put(key,hm.getOrDefault(key,0)+1);
            while(hm.size() > k){
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l]) == 0){
                    hm.remove(nums[l]);
                }
                l++;
            }
            ans+=r-l+1;
        }
        return ans;
    }
}