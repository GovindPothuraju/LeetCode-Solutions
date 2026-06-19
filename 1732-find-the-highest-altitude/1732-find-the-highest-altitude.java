class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int sum=0;
        for(int num : gain){
            sum+=num;
            res=Math.max(res,sum);
        }
        return res;
    }
}