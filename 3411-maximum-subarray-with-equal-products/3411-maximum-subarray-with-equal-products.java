class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int l=0 ; l<n; l++){
            long prd = 1;
            long gcd = 0;
            long lcm = 1;
            for(int r=l; r<n ; r++){
                long x = nums[r];
                prd = prd*x;
                gcd = (gcd==0)? x : getGcd(gcd,x);
                lcm = getLCM(lcm,x);
                
                if(prd == lcm*gcd){
                    res = Math.max(res , r-l+1);
                }
            }
        }
        return res;
    }
    private long getGcd(long a , long b){
        if(b == 0){
            return a;
        }
        return getGcd(b,a%b);
    }
    private long getLCM (long a,long b){
        return (a / getGcd(a,b))*b;
    }
}