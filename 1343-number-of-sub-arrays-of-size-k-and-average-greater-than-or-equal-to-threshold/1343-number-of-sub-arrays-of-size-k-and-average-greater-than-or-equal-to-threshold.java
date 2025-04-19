class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int temp=0;
        int ans=0;
        int l=0;
        for(int r=0; r<n ; r++){
            temp+=arr[r];

            if(r-l == k){
                temp-=arr[l];
                l++;
            }

            if(r-l+1 == k){
                if(temp/k >= threshold){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}