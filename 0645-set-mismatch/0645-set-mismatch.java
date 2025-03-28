class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n=nums.length;
        int duplicate=-1,missing=-1;
        for(int i=0;i<n;i++){
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
            }else{
                duplicate=nums[i];
            }
        }
        for(int i=1;i<=n;i++){
            if(!hs.contains(i)){
                missing=i;
            }
        }
        int[] res={duplicate,missing};
        return res;

    }
}