class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l=0;
        int n=blocks.length();
        int ans=Integer.MAX_VALUE;
        int temp=0;
        for(int r=0;r<n;r++){
           if(blocks.charAt(r) == 'W'){
            temp++;
           }
           if(r-l+1 >k){
                    if(blocks.charAt(l) == 'W'){
                    temp--;
                }
                l++;
           }
           if(r-l+1 == k){
            ans=Math.min(ans,temp);
           }
        }
        return ans;
    }
}