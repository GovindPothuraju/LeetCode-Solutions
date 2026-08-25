class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            if(num%k == 0)hs.add(num);
            max = Math.max(max,num);
        }
        int i=1,res=0;
        while(true){
            if(!hs.contains(k*i)){
                res = k*i;
                break;
            }
            i++;
        }
        return res;
    }
}