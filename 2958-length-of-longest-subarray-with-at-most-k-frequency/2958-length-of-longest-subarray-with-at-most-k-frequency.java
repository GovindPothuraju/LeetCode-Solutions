class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        int ans=0;
        int temp=0;
        int l=0;
        for(int r=0;r<n;r++){
            int key=nums[r];
            hm.put(key,hm.getOrDefault(key,0)+1);
            while(hm.get(key) > k){
                int key1=nums[l];
                hm.put(key1,hm.get(key1)-1);
                if(hm.get(key1) == 0){
                    hm.remove(key1);
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}