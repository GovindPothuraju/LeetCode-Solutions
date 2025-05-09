class Solution {
    public int passThePillow(int n, int time) {
        int ans=0;
        int div=time/(n-1);
        int rem=time % (n-1);
        if(div%2 != 0){
            ans=n-rem;
        }else{
            ans=rem+1;
        }
        
        return ans;
    }
}