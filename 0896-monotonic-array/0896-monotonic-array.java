class Solution {
    public boolean isMonotonic(int[] arr) {
        int n=arr.length;
        if(n<=2) return true;
        boolean inc=true;
        boolean dec=true;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                dec=false;
            }
            if(arr[i-1]<arr[i]){
                inc=false;
            }
        }
        return inc || dec;
    }
}