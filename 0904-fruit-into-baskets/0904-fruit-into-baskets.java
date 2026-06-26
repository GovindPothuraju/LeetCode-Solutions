class Solution {
    public int totalFruit(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums.length;
        int l=0;
        int max=0;
        for(int r=0;r<n;r++){
            int key = nums[r];
            hm.put(key,hm.getOrDefault(key,0)+1);
            while(hm.size() > 2){
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l]) == 0){
                    hm.remove(nums[l]);
                }
                l++;
            }
            if(hm.size()<=2){
                max=Math.max(max,r-l+1);
            }
        }
        return max;
    }
}