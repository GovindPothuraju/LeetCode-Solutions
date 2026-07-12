class Solution {
    public int findMin(int[] arr) {
        int l = 0;
        int r = arr.length-1;
        int min = Integer.MAX_VALUE;
        while(l<=r){
            
            int mid = l+(r-l)/2;
            if(arr[mid] == arr[r]){
                min = Math.min(min,arr[mid]);
                r--;
            }
            else if(arr[l] <= arr[mid]){
                min = Math.min(min,arr[l]);
                if(arr[mid] > arr[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }else{
                min = Math.min(min,arr[mid]);
                if(arr[mid] > arr[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return min;
    }
}