class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n=arr.length;
        if(n==1){
            return arr[0];
        }
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(mid==0 && arr[0]!=arr[1]){
                return arr[mid];
            }
            if(mid==n-1 && arr[n-1]!=arr[n-2]){
                return arr[mid];
            }
            if(arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }
            if(mid%2==0){
                if(arr[mid]==arr[mid-1]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }else{
                if(arr[mid]==arr[mid-1]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}