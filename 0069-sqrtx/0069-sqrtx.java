class Solution {
    public int mySqrt(int x) {
        int l=0;
        int r=x;
        while(l<=r){
            int mid=l+(r-l)/2;
            long val=(long)mid*mid;
            if(val==x){
                return mid;
            }else if(val>x){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return r;
    }
}