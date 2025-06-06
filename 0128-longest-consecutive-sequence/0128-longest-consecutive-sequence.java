class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int n=nums.length,max=0;
        for(int i=0;i<n;i++){
            hs.add(nums[i]);
        }
        for(int num:hs){
            if(!hs.contains(num-1)){
                int cnum=num;
                int cst=1;
                while(hs.contains(cnum+1)){
                    cnum++;
                    cst++;
                }
                max=Math.max(max,cst);
            }
        }
        return max;
    }
}