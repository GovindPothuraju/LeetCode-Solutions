class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();

        int ans = 0;
        int l = 0;
        for(int r=0;r<n;r++){
            int key = nums[r];
            hm.put(key , hm.getOrDefault(key,0)+1);
            while(hm.get(key) > k){
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l]) == 0){
                    hm.remove(nums[l]);
                }
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}