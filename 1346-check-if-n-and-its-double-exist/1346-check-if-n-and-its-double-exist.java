class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n;i++){
            int val=arr[i]*2;
            int l=0;
            int r=n-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(arr[mid]==val && mid !=i){
                    return true;
                }else if(arr[mid]<val){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return false;
    }
}