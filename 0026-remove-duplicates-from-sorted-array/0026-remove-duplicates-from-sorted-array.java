class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> hs = new TreeSet<>();
        for(int num : nums)hs.add(num);
        int k=0;
        for(int num :hs){
            nums[k++]=num;
        }
        return hs.size();
    }
}