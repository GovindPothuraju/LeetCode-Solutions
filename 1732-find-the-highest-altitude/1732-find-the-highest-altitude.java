class Solution {
    public int largestAltitude(int[] gain) {
        int res = Integer.MIN_VALUE;
        int sum=0;
        for(int num : gain){
            sum+=num;
            res=Math.max(res,sum);
        }
        return res<=0 ? 0 : res;
    }
}