class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        if(n==1){
            return arr[0];
        }
        int l=1;
        int r=n-2;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid-1]<arr[mid]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
       return -1; 
    }
}