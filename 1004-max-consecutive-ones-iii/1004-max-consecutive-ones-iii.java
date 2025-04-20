class Solution {
    public int longestOnes(int[] arr, int k) {
        int n=arr.length;
        int ans=0;
        int temp=0;
        int l=0;
        for(int r=0;r<n;r++){
            if(arr[r] == 0){
                temp++;
            }
            while(temp > k){
                if(arr[l] == 0){
                    temp--;
                }
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}